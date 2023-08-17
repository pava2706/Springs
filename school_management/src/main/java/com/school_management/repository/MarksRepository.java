package com.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school_management.entity.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {

}
