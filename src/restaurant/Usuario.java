package restaurant;
import java.util.Date;
import java.util.Objects;

public class Usuario {
	private static int nextID;
	private int id;
	private String nombreYApellido;
	private int tipoUsuario;
	private float saldoCuenta;
	private Date ultimaRecarga;
	private String email;
	public Usuario(String nombreYApellido, int tipoUsuario, float saldoCuenta,String email) {
		super();
		this.nombreYApellido = nombreYApellido;
		this.tipoUsuario = tipoUsuario;
		this.saldoCuenta = saldoCuenta;
		this.email= email;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void cargarCredito(float cuanto) {
		saldoCuenta+=cuanto;
		
	}
	public float descontarSaldo(float cuanto) throws SinSaldoException {
		if((saldoCuenta-cuanto)<0) throw new SinSaldoException();
		else
			saldoCuenta-= cuanto;
		return saldoCuenta;
		
	}
	float getSaldo() {
		return saldoCuenta;
	}

	public static int getNextID() {
		return nextID;
	}

	public int getId() {
		return id;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public float getSaldoCuenta() {
		return saldoCuenta;
	}

	public Date getUltimaRecarga() {
		return ultimaRecarga;
	}

	public String getEmail() {
		return email;
	}
	
//	public boolean esCorreoValido(String email) {
//        // Verificar si el correo contiene '@'
//        return email.contains("@");
//    }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email);
	}
//	
//	public void setEmail(String email) {
//		if(email.contains("@")) {
//			this.email = email;
//		}
//	}
	
	
}
