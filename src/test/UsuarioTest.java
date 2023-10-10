package test;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurant.Usuario;

public class UsuarioTest {
	
	
	

	@Test
	@DisplayName("usuario con email invalido")
	public void usuarioConEmailInvalido() {
		Usuario usuarioInvalido = new Usuario("Homero Simpson", 0, 350, "homerojsimpsonspringfield.com");	
		//me retorna false xq tiene correo sin @
		Assertions.assertFalse(usuarioInvalido.esCorreoValido(usuarioInvalido.getEmail()));
	}
	

}
