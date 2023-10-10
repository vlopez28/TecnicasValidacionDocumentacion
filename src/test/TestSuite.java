package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)

@Suite.SuiteClasses({
	UsuarioTest.class,
	AlmacenTest.class, 
	PedidoTest.class,
	RecetaTest.class

})
public class TestSuite {

}
