package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import restaurant.Ingrediente;
import restaurant.ItemReceta;
import restaurant.Producto;
import restaurant.ProductoBasico;
import restaurant.ProductoElaborado;
import restaurant.Receta;

public class ProductoTest {
	
	Producto prodElaborado;
	Producto producto;
	float costoProdElab;
	
	@BeforeEach
	
	public void cargarEjemplo() {
		
		Ingrediente huevo=new Ingrediente("huevo", "unidades",240, 100);
		Ingrediente papa = new Ingrediente("Papa","gramos",20000, 200);
		Ingrediente sal = new Ingrediente("Sal","gramos",1000, 20);
		

		ItemReceta ir1= new ItemReceta(huevo,4);
		ItemReceta ir2=new ItemReceta(sal, 20);
		ItemReceta ir3 = new ItemReceta(papa, 3);
		

		Receta tortilla=new Receta("Tortilla",15, 3000);
		tortilla.addIngrediente(ir1);
		tortilla.addIngrediente(ir2);
		tortilla.addIngrediente(ir3);
		
		costoProdElab = tortilla.calcularCosto();
		prodElaborado= new ProductoElaborado("Tortilla", 2200);
		producto= new ProductoBasico("Lata Coca Cola", 10, 11);
	}
	
	
	@Test
	@DisplayName(". La venta de productos o elaboración de estos dejan una ganancia mayor al 20% ")
	public void verificarGanancia() {
		
		Assertions.assertTrue(gananciaMayorOIgual20Porciento(prodElaborado.getPrecioUnitarioVenta(), costoProdElab));	
		Assertions.assertFalse(gananciaMayorOIgual20Porciento(
				producto.getPrecioUnitarioVenta(), producto.getPrecioUnitarioCompra()));
		
		
	}
	
	public boolean gananciaMayorOIgual20Porciento(float precioVta, float precioCompra){
		if(precioVta >= precioCompra*1.20) {
			return true;
		}
		return false;
	}
	
	//b. No se puede crear un usuario con un correo electrónico inválido
	//(contiene @) 


}
