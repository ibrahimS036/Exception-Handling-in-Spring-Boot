package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.UserRequest;
import com.api.entities.User;
import com.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(UserRequest userrequest) {
		User user = new User(
				userrequest.getName(),
				userrequest.getEmail(),
				userrequest.getMobile(),
				userrequest.getGender(),
				userrequest.getAge(),
				userrequest.getNationality());
		User save = this.repository.save(user);
		return save;
	}

	public List<User> getAllUsers() {
		return this.repository.findAll();
	}

	public User getUser(int id) {
		return this.repository.findByuser(id);
	}

}
