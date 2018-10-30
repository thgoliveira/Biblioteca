package br.com.cast.Biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.Biblioteca.dto.AutorDTO;
import br.com.cast.Biblioteca.modelo.Autor;
import br.com.cast.Biblioteca.repositorio.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository aRep;

	public List<AutorDTO> buscarTodos() {

		List<AutorDTO> autoresDto = new ArrayList<>();
		List<Autor> autores = aRep.buscarTodos();
		
		for (Autor autor : autores) {
			AutorDTO aDto = new AutorDTO();
			aDto.setId(autor.getId());
			aDto.setNome(autor.getNome());
			aDto.setPseudonimo(autor.getPseudonimo());
			autoresDto.add(aDto);
		}
		return autoresDto;
	}

}
