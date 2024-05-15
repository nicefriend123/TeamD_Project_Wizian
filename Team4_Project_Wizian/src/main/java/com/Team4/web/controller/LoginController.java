package com.Team4.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public String logIn(@RequestParam("user_no") String id, @RequestParam("pw") String pw, HttpSession session,  Model model) {
	    boolean loggedIn = loginService.checkLogin(id, pw);
	    if (loggedIn) {
	    	Map<String, Object> userInfo = loginService.getName(id);
            String name = (String) userInfo.get("stud_nm");
            String userNo = (String) userInfo.get("stud_no");
            session.setAttribute("username", name);
            session.setAttribute("userNo", userNo);
            System.out.println(name);
            System.out.println(userNo);
	        return "redirect:/index";
	    } else {
	    	model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
	        return "/login";
	    }
	}
	
	@PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/index";
    }

}
