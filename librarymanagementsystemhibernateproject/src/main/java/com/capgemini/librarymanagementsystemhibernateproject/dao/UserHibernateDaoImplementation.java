package com.capgemini.librarymanagementsystemhibernateproject.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.capgemini.librarymanagementsystemhibernateproject.dto.BookDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.LibraryDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.RequestDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.exceptions.LibraryManagemenetSystemHibernateExceptions;


public class UserHibernateDaoImplementation implements UserHibernateDao{

	@Override
	public LibraryDetailsHibernate login(String emailId, String password) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from LibraryInformation  m where m.emailId=:emailId and m.password=:password";
		TypedQuery<LibraryDetailsHibernate> query = manager.createQuery(jpql, LibraryDetailsHibernate.class);
		query.setParameter("emailId", emailId);
		query.setParameter("password", password);
		try {
			LibraryDetailsHibernate libraryInfo = query.getSingleResult();
			System.out.println("User Email Id  is : " + libraryInfo.getEmailId());
			System.out.println("User Password  is : " + libraryInfo.getPassword());
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			manager.close();
			factory.close();
		}

		return null;
	}

	@Override
	public List<BookDetailsHibernate> listOfBooks() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from BookInformation m";
		TypedQuery<BookDetailsHibernate> query = manager.createQuery(jpql, BookDetailsHibernate.class);
		List<BookDetailsHibernate> recordlist = query.getResultList();

		return recordlist;
	}

	@Override
	public BookDetailsHibernate searchByBookId(int bookId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		BookDetailsHibernate record = manager.find(BookDetailsHibernate.class, bookId);

		return record;
	}

	@Override
	public BookDetailsHibernate searchByBookName(String bookName) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		BookDetailsHibernate record = manager.find(BookDetailsHibernate.class, bookName);

		return record;
	}

	@Override
	public BookDetailsHibernate searchByAuthorName(String authorName) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		BookDetailsHibernate record = manager.find(BookDetailsHibernate.class, authorName);

		return record;
	}

	@Override
	public RequestDetailsHibernate bookRequest(int userId, int bookId) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		RequestDetailsHibernate requestDetails = new RequestDetailsHibernate();
		BookDetailsHibernate bookDetails = new BookDetailsHibernate();
		
		String jpql = null;
		int countOfRequest = 0;
		try {
		 factory = Persistence.createEntityManagerFactory("TestPersistence");
		 manager = factory.createEntityManager();
		 transaction = manager.getTransaction();
		 
		 jpql = "select count(*) from RequestInformation m where m.userId=:uId";
		 Query query = manager.createQuery(jpql);
		 query.setParameter("uId", userId);
		 countOfRequest = ((Number) query.getSingleResult()).intValue();
		 System.out.println("no of request placed by the user : "+ countOfRequest);
		 
		 if(countOfRequest < 3) {
			 bookDetails = manager.find(BookDetailsHibernate.class, bookId);
			 if(bookDetails != null) {
				 jpql = "select m from RequestInformation m";
				 TypedQuery<RequestDetailsHibernate> listOfRequest = manager.createQuery(jpql, RequestDetailsHibernate.class);
				 List<RequestDetailsHibernate> list = listOfRequest.getResultList();
				 for(RequestDetailsHibernate requestInfo : list) {
					 if(requestInfo.getBookId() == bookId) {
						 
						 throw new LibraryManagemenetSystemHibernateExceptions("Book is already requested by other user");
					 }
				 }
				 if(bookDetails.isAvaliable()) {
					 transaction.begin();
					 requestDetails.se
				 }
			 }
		 }
		 
		}
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
