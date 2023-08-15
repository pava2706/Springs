package com.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.book.store.entity.Book;
import com.book.store.entity.MyBookList;
import com.book.store.service.BookService;
import com.book.store.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	BookService bService;

	@Autowired
	MyBookListService listService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_book")
	public ModelAndView getAllBooks() {
		List<Book> list = bService.getAllBooks();
//		ModelAndView view=new ModelAndView();
//		view.setViewName("bookList");
//		view.addObject("book",list); 
		// (OR)

		return new ModelAndView("bookList", "book", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bService.save(b);
		return "redirect:/available_book";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = listService.getAllMyBooks();
		model.addAttribute("book", list);
		return "mybooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bService.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		listService.saveMyBooks(mb);
		return "redirect:/my_books ";
	}

}
