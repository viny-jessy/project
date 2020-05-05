package com.capgemini.librarymanagementsystemhibernateproject.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BookInformation")
@SuppressWarnings("serial")
public class BookDetailsHibernate implements Serializable {
	
	@Column
	private int slno;
	@Id
	@Column
	private int bookId;
	@Column
	private String bookName;
	@Column
	private String authorName;
	@Column
	private String publisher;
	@Column
	private String category;
	@Column
	private boolean isAvaliable;

}
