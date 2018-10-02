import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Modélisation du concept "véhicule", c'est pourquoi cette classe est abstraite.
 *
 * VOUS NE DEVEZ PAS MODIFIER LE CODE DE CETTE CLASSE
*/
public abstract class Vehicule {							
	 
	/* Types de véhicules (observez l'utilisation de static) */	
	public static final int TYPE_NON_DEFINI = -1;
	public static final int TYPE_VELO = 0; 
	public static final int TYPE_MOTO = 1; 
	public static final int TYPE_VOITURE = 2; 
		
	/* Attributs */
	private String immatriculation;
	private String nom;
	private String prenom;
	private int type;
		
	/* Constructeurs */
	public Vehicule (String immatriculation, String nom, String prenom, int type) {
		this.immatriculation = immatriculation;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
	}
		
	/* 
	 * Ce constructeur permet de construire un véhicule unique (avec son id immatriculation) 
	 * avec des valeurs par défaut. 
	 * Ce constructeur est spécifiquement utilisé pour les recherches et comparaisons dans les collections 
	 */
	public Vehicule (String immatriculation) {
		this (immatriculation, "", "", Vehicule.TYPE_NON_DEFINI);
	}
		
	/* Accesseurs */
	public int getType () {return type;} 
	public String getId () {return immatriculation;} 
		
	/** Deux Vehicules sont identiques si leurs immatriculations sont identiques */
	public boolean equals (Object obj) {return this.immatriculation.equals(((Vehicule)obj).immatriculation);}
		
	public String toString () {return "Véhicule : " + immatriculation + ", " + prenom + " " + nom;}
}