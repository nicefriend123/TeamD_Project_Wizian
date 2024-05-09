package com.Team4.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Team4.web.entity.Department;
import com.Team4.web.entity.Employee;
import com.Team4.web.entity.Study;
import com.Team4.web.entity.User;
import com.Team4.web.repository.JoinExamRepo;
import com.Team4.web.service.JoinExamRepoService;
import com.Team4.web.service.StudyRepoService;
import com.Team4.web.service.UserRepoService;

import jakarta.persistence.EntityManager;

@Controller
@RequestMapping("/study")
public class StudyController {
	
	@Autowired
	StudyRepoService studyRepoService;
	
	@Autowired
	UserRepoService userRepoService;
	
	@Autowired
	JoinExamRepoService joinExamRepoService;
	
	@GetMapping("/list")
	public String doStudyList(Model model) {
		
//		List<Study> list = studyRepoService.doSelectAll();
//		
//		model.addAttribute("list", list);
//		
//		System.out.println("list다 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		System.out.println(list);
//		System.out.println("list 다 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		
//		//studyRepoService.doDelete(1);
//		
//		Study study = new Study();
//		study.setContents("테스트입니다.");
//		study.setStudy_day("오늘입니다.");
//		studyRepoService.doInsert(study);
//		
//		study = new Study(); 
//		list = studyRepoService.doFindById(3);
//		System.out.println("스터디 : " + list);
//		
//		List<User> userList = userRepoService.doSelectAll();
//		System.out.println(userList);
//		
//		User user = new User();
//		user.setUser_no("111002");
//		user.setSe_cd("11");
//		user.setNo("1002");
//		
//		userRepoService.doInsert(user);
		
		
		//JOIN 부분 ------------------
//		
//		Employee emp = new Employee();
//		emp.setId(1234L);
//		emp.setName("홍길동");
//		
//		Department dep = new Department();
//		dep.setId(0000L);
//		dep.setName("총무부");
//		emp.setDepartment(dep);  //이렇게 emp에 넣을 수 있다.
//		
//		Employee emp2 = new Employee();
//		emp2.setId(9876L);
//		emp2.setName("김누구");
//		emp2.setDepartment(dep);
//
//		System.out.println(emp);
		
		List<Employee> empList = joinExamRepoService.doSelAll();
		for (Employee emp : empList) {
			System.out.println(emp.getId());
			System.out.println(emp.getName());
		    System.out.println(emp.getDepartment().getId());
		    System.out.println(emp.getDepartment().getName());
		}
		
		
		return "redirect:index";
	}

}