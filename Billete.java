//BILLETE

package billetes;
public class BilleteInfantil extends Billete{

	private Persona viajero;
	private int DESCUENTO = 50;

	public BilleteInfantil(LocalDateTime fechaYhora, String inicioTrayecto, String finTrayecto, Persona viajero){
		super(fechaYhora, inicioTrayecto, finTrayecto);
		setViajero(viajero);
	}

	private void setViajero(Persona viajero){
		if(viajero == null)throws
		if(viajero.getEdad() < 12)throws
		this.viajero = viajero;
	}

	public Persona getViajero(){
		return viajero;
	}

	@Override
	public String toString(){
		return "Fecha y hora: " + getFechaYHora() +
			   "Inicio del trayecto: " + getInicioTrayecto()+
			   "Fin del trayecto: " + getFinTrayecto()+
			   "Edad del viajero: "+ getViajero().getEdad();
	}

	@Override
	public double getPrecio(){
		return super.getPrecio()-(DESCUENTO/100)*super.getPrecio();
	}
}

public class BilleteAbierto extends Billete{
	private boolean identificado;
	private int INCREMENTO = 10;

	public BilleteAbierto(LocalDateTime fechaYhora, String inicioTrayecto, String finTrayecto, boolean identificado){
		super(fechaYhora, inicioTrayecto, finTrayecto);
		setEstadoViajero(identificado);
	}

	@Override
	public boolean isFechaYHoraCorrecta(LocalDateTime fechaYhora){
		return fechaYHora == null || fechaYhora.isAfter(LocalDateTime.now());
	}

	private void setEstadoViajero(boolean identificado){
		this.identificado = identificado;
	}

	public boolean getEstadoViajero(){
		return identificado;
	}

	@Override
	public String toString(){
		return "Fecha y hora: " + getFechaYHora() +
			   "Inicio del trayecto: " + getInicioTrayecto()+
			   "Fin del trayecto: " + getFinTrayecto()+
			   "Estado del viajero (identificado o sin identificar): "+ getEstadoViajero();
	}

	@Override
	public double getPrecio(){
		if(identificado){
			return super.getPrecio();
		}else{
			return super.getPrecio() + (INCREMENTO/100)*super.getPrecio();
		}
	}
}

public class BilleteIdaYVuelta{

	private ArrayList<Billete> billetes = new ArrayList<E>(2);
	private int DESCUENTO = 15;

	public BilleteIdaYVuelta(ArrayList<Billete> billetes){
		if(billetes.size()!=2)throws
		//no pueden ser de distinto tipo
		if(billetes.get(0).getClass() != billetes.get(1).getClass())throws
		//cumplir que inicio primer billete = fin trayecto segundo billete
		//fin trayecto primer = inicio trayecto segundo billete
		if(!billetes.get(0).getInicioTrayecto().equals(billetes.get(1).getFinTrayecto()))throws
		if(!billetes.get(0).getFinTrayecto().equals(billetes.get(1).getInicioTrayecto()))throws

		this.billetes = billetes;
	}

	public Billete getBilleteIda(){
		return billetes.get(0);
	}

	public Billete getBilleteVuelta(){
		return.billetes.get(1);
	}

	@Override
	public String toString(){
		if(getBilleteIda().instanceof(Billete)){
			return 	"PRIMER BILLETE (IDA): "+
			   		"Fecha y hora: " + getBilleteIda().getFechaYHora() +
			   		"Inicio del trayecto: " + getBilleteIda().getInicioTrayecto()+
			   		"Fin del trayecto: " + getBilleteIda().getFinTrayecto()+
			   		" ---------------------------"+
			   		"SEGUNDO BILLETE (VUELTA): "+
			   		"Fecha y hora: " + getBilleteVuelta().getFechaYHora() +
			   		"Inicio del trayecto: " + getBilleteVuelta().getInicioTrayecto()+
			   		"Fin del trayecto: " + getBilleteVuelta().getFinTrayecto();
		}else if(getBilleteIda().instanceof(BilleteInfantil)){
			return 	"PRIMER BILLETE (IDA): "+
			   		"Fecha y hora: " + getBilleteIda().getFechaYHora() +
			   		"Inicio del trayecto: " + getBilleteIda().getInicioTrayecto()+
			   		"Fin del trayecto: " + getBilleteIda().getFinTrayecto()+
			   		"Edad del viajero: "+ getBilleteIda().getViajero().getEdad()+
			   		" ---------------------------"+
			   		"SEGUNDO BILLETE (VUELTA): "+
			   		"Fecha y hora: " + getBilleteVuelta().getFechaYHora() +
			   		"Inicio del trayecto: " + getBilleteVuelta().getInicioTrayecto()+
			   		"Fin del trayecto: " + getBilleteVuelta().getFinTrayecto()+
			   		"Edad del viajero: "+ getBilleteVuelta().getViajero().getEdad();
		}else{
			return 	"PRIMER BILLETE (IDA): "+
			   		"Fecha y hora: " + getBilleteIda().getFechaYHora() +
			   		"Inicio del trayecto: " + getBilleteIda().getInicioTrayecto()+
			   		"Fin del trayecto: " + getBilleteIda().getFinTrayecto()+
			   		"Estado del viajero (identificado o sin identificar): "+ getBilleteIda().getEstadoViajero()+
			   		" ---------------------------"+
			   		"SEGUNDO BILLETE (VUELTA): "+
			   		"Fecha y hora: " + getBilleteVuelta().getFechaYHora() +
			   		"Inicio del trayecto: " + getBilleteVuelta().getInicioTrayecto()+
			   		"Fin del trayecto: " + getBilleteVuelta().getFinTrayecto()+
			   		"Estado del viajero (identificado o sin identificar): "+ getBilleteVuelta().getEstadoViajero();
		}

		@Override
		public double getPrecio(){
			return (getBilleteIda().getPrecio() + getBilleteVuelta().getPrecio())*((100-DESCUENTO)/100);
		}
	}
}


