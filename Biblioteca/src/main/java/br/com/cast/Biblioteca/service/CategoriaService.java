package br.com.cast.Biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.Biblioteca.dto.CategoriaDTO;
import br.com.cast.Biblioteca.modelo.Categoria;
import br.com.cast.Biblioteca.repositorio.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository cRep;
	
	public List<CategoriaDTO> buscarTodos(){
		
		List<CategoriaDTO> categoriasDto = new ArrayList<>();
		List<Categoria> categorias = cRep.buscarTodas();
		
		for (Categoria categoria : categorias) {
			CategoriaDTO cDto = new CategoriaDTO();
			cDto.setId(categoria.getId());
			cDto.setDescricao(categoria.getDescricao());
			categoriasDto.add(cDto);
		}
		return categoriasDto;
	}
}
