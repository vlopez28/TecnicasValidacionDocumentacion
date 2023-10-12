package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import restaurant.Ingrediente;
import restaurant.ItemReceta;
import restaurant.Producto;
import restaurant.ProductoBasico;
import restaurant.Receta;

public class RecetaTest {
	public static Receta receta;
//	public static Receta receta2;
	public static ItemReceta ir3;
	public static ItemReceta ir4;
	public static ItemReceta ir5;
	

	
	@BeforeAll
	public static void iniciarEjemplo() {
		//creo ingredientes
		Ingrediente huevo=new Ingrediente("huevo", "unidades",240, 100);
		Ingrediente papa = new Ingrediente("Papa","gramos",20000, 700);
		Ingrediente sal = new Ingrediente("Sal","gramos",1000, 200);
		

		//creo items receta
		ir3 =new ItemReceta(sal, 20);
		ir4 = new ItemReceta(huevo,4);
		ir5 = new ItemReceta(papa, 3);
		
		//creo receta
		receta = new Receta("Tortilla",15, 3000);
		receta.addIngrediente(ir3);
		receta.addIngrediente(ir4);
		receta.addIngrediente(ir5);
		
	}
	
	@Test
	@DisplayName("Una receta está compuesta por uno o más ingredientes ")
	public void verificarCantidadIngredientes() {
		//Assertions.assertFalse(receta.getIngredientes().isEmpty());
		Assertions.assertEquals(3, receta.getIngredientes().size());
	}
	
	
	@Test
	@DisplayName("No es posible realizar una receta si no se cuenta con todos los ingredientes")
	public void verificarIngredientes() {
		
		Assertions.assertAll("Pruebo varias",
				
					()-> Assertions.assertEquals(3, receta.getIngredientes().size()),
					()-> Assertions.assertTrue(receta.getIngredientes().contains(ir3)),
					()-> Assertions.assertTrue(receta.getIngredientes().contains(ir4)),
					()-> Assertions.assertTrue(receta.getIngredientes().contains(ir5))
				);
		
	}
	
	
	
	//No es posible realizar una receta si no se cuenta con todos los ingredientes 
	
	
	
	
	

}
