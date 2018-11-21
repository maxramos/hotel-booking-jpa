package com.maxaramos.hotelbookingjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maxaramos.hotelbookingjpa.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username: " + username));
	}

}
