package com.qc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "hello";
	}

	@RequestMapping("displayname")
	public String displayname(HttpServletRequest req) {
		String user = (String) req.getParameter("username");
		req.setAttribute("user", user);
		return "displayName";

	}
}