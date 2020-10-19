package br.com.mvc.sistemacompras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.sistemacompras.model.Pedido;
import br.com.mvc.sistemacompras.model.StatusPedido;
import br.com.mvc.sistemacompras.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository repository;

	@GetMapping
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

	@GetMapping("/{status}")
	//@Pathvariable (recebe do front
	public String porStatus(@PathVariable("status") String status, Model model) {
		//ValueOf recebe uma String e retorna um enum "Status pedido"
		List<Pedido> pedidos =  repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home";
	}
	
	//Metodo para quando o usuario digitar um valor errado
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}
