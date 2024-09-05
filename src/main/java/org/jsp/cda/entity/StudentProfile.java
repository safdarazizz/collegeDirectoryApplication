package org.jsp.cda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "StudentProfile")
@Data
@NoArgsConstructor
public class StudentProfile {

	@Id
	@Column(name = "user_id")
	private Long userId;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;

	@Column
	private String photo;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	@Column
	private String year;
}
