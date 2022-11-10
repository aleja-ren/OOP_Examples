public class EmpleadoTemporal extends Empleado{

	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private double sueldo;

	public EmpleadoTemporal(String nombre, int edad, String nif, LocalDate fechaAlta, LocalDate fechaBaja){
		super(nombre, edad, nif);
		setFechaAlta(fechaAlta);
		setFechaBaja(fechaBaja);
	}

	private void setFechaAlta(LocalDate fechaAlta){
		if(fechaAlta == null)throw 
		if(fechaAlta.isBefore(LocalDate.now()))throw 
		this.fechaAlta = fechaAlta;
	}

	private void setFechaBaja(LocalDate fechaBaja){
		if(fechaBaja == null)throw 
		if(fechaBaja.isBefore(getFechaAlta()))throw 
		this.fechaBaja = fechaBaja;
	}

	public LocalDate getFechaAlta(){
		return fechaAlta;
	}

	public LocalDate getFechaBaja(){
		return fechaBaja;
	}

	@Override
	public String toString(){
		return 	"Nombre: "+ getNombre() +
				"Edad: "+getEdad()+
				"Nif: "+getNif()+
				"Fecha Alta: "+getFechaAlta()+
				"Fecha Baja: "+getFechaBaja();
	}

	public double calculoSueldo(){
		return sueldo;
	}
}

public class EmpleadoPorHoras extends Empleado{
	private double precioHora;
	private int numeroHorasMes;

	public EmpleadoPorHoras(String nombre, int edad, String nif, double precioHora, int numeroHorasMes){
		super(nombre, edad, nif);
		setPrecioHora(precioHora);
		setNumeroHoras(numeroHorasMes);
	}

	private void setPrecioHora(double precioHora){
		if(precioHora <= 0)throw
		this.precioHora = precioHora;
	}

	public void setNumeroHoras(int numeroHorasMes){
		if(numeroHorasMes<= 0)throw
		this.numeroHorasMes = numeroHorasMes;
	}

	public double getPrecioHora(){
		return precioHora;
	}

	public int getNumeroHorasMes(){
		return numeroHorasMes;
	}

	@Override
	public String toString(){
		return 	"Nombre: "+ getNombre() +
				"Edad: "+getEdad()+
				"Nif: "+getNif()+
				"Numero de horas trabajadas: "+getNumeroHorasMes()+
				"Precio de la hora de trabajo: "+getPrecioHora();
	}

	public double calculoSueldo(){
		return getPrecioHora()*getNumeroHorasMes();
	}
}

public class EmpleadoFijo extends Empleado{
	private int altaEmpresa;
	private double COMPLEMENTO;
	private double sueldo;

	public EmpleadoFijo(String nombre, int edad, String nif, int altaEmpresa){
		super(nombre, edad, nif);
		setFechaAltaEmpresa(altaEmpresa);
	}

	private void setFechaAltaEmpresa(int altaEmpresa){
		if(altaEmpresa <= 0)throw 
		this.altaEmpresa = altaEmpresa;
	}

	public int getFechaAltaEmpresa(){
		return altaEmpresa;
	}

	public double calculoSueldo(){
		return sueldo+(COMPLEMENTO*getFechaAlta());
	}
}
