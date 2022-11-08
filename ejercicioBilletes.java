package billetes;
import java.util.ArrayList;

public class BilleteInfantil extends Billete{

	private Persona viajero;
	private int DESCUENTO = 50;

	public BilleteInfantil(LocalDateTime fechaYhora, String inicioTrayecto, String finTrayecto, Persona viajero){
		super(fechaYhora, inicioTrayecto, finTrayecto);
		setViajero(viajero);
	}

	private setViajero(Persona viajero){
		if(viajero == null)throw new IllegalArgumentException ("");
		if(viajero.getEdad() < 12)throw new IllegalArgumentException ("");
	}

	public Persona getViajero(){
		return viajero;
	}

	@Override
	public String toString(){
		return 	"fecha y hora: "+getFechaYHora() +
				"inicio trayecto: "+getInicioTrayecto()+
				"fin trayecto: "+getFinTrayecto()+
				"viajero: "+getViajero()+
				"edad del viajero: "+getViajero().getEdad();
	}

	@Override
	public double getPrecio(){
		return (super.getPrecio()*((100-DESCUENTO)/100));
	}
}

public class Abierto extends Billete{

	private int INCREMENTO = 10;
	private Persona viajero;

	public Abierto(LocalDateTime fechaYhora, String inicioTrayecto, String finTrayecto, Persona viajero){
		super(fechaYhora, inicioTrayecto, finTrayecto);
		setViajero(viajero);
	}

	private setViajero(Persona viajero){
		//puede ser nulo, significa que no esta identificado
		this.viajero = viajero;
	}

	@Override
	public boolean isFechaYHoraCorrecta(LocalDateTime fechaYhora){
		return fechaYHora != null || fechaYhora.isAfter(LocalDateTime.now());
	}

	public Persona getViajero(){
		return viajero;
	}

		private boolean aplicaDescuento(){
		return(getViajero() != null);
	}

	@Override
	public String toString(){
		return 	"fecha y hora: "+getFechaYHora() +
				"inicio trayecto: "+getInicioTrayecto()+
				"fin trayecto: "+getFinTrayecto()+
				"viajero: "+getViajero()+
				"aplica descuento: "+aplicaDescuento();
	}

	@Override
	public double getPrecio(){
		//si el viajero esta identificado, no hacemos cambios o incrementos
		if(getViajero() == null){
			return super.getPrecio();
		}else{
			return (super.getPrecio()+((INCREMENTO/100)*super.getPrecio()));
		}
	}
}

public class BilleteIdaYVuelta{

	private ArrayList<Billete>billetes;
	private int DESCUENTO = 15;

	public BilleteIdaYVuelta(ArrayList<Billete> billetes){
		setBilletes(billetes);
	}

	private void setBilletes(ArrayList<Billete> billetesNuevos){
		//no puede ser nulo o tener tamaño distinto de 2
		if(billetesNuevos == null)throw new IllegalArgumentException("");
		if(billetesNuevos.size() != 2)throw new	IllegalArgumentException("");
		//ambos billetes deben de ser del mismo tipo
		if(!billetesNuevos.get(0).getClass().equals(billetesNuevos.get(1).getClass())) throw new IllegalArgumentException("");
		//inicio 1o = fin 2o
		//fin 1o = inicio 2o
		if(!billetesNuevos.get(0).getInicioTrayecto().equals(billetesNuevos.get(1).getFinTrayecto()))throw new IllegalArgumentException("");
		if(!billetesNuevos.get(0).getFinTrayecto().equals(billetesNuevos.get(1).getInicioTrayecto()))throw new IllegalArgumentException("");
		billetes = billetesNuevos;
	}

	public ArrayList<Billete> getBilletes(){
		return billetes;
	}

	@Override
	public String toString(){
		return 	"fecha y hora: "+getFechaYHora() +
				"inicio trayecto: "+getInicioTrayecto()+
				"fin trayecto: "+getFinTrayecto()+
				"viajero: "+getViajero();
	}

	@Override
	public double getPrecio(){
		//calculamos el precio conjutno, es decir, la suma
		double precio = getBilletes().get(0).getPrecio()+getBilletes().get(1).getPrecio();
		//aplicamos el descuento 
		precio = precio*((100-DESCUENTO)/100);
		return precio;
	}
}