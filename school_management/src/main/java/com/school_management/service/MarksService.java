package com.school_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_management.entity.Marks;
import com.school_management.entity.Student;
import com.school_management.repository.MarksRepository;
import com.school_management.repository.StudentRepository;

@Service
public class MarksService {

	@Autowired
	MarksRepository marksRepository;
	
	@Autowired
	StudentRepository stdRepository;
	

	public String addMarks(Marks marks) {
		System.out.println(marks.getId());
		Optional<Student> std = stdRepository.findById(marks.getId());
		
		if (std.isPresent()) { 
			Student stdn = std.get();
			if(stdn.getMarks()==null) {
        	//marksRepository.save(marks);
				marks.setStudent(stdn);
				marksRepository.save(marks);
				stdn.setMarks(marks);
				stdRepository.save(stdn);
				return null;
			}
			else {
				marksRepository.save(marks);
				return null;
			}
		}
			else {
				return "Please Enter Proper Student Id";
			}
		}

	public Object readById(int id) {
		Optional<Student> std=stdRepository.findById(id);
		if(std.isPresent()) {
			return std.get();
		}
			return null;
	}

}
