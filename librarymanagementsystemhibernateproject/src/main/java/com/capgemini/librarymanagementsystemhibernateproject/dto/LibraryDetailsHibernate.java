package com.capgemini.librarymanagementsystemhibernateproject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="LibraryInformation")
public class LibraryDetailsHibernate {
	@Id
	@Column
	private int id;
	@Column
	private String userName;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String emailId;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private int noOfBooksBorrowed;
	@Column
	private int fine;

	

}
