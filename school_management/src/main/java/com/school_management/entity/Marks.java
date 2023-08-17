package com.school_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Marks {
	@Id
	private int id;
	private int Kan_marks;
	private int Eng_marks;
	private int Hin_marks;
	private int Maths_marks;
	private int Science_marks;
	private int Social_marks;

	public Marks(int id, int kan_marks, int eng_marks, int hin_marks, int maths_marks, int science_marks,
			int social_marks) {
		super();
		this.id = id;
		Kan_marks = kan_marks;
		Eng_marks = eng_marks;
		Hin_marks = hin_marks;
		Maths_marks = maths_marks;
		Science_marks = science_marks;
		Social_marks = social_marks;
	}

	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKan_marks() {
		return Kan_marks;
	}

	public void setKan_marks(int kan_marks) {
		Kan_marks = kan_marks;
	}

	public int getEng_marks() {
		return Eng_marks;
	}

	public void setEng_marks(int eng_marks) {
		Eng_marks = eng_marks;
	}

	public int getHin_marks() {
		return Hin_marks;
	}

	public void setHin_marks(int hin_marks) {
		Hin_marks = hin_marks;
	}

	public int getMaths_marks() {
		return Maths_marks;
	}

	public void setMaths_marks(int maths_marks) {
		Maths_marks = maths_marks;
	}

	public int getScience_marks() {
		return Science_marks;
	}

	public void setScience_marks(int science_marks) {
		Science_marks = science_marks;
	}

	public int getSocial_marks() {
		return Social_marks;
	}

	public void setSocial_marks(int social_marks) {
		Social_marks = social_marks;
	}

	@OneToOne
	Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
