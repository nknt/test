package net.roseindia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import database.DBAccount;

import java.util.Map;
import javax.validation.Valid;

import net.roseindia.form.Account;
import net.roseindia.form.LoginForm;

@Controller
@RequestMapping("loginform.html")
public class LoginController extends DBAccount{
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model) {
		if (result.hasErrors()) {
			return "loginform";
		}
		loginForm = (LoginForm) model.get("loginForm");
		
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		
		Account acc = login(userName, password);
		
		if (acc == null) {
			return "loginfail";
		}
		model.put("account", acc);
		return "loginsuccess";
	}

}
