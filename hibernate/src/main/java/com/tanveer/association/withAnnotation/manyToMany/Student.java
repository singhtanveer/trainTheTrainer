package com.tanveer.association.withAnnotation.manyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({ @NamedQuery(name = "studentById", query = "from Student where studentId = ?")
})
@NamedNativeQuery(name = "studentByName", query = "select * from student where student_name = ?", resultClass = Student.class)
@Table(name = "student", catalog = "tanveerDB", uniqueConstraints = { @UniqueConstraint(columnNames = "STUDENT_NAME") })
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID", unique = true, nullable = false)
	private Integer studentId;

	@Column(name = "STUDENT_NAME", unique = true, nullable = false, length = 20)
	private String studentName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", catalog = "tanveerDB", 
			   joinColumns = {@JoinColumn(name = "STUDENTS_ID", referencedColumnName="STUDENT_ID", nullable = false, updatable = false) }, 
			   inverseJoinColumns = {@JoinColumn(name = "COURSES_ID", referencedColumnName="COURSE_ID", nullable = false, updatable = false) })
	//if refernced column name not given still it works
	private Set<Course> courses = new HashSet<Course>();

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
