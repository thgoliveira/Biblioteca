package br.com.cast.Biblioteca.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void remover(Integer id) {
		bService.excluirLivro(id);
	}

}
