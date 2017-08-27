package com.tanveer.association.withAnnotation.manyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "course", catalog = "tanveerDB")
public class Course {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "COURSE_ID", unique = true, nullable = false)
	Integer courseId;
	
	@Column(name = "COURSE_NAME", nullable = false, length = 10)
	String courseName;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
	Set<Student> students = new HashSet<Student>();

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	

}
