package com.school_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school_management.entity.Student;
import com.school_management.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService stdservice;

//	@GetMapping("/")
//	public String home() {
//		return "home";
//	}

	@GetMapping("/add_student")
	public String addstudent() {
		return "addstudent";
	}

	@GetMapping("/update_student")
	public String updatestudent() {
		return "updatestudent";
	}

	@GetMapping("/delete_student")
	public String deletestudent() {
		return "deletestudent";
	}

	@PostMapping("/addstudent")
	public Object addStudent(@ModelAttribute Student std) {
		String msg = stdservice.addStudent(std);
		if (msg.contains(" ")) {
			ModelAndView view = new ModelAndView("addstudent");
			view.addObject("msg", msg);
			return view;
		}
		return "redirect:/read_student";
	}

	@PostMapping("/updatestudent")
	public String updateStudent(@ModelAttribute Student std) {
		stdservice.updateStudent(std);
		return "redirect:/read_student";
	}

	@GetMapping("/read_student")
	public ModelAndView readStudent() {
		Object list = stdservice.readStudents();
		ModelAndView view = new ModelAndView("read");
		if (list != null) {
			view.addObject("s", "Students List.......");
			view.addObject("std", list);
			return view;
		} else {
			view.addObject("msg", "No data found.....");
			return view;
		}
	}

	@GetMapping("/deletestudent")
	public Object delete_Student(@ModelAttribute Student std) {
		String msg = stdservice.deleteStudent(std.getId(), std.getName());
		if (msg != null) {
			ModelAndView view = new ModelAndView("deletestudent");
			view.addObject("msg", msg);
			return view;
		}
		return "redirect:/read_student";
	}
}
