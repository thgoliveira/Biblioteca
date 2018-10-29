package br.com.cast.Biblioteca.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.Biblioteca.service.LivroService;

@Component
public class BibliotecaClient {

	private RestTemplate client;
	private LivroService bService;
	
	public BibliotecaClient(RestTemplateBuilder builder) {
		this.client = builder.build();
	}
	
	
}
