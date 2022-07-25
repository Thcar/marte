package br.com.alura.mvc.marte.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.marte.modelos.Pedido;
import br.com.alura.mvc.marte.modelos.StatusPedido;

public class PedidoWebRequest {
	//Mesmos nomes(name) dos inputs do formulário;
	@NotBlank //NotBlank.pedidoWebRequest.nomeProduto; Caso este campo seja nulo, me dará um erro;
	private String nomeProduto;
	@NotBlank 
	private String urlProduto;
	@NotBlank 
	private String urlImagem;
	private String descricaoProduto;

	public PedidoWebRequest(String nomeProduto, String urlProduto, String urlImagem, String descricaoProduto) {
		this.nomeProduto = nomeProduto;
		this.urlProduto = urlProduto;
		this.urlImagem = urlImagem;
		this.descricaoProduto = descricaoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(this.nomeProduto);
		pedido.setUrlImagem(this.urlImagem);
		pedido.setUrlProduto(this.urlProduto);
		pedido.setDescricaoProduto(this.descricaoProduto);
		pedido.setStatus(StatusPedido.ENTREGUE);
		return pedido;
	}
	

}
