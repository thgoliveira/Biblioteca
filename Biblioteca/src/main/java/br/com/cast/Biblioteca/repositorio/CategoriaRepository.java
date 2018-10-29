package br.com.cast.Biblioteca.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.Biblioteca.modelo.Categoria;

@Repository
public class CategoriaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Buscar Categoria por id
	 * @param id
	 * @return
	 */
	public Categoria buscarPorId(Integer id) {
		return em.find(Categoria.class, id);
	}
	
	/**
	 * Buscar todas as categorias
	 * @return
	 */
	public List<Categoria> buscarTodas(){
		StringBuilder jpql = new StringBuilder();
		jpql.append("select c ")
			.append("from ").append(Categoria.class.getName()).append(" c ");
		
		return em.createQuery(jpql.toString(), Categoria.class)
				 .getResultList();
	}

}
