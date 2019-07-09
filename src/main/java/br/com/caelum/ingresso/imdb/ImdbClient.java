package br.com.caelum.ingresso.imdb;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.Filme;

@Component
public class ImdbClient {
	
	public <T> Optional<T> buscaAsInformacoesDoFilme(Filme filme, Class<T> tClass) {
		RestTemplate restTemplate = new RestTemplate();
		String titulo =  filme.getNome().replace(" ", "+");
		String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s", titulo);
		
		try {
			return Optional.of(restTemplate.getForObject(url, tClass));
		} catch (RestClientException e) {
			e.printStackTrace();
			Optional.empty();
		}
		
		return null;
	}

}
