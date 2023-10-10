package test;

public class UsuarioRepetidoException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public UsuarioRepetidoException( ){
       
    }

	public String toString() { return "El usuario esta repetido";}
}
