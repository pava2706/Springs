package com.book.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.entity.MyBookList;
import com.book.store.repository.MyBookRepository;

@Service
public class MyBookListService {
	@Autowired
	private MyBookRepository myBookRepository;

	public void saveMyBooks(MyBookList bookList) {
		myBookRepository.save(bookList);
	}

	public List<MyBookList> getAllMyBooks() {
		return myBookRepository.findAll();
	}

}
