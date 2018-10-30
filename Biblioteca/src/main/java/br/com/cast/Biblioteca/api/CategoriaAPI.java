package br.com.cast.Biblioteca.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.Biblioteca.dto.CategoriaDTO;
import br.com.cast.Biblioteca.service.CategoriaService;

@RestController
@RequestMapping(path = "categoria")
public class CategoriaAPI {
	
	@Autowired
	private CategoriaService cService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CategoriaDTO> buscarTodos(){
		List<CategoriaDTO> listarCategorias = cService.buscarTodos();
		return listarCategorias;
	}

}
