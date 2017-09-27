package com.pal.farm.test.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pal.farm.controller.ChickenControllerImpl;
import com.pal.farm.model.Chicken;
import com.pal.farm.service.ChickenService;



@RunWith(MockitoJUnitRunner.class)
public class TestChickenController {
	
	private static final Integer ID = 5;
	private static final String TYPE = "Black Rock";
	private static final String FRECUENCY = "5";
	private static final Chicken CHICKEN = new Chicken();
	
	private static final String JSON1 = "{\"type\":\"Light Sussex\",\"frecuency\":\"10\"}";
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private ChickenControllerImpl chickenController = new ChickenControllerImpl();
	
	@Mock
	private ChickenService chickenService;

	@Before
	public void init() {
		
	    // Process mock annotations
//        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        mockMvc = MockMvcBuilders.standaloneSetup(chickenController).build();
 
		
		CHICKEN.setType(TYPE);
		CHICKEN.setFrecuency(FRECUENCY);
	}

//	@Test
//	public void testCreate() {
//		Mockito.when(chickenService.create(new LoginDTO("KO", "KO"))).thenThrow(InvalidUserException.class);
//		mockMvc.perform(MockMvcRequestBuilders.post("/v1/auth").contentType(ContentType.APPLICATION_JSON.getMimeType())
//				.content(JSON1)).andExpect(MockMvcResultMatchers.status().isUnauthorized());
//	}
//
//	@Test
//	public void testTokenKoExpiredJwtException() throws Exception {
//		Mockito.when(chickenService.validateToken(Mockito.any())).thenThrow(ExpiredJwtException.class);
//		mockMvc.perform(MockMvcRequestBuilders.get("/v1/auth/validate")
//				.contentType(ContentType.APPLICATION_JSON.getMimeType()).content(JSON1))
//				.andExpect(MockMvcResultMatchers.status().isUnauthorized());
//	}
//
//	@Test
//	public void testTokenKoSignatureException() throws Exception {
//		Mockito.when(jwtService.validateToken(Mockito.any())).thenThrow(SignatureException.class);
//		mockMvc.perform(MockMvcRequestBuilders.get("/v1/auth/validate")
//				.contentType(ContentType.APPLICATION_JSON.getMimeType()).content(JSON_KO))
//				.andExpect(MockMvcResultMatchers.status().isUnauthorized());
//	}
//
//	@Test
//	public void testTokenKoInvalidRequestException() throws Exception {
//		Mockito.when(requestService.extractToken(Mockito.any())).thenThrow(new InvalidRequestException());
//		mockMvc.perform(MockMvcRequestBuilders.get("/v1/auth/validate")
//				.contentType(ContentType.APPLICATION_JSON.getMimeType()).content(JSON_KO))
//				.andExpect(MockMvcResultMatchers.status().isUnauthorized());
//	}
//
//	@Test
//	public void testTokenOk() throws Exception {
//		Mockito.when(jwtService.loginUser(new LoginDTO("KO", "KO"))).thenReturn(createTokenDTO());
//		mockMvc.perform(MockMvcRequestBuilders.post("/v1/auth").contentType(ContentType.APPLICATION_JSON.getMimeType())
//				.content("{\"email\":\"KO\",\"password\":\"KO\"}")).andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.accessToken", org.hamcrest.core.Is.is(ACCESS)));
//	}
//
//	@Test
//	public void testTokenValidationOk() throws Exception {
//		Mockito.when(requestService.extractToken(Mockito.any())).thenReturn(ACCESS);
//		Mockito.when(jwtService.validateToken(ACCESS)).thenReturn(new ValidTokenDTO(USERNAME));
//		mockMvc.perform(
//				MockMvcRequestBuilders.get("/v1/auth/validate").contentType(ContentType.APPLICATION_JSON.getMimeType()))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.username", org.hamcrest.core.Is.is(USERNAME)));
//	}
//
//	
//	@Test
//	public void testGetByIdOK() throws Exception {
//	    Mockito.when(chickenService.findById(ID)).thenReturn(CHICKEN);
//	    mockMvc.perform(MockMvcRequestBuilders.get("/chicken/{id}", ID)
//	    		.content(JSON1)).andExpect(status().isOk()) ;
//	    
//	}
}
