package br.com.mvc.sistemacompras.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.sistemacompras.dto.RequisicaoNovoPedido;
import br.com.mvc.sistemacompras.model.Pedido;
import br.com.mvc.sistemacompras.repository.PedidoRepository;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository repository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("/novo") //@Valid - para funcionar @NotBlank da classe DTO
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		if (result.hasErrors()) {
			//Se tiver erro retonar o formulario
			return "pedido/formulario";
		}

//		//VALIDAÇÃO - Não deixar inserir ses estiver nulo ou vazio
//		if(requisicao.getNomeProduto() == null || requisicao.getNomeProduto().isEmpty()) {
//			return "pedido/formulario";
//		}
		
		Pedido pedido =  requisicao.toPedido();
		repository.save(pedido);
		
		System.out.println("CRIANDO NOVO PEDIDO");
		return "pedido/formulario";
	}
	
}
