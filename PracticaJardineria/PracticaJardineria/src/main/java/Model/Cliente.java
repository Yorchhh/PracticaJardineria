package Model;

public class Cliente {

	public Integer id;
	private String nombreCliente;
	private String apellidoCliente;
	private String telefono;
	private String ciudad;
	private String codigoPostal;
	private String email;
	private String contraseña;
	private String documento;
	private tipoDocumento tipoDocumento;

	public Cliente(Integer id, String nombreCliente, String apellidoCliente, String telefono, String ciudad,
			String codigoPostal, String email, String contraseña, String documento, tipoDocumento tipoDocumento) {
		super();
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.email = email;
		this.contraseña = contraseña;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;

	}

	public Cliente() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;

	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public tipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(tipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		
		return "El usuario con Id:" + this.id + " es " + this.nombreCliente + " " + this.apellidoCliente + " ."
				+ "Con telefono: " + this.telefono + " , registrado en la ciudad " + this.ciudad
				+ " con codigo postal: " + this.codigoPostal + " con email: " + this.email + " y contraseña publica : "
				+ this.contraseña + " . Con documento "+this.documento;
	}

}
