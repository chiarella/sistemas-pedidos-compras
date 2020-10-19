package br.com.mvc.sistemacompras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mvc.sistemacompras.model.Pedido;
import br.com.mvc.sistemacompras.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido status);

	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public List<Pedido> recuperaTodosOsPedidos() {
//		Query query =  entityManager.createQuery("Select p from Pedido p", Pedido.class);
//		return query.getResultList();
//				
//	}
	
	//Herda de JPA REPOSITORY
//	public List<Pedido> findAll();
	

}
