package com.java.backendus.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Builder
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String userId;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String passWord;

	@Column
	private Integer point;

	@Column
	private String country;


	public User() {

	}


}
