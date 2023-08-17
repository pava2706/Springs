package com.school_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school_management.entity.Teacher;
import com.school_management.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@GetMapping("/add_teacher")
	public String addTeacher() {
		return "addteacher";
	}

	@GetMapping("/update_teacher")
	public String updateteacher() {
		return "updateteacher";
	}

	@GetMapping("/delete_teacher")
	public String deleteteacher() {
		return "deleteteacher";
	}

	@PostMapping("/addteacher")
	public String addTeacher(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "redirect:/read_teacher";
	}

	@PostMapping("/updateteacher")
	public String updateTeacher(@ModelAttribute Teacher teacher) {
		teacherService.updateTeacher(teacher);
		return "redirect:/read_teacher";
	}

	@GetMapping("/read_teacher")
	public ModelAndView readTeacher() {
		List<Teacher> list = teacherService.readTeachers();
		ModelAndView view = new ModelAndView("read");
		if (list != null) {
			view.addObject("s", "Teachers List.......");
			view.addObject("std", list);
			return view;
		} else {
			view.addObject("msg", "No data found.....");
			return view;
		}
	}

	@GetMapping("/deleteteacher")
	public Object deleteTeacher(@ModelAttribute Teacher teacher) {
		System.out.println(teacher.getId());
		System.out.println(teacher.getName());
		String msg = teacherService.deleteTeacher(teacher.getId(), teacher.getName());
		if (msg != null) {
			ModelAndView view = new ModelAndView("deletestudent");
			view.addObject("msg", msg);
			return view;
		}
		return "redirect:/read_student";
	}

}
