package br.com.cast.Biblioteca.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cast.Biblioteca.modelo.Livro;

@Repository
public class LivroRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void inserir(Livro livro) {
		em.persist(livro);
	}
	
	@Transactional
	public void alterar(Livro livro) {
		em.merge(livro);
	}

	@SuppressWarnings("unchecked")
	public List<Livro> buscarLivros() {
		StringBuilder qlString = new StringBuilder();
		qlString.append("select l ")
				.append(" from ").append(Livro.class.getName()).append(" l ")
				.append(" join fetch l.autor ")
				.append(" join fetch l.categoria" );
		
		Query query = em.createQuery(qlString.toString());
		return query.getResultList();
		
	}
	
	/**
	 * Buscar Livro por id
	 * 
	 * @param id
	 * @return
	 */
	public Livro buscarPorId(Integer id) {
		return em.find(Livro.class, id);
	}

	@Transactional
	public void excluir(Livro livro) {
		em.remove(livro);
		
	}
}
