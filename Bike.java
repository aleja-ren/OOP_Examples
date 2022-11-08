public class AdultBike extends Bike{

	public AdultBike(String id, String size){
		super(id,size);
	}

	@Override
	public String toString(){
		return "id: " + getId() + ", " + "size: " + getSize();
	}

	@Override
	protected void setSize(String size){
		if(size.equals(null))throw 
		if(size != "S" || size != "M" || size != "L" || size != "XL")throw 
	}

	public double getDepositToPay(double deposit){
		if(deposit <= 0)throw 
		return deposit;
	}
}

public class ElectricBike extends AdultBike{

	private double voltios;
	private double carga;

	public ElectricBike(String id, String size, double voltios, double carga){
		super(id, size);
		setVoltios(voltios);
		setCarga(carga);
	}

	private void setVoltios(double voltios){
		if(voltios <= 0)throw
		this.voltios = voltios;
	}

	private void setCarga(double carga){
		if(carga <= 0)throw
		this.carga = carga;
	}

	public double getVoltios(){
		return voltios;
	}

	public double getCarga(){
		return carga;
	}

	public double getCargaTotal(){
		return getCarga()*getVoltios();
	}

	@Override
	public String toString(){
		return 	"id: " + getId() +
				"size: " + getSize() +
				"voltios (V): " + getVoltios()+
				"carga (Ah): " + getCarga()+
				"carga total (Wh): " + getCargaTotal();
	}

	public double getDepositToPay(double deposit){
		return deposit+(getVoltios()/100)*deposit;
	}
}

public class GoldenAgePack extends Bike{

	private ArrayList<Bike>bicis;
	private int DESCUENTO = 40;

	public GoldenAgePack(Bike[] bicicletas){
		if(bicicletas == null)throw 
		bicis = new ArrayList<Bike>(bicicletas);
		if(getNumBicis() < 10) throw 
		int electricas = 0;
		//mitad del pack deben de ser electricas
		for(int i = 0; i < getNumBicis(); i++){
			if(bicis.get(i).instaceof(ElectricBike)){
				elecricas++;
			}
		}
		if(electricas != getNumBicis()/2)throw 
		HashSet<Bike> bicisUnicas = new HashSet<Bike>(bicis);
		if(bicisUnicas.size() != getNumBicis())throw 
	}

	public void agregarBiciPack(Bike bicicleta){
		if(bicicleta.equals(null))throw
		//no puede haber bicis repetidas
		if bicis.contains(bicicleta)throw 
		//al inicializar un pack obligamos que el tamaño sea mayor que 10, si agregamos nunca va a incumplir esa condicion
		int electricas = 0;
		//mitad del pack deben de ser electricas
		for(int i = 0; i < getNumBicis(); i++){
			if(bicis.get(i).instaceof(ElectricBike)){
				elecricas++;
			}
		}
		//calculamos las electricas que ya hay en el pack, comprobamos si la nueva a añadir es electrica
		if(bicicleta.instaceof(ElectricBike)){
			electricas++;
		}
		//aqui tendriamos el numero final de bicics electricas, podemos comprobar
		if(electricas != getNumBicis()+1/2)throw 
		bicis.add(bicicleta);
	}

	public void eliminarBiciPack(Bike bicicleta){
		if(bicicleta.equals(null))throw
		//tenemos que comprobar si existe esa bici
		if(!bicis.contains(bicicleta))throw 
		//comprobamos que si la eliminamos el tamaño será 10 o mayor
		if(getNumBicis()-1 < 10)throw 
		//realizamos el recuento de bicis electricas
		int electricas = 0;
		//mitad del pack deben de ser electricas
		for(int i = 0; i < getNumBicis(); i++){
			if(bicis.get(i).instaceof(ElectricBike)){
				elecricas++;
			}
		}
		//calculamos las electricas que ya hay en el pack, comprobamos si que queremos quitar es electrica
		if(bicicleta.instaceof(ElectricBike)){
			electricas--;
		}
		//aqui tendriamos el numero final de bicics electricas si quitamos la bici, podemos comprobar
		if(electricas != getNumBicis()-1/2)throw 
		bicis.remove(bicicleta);
	}

	public int getNumBicis(){
		return bicis.size();
	}

	@Override
	public String toString(){
		return "Numero de bicis que forman el pack: "+ getNumBicis();
	}

	public double getDepositToPay(double deposit){
		if(deposit <= 0)throw 
		double suma = 0;
		for(int i = 0; i < getNumBicis(); i++){
			suma = suma +bicis.get(i).getDepositToPay(deposit/getNumBicis());
		}
		return suma*((100-DESCUENTO)/100);
	}
}