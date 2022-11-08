/*
EMPRESA:
organiza en unidades de negocio
PRESINDENTE
CIF
DIRECCION POSTAL

UNIDAD DE NEGOCIO:
GERENTE
NUM EMPLEADOS
BENEFICIOS BRUTOS ULTIMO TRIMESTRE
INVERSION EN EDIFICIOS
MEDIA DE CONTRATOS SEMANALES

puede estar formada por varias unidades: empleados, beneficios e inversiones como suma
										  media contratos es la media de los numeros medios

*/
//HACEMOS CLASE ABSTRACTA COMO VENDIBLE QUE SEA UNIDAD DE NEGOCIO
public abstract class UnidadDeNegocio{
	protected String gerente;

	public UnidadDeNegocio(String gerente){
		setGerente(gerente);
	}

	protected void setGerente(String gerente){
		if(gerente == null)throw...
		if(gerente.isEmpty())throw...
		this.gerente = gerente;
	}

	protected String getGerente(){
		return this.gerente;
	}
}

public class UnidadDeNegocioUnica extends UnidadDeNegocio{
	private int numEmpleados;
	private double beneficiosTrimestre;
	private double inversionEdificios;
	//protected double mediaContratos;
	private int contratosMensuales;

	public UnidadDeNegocioUnica(String gerente,int numEmpleados,double beneficiosTrimestre, double inversionEdificios, int contratosMensuales){
		super(gerente);
		setNumEmpleados(numEmpleados);
		setBeneficiosTrimestre(beneficiosTrimestre);
		setInversionEd(inversionEdificios);
		setMediaContratosMensuales(contratosMensuales);
	}

	private void setNumeroEmpleados(int numEmpleados){
		if(empleados <= 0)throw ...
		this.numEmpleados = numEmpleados;
	}

	private void setBeneficiosTrimestre(double beneficiosTrimestre){
		this.beneficiosTrimestre = beneficiosTrimestre;
	}

	private void setInversionEd(double inversionEdificios){
		this.inversionEdificios = inversionEdificios;
	}

	private void setMediaContratosMensuales(int contratosMensuales){
		this.contratosMensuales = contratosMensuales/4;
		//dividimos entre 4 porque un mes tiene 4 semanas
	}

	public int getNumEmpleados(){
		return this.numEmpleados;
	}

	public double getBeneficiosTrimestre(){
		return this.beneficiosTrimestre;
	}

	public double getInversionEdificios(){
		return this.inversionEdificios;
	}

	public double getConTratosMensuales(){
		return this.contratosMensuales;
	}

	public double getMediaContratosMensuales(){
		return this.contratosMensuales/4;
	}
}

public class UnidadesDeNegocioVarias extends UnidadDeNegocio{
	private int numEmpleados;
	private double beneficiosTrimestre;
	private double inversionEdificios;
	private int contratosMensuales;
	private ArrayList<UnidadDeNegocioUnica> unidadesNegocio;

	public UnidadesDeNegocioVarias(String gerente,int numEmpleados,double beneficiosTrimestre, double inversionEdificios, int contratosMensuales){
		super(gerente);
		setNumEmpleados(numEmpleados);
		setBeneficiosTrimestre(beneficiosTrimestre);
		setInversionEd(inversionEdificios);
		setMediaContratosMensuales(contratosMensuales);
	}

	private void setNumEmpleados(int numEmpleados){
		int empleados = 0;
		for(int i = 0; i < unidadesNegocio.size(); i++){
			empleados = empleados + unidadesNegocio.get(i).getNumEmpleados;
		}
		this.numEmpleados = empleados;
	}

	public int getNumEmpleados(){
		return this.numEmpleados;
	}

	private void setBeneficiosTrimestre(double beneficiosTrimestre){
		double beneficios = 0;
		for (int i = 0; i < unidadesNegocio.size(); i++){
			beneficios = beneficios + unidadesNegocio.get(i).getBeneficiosTrimestre;
		}
		this.beneficiosTrimestre = beneficios;
	}

	public double getBeneficiosTrimestre(){
		return this.beneficiosTrimestre;
	}

	private void setInversionEd(double inversionEdificios){
		double inversion = 0;
		for (int i = 0; i < unidadesNegocio.size(); i++){
			inversion = inversion + unidadesNegocio.get(i).getInversionEdificios;
		}
		this.inversionEdificios = inversion;
	}

	public double getInversionEdificios(){
		return this.inversionEdificios;
	}

	private void setMediaContratosMensuales(int contratosMensuales){
		double medias = 0;
		for (int i = 0; i < unidadesNegocio.size(); i++){
			medias = medias + unidadesNegocio.get(i).getMediaContratosMensuales;
		}
		this.contratosMensuales = medias/4;
	}

	public double getMediaContratosMensuales(){
		return this.contratosMensuales;
	}
}

public class Empresa{

	//ATRIBUTOS
	private String presidente;
	private String cif;
	private int cp;
	private ArrayList<UnidadDeNegocio> negocios;

	public Empresa(Srtring presidente, String cif, int cp, ArrayList<UnidadDeNegocio> negocios){
		setPresidente(presidente);
		setCif(cif);
		setCp(cp);
		setNegocios(negocios);
	}

	public void setPresidente(String presidente){
		if(presidente == null)throw ...
		if(presidente.isEmpty())throw ...
		//if contiene numeros mandar excepcion
		this.presidente = presidente;
	}

	public void setCif(String cif){
		if(cif == null)throw ...
		if(cif.isEmpty())throw ...
		this.cif = cif;
	}

	public void setCp(int cp){
		if(cp <= 0)throw ...
		this.cp = cp;
	}

	public void setNegocios(ArrayList<UnidadDeNegocio> negocios){
		if(negocios == null)throw ...
		if(negocios,size())throw ...
		this.negocios = negocios;
	}


}