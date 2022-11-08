package ejerciciocolecciones;
import java.util.ArrayList;

/**
 * 
 * 
 * JAVA DOC SOBRE INFO DE LA CLASE
 * 
 * @param <E> tipo de los elementos de los que hacemos una coleccion
 * 
 */

public class Coleccion<E> implements Interfaz{

	private ArrayList<E> coleccion;
	private String nombre;

	/**
	 * Inicializa una coleccion vacia y define su nombre
	 * @param nombre de la coleccion
	 */

	public Coleccion(String nombre){
		setNombre(nombre);
		coleccion = new ArrayList<E>();
	}

	/**
	 * Actualiza el nombre de la coleccion
	 * @throws IllegalArgumentException si el nombre es nulo
	 * @param nombre d ela coleccion
	 */
	private void setNombre(String nombre){
		if(nombre == null)throw 
		if(nombre.isEmpty())throw 
		this.nombre = nombre;
	}

	/**
	 * Devuelve el nombre de la coleccion
	 * @return nombre de la coleccion
	 */
	public String getNombre(){
		return nombre;
	}

	/**
	 * Agrega un elemento a la coleccion
	 * @throws IllegalArgumentException si el elemento a insertar es nulo
	 */
	public void agregar(E elemento){
		if(elemento == null)throw 
		coleccion.add(elemento);
	}

	/**
	 * Devuelve el contenido de la coleccion dado el indice
	 * @param indice 
	 * @return indice 
	 * @throws IllegalArgumentException si el indice es negativo o es mayor que el tamaño de la coleccion
	 */
	public E obtenerContenido(int indice){
		if(indice < 0 || indice >= coleccion.size())throw 
		return coleccion.get(indice);
	}

	/**
	 * Elimina el contenido de la coleccion dado el indice
	 * @param indice
	 * @return indice 
	 * @throws IllegalArgumentException si el indice es negativo o es mayor que el tamaño de la coleccion
	 */
	public void eliminarContenido(int indice){
		if(indice < 0 || indice >= coleccion.size())throw 
		coleccion.remove(indice);
	}

	/**
	 * Reproduce toda la coleccion en orden secuencial
	 */
	public ArrayList<E> play(){
		return coleccion;
	}

	/**
	 * Concatena dos colecciones
	 * @param coleccion a concatenar
	 * @throws IllegalArgumentException si la coleccion es nula
	 * @throws IllegalArgumentException si la coleccion esta vacia
	 */
	public void concatenar(ArrayList<E> coleccionB){
		if(coleccionB == null)throw 
		if(coleccion.size() == 0)throw 
		coleccion.addAll(coleccionB);
	}
}