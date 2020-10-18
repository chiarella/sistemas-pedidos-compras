package br.com.mvc.sistemacompras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mvc.sistemacompras.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
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
