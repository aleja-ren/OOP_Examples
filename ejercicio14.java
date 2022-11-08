public class Libro{

	private String titulo;
	private ArrayList<String> autor;
	private String editorial;
	private LocalDate fechaPubli;
	private boolean prestamo;

	public Libro(String titulo, ArrayList<String> autor, String editorial, LocalDate fechaPubli, boolean prestamo){
		ArrayList<String> autor = new ArrayLis<String>();
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setFechaPubli(fechaPubli);
		setEstadoPrestamo(prestamo);
	}

	private void setTitulo(String titulo){
		if(titulo.equals(null))throw
		if(titulo.isEmpty())throw 
		this.titulo = titulo;
	}

	private void setAutor(ArrayList<String> autor){
		if(autor == null)throw 
		if(autor.isEmpty())throw 
		this.autor = autor;
	}

	private void setFechaPubli(LocalDate fechaPubli){
		if(fechaPubli == null) throw 
		if(fechaPubli.isBefore(LocalDate.now()))throw 
		this.fechaPubli = fechaPubli;
	}

	private void setEstadoPrestamo(boolean prestamo){
		//si es una excepcion no se podra prestar y solo consultarse en la sala
		this.prestamo = prestamo;
	}

	public String getTitulo(){
		return titulo;
	}

	public ArrayList<String> getAutor(){
		return autor;
	}

	public LocalDate getFechaPubli(){
		return fechaPubli;
	}

	public boolean getEstadoPrestamo(){
		return prestamo;
	}
}

public class Revistas extends Libro{

	private int volumen;
	private int numero;
	private int mesSalida;

	public RevistasPapel(String titulo, ArrayList<String> autor, String editorial, LocalDate fechaPubli, boolean prestamo, 
		int volumen, int numero, int mesSalida){

		super(titulo, autor, editorial, fechaPubli, prestamo);
		setVolumen(volumen);
		setNumero(numero);
		setMesSalida(mesSalida);
	}

	@Override
	public void setEstadoPrestamo(boolean prestamo){
		prestamo = true;
	}

	private void setVolumen(int volumen){
		if(volumen < 0)throw 
		this.volumen = volumen;
	}

	private void setNumero(int numero){
		if(numero < 0)throw 
		this.numero = numero;
	}

	private void setMesSalida(int mesSalida){
		if(mesSalida<=0 || mesSalida > 12)throw 
		this.mesSalida = mesSalida;
	}

	public int getVolumen(){
		return volumen;
	}

	public int getNumero(){
		return numero;
	}

	public int getMesSalida(){
		return mesSalida;
	}
}

public class DocumentoCD extends Libro{

	public DocumentoCD(String titulo, ArrayList<String> autor, String editorial, LocalDate fechaPubli, boolean prestamo, 
		String formato, String licencia){

		super(titulo, autor, editorial, fechaPubli, prestamo);
		setFormato(formato);
		setLicencia(licencia);
	}

	private void setFormato(String formato){
		if(formato.equals(null))throw 
		if(formato.isEmprty())throw 
		this.formato = formato;
	}

	private void setLicencia(String licencia){
		if(licencia.equals(null))throw 
		if(licencia.isEmpty())throw 
		this.licencia = licencia;
	}

	public String getFormato(){
		return formato;
	}

	public String getLicencia(){
		return licencia;
	}
}

public class RevistaInvestigacion extends RevistasPapel{

	private int codigo;
	//que cojones es un terminal, no se que ha que hacer con ello
	private boolean terminal;

	public RevistaInvestigacion(String titulo, ArrayList<String> autor, String editorial, LocalDate fechaPubli, boolean prestamo, 
		int volumen, int numero, int mesSalida, int codigo){

		super(String titulo, ArrayList<String> autor, String editorial, LocalDate fechaPubli, boolean prestamo, 
		int volumen, int numero, int mesSalida);
		setCodigo(codigo);
	}

	private void setCodigo(int codigo){
		if(codigo <= 0)throw 
		this.codigo = codigo;
	}

	private void setTerminal(boolean terminal){
		this.terminal = terminal;
	}

	public int getCodigo(){
		return codigo;
	}

	public boolean getTerminal(){
		return terminal;
	}
}