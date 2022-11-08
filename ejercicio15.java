public class Alquiler{

	private String nombre;
	private String dni;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private int amarre;
	private Barco barco;
	private int FIJO=12;


	public Alquiler(String nombre, String dni, LocalDate fechaIni, LocalDate fechaFin, int amarre, Barco barco){
		setNombre(nombre);
		setDni(dni);
		setFechaIni(fechaIni);
		setFechaFin(fechaFin);
		setAmarre(amarre);
		setBarco(barco);
	}

	private void setNombre(String nombre){
		if(nombre == null)throw 
		if(nombre.isEmpty())throw 
		this.nombre = nombre;
	}

	private void setDni(String dni){
		if(dni == null)throw 
		if(dni.isEmpty())throw 
		if(Character.isDigit(dni.charAt(dni.length()-1)))throw 
		for(int i = 0; i < dni.length()-1; i++){
			if(Character.isLetter(dni.charAt(i))){
				throw 
			}
		}
		this.dni = dni;
	}

	private void setFechaIni(LocalDate fechaIni){
		if(fechaIni == null)throw 
		this.fechaIni = fechaIni;
	}

	private void setFechaFin(LocalDate fechaFin){
		if(fechaFin == null)throw 
		if(fechaFin.isBefore(getFechaIni()))throw 
		this.fechaFin = fechaFin;
	}

	private void setAmarre(int amarre){
		if(amarre < 0)throw 
		this.amarre = amarre;
	}

	private void setBarco(Barco barco){
		if(barco == null)throw 
		this.barco = barco;
	}

	public String getNombre(){
		returrn nombre;
	}

	public String getDni(){
		return dni;
	}

	public LocalDate getFechaIni(){
		return fechaIni;
	}

	public LocalDate getFechaFin(){
		return fechaFin;
	}

	public int getAmarre(){
		return amarre;
	}

	public Barco getBarco(){
		return barco;
	}

	public int getNumDiasOcupados(){
		LocalDate fini = getFechaIni();
		LocalDate ffin = getFechaFin();

		return ChronoUnit.DAYS.between(fini,ffin);
	}

	public double getAlquiler(){
		return (getBarco().getModulo()*getNumDiasOcupados()*FIJO);
	}
}

public class Barco{

	private String matricula;
	private double eslora;
	private LocalDate fechaFabricacion;

	public Barco(String matricula, double eslora, LocalDate fechaFabricacion){
		setMatricula(matricula);
		setEslora(eslora);
		setFechaFabricacion(fechaFabricacion);
	}

	private void setMatricula(String matricula){
		if(matricula == null)throw 
		if(matricula.isEmpty())throw 
		this.matricula = matricula;
	}

	private void setEslora(double eslora){
		if(eslora <= 0)throw 
		this.eslora = eslora;
	}

	private void setFechaFabricacion(LocalDate fechaFabricacion){
		if(fechaFabricacion == null)throw 
		if(fechaFabricacion.isAfter(LocalDate,now()))throw 
		this.fechaFabricacion = fechaFabricacion;
	}

	public String getMatricula(){
		return matricula;
	}

	public double getEslora(){
		return eslora;
	}

	public LocalDate getFechaFabricacion(){
		return fechaFabricacion;
	}

	public double getModulo(){
		return (10*getEslora());
	}
}

public class Velero extends Barco{

	private int numMastiles;

	public Velero(String matricula, double eslora, LocalDate fechaFabricacion, int numMastiles){
		super(matricula, eslora, fechaFabricacion);
		setNumMastiles(numMastiles);
	}

	private void setNumMastiles(int numMastiles){
		if(numMastiles <= 0)throw 
		this.numMastiles = numMastiles;
	}

	public int getNumMastiles(){
		return numMastiles;
	}

	@Override
	public double getModulo(){
		return super.getModulo()+getNumMastiles();
	}
}

public class DeportivosMotor extends Barco{

	private double cV;

	public DeportivosMotor(String matricula, double eslora, LocalDate fechaFabricacion, double cV){
		super(matricula, eslora, fechaFabricacion);
		setCV(cV);
	}

	private void setCV(double cV){
		if(cV <= 0)throw 
		this.cV = cV;
	}

	public double getCV(){
		return cV;
	}

	@Override
	public double getModulo(){
		return super.getModulo()+getCV();
	}
}

public class YatesLujo extends DeportivosMotor{

	private int numCamarotes;

	public YatesLujo(String matricula, double eslora, LocalDate fechaFabricacion, double cV, int numCamarotes){
		super(matricula, eslora, fechaFabricacion, cV);
		setNumCamarotes(numCamarotes);
	}

	private void setNumCamarotes(int numCamarotes){
		if(numCamarotes <= 0)throw 
		this.numCamarotes = numCamarotes;
	}

	public int getNumCamarotes(){
		return numCamarotes;
	}

	@Override
	public double getModulo(){
		return super.getModulo()+getNumCamarotes();
	}
}