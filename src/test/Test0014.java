package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class Test0014 {

	private static Cuenta cta12345;
	private static Cuenta cta67890;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		double inicio12345=50;
		double inicio67890=0;
		cta12345= new Cuenta(inicio12345);
		cta67890= new Cuenta(inicio67890);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCasoT0014() {
		cta12345.reintegro(200); 
		cta67890.reintegro(350);   
		cta12345.ingreso(100);  
		cta67890.reintegro(200); 
		cta67890.reintegro(150);
		cta12345.reintegro(200);
		cta67890.ingreso(50);
		cta67890.reintegro(100);
		
		assertEquals(-250, cta12345.getSaldo());
		assertEquals(-450, cta67890.getSaldo());
		assertEquals(3, cta12345.devolverMov().size());
		assertEquals(3, cta67890.devolverMov().size());
	}

}
