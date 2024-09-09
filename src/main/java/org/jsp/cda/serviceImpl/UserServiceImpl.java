package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.UserNotFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JavaMailSender javaMailSender;

	public ResponseEntity<?> findByUsernameAndPassword(AuthUser authUser) {
		Optional<User> optional = userDao.findByUsernameAndPassword(authUser.getUsername(), authUser.getPassword());
		if (optional.isEmpty())
			throw UserNotFoundException.builder().message("Invalid Credentials... Invalid Username or Password...").build();
		
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Created Successfully").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> saveUser(User user) {
		User dbUser = userDao.saveUser(user);
		
//		System.out.println(user.getEmail());
		
		double floatingNumber = 0;
		
		while(floatingNumber < 1000)
		{
			floatingNumber = Math.random() * 10000;
		}
		int otp = (int) floatingNumber;
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try
		{
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			
			helper.setTo(user.getEmail());
			helper.setSubject("Mail sent by mail API");
			
			String htmlContent = "<html> <body> " + otp + " </body> </html>";

			helper.setText(htmlContent, true);

			javaMailSender.send(mimeMessage);
		} 
		catch (MessagingException e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(ResponseStructure.builder()
	                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
	                    .message("Failed to send email")
	                    .body(null)
	                    .build());
		}
				
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Saved Successfully").body(dbUser).build());
	}

	@Override
	public ResponseEntity<?> getUserById(Long id) {
		Optional<User> optional = userDao.getUserById(id);
		
		if(optional.isEmpty())
			throw UserNotFoundException.builder().message("User with ID: " + id + " does not exist").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Found Successfully with ID: " + id).body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> getUserByUsername(String username) {
		Optional<User> optional = userDao.getUserByUsername(username);

		if(optional.isEmpty())
			throw UserNotFoundException.builder().message("User with Username: " + username + " does not exist").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Found Successfully with Username: " + username).body(optional.get()).build());

	}

	@Override
	public ResponseEntity<?> deleteUserById(Long id) {
		Optional<User> optional = userDao.getUserById(id);
		
		if(optional.isEmpty())
			throw UserNotFoundException.builder().message("User not found with ID: " + id).build();

		userDao.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Deleted Successfully with ID: " + id).body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> listOfUsers = userDao.findAllUsers();
		
		if(listOfUsers.isEmpty())
			throw UserNotFoundException.builder().message("No User present. Please insert a new User").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Users found Successfully").body(listOfUsers).build());
	}

	@Override
	public ResponseEntity<?> updateUser(User user) {
		User dbUser = userDao.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Updated Successfully").body(dbUser).build());
	}
}
