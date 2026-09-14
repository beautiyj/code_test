package springboot_test.ch01.src.main.java.sample12.dao;

import sample12.model.Book;

public interface BookDao {
	Book getBook(String title);
}