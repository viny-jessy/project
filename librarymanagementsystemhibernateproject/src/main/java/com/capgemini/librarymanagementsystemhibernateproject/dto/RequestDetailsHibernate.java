package com.capgemini.librarymanagementsystemhibernateproject.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BookInformation")
@SuppressWarnings("serial")
public class RequestDetailsHibernate implements Serializable {
	@Column
	private int bookId;
	@Column
	private int userId;
	@Id
	@Column
	private int requestId;
	@Column
	private String userName;
	@Column
	private String bookName;
	@Column
	private BookDetailsHibernate bookDetails;
	@Column
	private LibraryDetailsHibernate userDetails;
	@Column
	private Date issueDate;
	@Column
	private Date returnDate;
	@Column
	private Date expectedReturnDate;
	@Column
	private double fine;

}
