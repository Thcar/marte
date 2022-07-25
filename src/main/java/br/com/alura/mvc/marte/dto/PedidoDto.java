package br.com.alura.mvc.marte.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoDto {

	private String nomeProduto;
	private BigDecimal valorProduto;
	private LocalDate dataEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricaoProduto;

	public PedidoDto() {
		
	}

	public PedidoDto(String nomeProduto, BigDecimal valorProduto, LocalDate dataEntrega, String urlProduto,
			String urlImagem, String descricaoProduto) {
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.dataEntrega = dataEntrega;
		this.urlProduto = urlProduto;
		this.urlImagem = urlImagem;
		this.descricaoProduto = descricaoProduto;

	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

}
