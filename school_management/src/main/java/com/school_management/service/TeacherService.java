package com.school_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_management.entity.Teacher;
import com.school_management.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository techrepository;
	
	public void addTeacher(Teacher teach) {
		techrepository.save(teach);
	}

	public void updateTeacher(Teacher teach) {
		techrepository.save(teach);
	}

	public List<Teacher> readTeachers() {
		List<Teacher> tech = techrepository.findAll();
		if (tech.isEmpty()) {
			return null;
		}
		return tech;
	}

	public String deleteTeacher(int id,String name) {
		Optional<Teacher> tech=techrepository.findById(id);
		System.out.println(name+" 1");
		if(tech.isPresent()) {
			Teacher s1=tech.get();
			System.out.println(name+" 2");
		if (s1.getName().contains(name)) {
			System.out.println(name);
			techrepository.deleteById(id);
			return null;
		} else {
			return "Invalid id or name";
		}
	}
		 else {
				return "Invalid id or name";
			}
	}

}
