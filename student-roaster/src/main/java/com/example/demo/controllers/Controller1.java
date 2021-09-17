package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Contact;
import com.example.demo.models.Dorm;
import com.example.demo.models.Student;
import com.example.demo.services.ContactService;
import com.example.demo.services.DomService;
import com.example.demo.services.StudentService;

@Controller
public class Controller1 {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private DomService dormService;
	
	@GetMapping("/")
	public String indez() {
		return "redirect:/dashboard";
	}
	
	
	@GetMapping("/dashboard")
	public String Dashboard(Model viewModel) {
		List<Student> allStudents = this.studentService.getAllStudents();
		viewModel.addAttribute("allStudents", allStudents);
		List<Dorm> allDorms = this.dormService.getAllDom();
		viewModel.addAttribute("allDorms", allDorms);
		return "Dashboard.jsp";
	}
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student, Model viewModel) {//need model to display to frontend from DB
		
		return "addStudent.jsp";
	}

	@GetMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model viewModel) {//need model to display to frontend from DB
		List<Student> allStudents = this.studentService.getAllStudents();//store everything in a list
		viewModel.addAttribute("allStudents", allStudents);

		return "addContact.jsp";
	}

	@GetMapping("/dorms/create")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		
		return "addDorm.jsp";
	}

	@GetMapping("/dorms/{id}")
	public String newStudent(Model viewModel, @PathVariable("id") Long id) {//need model to display to frontend from DB
		//in order to grab the list of Students:	
		List<Student> allStudents = this.studentService.getAllStudents();//store everything in a list
		viewModel.addAttribute("allStudents", allStudents);

		Dorm showDorm = this.dormService.getSingleDorm(id);
		viewModel.addAttribute("dorm", showDorm);
		
		return "showDorm.jsp";
	}
	

	@PostMapping("/students/create")
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
	     if(result.hasErrors()) {
	         return "addStudent.jsp";//re-render the page if there are errors
	     }    
	     
	    this.studentService.createStudent(student);
	    
	    return "redirect:/dashboard";
	}
	
	@PostMapping("/contacts/create")
	public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
	     if(result.hasErrors()) {
	         return "addContact.jsp";//re-render the page if there are errors
	     }    
	     
	    this.contactService.createContact(contact);
	    
	    return "redirect:/dashboard";
	}

	//create a new dorm
	@PostMapping("/dorms/create")
	public String addDorm(@RequestParam(value="name", required=false) String name) {
		Dorm newDorm = new Dorm();
		newDorm.setName(name);

		this.dormService.createDorm(newDorm);
		
		return "redirect:/dashboard";
	}

	//add student to dorm
	//	Have a method handler in the controller for the following example url: /dorms/3/add?student=1. This method should add student with id 1 to the dorm with id 3. Add multiple student to different dormitories.
	@PostMapping("/dorms/{dorm_id}/add")
	public String addStudentToDorm(@PathVariable("dorm_id") Long dorm_id, @RequestParam(value="student", required=false) Long student_id) {
		Student student = this.studentService.getSingleStudent(student_id);
		Dorm dorm = this.dormService.getSingleDorm(dorm_id);
		
		student.setDorm(dorm);
	     
	    this.studentService.updateStudent(student);
	    
	    return "redirect:/dashboard";
	}



	//DELETIONS
	//delete entire student
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		this.studentService.deleteStudent(id);
		
		return "redirect:/dashboard";
	}

	//delete entire dorm - note only works if dorm has no students assigned to it
	@GetMapping("/deleteDorm/{id}")
	public String deleteDorm(@PathVariable("id") Long id) {
		this.dormService.deleteDorm(id);
		
		return "redirect:/dashboard";
	}
	


	//UPDATES
	//remove dorm from student
	//	Have a method handler in the controller for the following example url: /dorms/3/remove?student=1. This method should remove student with id 1 from the dorm with id 3. Remove multiple students from a single dormitory.
	@GetMapping("/dorms/{dorm_id}/remove")
	public String removeStudentromDorm(@PathVariable("dorm_id") Long dorm_id, @RequestParam(value="student", required=false) Long student_id) {
		Student student = this.studentService.getSingleStudent(student_id);
//		Dorm dorm = this.dormService.getSingleDorm(dorm_id); //not used
		
		student.setDorm(null);
	     
	    this.studentService.updateStudent(student);
	    
	    return "redirect:/dashboard";
	}
}
