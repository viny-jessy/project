package com.capgemini.librarymanagementsystemhibernateproject.dao;

import java.util.List;
import com.capgemini.librarymanagementsystemhibernateproject.dto.BookDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.LibraryDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.RequestDetailsHibernate;

public interface UserHibernateDao {

	LibraryDetailsHibernate login(String emailId, String password);

	List<BookDetailsHibernate> listOfBooks();

	BookDetailsHibernate searchByBookId(int bookId);

	BookDetailsHibernate searchByBookName(String bookName);

	BookDetailsHibernate searchByAuthorName(String authorName);

	public RequestDetailsHibernate bookRequest(int userId, int bookId);

	boolean bookReturn(int userId, int bookId);

}
