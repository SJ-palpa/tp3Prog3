import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Modélisation du véhicule deux roues "Moto".
 * La mémorisation est (héritée de Vehicule) : 
 *			- immatriculation (id);
 *			- nom et prénom du conducteur;
 *			- type de véhicule.
 *
 * VOUS POUVEZ MODIFIER LE CODE DE CETTE CLASSE SI VOUS LE SOUHAITEZ
 *
 * @author VOTRE NOM
*/
public class Moto extends DeuxRoues {
		
	public Moto (String immatriculation, String nom, String prenom) {
		super (immatriculation, nom, prenom, Vehicule.TYPE_MOTO);
	}
		
	public String toString () {return super.toString() + " conduit une moto ";}
}

