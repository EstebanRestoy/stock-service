package com.stock.stock;

import com.stock.stock.controller.StockController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StockApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StockController stockController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetStockByISBN() throws Exception {
		this.mockMvc.perform(get("/stock/154871564789")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void testGetStockByISBNWithFakeValues() throws Exception {
		this.mockMvc.perform(get("/stock/dadedaede")).andDo(print()).andExpect(status().isBadRequest())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

		this.mockMvc.perform(get("/stock/154871564782")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

}
