package br.com.cast.Biblioteca.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.Biblioteca.dto.AutorDTO;
import br.com.cast.Biblioteca.service.AutorService;

@RestController
@RequestMapping(path = "autor")
public class AutorAPI {
	
	@Autowired
	private AutorService aService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<AutorDTO> buscarTodos(){
		List<AutorDTO> listarAutores = aService.buscarTodos();
		return listarAutores;
	}

}
