package com.capgemini.annapurna.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class WebsiteSecurityConfiguration{
	/*
	 * extends WebSecurityConfigurerAdapter {
	 * 
	 * 
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/resources/**"); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/", "/foodItems",
	 * "/search").permitAll() .antMatchers("/cart").hasAnyRole("USER", "ADMIN")
	 * .anyRequest().authenticated().and().formLogin().permitAll().and().logout().
	 * permitAll();
	 * 
	 * http.csrf().disable(); }
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder
	 * authenticationMgr) throws Exception {
	 * authenticationMgr.inMemoryAuthentication().passwordEncoder(
	 * NoOpPasswordEncoder.getInstance()).withUser("foods")
	 * .password("foods").roles("USER").and().withUser("annapurna").password(
	 * "annapurna").roles("ADMIN"); }
	 */

}