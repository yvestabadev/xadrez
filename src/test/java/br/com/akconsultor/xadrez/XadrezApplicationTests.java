package br.com.akconsultor.xadrez;


import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class XadrezApplicationTests {
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void jogoCompleto() throws Exception {
		URI uri = new URI("/novoJogo");
		String jsonVerifica;
		String jsonMove;
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri));
		jsonVerifica = "{"
				+ "	\"jogoId\": 1,"
				+ "	\"ehBranca\": true,"
				+ "	\"coluna\": 5,"
				+ "	\"linha\": 1"
				+ "}";
		uri = new URI("/verifica");
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(jsonVerifica)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
		
		URI uriMove = new URI("/move");
		jsonMove = "{"
				+ "	\"jogoId\": 1,"
				+ "    \"ehBranca\": true,"
				+ "	\"colunaAtual\": 5,"
				+ "	\"linhaAtual\": 1,"
				+ "	\"colunaDestino\": 5,"
				+ "	\"linhaDestino\": 2"
				+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uriMove)
				.content(jsonMove)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
		
		jsonMove = "{"
				+ "	\"jogoId\": 1,"
				+ "    \"ehBranca\": false,"
				+ "	\"colunaAtual\": 4,"
				+ "	\"linhaAtual\": 6,"
				+ "	\"colunaDestino\": 4,"
				+ "	\"linhaDestino\": 4"
				+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uriMove)
				.content(jsonMove)
				.contentType(MediaType.APPLICATION_JSON));
		
		jsonMove = "{"
				+ "	\"jogoId\": 1,"
				+ "    \"ehBranca\": true,"
				+ "	\"colunaAtual\": 6,"
				+ "	\"linhaAtual\": 1,"
				+ "	\"colunaDestino\": 6,"
				+ "	\"linhaDestino\": 3"
				+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uriMove)
				.content(jsonMove)
				.contentType(MediaType.APPLICATION_JSON));
		
		jsonMove = "{"
				+ "	\"jogoId\": 1,"
				+ "    \"ehBranca\": false,"
				+ "	\"colunaAtual\": 3,"
				+ "	\"linhaAtual\": 7,"
				+ "	\"colunaDestino\": 7,"
				+ "	\"linhaDestino\": 3"
				+ "}";
		
		String resultado = "{"
				+ "    \"check\": true,"
				+ "    \"checkmate\": true"
				+ "}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uriMove)
				.content(jsonMove)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.content().json(resultado));
		
	}

}
