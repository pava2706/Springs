package com.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school_management.entity.Teacher;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Integer>{

}
