package com.school_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_management.entity.Student;
import com.school_management.entity.Teacher;
import com.school_management.repository.StudentRepository;
import com.school_management.repository.TeacherRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository stdRepository;

	@Autowired
	TeacherRepository teacherRepository;

	public String addStudent(Student student) {
		Optional<Teacher> teacher = teacherRepository.findById(student.getTechid());
		if (teacher.isPresent()) {
			student.setTeacher(teacher.get());
			stdRepository.save(student);
			return "";
		} else {
			return "Please enter proper details....";
		}
	}

	public void updateStudent(Student student) {
		Teacher teacher = teacherRepository.findById(student.getTechid()).get();
		if (teacher.getId() != student.getTechid()) {
			student.setTeacher(teacher);
			stdRepository.save(student);
		} else {
			stdRepository.save(student);
		}
	}

	public Object readStudents() {
		List<Student> std = stdRepository.findAll();
		if (std.isEmpty()) {
			return null;
		}
		return std;
	}

	public String deleteStudent(int id, String name) {
		Optional<Student> std = stdRepository.findById(id);
		if (std.isPresent()) {
			Student s1 = std.get();

			if (s1.getName().contains(name)) {
				stdRepository.deleteById(id);
				return null;
			} else {
				return "Invalid id or name";
			}
		} else {
			return "Invalid id or name";
		}
	}

}
