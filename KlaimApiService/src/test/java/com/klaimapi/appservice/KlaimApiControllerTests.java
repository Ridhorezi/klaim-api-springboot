package com.klaimapi.appservice;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klaimapi.appservice.klaim.KlaimApiController;
import com.klaimapi.appservice.klaim.KlaimService;
import com.klaimapi.common.Klaim;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(KlaimApiController.class)
public class KlaimApiControllerTests {

	private final String END_POINT_PATH = "/v1/klaims";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	KlaimService klaimService;

	@Test
	public void testAddShouldReturn400BadRequest() throws Exception {

		Klaim klaim = new Klaim();

		String bodyContent = objectMapper.writeValueAsString(klaim);

		mockMvc.perform(post(END_POINT_PATH).contentType("application/json").content(bodyContent))
				.andExpect(status().isBadRequest()).andDo(print());
	}

	@Test
	public void testAddShouldReturn201Created() throws Exception {

		Klaim klaim = new Klaim();

		klaim.setLob("test");
		klaim.setPenyebabKlaim("Macet");
		klaim.setPeriode(new Date());
		klaim.setNilaiBebanKlaim(1.00);

		Mockito.when(klaimService.add(Mockito.any(Klaim.class))).thenReturn(klaim);

		String bodyContent = objectMapper.writeValueAsString(klaim);

		mockMvc.perform(post(END_POINT_PATH).contentType("application/json").content(bodyContent))
				.andExpect(status().isCreated()).andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.lob", is("test"))).andExpect(jsonPath("$.penyebab_klaim", is("Macet")))
				.andExpect(header().string("Location", "/v1/klaims/test")).andDo(print());
	}
}
