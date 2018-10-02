import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Modélisation du concept "deux roues", c'est pourquoi cette classe est abstraite.
 *
 * VOUS NE DEVEZ PAS MODIFIER LE CODE DE CETTE CLASSE
*/																												
public abstract class DeuxRoues extends Vehicule {

	public DeuxRoues (String immatriculation, String nom, String prenom, int type) {
		super (immatriculation, nom, prenom, type);
	}
		
	public String toString () {return super.toString() + " deux roues";}
}