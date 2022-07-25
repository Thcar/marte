package br.com.alura.mvc.marte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.marte.modelos.Pedido;
import br.com.alura.mvc.marte.modelos.StatusPedido;
import br.com.alura.mvc.marte.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping()
	public String home(Model model) {
		List<Pedido> pedidos = this.pedidoRepository.findAll();
//			PedidoDto pedidoDao = new PedidoDto();
//			pedidoDao.setDataEntrega(pedidos.getDataEntrega());
//			pedidoDao.setDescricaoProduto(pedidos.getDescricaoProduto());
//			pedidoDao.setNomeProduto(pedidos.getNomeProduto());
//			pedidoDao.setUrlImagem(pedidos.getUrlImagem());
//			pedidoDao.setUrlProduto(pedidos.getUrlProduto());
//			pedidoDao.setValorProduto(pedidos.getValorProduto());

		model.addAttribute("pedidos", pedidos);
		return "home.html";

	}
	//OBS
	// Interessante esse método aqui. Ele pegar o parâmetro na url da requsição e processa no método - action tipo get;
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		
		StatusPedido statusPedido = StatusPedido.valueOf(status.toUpperCase());
		List<Pedido> pedidos = this.pedidoRepository.findByStatus(statusPedido);
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home.html";

	}
	//OBS
	//caso acesse alguma url que não tenha.. 
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		
		return "redirect:/home";
		
		//Nesse caso, o Spring MVC executará o redirecionamento 'client-side'. Isto é, ele 
		//devolve uma resposta HTTP para pedir uma nova requisição para a URL /home.
		//Também existe o redirecionamento 'server-side', mas devemos usar o prefixo forward.
		
		//return "forward:/home"; ->Nesse caso, o fluxo volta apenas para o Front-Controller do Spring MVC e ele chama a nova action.
		
		//Diferença: Enquanto o redirecionamento client-side causa uma nova requisição, o server-side continua dentro da mesma requisição HTTP.
		//Regra: Nesse exemplo, o melhor seria usar redirect, pois estamos trabalhando com uma requisição POST, seguindo a regra: "always redirect after post".
	}

}
