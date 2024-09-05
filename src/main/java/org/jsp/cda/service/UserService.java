package org.jsp.cda.service;

import org.jsp.cda.entity.User;
import org.jsp.cda.util.AuthUser;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> findByUsernameAndPassword(AuthUser authUser);

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> getUserById(Long id);

	ResponseEntity<?> getUserByUsername(String username);

	ResponseEntity<?> deleteUserById(Long id);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> updateUser(User user);
}
