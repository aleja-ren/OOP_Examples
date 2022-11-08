public class ClienteDescubierto extends Cliente{

	private ArrayList<Float>pagos = ArrayList<FLoat>(3);
	private float importe;
	private int PRIMERO = 50;
	private int SEGUNDO = 25;

	public ClienteDescubierto(Persona persona, float importe){
		super(persona);
		pagos = new ArrayList<FLoat>(3);
		cargar(importe);
	}

	public ArrayList<FLoat> getSaldoDispuesto(){
		pagos.add(((100-PRIMERO)/100)*importe);
		pagos.add(((100-SEGUNDO)/100)*importe);
		pagos.add(((100-SEGUNDO)/100)*importe);
		return pagos;
	}

	public void cargar(float importe){
		this.importe = importe;
	}

	public float getCargoAutorizado(){
		return importe;
	}
}

public class ClienteDescuentoFijo extends Cliente{
	private ArrayList<Float>pagos = ArrayList<FLoat>(3);
	private int FIJO;
	private float importe;

	public ClienteDescuentoFijo(Persona persona, float importe){
		super(persona);
		pagos = new ArrayList<FLoat>(3);
		cargar(importe);
	}

	public void cargar(float importe){
		if(importe <= 0)throw 
		this.importe = (importe*(100-FIJO)/100);
	}

	public float getCargoAutorizado(){
		return importe;
	}

	public ArrayList<FLoat> getSaldoDispuesto(){
		pagos.add(getCargoAutorizado()/3);
		pagos.add(getCargoAutorizado()/3);
		pagos.add(getCargoAutorizado()/3);
	}
}

public class ClienteDescuentoVariable extends Cliente{
	private ArrayList<Float>pagos = ArrayList<FLoat>(3);
	private int variable;
	private float importe;

	public ClienteDescuentoVariable(Persona persona, float importe, int variable){
		super(persona);
		pagos = new ArrayList<FLoat>(3);
		cargar(importe);
		setVariable(variable);
	}

	private void setVariable(int variable){
		if(variable <= 0)throw 
		this.variable = variable;
	}

	public void cargar(float importe){
		if(importe <= 0)throw 
		this.importe = (importe*(100-getVariable())/100);
	}

	public float getCargoAutorizado(){
		return importe;
	}

	public ArrayList<Float> getSaldoDispuesto(){
		pagos.add(getCargoAutorizado()/3);
		pagos.add(getCargoAutorizado()/3);
		pagos.add(getCargoAutorizado()/3);
	}
}