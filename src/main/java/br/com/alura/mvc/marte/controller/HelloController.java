package br.com.alura.mvc.marte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//O servlet do Spring MVC recebe as requisições e delega para "controllers mais específicos";
//Como View, o Spring MVC usa Thymeleaf;
//O Thymeleaf é uma 'alternativa' a tecnologia JSP, serve para gerar HTML dinâmicamente
//EL ${variavel};
//Os Métodos no controller que atendem requisições HTTP são chamados de action;
@Controller
public class HelloController {
	//Ação (action) que processa a minha requisição;(Métodos)
	@GetMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("nome", "Marte");
		return "hello.html";
	}

}
