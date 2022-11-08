import java.util.ArrayList;
package ejercicio.rankingTopTen;
/**
 * 
 * JAVADOC DE LA CLASE
 * 
 */
public class RankingTopTen<E>{
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	private boolean estado;
	private ArrayList<E> nominados;
	private ArrayList<Integer> votos;
	private ArrayList<E> ranking;
	private int TOP = 10;
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	public RankingTopTen(){
		nominados = new ArrayList<E>();
		votos = new ArrayList<E>();
		ranking = new ArrayList<E>(TOP);
		abrir();
	}
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	private void abrir(){
		estado = true;
	}
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	private void cerrar(){
		estado = false;
	}
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	private boolean getEstado(){
		return estado;
	}
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	public void nominarElemento(E elemento){
		if(elemento == null)throw
		if(nominados.contains(elemento))throw
		if(!getEstado())throw
		nominados.add(elemento);
		//inicializamos a 0 el voto del elemento nominado
		//add(idx, element)
		votos.add(0);
	}
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	public void votarElemento(E elemento){
		if(elemento == null)throw
		if(!nominados.contains(elemento))throw
		if(!getEstado())throw
		//queremos votar en la casilla del indice del elemento, los votos que tuviera mas uno
		votos.set(nominados.indexOf(elemento),votos.get(nominados.indexOf(elemento))+1);
	}
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	public int getNumNominados(){
		return nominados.size();
	}
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	public boolean consultarNominado(E elemento){
		if (elemento == null)throw 
		return (nominados.contains(elemento));
	}
	/**
	 * 
	 * JAVADOC
	 * 
	 */
	public int getVotosElemento(E elemento){
		if(elemento == null)throw
		if(!nominados.contains(elemento))throw
		if(getEstado())throw
		return votos.get(nominados.indexOf(elemento));
	}

	/**
	 * 
	 * JAVADOC
	 * 
	 */
	public ArrayList<E> getRanking(){
		if(getEstado())throw 
		if(getNumNominados()==0)throw 
		//necesitamos comparar los votos
		//ATENCION MIRAR QUE HACER CUANDO SON IGUALES
		while(ranking.size()<=TOP || getNumNominados()>0){
			int votoMayor=votos.get(0);
			for(int i = 0; i < votos.size(); i++){
				if(votos.get(i) > votoMayor){
				votoMayor = votos.get(i);
				}
			}
			//aqui cogemos de nominados el que mayor votos tiene y lo metemos el primero de add
			ranking.add(nominados.get(votos.indexOf(votoMayor));
			//tenemos que quitar de nominados y de votos el elemento ya agregado
			nominados.remove(votos.indexOf(votoMayor));
			votos.remove(votoMayor);
		}
	}
}