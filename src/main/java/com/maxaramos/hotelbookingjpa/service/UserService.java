package com.maxaramos.hotelbookingjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxaramos.hotelbookingjpa.dao.RoleDao;
import com.maxaramos.hotelbookingjpa.dao.UserDao;
import com.maxaramos.hotelbookingjpa.model.Role;
import com.maxaramos.hotelbookingjpa.model.User;

@Service
@Transactional
@PreAuthorize("hasRole('ADMIN')")
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findById(Long id) {
		return userDao.findById(id).orElse(null);
	}

	public List<User> findByUsernameOrName(String searchParam) {
		User user = new User();
		user.setUsername(searchParam);
		user.setFirstName(searchParam);
		user.setLastName(searchParam);

		ExampleMatcher matcher = ExampleMatcher.matchingAny()
				.withIgnoreCase()
				.withMatcher("username", match -> match.startsWith())
				.withMatcher("firstName", match -> match.contains())
				.withMatcher("lastName", match -> match.contains());

		List<User> results = new ArrayList<>();
		userDao.findAll(Example.of(user, matcher)).forEach(results::add);
		return results;
	}

	public User addManager(User user) {
		String password = passwordEncoder.encode(user.getRawPassword());
		Role role = roleDao.findByName(Role.MANAGER).orElseThrow(() -> new RuntimeException(String.format("Role [name=%] not found.", Role.MANAGER)));

		user.setId(null);
		user.setPassword(password);
		user.setRole(role);
		user.setEnabled(true);
		return userDao.save(user);
	}

	public User addReceptionist(User user) {
		String password = passwordEncoder.encode(user.getRawPassword());
		Role role = roleDao.findByName(Role.RECEPTIONIST).orElseThrow(() -> new RuntimeException(String.format("Role [name=%] not found.", Role.RECEPTIONIST)));

		user.setId(null);
		user.setPassword(password);
		user.setRole(role);
		user.setEnabled(true);
		return userDao.save(user);
	}

	public User addGuest(User user) {
		String password = passwordEncoder.encode(user.getRawPassword());
		Role role = roleDao.findByName(Role.GUEST).orElseThrow(() -> new RuntimeException(String.format("Role [name=%] not found.", Role.GUEST)));

		user.setId(null);
		user.setPassword(password);
		user.setRole(role);
		user.setEnabled(true);
		return userDao.save(user);
	}

	public User update(Long id, User user) {
		User updatedUser = userDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("User [id=%s] not found.", id)));
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setPhoneNumber(user.getPhoneNumber());
		return userDao.save(updatedUser);
	}

	public User enable(Long id) {
		User updatedUser = userDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("User [id=%s] not found.", id)));
		updatedUser.setEnabled(true);
		return userDao.save(updatedUser);
	}

	public User disable(Long id) {
		User updatedUser = userDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("User [id=%s] not found.", id)));
		updatedUser.setEnabled(false);
		return userDao.save(updatedUser);
	}

	public void delete(Long id) {
		userDao.deleteById(id);
	}

}
