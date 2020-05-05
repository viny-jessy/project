package com.capgemini.librarymanagementsystemhibernateproject.service;

import java.util.List;
import com.capgemini.librarymanagementsystemhibernateproject.dto.LibraryDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.BookDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.RequestDetailsHibernate;

public interface AdminHibernateService {

	LibraryDetailsHibernate adminLogin(String emailId, String password);

	boolean enrollUser(LibraryDetailsHibernate user);

	boolean enrollBook(BookDetailsHibernate book);

	boolean updateBook(BookDetailsHibernate bookInfo);

	BookDetailsHibernate searchByBookId(int bookId);

	BookDetailsHibernate searchByBookName(String bookName);

	BookDetailsHibernate searchByAuthorName(String authorName);

	List<LibraryDetailsHibernate> listOfUsers();

	List<BookDetailsHibernate> listOfBooks();

	List<RequestDetailsHibernate> listOfRequests();

	boolean bookIssue(int requestId);

	boolean isBookReceived(int requestId);

	boolean removeBook(int bookId);

}
