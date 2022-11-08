public class Seguidor extends Contrato{

	private String equipo;
	//ya como atributo en la clase contrato??
	private ArrayList<Partido> partidos;

	public Segudior(Cliente c, String equipo){
		super(c);
		setEquipo(equipo);
	}

	private void setEquipo(String equipo){
		if(equipo == null)throw 
		if(equipo.isEmpty())throw 
		this.equipo = equipo;
	}

	public String getEquipo(){
		return equipo;
	}

	public ArrayList<Partido> getPartidos(){
		return partidos;
	}

	@Override
	public double importe(){
		double importe = 0;
		for(int i = 1; i < getPartidos().size(); i++){
			if(!getPartidos().get(i).getVisitante().equals(getEquipo())){
					importe = importe + super.importe()/getPartidos().size();
			}
		}
		return importe;
	}
}

public class DosPorUno extends Contrato{

	private ArrayList<Partido> partidos;
	private int INCREMENTO = 5;

	public DosPorUno(Cliente c){
		super(c);
	}

	public ArrayList<Partido> getPartidos(){
		return partidos;
	}

	@Override
	public double importe(){
		double importe = 0;
		for(int i = 0; i < getPartidos().size(); i++){
			if(i%2 == 0){
				importe = importe + super.importe()/getPartidos().size();
			}
		}
		importe = importe + (INCREMENTO/100)*importe;
		return importe;
	}
}

public class TodoElFutbol extends Contrato{

	private ArrayList<Partido> partidos;
	private int INCREMENTO = 20;

	public TodoElFutbol(Cliente c){
		super(c);
	}

	public ArrayList<Partido> getPartidos(){
		return partidos;
	}

	@Override 
	public double importe(){
		double importe = 0;
		//no se factura ningún partido
		//el super.importe() = gastos fijos + importe de los partidos
		//reset reinicia la info de los partidos 
		reset();
		importe = super.importe() + (INCREMENTO/100)*super.importe();
		return importe;
	} 
}
