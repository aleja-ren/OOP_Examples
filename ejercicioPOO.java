import java.time.LocalDate;

public class Cliente {
	
	//ATRIBUTOS
	private String nombre;
	private String apellidos;
	private String dni;
	private LocalDate fechaNacimiento;


	//PONER JAVADOC
	public String getNombre(){
		return nombre;
	}

	//PONER JAVADOC
	public String getApellidos(){
		return apellidos;
	}

	//PONER JAVADOC
	public String getDNI(){
		return dni;
	}

	//PONER JAVADOC
	public LocalDate getFechaNacimiento(){
		return fechaNacimiento;
	}

	//PONER JAVADOC
	public void setNombre(String nombre){
		if(nombre == null) throw new IllegalArgumentException("EL nombre no puede ser nulo");
		if(nombre.isEmpty()) throw new IllegalArgumentException("EL nombre no puede ser vacio");
		//no puede contener numeros
		this.nombre = nombre;
	}

	//PONER JAVADOC
	public void setApellidos(String apellidos){
		if(apellidos == null) throw new IllegalArgumentException("EL apellido no puede ser nulo");
		if(apellidos.isEmpty()) throw new IllegalArgumentException("El apellido no puede ser vacio");
		//no puede contener numeros
		this.apellidos = apellidos;
	}

	//PONER JAVADOC
	public void setDNI(String dni){
		if(dni == null) throw new IllegalArgumentException("El dni no puede ser nulo");
		if(dni.isEmpty()) throw new IllegalArgumentException("El dni no puede ser vacio");
		//comprobar que es correcto el dni con un metodo privado
		if(!dniCorrecto()) throw new IllegalArgumentException("El dni es incorrecto");
		this.dni = dni;
	}

	public void setFechaNacimiento(LocalDate fechaNAcimiento){
		LocalDate hoy = LocalDate.now();
		if(fecha == null) throw new IllegalArgumentException("");
		if (fecha.isBefore(hoy)) throw new IllegalArgumentException("");
	}

	private Boolean dniCorrecto(String dni){

	}

}


public class Alquiler {
	private Cliente cliente;
	private Barco barco;
	private LocalDate fechaInicioAlquiler;
	private LocalDate fechaFinAlquiler;
	private int numeroAmarre;


	public Alquiler( Cliente cliente, Barco barco, LocalDate fechaInicio, LocalDate fechaFin, int numeroAmarre){
			setCliente(cliente);
			setBarco(barco);
			setFechaInicioAlquiler(fechaInicio);
			setFechaFinAlquiler(fechaFin);
			setNumeroAmarre(numeroAmarre);
			//excepciones controladas en los setters
	}

	public Cliente getCliente(){
		return cliente;
	}

	public Barco getBarco(){
		return barco;
	}

	public LocalDate getFechaInicioAlquiler(){
		return fechaInicioAlquiler;
	}

	public LocalDate getFechaFinAlquiler(){
		return fechaFinAlquiler;
	}


	//hacer los get publicos
	public int getNumeroAmarre(){
		return numeroAmarre;
	}

	//los set son privados
	private void setFechaInicioAlquiler(LocalDate fechaInicioAlquiler){
		if(fechaInicioAlquiler == null) throw IllegalArgumentException("");
		this.fechaInicioAlquiler = fechaInicioAlquiler;
	}

	private void setFinFechaAlquiler(LocalDate fechaFinAlquiler){
		//excepciones
		this.fechaFinAlquiler = fechaFinAlquiler;
	}

	public long getNumDiasAlquiler(){
		LocalDate fini = getFechaInicioAlquiler();
		LocalDate ffin = getFechaFinAlquiler();
		//usar el chronoUnit para ver cuantos dias hay entre medias
		return DiasAlquiler;
	}
}

public class Barco {

	//es el padre de embarcacion a motor y de velero
	//embarcacion a motor es padre de yate

	//es una clase normal donde sus metodos estan implementados
	
	public void getModulo(){

	}
}

//creamos clases nuevas para los hijos de barco

public class Velero extends Barco{

	private int numMastiles;


	public Velero(LocalDate fechaFabricacion, String matricula, double metrosEslora, int numMastiles){
		super(fechaFabricacion, matricula, metrosEslora);
		setNumeroMastiles(numMastiles);
	}
	/**
	 * Consulta el numero de mastiles d eun velero
	 * */

	public int getNumeroMastiles(){
		return numMastiles;
	}

	/**
	 * Actualiza el numero de mastiles de un velero
	 * @param numeroMastiles numero de mastiles del velero 
	 * @throws IllegalArgumentException 
	*/
	private void setNumeroMastiles(int numMastiles){
		if (numMastiles <= 0) throw IllegalArgumentException("");
		this.numMastiles = numMastiles;
	}

	/**
	 * Calcula el modulo de los barcos veleros
	 * @return el modulo
	 * */
	public double getModulo(){
		//redefincion del metodo del padre
		return(super.getModulo() + numMastiles);
	}
}

public class EmbarcacionAMotor extends Barco{

	private double potenciaCV;

	/**
	 * Construye una instancia de una embarcacion a motor
	 * */
	public EmbarcacionAMotor(LocalDate fechaFabricacion, String matricula, double metrosEslora, double potenciaCV){
		super(fechaFabricacion, matricula, metrosEslora);
		setPotenciaCV(potenciaCV);
	}

	public double getPotenciaCV(){
		return potenciaCV;
	}

	/**
	 * Actualiza la potencia de caballos de motor de una embarcacion a motor
	 * */
	public void setPotenciaCV(double potenciaCV){
		if (potenciaCV <= 0) throw new IllegalArgumentException("");
		this.potenciaCV = potenciaCV;
	}

	/**
	 * Consulta el modulo de una embarcacion a motor
	 * */
	public double getModulo(){
		//redefinicion del metodo del padre
		return(super.getModulo() + potenciaCV);
	}

}

public class Yate extends EmbarcacionAMotor{

	private int numCamarotes;

	/**
	 * Construye una instancia de yate
	 */
	public Yate(LocalDate fechaFabricacion, String matricula, double metrosEslora, double potenciaCV, int numCamarotes){
		super(fechaFabricacion, matricula, metrosEslora, potenciaCV);
		setNumCamarotes(numCamarotes);
	}

	/**
	 * Actualiza el numero de camarotes de un yate
	 */
	private void setNumCamarotes(int numCamarotes){
		if (numCamarotes <= 0) throw new IllegalArgumentException("");
		this.numCamarotes = numCamarotes;
	}

	/**
	 * Consulta el numero de camarotes de un yate
	 */
	public int getNumCamarotes(){
		return numCamarotes;
	}

	/**
	 * Consulta el modulo de un yate
	 */
	public double getModulo(){
		//redefinicion del padre
		return (super.getModulo() + numCamarotes);
	}
}

//se puede instanciar un barco porque no es abstracto pero solo tiene sentido crear una instancia de ese tipo
//si tu barco no es una de las especialidades descritas (un barco a pedales por ejemplo)