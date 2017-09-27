package com.pal.farm.test.service;

/////////////////////////////////////////////////////////////////////////////////  test unitario 90% -> excluyendo Modelos y DTO


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.pal.farm.dao.ChickenDAO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Chicken;
import com.pal.farm.service.ChickenService;
import com.pal.farm.service.ChickenServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestChickenService {


	private static Chicken CHICKEN1;
	private static Chicken CHICKEN2;
	private static Chicken CHICKEN3;
	private static List<Chicken> LIST1;
	private static List<Chicken> LIST2;
	private static Pageable PAGEABLE;
	private static Page<Chicken> PAGE;
	
	private static final Integer ID1 = 5;
	private static final String TYPE1 = "Black Rock";
	private static final String FRECUENCY1 = "5";
	
	private static final Integer ID2 = 6;
	private static final String TYPE2 = "Rhode Island";
	private static final String FRECUENCY2 = "3";
	
	private Chicken createTestChicken (Integer id, String type, String frecuency) {
		
		final Chicken c = new Chicken();
		c.setType(type);
		c.setFrecuency(frecuency);
		return c;
	}
	
	
	
	@InjectMocks
	private ChickenService chickenService = new ChickenServiceImpl();

	@Mock
	private ChickenDAO chickenDao;
	
	
	@Before
	public void init() {
		
		CHICKEN1 = createTestChicken(ID1, TYPE1, FRECUENCY1);
		CHICKEN2 = createTestChicken(ID2, TYPE2, FRECUENCY2);
		CHICKEN3 = createTestChicken(ID1, TYPE2, FRECUENCY2);
		
		// test OK
		LIST1 = new ArrayList<Chicken>();
		LIST1.add(CHICKEN1);
		
		// test KO en findOneByTypeAndFrecuency(). El primero no debe estar.
		LIST2 = new ArrayList<Chicken>();
		LIST2.add(CHICKEN1);
		LIST2.add(CHICKEN2);
		LIST2.add(CHICKEN3);
		
		PAGE = new PageImpl<Chicken>(LIST2, new PageRequest(1,3), LIST2.size());
		

		// Testean en chickenService.create() y chickenService.update()
		Mockito.when(chickenDao.save(CHICKEN1)).thenReturn(CHICKEN1);
		Mockito.when(chickenDao.save(CHICKEN2)).thenReturn(CHICKEN1);
		
		// Testea en chickenService.getAll()
//		Mockito.when(chickenDao.findAll(PAGEABLE)).thenReturn(PAGE);
		
		// Testea en chickenService.findById()
		Mockito.when(chickenDao.findOne(ID1)).thenReturn(CHICKEN1);
		Mockito.when(chickenDao.findOne(ID2)).thenReturn(CHICKEN1);

		// Testea en chickenService.findByTypeAndFrecuency()
		Mockito.when(chickenDao.findOneByTypeAndFrecuency(TYPE1, FRECUENCY1)).thenReturn(LIST1);
		Mockito.when(chickenDao.findOneByTypeAndFrecuency(TYPE2, FRECUENCY2)).thenReturn(LIST2);

	}
	
//	
//
//	
//	@Test
//	public void testCreateOK() throws NotFound { 
//		
//		final Chicken chicken = chickenService.create(CHICKEN1); 
//
//		Assert.assertNotNull(chicken);
//		Assert.assertEquals(chicken.getType(), TYPE1);
//		Assert.assertEquals(chicken.getFrecuency(), FRECUENCY1);
//		
//	}
//	
//	@Test(expected = AssertionError.class)
//	public void testCreateKO() throws NotFound { 
//		
//		final Chicken chicken = chickenService.create(new Chicken()); 
//
//		Assert.assertNotNull(chicken);
//		
//	}
//
//	
//	
//	@Test
//	public void testDeleteOK() throws CannotProceed { 
//		
//		// Requiere de test de integración para averiguar si borra el indicado.
//		// chickenDao.save(CHICKEN1);
//		chickenService.delete(CHICKEN1);  // return void
//		
//	}
//	
//	@Test
//	public void testDeleteKO() throws CannotProceed { 
//		
//		// Requiere de test de integración para averiguar si borra el indicado.
//		// chickenDao.save(CHICKEN1);
//		chickenService.delete(CHICKEN2);
//		
//	}
//
//	
//	
//	@Test
//	public void testUpdateOK() throws CannotProceed, NotFound {
//
//		// Requiere de test de integración para averiguar si borra el indicado.
//
//		final Chicken chickenUpdated = chickenService.update( CHICKEN1 );
//
//		Assert.assertNotNull(chickenUpdated);
////		Assert.assertEquals(chickenUpdated.getIdChicken(), ID1);
//		Assert.assertEquals(chickenUpdated.getType(), TYPE1);
//		Assert.assertEquals(chickenUpdated.getFrecuency(), FRECUENCY1);
//		
//	}
//
//	@Test(expected = AssertionError.class)
//	public void testUpdateKO() throws CannotProceed, NotFound {
//
//		// Requiere de test de integración para averiguar si borra el indicado.
//
//		final Chicken chickenUpdated = chickenService.update( CHICKEN1 );
//
//		Assert.assertNotNull(chickenUpdated);
////		Assert.assertEquals(chickenUpdated.getIdChicken(), ID2);
//		// suficiente con que el ID indicado no sea el del objeto
//		
//	}
//
//	
//	
//	@Test
//	public void testGetAllOK() throws NotFound {
//		
//		List<Chicken> chickens = chickenService.getAll(PAGEABLE);
//		
//		Assert.assertNotNull(chickens);
//		Assert.assertEquals(chickens, LIST2);
//		
//		chickens = chickenService.getAll(null);
//
//		Assert.assertNotNull(chickens);
//		Assert.assertEquals(chickens, LIST2);
//
//	}
//
//	@Test
//	public void testGetAllKO() throws NotFound { 
//		
//		final List<Chicken> chickens = chickenService.getAll(null);
//
//		Assert.assertNotNull(chickens);
//		Assert.assertNotEquals(chickens, LIST1); // contiene solo un pollo de los tres
//		
//	}
//
//	
//	
//	@Test
//	public void testFindByIdOK() throws NotFound { 
//		
//		final Chicken chicken = chickenService.findById(ID1); 
//
//		Assert.assertNotNull(chicken);
//		Assert.assertEquals(chicken.getType(), TYPE1);
//		Assert.assertEquals(chicken.getFrecuency(), FRECUENCY1);
//		
//	}
//
//	@Test
//	public void testFindByIdKO() throws NotFound {
//		
//		Chicken chicken = chickenService.findById(ID1); 
//
//		Assert.assertNotNull(chicken);
//		Assert.assertNotEquals(chicken.getType(), TYPE2);
//		Assert.assertNotEquals(chicken.getFrecuency(), FRECUENCY2);
//		
//		chicken = chickenService.findById(null); 
//
//		Assert.assertNull(chicken);
//		
//	}
//	
//	
//	
//	@Test
//	public void testFindByTypeAndFrecuencyOK() {	
//		
//		List<Chicken> chickens = chickenService.findByTypeAndFrecuency(TYPE1, FRECUENCY1); 
//
//		Assert.assertNotNull(chickens);
//		chickens.forEach(c -> {
//			Assert.assertEquals(c.getType(), TYPE1);
//			Assert.assertEquals(c.getFrecuency(), FRECUENCY1);
//		});
//	}
//	
//	@Test(expected = AssertionError.class)
//	public void testFindByTypeAndFrecuencyKO() {
//		
////		List<Animal> chickens = chickenService.findByTypeAndFrecuency(null, FRECUENCY1); 
//
////		Assert.assertNotNull(chickens);
////		
////		chickens.forEach(c -> Assert.assertNotEquals(c.getFrecuency(), FRECUENCY2) );
////		
////		
////		chickens = chickenService.findByTypeAndFrecuency(TYPE2, FRECUENCY2); 
////
////		Assert.assertNotNull(chickens);
////		chickens.forEach(c -> {
////			Assert.assertNotEquals(c.getType(), TYPE2);
////			Assert.assertNotEquals(c.getFrecuency(), FRECUENCY2);
////		});	
//		
//	}

}
