//EJERCICIO COLA2VENTANILLAS

public class ColaDosVentanillas<E>{

	/**
	 * 
	 * JAVADOC SOBRE LA CLASE
	 * 
	 */

	//atributos
	private ArrayList<E> venUno
	private ArrayList<E> venDos
	private boolean estadoUno
	private boolean estadoDos

	/**
	 * 
	 * JAVADOC
	 * 
	 */
	public ColaDosVentanillas(ArrayList<E> elementos){
		if(elementos == null)throws
		if(elementos.isEmpty())throws
		HashSet<E> unicos = new HashSet<E>(elementos);
		if(elementos.size() != unicos.size())throws
		venUno = new ArrayList<E>();
		venDOs = new ArrayList<E<();

		//inicializamos con ambas ventanas abiertas
		setEstadoUno(true);
		setEstadoDOs(true);

		//insertamos aleternativamente
		for(int i = 0; i < elementos.size(); i++){
			if(i%2 == 0){
				venUno.add(elementos.get(i));
			}else{
				venDos.add(elementos.get(i));
			}
		}
	}

	/**
	 * JAVADOC
	 */
	private void setEstadoUno(boolean estadoUno){
		this.estadoUno = estadoUno;
	}
	/**
	 * JAVADOC
	 */
	private void setEstadoDos(boolean estadoDos){
		this.estadoDos = estadoDos;
	}

	/**
	 * JAVADOC
	 */
	public void introducirElemento(E elemento){
		if(elemento == null)throws
		if(!estadoUno && !estadoDos)throws
		if(venUno.contains(elemento) || venDos.contains(elemento))throws

		//ambas abiertas, cogemos el de menor numero de elementos
		if(estadoUno && estadoDos){
			if(venUno.size() <= venDos.size()){
				venUno.add(elemento);
			}else{
				venDos.add(elemento);
			}
		//ventana 1 abierta, ventana 2 cerrada
		}else if(estadoUno && !estadoDos){
			venUno.add(elemento);
		//ventana 1 cerrada, ventana 1 abierta
		}else{
			venDos.add(elemento);
		}
	}

	/**
	 * JAVADOC
	 */
	public int getPendientesAtender(){
		return venUno.size() + venDos.size();
	}

	/**
	 * JAVADOC
	 */
	public int getPendientesUno(){
		return venUno.size();
	}

	/**
	 * JAVADOC
	 */
	public int getPendientesDos(){
		return venDos.size();
	}

	/**
	 * JAVADOC
	 */
	public void atenderElemento(){
		if(!estadoUno && !estadoDos)throws
		if(getPendientesAtender() == 0)throws
		//si ambas estan abiertas se atiende alternativamente de una y de otra
		if(estadoUno && estadoDos){
			venUno.remove(0);
			venDos.remove(0);
		}else if(estadoUno && !estadoDos){
			venUno.remove(0);
		}else{
			venDos.remove(0);
		}
	}

	/**
	 * JAVADOC
	 */
	public int getProxAtenderUno(){
		if(getPendientesUno() == 0)throws
		return venUno.get(venUno.indexOf(venUno.size()-1));
	}

	/**
	 * JAVADOC
	 */
	public int getProxAtenderDos(){
		if(getPendientesDos() == 0)throws
		return venDos.get(venDos.indexOf(venDos.size()-1));
	}

	/**
	 * JAVADOC
	 */
	public void cerrarVentanilla(){
		if(!estadoUno && !estadoDos)throws
		if(getPendientesUno() <= getPendientesDos()){
			//pasamos los elementos de Uno a la cola Dos
			venDos.addAll(venUno);
			//cerramos la ventanilla
			setEstadoUno(false);

		}else{
			venUno.addAll(venDos);
			setEstadoDos(false);
		}
	}

	/**
	 * JAVADOC
	 */
	public void cerrarCola(){
		if(!estadoUno || !estadoDos)throws
		if(getPendientesAtender() != 0)throws
		setEstadoUno(false);
		setEstadoDos(false);
	}

	/**
	 * JAVADOC
	 */
	public void abrirVentanilla(){
		if(estadoUno && estadoDos)throws
		if(!estadoUno){
			setEstadoUno(true);
		}else{
			setEstadoDos(true);
		}
	}

	/**
	 * JAVADOC
	 */
	public void balancear(){
		//requiere ambas abiertas
		if(!estadoUno || !estadoDos)throws
		//ya estan balanceados
		if(getPendientesUno() == getPendientesDos()) throws
		if(getPendientesUno() < getPendientesDos()){
			while(getPendientesDos()-getPendientesUno() > 1){
				venUno.add(venDos.get(0));
				venDos.remove(0);
			}
		}else{
			while(getPendientesUno()-getPendientesDos() > 1){
				venDos.add(venUno.get(0));
				venUno.remove(0);
			}
		}
	}
}