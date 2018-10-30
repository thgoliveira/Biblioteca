package br.com.cast.Biblioteca.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.Biblioteca.dto.LivroDTO;
import br.com.cast.Biblioteca.service.LivroService;

@RestController
@RequestMapping(path = "/biblioteca")
public class LivroAPI {
	
	@Autowired
	private LivroService bService;
	
	
	@GetMapping(path = "/teste")
	public String teste() {
		return "Teste";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<LivroDTO> buscarTodos() {
		List<LivroDTO> listarLivros = bService.buscarTodos();
		return listarLivros;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void inserir(@RequestBody LivroDTO livroDto) throws Exception{
		bService.salvar(livroDto);
	}
	
	@DeleteMapping(path="/{id}")
	public void remover(@PathVariable("id") Integer id) {
		bService.excluirLivro(id);
	}
	
	@GetMapping(path="/{id}")
	public LivroDTO buscarPorID(@PathVariable("id") Integer id) {
		LivroDTO lDto = bService.buscarPorID(id);
		return lDto;
	}

}
