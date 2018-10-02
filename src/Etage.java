import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Modélisation d'un "étage" contenant les box.
 * Mémorisation du n° de l'étage et de la liste des références sur des objets de type classe Box
 *
 * @author VOTRE NOM
*/
public class Etage {
		
	/* Attributs */ 
	private int no; /* Identifiant */
	private ArrayList boxes;
		
	/* Constructeur	*/ 
	public Etage (int no) {
		this.no = no;
		boxes = new ArrayList(); // Création effective de la liste des box
	}
		 
	/* Accesseurs */ 
	public int getNo () {return no;}
	public Box getBox (int noBox) {
		int pos = boxes.indexOf(new Box(noBox));
		return pos < 0 ? null : (Box)boxes.get(pos);
	}

	/* Ajoute un box */
	public void add (Box box) {boxes.add(box);}	
	 
	/* Retourne le nombre de véhicules (somme de tous les types de véhicules) */ 
	public int getNbVehicules () {
		int cpt=0;
		for(int i = 0; boxes.size()>0 ;i++)
		{
			Box bx = ((Box)boxes.get(i));
			if(bx.getVehicule() != null)
			{
				cpt ++;
			}
		}
		return cpt;
	}
	 
	/* Retourne le montant total (sommes des montants de tous les types de véhicules) */ 
	public double getMontant () {
		/***** À COMPLÉTER *****/
		return -1;
	}
		 
	/* Supprime le box contenant le véhicule designé par son IdVehicule
	 * Retourne : vrai si l'opération s'est bien déroulée, faux sinon
	*/	
	public boolean removeVehicule (String idVehicule) {
		/***** À COMPLÉTER *****/
		return false;
	}
	 
	/* Retourne vrai s'il n'y a pas de véhicule sur l'étage */
	public boolean estVide () {return boxes.isEmpty();}
	 
	public String toString () {return "Étage no : " + no;}
	 
	/* Deux étages sont égaux si leur numéro est identique */
	public boolean equals (Object obj) {return ((Etage)obj).no == no;}
}