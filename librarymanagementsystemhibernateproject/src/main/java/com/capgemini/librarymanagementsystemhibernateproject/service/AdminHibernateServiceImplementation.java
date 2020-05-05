package com.capgemini.librarymanagementsystemhibernateproject.service;

import java.util.List;
import com.capgemini.librarymanagementsystemhibernateproject.dto.BookDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.RequestDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.LibraryDetailsHibernate;

public class AdminHibernateServiceImplementation implements AdminHibernateService{

	@Override
	public LibraryDetailsHibernate adminLogin(String emailId, String password) {
		
		return null;
	}

	@Override
	public boolean enrollUser(LibraryDetailsHibernate user) {
		
		return false;
	}

	@Override
	public boolean enrollBook(BookDetailsHibernate book) {
		
		return false;
	}

	@Override
	public boolean updateBook(BookDetailsHibernate bookInfo) {
		
		return false;
	}

	@Override
	public BookDetailsHibernate searchByBookId(int bookId) {
		
		return null;
	}

	@Override
	public BookDetailsHibernate searchByBookName(String bookName) {
		
		return null;
	}

	@Override
	public BookDetailsHibernate searchByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibraryDetailsHibernate> listOfUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDetailsHibernate> listOfBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestDetailsHibernate> listOfRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bookIssue(int requestId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBookReceived(int requestId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
