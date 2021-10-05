package com.nelito.signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nelito.signup.model.Login;
import com.nelito.signup.model.ResponseObject;
import com.nelito.signup.repository.loginRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class loginController {

	@Autowired
	loginRepo loginrepo;

	@PostMapping("/view")
	public ResponseEntity<ResponseObject> ViewData(@RequestBody Login login) {
		ResponseObject respObj = new ResponseObject();

		List<Login> viewlist = loginrepo.findByUsername(login.getUsername());

		if (viewlist.size() > 0) {
			respObj.setRespcode("200");
			respObj.setRespmsg("");
			respObj.setRespstatus("success");
			respObj.setResultset(viewlist);

		} else {
			respObj.setRespcode("300");
			respObj.setRespmsg("user doesn't exists");
			respObj.setRespstatus("failed");
		}

		return new ResponseEntity<ResponseObject>(respObj, HttpStatus.OK);

	}

	@PostMapping("/signup")
	public ResponseEntity<ResponseObject> signUp(@RequestBody Login login) {
		ResponseObject respObj = new ResponseObject();

		List<Login> loginList = loginrepo.findByUsername(login.getUsername());

		if (loginList.size() == 0) {
			loginrepo.save(login);
			respObj.setRespcode("200");
			respObj.setRespmsg(null);
			respObj.setRespstatus("success");
		} else {
			respObj.setRespcode("300");
			respObj.setRespmsg("user already exists");
			respObj.setRespstatus("failed");
		}

		return new ResponseEntity<ResponseObject>(respObj, HttpStatus.OK);
	}

	@PostMapping("/login")

	public ResponseEntity<ResponseObject> userLogin(@RequestBody Login login) {
		ResponseObject respObj = new ResponseObject();

		List<Login> userlogin = loginrepo.findByUsername(login.getUsername());

		

		if (userlogin.size() == 0) {
			respObj.setRespcode("300");
			respObj.setRespmsg("sign up to login");
			respObj.setRespstatus("failed");

		} else {

			Login user = userlogin.get(0);

			if (user.getPassword().equals(login.getPassword())) {
				respObj.setRespcode("200");
				respObj.setRespmsg("login successful");
				respObj.setRespstatus("success");
			} else {
				respObj.setRespcode("300");
				respObj.setRespmsg("login unsuccessful");
				respObj.setRespstatus("failed");

			}

		}

		return new ResponseEntity<ResponseObject>(respObj, HttpStatus.OK);

	}

}
