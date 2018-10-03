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
		for(int i = 0; boxes.size()>i ;i++)
		{
			Box bx = ((Box)boxes.get(i));
			if(bx.getVehicule() != null)
			{
				cpt ++;
			}
		}
		return cpt;
	}

	public int compteType(int type)
	{
		int cpt = 0 ;
		for(int i = 0; boxes.size()> i ; i++)
		{
			if(((Box)boxes.get(i)).memeTypeVehicule(type))
			{
				cpt++;
			}
		}
		return cpt;
	}

	public double compteQuartHeureType(int type)
	{
		double cpt = 0 ;
		for(int i = 0; boxes.size()> i ; i++)
		{
			if(((Box)boxes.get(i)).memeTypeVehicule(type))
			{
				cpt+= ((Box)boxes.get(i)).getNbQuartHeures();
			}
		}
		return cpt;
	}

	/* Retourne le montant total (sommes des montants de tous les types de véhicules) */ 
	public double getMontant () {
		double cpt = 0;
		for(int i= 0; boxes.size()>i;i++)
		{
			//cpt += ((Box)boxes.get(i)).getP
		}
		return cpt;
	}
		 
	/* Supprime le box contenant le véhicule designé par son IdVehicule
	 * Retourne : vrai si l'opération s'est bien déroulée, faux sinon
	*/	
	public boolean removeVehicule (String idVehicule) {
		for(int i = 0; boxes.size()>i ; i++)
		{
			if (((Box) boxes.get(i)).memeIdVehicule(idVehicule))
			{
				((Box) boxes.get(i)).removeVehicule();
				((Box) boxes.get(i)).setNbQuartHeures(0);
				boxes.remove(i);
				return false;
			}
		}
		return false;
	}


	/* Retourne vrai s'il n'y a pas de véhicule sur l'étage */
	public boolean estVide () {return boxes.isEmpty();}
	 
	public String toString () {return "Étage no : " + no;}
	 
	/* Deux étages sont égaux si leur numéro est identique */
	public boolean equals (Object obj) {return ((Etage)obj).no == no;}
}