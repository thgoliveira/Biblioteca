package br.com.cast.Biblioteca.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.Biblioteca.modelo.Autor;

@Repository
public class AutorRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Buscar Autor por id
	 * @param id
	 * @return
	 */
	public Autor buscarPorId(Integer id) {
		return em.find(Autor.class, id);
	}
	
	/**
	 * Buscar todos os autores
	 * @return
	 */
	public List<Autor> buscarTodos(){
		StringBuilder jpql = new StringBuilder();
		jpql.append("select a ")
			.append("from ").append(Autor.class.getName()).append(" a ");
		
		return em.createQuery(jpql.toString(), Autor.class)
				 .getResultList();
	}

}
