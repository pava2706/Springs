package com.book.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.entity.Book;
import com.book.store.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;

	public void save(Book b) {
		repository.save(b);
	}

	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	public Book getBookById(int id) {
		return repository.findById(id).get();
	}

}
