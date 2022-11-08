package ejercicioEmpresa;
import java.util.ArrayList;

public class Empresa{
	
	private String presidente;
	private String cif;
	private int cp;
	private ArrayList<Negocios> unidadesDeNegocios;

	public Empresa(String presidente, String cif, int cp, ArrayList<Negocios> negocios){
		setPresidente(presidente);
		setCif(cif);
		setCP(cp);
		setUnidadesNegocio(negocios);
	}

	private void setPresidente(String presidente){
		if(presidente == null)throw 
		if(presidente.isEmpty())throw 
		this.presidente = presidente;
	}

	private void setCif(String cif){
		if(cif == null)throw 
		if(cif.isEmpty())throw 
		this.cif = cif;
	}

	private void setCP(int cp){
		if(cp <=0)throw 
		this.cp = cp;
	}

	private void setUnidadesNegocio(ArrayList<Negocios> negocios){
		if(negocios == null)throw 
		if(negocios.size() == 0)throw 
		unidadesDeNegocios = negocios;
	}

	public String getPresidente(){
		return presidente;
	}

	public String getCif(){
		return cif;
	}

	public int getCP(){
		return cp;
	}

	public ArrayList<Negocios> getUnidadesNegocio(){
		return unidadesDeNegocios;
	}
}

public abstract class Negocios{

	private String gerente;
	private double inversion;
	protected int numEmpleados;
	protected double beneficios;
	protected double mediaContratos;

	public Negocios(String gerente,double inversion){
		setGerente(gerente);
		setInversion(inversion);
	}

	private void setGerente(String gerente){
		if(gerente == null)throw 
		if(gerente.isEmpty())throw 
		this.gerente = gerente;
	}

	private void setInversion(double inversion){
		if(inversion < 0)throw 
		this.inversion = inversion;
	}

	public String getGerente(){
		return gerente;
	}

	public double getInversion(){
		return inversion;
	}

		public int getNumeroEmpleados(){
		return numEmpleados;
	}

	public double getBeneficios(){
		return beneficios;
	}

	public double getMediaContratos(){
		return mediaContratos;
	}

	protected abstract setEmpleado();
	protected abstract setBeneficios();
	protected abstract setMediaContratos();
}

public class UnidadNegocio extends Negocio{

	public UnidadNegocio(String gerente, int numEmpleados, double benficios, double inversion, double mediaContratos){
		super(gerente, inversion);
		setEmpleado(numEmpleados);
		setBeneficios(beneficios);
		setMediaContratos(mediaContratos);
	}

	protected void setEmpleado(int numEmpleados){
		if(numEmpleados < 0)throw 
		this.numEmpleados = numEmpleados;
	}

	protected void setBeneficios(double beneficios){
		this.beneficios = beneficios;
	}

	protected void setMediaContratos(double mediaContratos){
		this.mediaContratos = mediaContratos;
	}
}

public class UnidadesNegocio extends Negocio{

	private ArrayList<UnidadNegocio> unidades;

	public UnidadesNegocio(String gerente, ArrayList<UnidadNegocio> unidades){
		super(gerente, inversion);
		setEmpleado(unidades);
		setBeneficios(unidades);
		setMediaContratos(unidades);
	}

	protected void setEmpleado(ArrayList<UnidadNegocio> unidades){
		int empleados = 0;
		for(int i = 0; i < getUnidades().size(); i++){
			empleados = empleados + getUnidades().get(i).getNumeroEmpleados();
		}
		numEmpleados = empleados;
	}

	protected void setBeneficios(ArrayList<UnidadNegocio> unidades){
		double beneficiosUnidades = 0;
		for(int i = 0; i < getUnidades().size(); i++){
			beneficiosUnidades = beneficiosUnidades + getUnidades().get(i).getBeneficios();
		}
		beneficios = beneficiosUnidades;
	}

	protected void setMediaContratos(ArrayList<UnidadNegocio> unidades){
		double mediaContratosUnidades = 0;
		for(int i = 0; i < getUnidades().size(); i++){
			mediaContratosUnidades = mediaContratosUnidades + getUnidades().get(i).getMediaContratos();
		}
		mediaContratosUnidades = mediaContratosUnidades/getUnidades().size();
		mediaContratos = mediaContratosUnidades;
	}

	public ArrayList<UnidadNegocio> getUnidades(){
		return unidades;
	}
}