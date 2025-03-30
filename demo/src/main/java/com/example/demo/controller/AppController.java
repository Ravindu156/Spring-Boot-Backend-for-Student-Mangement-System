package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
@RequestMapping("/app")


public class AppController {

	//create some student objects
	Student Bob=new Student("2020ICT01","Bob Marley",23,"IT",3.21);
	Student Amal=new Student("2020ICT25","Amal Perera",22,"Bio",3.89);
	Student Namal=new Student("2020ICT01","Namal Rajapaksha",21,"AMC",3.97);
	List<Student> students=new ArrayList<Student>();
	
	
	
	public AppController() {
		students.add(Bob);
		students.add(Amal);
		students.add(Namal);
	}
	
	
	
	//A method to return a student
	@GetMapping("/student")
	public Student getStudent() {
		return Bob;
	}
	
	
	//return multiple students
	@GetMapping("/allstudents")
	public List<Student> getAll(){
		return students;
	}
	
	//Find the student from the list by regNo
	@GetMapping("/student/{regno}")
	public Student getStudent(@PathVariable("regno") String regNo) {
		for(Student student:students) {
			if (student.getRegNo().equals(regNo)) {
				return student;
			}
		}
		return null;
	}
	
	//Find students whoose age is between 20 and 23
	@GetMapping("/student/by-age")
	public List<Student> getStudentByAge(){
		List<Student> stu=new ArrayList<Student>();
		for (Student student: students) {
			if (student.getAge()>20 && student.getAge()<23) {
				stu.add(student);
			}
		}
		return stu;
		
		
	}
	
	@GetMapping("order/all-students")
	public List<Student> getAllStudents(){
		students.sort((s1,s2)->Double.compare(s2.getGpa(), s1.getGpa()));
		return students;
	}
	
	//add student
    @PostMapping("/student/add")
    public List<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        return students;
    }
	
	//update student by regNo
    @PutMapping("/student/update/{regno}")
    public Student updateStudent(@PathVariable("regno") String regNo,@RequestBody Student updatedStudent) {
    	for (Student student:students) {
    		if (student.getRegNo().equals(regNo)) {
    			student.setName(updatedStudent.getName());
    			student.setAge(updatedStudent.getAge());
    			student.setCourse(updatedStudent.getCourse());
    			student.setGpa(updatedStudent.getGpa());
    			return student;
    		}
    	}
    	
    	return null;
    }
    
    
    //Delete a student by registration number
    @DeleteMapping("/student/delete/{regno}")
    public String deleteStudent(@PathVariable("regno") String regNo) {
    	for(Student student:students) {
    		if(student.getRegNo().equals(regNo)) {
    			students.remove(student);
    			return  "Student with reg no" + regNo + "has been deleted";
    		}
    	}
    	return "Student with regNo " + regNo + " not found."; 
    }
    
    
   

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
