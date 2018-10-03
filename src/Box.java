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

	private int no; /* Identifiant */
	private int nbQuartHeures;
	private Vehicule vehicule;

	public Box(int no, Vehicule vehicule) {
		this.no = no;
		this.vehicule = vehicule;
		nbQuartHeures = 0;
	}
	public Box(int no) {this(no, null);} /* Pour la recherche */



	public int getNbQuartHeures() {return nbQuartHeures;}
	public void setNbQuartHeures(int nbQuartHeures) {this.nbQuartHeures = nbQuartHeures;}

	public boolean memeIdVehicule(String id) {return vehicule.equalsId(id);}
	public boolean memeTypeVehicule(int type) {return vehicule.equalsType(type);}

	/* Deux Box sont égaux si leurs numéros sont identiques */
	public boolean equals(Object obj) {return ((Box)obj).no == no;}

	public String toString() {return "Box no " + no + ", contenant : " + vehicule;}

	//-------------------------- Methode ajouté ---------------------------------------------

	public Vehicule getVehicule() {return vehicule;} // néccessaire nn ?
	/* Pas convaincue de cette methode*/
	public boolean  removeVehicule()
	{
		vehicule = null;
		return true;	// Pour être certain que le vehicule à bien été supprimé
	}



}