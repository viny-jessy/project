package com.capgemini.librarymanagementsystemhibernateproject.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.capgemini.librarymanagementsystemhibernateproject.dto.LibraryDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.BookDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.dto.RequestDetailsHibernate;
import com.capgemini.librarymanagementsystemhibernateproject.exceptions.LibraryManagemenetSystemHibernateExceptions;

public class AdminHibernateDaoImplementation implements AdminHibernateDao {

	@Override
	public LibraryDetailsHibernate adminLogin(String emailId, String password) {

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

	public boolean enrollUser(LibraryDetailsHibernate userInfo) {

		LibraryDetailsHibernate user = new LibraryDetailsHibernate();

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			System.out.println("Registartion record saved in database");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		return false;
	}

	public boolean enrollBook(BookDetailsHibernate info) {

		BookDetailsHibernate book = new BookDetailsHibernate();

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(book);
			System.out.println("Record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		return false;
	}

	public boolean removeBook(int bookId) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookDetailsHibernate record = manager.find(BookDetailsHibernate.class, bookId);
			manager.remove(record);
			System.out.println("book sucessfully deleted from the record");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
			factory.close();
		}

		return false;
	}

	public boolean updateBook(BookDetailsHibernate bookInfo) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookDetailsHibernate record = manager.find(BookDetailsHibernate.class, bookInfo);
			record.setBookId(bookInfo.getBookId());
			record.setBookName(bookInfo.getBookName());
			record.setAuthorName(bookInfo.getAuthorName());
			System.out.println("book updated sucessfully");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
			factory.close();
		}

		return false;
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

	public List<LibraryDetailsHibernate> listOfUsers() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from LibraryInformation m";
		TypedQuery<LibraryDetailsHibernate> query = manager.createQuery(jpql, LibraryDetailsHibernate.class);
		List<LibraryDetailsHibernate> recordlist = query.getResultList();

		return recordlist;
	}

	public List<BookDetailsHibernate> listOfBooks() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from BookInformation m";
		TypedQuery<BookDetailsHibernate> query = manager.createQuery(jpql, BookDetailsHibernate.class);
		List<BookDetailsHibernate> recordlist = query.getResultList();

		return recordlist;
	}

	@Override
	public List<RequestDetailsHibernate> listOfRequests() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from RequestInformation m";
		TypedQuery<RequestDetailsHibernate> query = manager.createQuery(jpql, RequestDetailsHibernate.class);
		List<RequestDetailsHibernate> recordlist = query.getResultList();

		return recordlist;
	}
	@Override
	public boolean bookIssue(int requestId) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		RequestDetailsHibernate requestDetails = new RequestDetailsHibernate();
		BookDetailsHibernate bookDetails = new BookDetailsHibernate();
		LibraryDetailsHibernate libraryDetails = new LibraryDetailsHibernate();

		int userRequestId = 0;
		int bookRequestedId = 0;
		int noOfBooksCount = 0;
		Date expectedReturnDate = null;

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();

		try {

			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			requestDetails = manager.find(RequestDetailsHibernate.class, requestId);

			if (requestDetails != null) {
				Date bookIssueDate = requestDetails.getIssueDate();
				if (bookIssueDate == null) {
					userRequestId = requestDetails.getUserId();
					bookRequestedId = requestDetails.getBookId();

					requestDetails.setIssueDate(date);
					requestDetails.setExpectedReturnDate(expectedReturnDate);
					transaction.commit();

					transaction.begin();
					libraryDetails = manager.find(LibraryDetailsHibernate.class, bookRequestedId);
					noOfBooksCount = libraryDetails.getNoOfBooksBorrowed();

					++noOfBooksCount;
					System.out.println("Number of books borrowed by user are : " + noOfBooksCount);
					libraryDetails.setNoOfBooksBorrowed(noOfBooksCount);
					transaction.commit();

					transaction.begin();
					bookDetails = manager.find(BookDetailsHibernate.class, bookRequestedId);
					bookDetails.setAvaliable(false);
					transaction.commit();
				} else {
					throw new LibraryManagemenetSystemHibernateExceptions(
							"This book can't issued to you, it is borrowed by other user");
				}

			} else {
				throw new LibraryManagemenetSystemHibernateExceptions("You might have entered invalid request id");
			}

		} catch (LibraryManagemenetSystemHibernateExceptions l) {
			throw new LibraryManagemenetSystemHibernateExceptions("sorry book can't be issued you");
		} finally {
			manager.close();
			factory.close();
		}

		return false;
	}

	public boolean isBookReceived(int requestId) {

		return false;
	}

}
