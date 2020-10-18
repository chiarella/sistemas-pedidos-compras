package br.com.mvc.sistemacompras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {
	
	
	@GetMapping("/hello")
	/*
	 * Ao invé de utilizar 	
	 * public String hello(HttpServletRequest request) {
	 * 	request.setAttribute("nome", "Mundo");
	 *  return "hello";
	 *  Utilizaremos model 
	 */
	public String hello(Model model) {
		model.addAttribute("nome", "Mundo");
		return "hello";
	}

}
