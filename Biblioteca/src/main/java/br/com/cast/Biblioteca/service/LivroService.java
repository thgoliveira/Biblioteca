package br.com.cast.Biblioteca.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.Biblioteca.dto.AutorDTO;
import br.com.cast.Biblioteca.dto.CategoriaDTO;
import br.com.cast.Biblioteca.dto.LivroDTO;
import br.com.cast.Biblioteca.modelo.Autor;
import br.com.cast.Biblioteca.modelo.Categoria;
import br.com.cast.Biblioteca.modelo.Livro;
import br.com.cast.Biblioteca.repositorio.AutorRepository;
import br.com.cast.Biblioteca.repositorio.CategoriaRepository;
import br.com.cast.Biblioteca.repositorio.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository lRep;
	
	@Autowired
	private AutorRepository aRep;
	
	@Autowired
	private CategoriaRepository cRep;
	
	public LivroDTO buscarPorID(Integer id) {
		LivroDTO lDto = new LivroDTO();
		Livro livro = lRep.buscarPorId(id);
		lDto.setId(livro.getId());
		lDto.setTitulo(livro.getTitulo());
		lDto.setPublicacao(dateToString(livro.getPublicacao()));
		
		AutorDTO aDto = new AutorDTO();
		aDto.setId(livro.getAutor().getId());
		aDto.setNome(livro.getAutor().getNome());
		aDto.setPseudonimo(livro.getAutor().getPseudonimo());
		lDto.setAutorDTO(aDto);
		
		CategoriaDTO cDto = new CategoriaDTO();
		cDto.setId(livro.getCategoria().getId());
		cDto.setDescricao(livro.getCategoria().getDescricao());
		
		lDto.setCategoriaDTO(cDto);
		
		return lDto;
	}
	
	public List<LivroDTO> buscarTodos() {

		List<LivroDTO> livrosDTO = new ArrayList<>();
		List<Livro> livros = lRep.buscarLivros();
		
		for (Livro livro : livros) {

			LivroDTO livroDTO = new LivroDTO();
			livroDTO.setId(livro.getId());
			livroDTO.setTitulo(livro.getTitulo());
			livroDTO.setPublicacao(dateToString(livro.getPublicacao()));

			Autor autor = livro.getAutor();
			Categoria categoria = livro.getCategoria();

			if (autor != null && categoria != null) {
				AutorDTO autorDTO = new AutorDTO();
				autorDTO.setId(autor.getId());
				autorDTO.setNome(autor.getNome());
				autorDTO.setPseudonimo(autor.getPseudonimo());

				CategoriaDTO categoriaDTO = new CategoriaDTO();
				categoriaDTO.setId(categoria.getId());
				categoriaDTO.setDescricao(categoria.getDescricao());

				livroDTO.setAutorDTO(autorDTO);
				livroDTO.setCategoriaDTO(categoriaDTO);
			}

			livrosDTO.add(livroDTO);
		}

		return livrosDTO;
	}
	
	public void salvar(LivroDTO livroDTO){
		
		Autor autor = aRep.buscarPorId(livroDTO.getAutorDTO().getId());
		Categoria categoria = cRep.buscarPorId(livroDTO.getCategoriaDTO().getId());
			
		Livro livro = new Livro();
		livro.setId(livroDTO.getId());
		livro.setTitulo(livroDTO.getTitulo());
		livro.setPublicacao(stringToDate(livroDTO.getPublicacao()));
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		if (livro.getId() != null) {
			lRep.alterar(livro);
		} else {
			lRep.inserir(livro);
		}
		
	}
	
	public void excluirLivro(Integer id) {
		Livro livro = lRep.buscarPorId(id);
		lRep.excluir(livro);
	}
	
	public Date stringToDate(String data) {
		Date dataFormatada = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataFormatada = format.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}

	public String dateToString(Date date) {
		String dataFormatada = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataFormatada = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}


}
