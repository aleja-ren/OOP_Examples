package ejercicio16;

import java.util.ArrayList;

public abstract class Sistema{

	private ArrayList<Dispositivo> seguridadSistema;

	public Sistema(ArrayList<Dipositivo> seguridad){
		setSeguridad(seguridad);
	}

	private void setSeguridad(ArrayList<Dipositivo> seguridad){
		if(seguridad == null)throw 
		if(seguridad.size() == 0)throw 
		seguridadSistema = seguridad;
	}

	public ArrayList<Dipositivo> getSeguridad(){
		return seguridadSistema;
	}

	public boolean alarmaSistema(){
		for (int i = 0; i < getSeguridad().size(); i++){
			if(getSeguridad().get(i).alarma()){
				return true;
			}
		}
	}
}

public class Dispositivo{

	abstract boolean alarma();
}

public class Sensor extends Dispositivo{

	private boolean estado;
	private double medida;
	private double umbral;

	public Sensor(double umbral){
		setumbral(umbral);
	}

	private void setUmbral(double umbral){
		if(umbral <= 0)throw 
		this.umbral = umbral;
	}

	public void setEstado(boolean estado){
		//false si esta desconectado
		//true si esta conectado
		this.estado = estado;
	}

	public void medir(double medidaActual){
		if(medidaActual < 0)throw 
		medida = medidaActual;
	}

	public boolean getEstado(){
		return estado;
	}

	public double getMedida(){
		return medida;
	}

	public double getUmbral(){
		return umbral;
	}

	public boolean alarma(){
		return (getEstado()&&(getMedida()>getUmbral()));
	}
}

public class SensorComplejo extends Dispositivo{

	private double umbralComplejo;
	private ArrayList<Sensor>grupo;

	public SensorComplejo(double umbral,ArrayList<Sensor>grupo){
		setUmbralComplejo(umbral);
		setGrupo(grupo);
	}

	private void setUmbralComplejo(double umbral){
		if(umbral <= 0)throw 
		umbralComplejo = umbral;
	}

	private void setGrupo(ArrayList<Sensor>grupoSensores){
		if(grupo == null)throw 
		if(grupo.size()==0)throw
		grupo = new ArrayList<Sensor>(grupoSensores);
	}

	public double getUmbralComplejo(){
		return umbralComplejo;
	}

	public ArrayList<Sensor> getGrupo(){
		return grupo;
	}

	public boolean alarma(){
		double media = 0;
		for(int i = 0; i < getGrupo().size(); i++){
			media = media + getGrupo().get(i).getUmbral();
		}
		media = media/getGrupo().size();
		return (media > getUmbralComplejo());
	}
}