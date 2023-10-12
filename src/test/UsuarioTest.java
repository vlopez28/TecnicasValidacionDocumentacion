package test;




import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import restaurant.Ingrediente;
import restaurant.ItemPedido;
import restaurant.ItemReceta;
import restaurant.Mostrador;
import restaurant.Pedido;
import restaurant.Producto;
import restaurant.ProductoBasico;
import restaurant.Receta;
import restaurant.SinSaldoException;
import restaurant.Usuario;

public class UsuarioTest {
	
	//Usuario usuario;
	
	@BeforeClass
	public void cargarEjemplo() throws SinSaldoException{
//		Producto p1= new ProductoBasico("Lata Coca Cola", 10, 20);
//		Producto p2= new ProductoBasico("Lata Sprite", 10, 22);
//		Pedido p= new Pedido();
//	//	p.setUsuario(u1);
//		p.agregarItem(new ItemPedido(1,p1));
//		p.agregarItem(new ItemPedido(1, p2));
//		p.solicitarPedido();
//			
//		Mostrador ordenesActuales = new Mostrador();
//			
//		ordenesActuales.agregarPedido(p);
//		
//		p.prepararPedido();
//		p.terminarPedido();
//		p.entregarPedido();
	//	usuario = new Usuario("Homero Simpson", 0, 1000, "homerojsimpson@springfield.com");	
		
		
		

	}
	
	@Test
	@DisplayName("usuario con email invalido")
	public void usuarioConEmailInvalido() {
		Usuario usuarioInvalido = new Usuario("Homero Simpson", 0, 350, "homerojsimpsonspringfield.com");	
		//me retorna false xq tiene correo sin @
		Assertions.assertFalse(this.esCorreoValido(usuarioInvalido.getEmail()));
	}
	
	@TestFactory
	@DisplayName("test dinamico, correo valido")
	 Stream<DynamicTest> dynamicTestsFromUsuarios() {
	    List<Usuario>  testList = new  ArrayList<Usuario>();
	    Usuario u1 =new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
		Usuario u2 =new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
		Usuario u3 =new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
		Usuario u4 =new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
	    
		testList.add(u1);
		testList.add(u2);
		testList.add(u3);
		testList.add(u4);
	        return testList.stream()
		            .map(dom -> DynamicTest.dynamicTest("Testing: " + dom.getNombreYApellido(), () -> {
		                
		                Assertions.assertTrue(this.esCorreoValido(dom.getEmail()));
		            }));

		}    
	
	

	//Un pedido reduce el saldo de un usuario 

	@Test
	@DisplayName("pedido reduce el saldo")
	public void reducirSaldo() throws SinSaldoException {
		Usuario usuario = new Usuario("Homero Simpson", 0, 1000, "homerojsimpson@springfield.com");	
		//float saldoInicial = usuario.getSaldoCuenta();
		usuario.descontarSaldo(300);
		Assertions.assertEquals(700, usuario.getSaldoCuenta());
		
	}
	
	
	@Test
	@DisplayName("pedido saldo insuficiente")
	public void reducirSaldo2()  {
		Usuario usuario = new Usuario("Homero Simpson", 0, 1000, "homerojsimpson@springfield.com");	
		//float saldoInicial = usuario.getSaldoCuenta();
		
		try {
			usuario.descontarSaldo(1100);
			
			
		} catch (SinSaldoException ex) {
			System.out.println("No posee saldo suficiente");
		}
		
	//	usuario.descontarSaldo(300);
	//	Assertions.assertEquals(700, usuario.getSaldoCuenta());
		
	}
	
	
	public boolean esCorreoValido(String email) {
        // Verificar si el correo contiene '@'
        return email.contains("@");
    }
	
}
