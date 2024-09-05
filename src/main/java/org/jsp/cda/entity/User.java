package org.jsp.cda.entity;

import org.jsp.cda.util.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(unique = true, nullable = false)
	private String username;

//	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
//	@Column(nullable = false)
	private Role role;

//	@Column(nullable = false)
	private String name;

//	@Column(unique = true, nullable = false)
	private String email;

//	@Column(unique = true, nullable = false)
	private String phone;
}
