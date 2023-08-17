package com.school_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school_management.entity.Marks;
import com.school_management.entity.Student;
import com.school_management.service.MarksService;

@Controller
public class MarksController {

	@Autowired
	MarksService marksService;

	@GetMapping("/add_marks")
	public String addMarks() {
		return "marks";
	}

	@PostMapping("/addmarks")
	public ModelAndView addMarks(@ModelAttribute Marks marks) {
		String msg = marksService.addMarks(marks);
		ModelAndView view = new ModelAndView("marks");
		if (msg != null) {
			view.addObject("msg", msg);
			return view;
		} else {
			view.addObject("msg", "Marks Updated Sucessfully...");
			return view;
		}
	}

	@GetMapping("/std_id")
	public String getStdId() {
		return "findstdbyid";
	}

	@GetMapping("/read_studentbyid")
	public ModelAndView readStudentById(@ModelAttribute Student id) {
		Object std = marksService.readById(id.getId());
		ModelAndView view = new ModelAndView("findstdbyid");
		if (std != null) {
			Student std1 = (Student) std;
			if (std1.getMarks() != null) {
				ModelAndView view1 = new ModelAndView("display");
				view1.addObject("std1", std1.getId());
				view1.addObject("std2", std1.getName());
				view1.addObject("tech", std1.getTeacher().getName());
				view1.addObject("sub1", std1.getMarks().getKan_marks());
				view1.addObject("sub2", std1.getMarks().getEng_marks());
				view1.addObject("sub3", std1.getMarks().getHin_marks());
				view1.addObject("sub4", std1.getMarks().getMaths_marks());
				view1.addObject("sub5", std1.getMarks().getScience_marks());
				view1.addObject("sub6", std1.getMarks().getSocial_marks());
				view1.addObject("total", ((Student) std1).getMarks().getKan_marks()
						+ ((Student) std1).getMarks().getEng_marks() + ((Student) std1).getMarks().getHin_marks()
						+ ((Student) std1).getMarks().getMaths_marks() + ((Student) std1).getMarks().getScience_marks()
						+ ((Student) std1).getMarks().getSocial_marks());
				return view1;
			} else {
				view.addObject("msg", "Marks Not Updated....");
				return view;
			}
		} else {
			view.addObject("msg", "please enter proper id..");
			return view;
		}
	}
}
