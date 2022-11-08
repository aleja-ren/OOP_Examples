public class Premium extends Contrato{
	
	private int INCREMENTO = 699;
	private ArrayList<Paquete> paquetes;

	public Premium(Cliente c){
		super(c);
	}

	public ArrayList<Paquete> getPorte(){
		return paquetes;
	}

	@Override
	public double importe(){
		double importe = 0;

		//si el tamaño es mayor que 1000, no cobramos los mil primeros (0-999) y los demás les cobramos, cogiendo el importe padre/tamaño
		//para obtener el importe de cada paquete
		if(getPorte().size()> 1000){
			for (int i = 999; i < getPorte().size(); i++){
				importe = importe + super.importe()/getPorte.size()
			}
		//si e tamaño es menor que 1000, no cobramos ningún paquete pero al final si hacemos el incremento
		}else{
			importe = 0;
		}
		//hacemos el incremento incondicionalmente del numero de paquetes cobrados
		return importe + INCREMENTO;
	}
}

public class Fragil extends Contrato{

	private ArrayList<Paquete> paquetes;

	public Fragil(Cliente c){
		super(c);
	}

	public ArrayList<Paquete> getPorte(){
		return paquetes;
	}

	@Override
	public double importe(){
		int contFragil = 0;
		double importe = 0;
		for(int i = 0; i < getPorte().size(); i++){
			if(getPorte().get(i).esFragil()){
				contFragil++;
			}else{
				importe = importe + super.importe()/getPorte().size();
			}
			if(contFragil >= 100){
				for(int i = 99; i < getPorte().size(); i++){
					if(i %2 != 0){
						importe = importe + super.importe()/getPorte().size();
					}
				}
			}
		}
		return importe;
	}
}

public class Plano extends Contrato{

	private double importe;
	private ArrayList<Paquete> paquetes;

	public Plano(Cliente c, double importe){
		super(c);
		setImporteFijo(importe);
	}

	private void setImporteFijo(double importe){
		if(importe <= 0)throw 
		this.importe = importe;
	}

	public double getImporteFijo(){
		return importe;
	}

	public ArrayList<Paquete> getPorte(){
		return paquetes;
	}

	@Override
	public double importe(){
		reset();
		return getImporteFijo();
	}
}