package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import restaurant.Pedido;
import restaurant.Usuario;

public class PedidoTest {
	
	Pedido pedido;
	Usuario usuario;
	Usuario repetido;
	
	@BeforeEach
	public void agregarUsuarioRepetido() {
		this.usuario = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
        this.pedido = new Pedido();
        pedido.agregarUsuario(usuario);
        //creo 2 usuarios con mismo id
        
	}


    @Test
    @DisplayName("Se agrega usuario repetido")
    public void testAgregarUsuarioRepetido() {
    	
    	this.repetido = new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
    	//pedido.agregarUsuario(repetido);
    	System.out.println(pedido.getUsuario().getNombreYApellido());
    	//existe usuario? si xq tiene el mismo email 
    	Assertions.assertEquals(usuario, repetido);
       // assertTrue(pedido.existeUsuario(repetido));
      
    }
    
    @Test
    @DisplayName("Se agrega usuario repetido2")
    public void testAgregarUsuarioRepetido2() {
    	
    	this.repetido = new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
    	
    	System.out.println(pedido.getUsuario().getNombreYApellido());
    	
    	Assertions.assertTrue(pedido.existeUsuario(repetido));
      
    }
    
//
//    @Test
//    @DisplayName("Se agrega usuario repetido")
//    public void testAgregarUsuarioRepetido33() throws UsuarioRepetidoException {
//    	Usuario usuario = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
//        Pedido pedido = new Pedido();
//        pedido.agregarUsuario(usuario);
//
//
//        Usuario repetido = new Usuario("Homerito", 0, 0, "homerojsimpson@springfield.com");
//        
//        pedido.agregarUsuario(repetido);
//		fail("fallo el test");
//      
//    }
////    
//    @Test
//    @DisplayName("Se agrega usuario repetido2")
//    public void testAgregarUsuarioRepetido2() {
//    	this.repetido = new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
//    	
//        
//        try {
//        	pedido.agregarUsuario(repetido);
//        	System.out.println(pedido.getUsuario().getNombreYApellido());
//        	fail("fallo xq agrega un usuario que ya existe");
//        	//assertFalse(pedido.existeUsuario(repetido));
//        } catch(Exception e) { 
//        	System.out.println(pedido.getUsuario());
//        	e.printStackTrace();
//        }
//      
//     
//        
//    }

}
