package test;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import restaurant.Ingrediente;
import restaurant.ItemReceta;
import restaurant.Producto;
import restaurant.ProductoBasico;
import restaurant.Receta;

public class RecetaTest {
	public static Receta receta;
	

	
	@BeforeClass
	public void iniciarEjemplo() {
		//creo ingredientes
		Ingrediente huevo=new Ingrediente("huevo", "unidades",240, 100);
		Ingrediente papa = new Ingrediente("Papa","gramos",20000, 700);
		Ingrediente sal = new Ingrediente("Sal","gramos",1000, 200);
		

		//creo items receta
		ItemReceta ir3 =new ItemReceta(sal, 20);
		ItemReceta ir4 = new ItemReceta(huevo,4);
		ItemReceta ir5 = new ItemReceta(papa, 3);
		
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

	
	//No es posible realizar una receta si no se cuenta con todos los ingredientes 

}
