package br.com.alura.mvc.marte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.marte.modelos.Pedido;
import br.com.alura.mvc.marte.modelos.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido statusPedido);

	
	

}
