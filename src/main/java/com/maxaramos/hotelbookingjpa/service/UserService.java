package com.maxaramos.hotelbookingjpa.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxaramos.hotelbookingjpa.dao.UserDao;
import com.maxaramos.hotelbookingjpa.model.User;

@Service
@Transactional
public class UserService implements UserDetailsService {

	@Autowired
	private Logger log;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username: " + username));
		log.debug(user.toString());
		return user;
	}

}
