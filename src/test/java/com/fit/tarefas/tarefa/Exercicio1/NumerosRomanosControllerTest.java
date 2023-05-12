package com.fit.tarefas.tarefa.Exercicio1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.tarefas.tarefa.Exercicio1.NumerosRomanosController;


@WebMvcTest(NumerosRomanosController.class)
public class NumerosRomanosControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@BeforeEach
	void setUp() {
	
	}
	
	
	@Test
	public void getNumeroRomano__with_success() throws Exception {
		mockMvc.perform(get("/numeroRomano/2"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
		.andExpect(MockMvcResultMatchers.jsonPath("$", is("II")));
	}
}
