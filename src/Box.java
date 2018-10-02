import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Modélisation du "box" contenant le véhicule : cette classe est un "WRAPPER" de Vehicule
 * Mémorisation du n° de box et de la référence sur l'objet de classe Vehicule
 *
 * VOUS NE DEVEZ PAS MODIFIER LE CODE DE CETTE CLASSE
*/		
public class Box {
	 
	/* Attributs */ 
	private int no; /* Identifiant */
	private int nbQuartHeures;
	private Vehicule vehicule;
		
	public Box (int no, Vehicule vehicule) {
		this.no = no;
		this.vehicule = vehicule;
		nbQuartHeures = 0;
	}
	public Box (int no) {this(no, null);} /* Pour la recherche */
			
	/* Accesseurs */ 
	/* Lecture seule */
	public int getNo () {return no;}
	public Vehicule getVehicule () {return vehicule;}
	public int getTypeVehicule () {return vehicule.getType();}
	 
	/* 
	 * Abstraction de l'identificateur de l'objet référencé par le Box
	 *
	 * L'idée est que "getId()" permet de récupérer un identificateur unique
	 * sur l'objet du Box sans se soucier de la nature de cet objet.
	 * Ainsi, si une maintenance venait à modifier la classe référencée par
	 * le Box, la gestion du parking n'en serait pas du tout affectée (donc aucune
	 * modification de code ne sera nécessaire au niveau du parking).
	 *
	 * La seule contrainte est que la classe référencée par le Box possède une
	 * méthode "public String getId() {}"
	 * Pour assurer ceci, nous verrons dans le prochain cours la notion d'interface.
	*/
	public String getIdVehicule () {return vehicule.getId();}
	public int getNbQuartHeures () {return nbQuartHeures;}
	public void setNbQuartHeures (int nbQuartHeures) {this.nbQuartHeures = nbQuartHeures;}
	 
	/* Deux Box sont égaux si leurs numéros sont identiques */
	public boolean equals (Object obj) {return ((Box)obj).no == no;}
		
	public String toString () {return "Box no :	" + no + " contenant : " + vehicule;}
}