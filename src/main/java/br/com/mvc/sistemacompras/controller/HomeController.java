package br.com.mvc.sistemacompras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mvc.sistemacompras.model.Pedido;
import br.com.mvc.sistemacompras.repository.PedidoRepository;

@Controller
public class HomeController {

	@Autowired
	private PedidoRepository repository;

	@GetMapping("/home")
	public String home(Model model) {
		List<Pedido> pedidos =  repository.findAll();
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
// Desse forma, os parâmetros do método ficam reservados para os dados
//	da requisição (o input) e o	retorno do método fica reservado para os dados da view (o output).

	//	@GetMapping
//	public ModelAndView home() {
//		List<Pedido> pedidos =  repository.findAll();
//		ModelAndView mv =  new ModelAndView("home");
//		model.addObject("pedidos", pedidos);
//		return mv;
//	}
	
	
}
