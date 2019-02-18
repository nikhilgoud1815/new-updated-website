/**
 * 
 */
package com.capgemini.annapurna.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.annapurna.restaurant.entity.Profile;


/**
 * @author ugawari
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		ResponseEntity<Profile> entity = restTemplate.getForEntity("http://annapurna-profile/profiless/login/"+userName, Profile.class);
		Profile profile = entity.getBody();
		if (profile != null) {
			List<GrantedAuthority> authorities = getUserAuthority(profile.getRole());
			return buildUserForAuthentication(profile, authorities);
		} else {
			throw new UsernameNotFoundException("username not found");
		}
	}

	private List<GrantedAuthority> getUserAuthority(String userRoles) {
		Set<GrantedAuthority> roles = new HashSet<>();
			roles.add(new SimpleGrantedAuthority(userRoles));
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(Profile profile, List<GrantedAuthority> authorities) {
		return new User(profile.getUserName(), profile.getPassword(), authorities);
	}
	
	public Profile getCurrentUser() {
		String name = null;
		Profile profile = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			name = ((UserDetails)principal).getUsername();
		} else {
			name = principal.toString();
		}
		
		if(!name.equalsIgnoreCase("anonymousUser") || !name.equals(null)) {
			ResponseEntity<Profile> entity = restTemplate.getForEntity("http://annapurna-profile/profiless/login/"+name, Profile.class);
			profile = entity.getBody();
		}
	      return profile;
	  }

}
