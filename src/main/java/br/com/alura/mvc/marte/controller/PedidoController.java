package br.com.alura.mvc.marte.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.marte.dto.PedidoWebRequest;
import br.com.alura.mvc.marte.modelos.Pedido;
import br.com.alura.mvc.marte.repository.PedidoRepository;


@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/formulario")
	public String formulario(PedidoWebRequest pedidoWebRequest){
		return "pedido/formulario.html";
	}
	//O PedidoWebRequest irá receber os dados do formulário;
	@PostMapping("/novo")
	public String novo(@Valid PedidoWebRequest pedidoWebRequest, BindingResult result){
		if(result.hasErrors()) {
			return "pedido/formulario.html" ;
			
		}
		Pedido pedido = pedidoWebRequest.toPedido();
		this.pedidoRepository.save(pedido);
		return "redirect:/home";//depois de um 'post', sempre um redirect. O cliente fará um novo request - client-side;;
	}
}
