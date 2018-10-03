import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Modélisation du parking. Un parking est composé d'étages
 * Mémoriasation de la liste des référence sur des objets de type classe Etage
 *
 * @author VOTRE NOM
*/
public class Parking {
		
	/* Prix par type de véhicule (CHF / quart d'heure) */	
	public static final double PRIX_NON_DEFINI = 0.0;
	public static final double PRIX_VELO = 0.25; 
	public static final double PRIX_MOTO = 0.75; 
	public static final double PRIX_VOITURE = 3.0; 
		
	/* Attributs */ 
	private ArrayList etages;
		
	/* Constructeur */ 
	public Parking () {
		etages = new ArrayList();
	}
	 
	/* Accesseurs */ 
	public Etage getEtage (int noEtage) {
		int pos = etages.indexOf(new Etage(noEtage));
		return pos < 0 ? null : (Etage)etages.get(pos);
	}

	/* Ajoute un étage */
	public void add (Etage etage) {etages.add(etage);}
	 
	/* Retourne le nombre de véhicules (somme de tous les types de véhicules de l'étage) */ 
	public int getNbVehicules () {
		int cpt= 0;
		for(int i = 0; etages.size()> i ; i++)
		{
			cpt += ((Etage)etages.get(i)).getNbVehicules();
		}
		return cpt;
	}
	 
	/* Retourne le montant (sommes des montants de tous les types de véhicules de l'étage) */ 
	public double getMontant () {
		double cpt = 0.0;
		for(int i = 0; etages.size()>i; i++)
		{
			cpt += ((Etage)etages.get(i)).getMontant();
		}
		return cpt;
	}

	public double getPrixType(int type)
	{
		double cpt = 0.0;
		for(int i = 0; etages.size()> i ; i++)
		{
			cpt += ((Etage)etages.get(i)).compteQuartHeureType(type);
		}
		if(type == 0)
		{
			cpt = cpt *PRIX_VELO;
		}
		else if(type == 1)
		{
			cpt = cpt *PRIX_MOTO;
		}
		else if(type == 2)
		{
			cpt = cpt *PRIX_VOITURE;
		}
		return cpt;
	}

	public int getCompteType(int type)
	{
		int cpt = 0;
		for(int i = 0; etages.size()> i ; i++)
		{
			cpt += ((Etage)etages.get(i)).compteType(type);
		}
		return cpt;
	}

	/* Supprime le box contenant la voiture désignée par son IdVehicule
		* Tester tous les étages jusqu'à trouver le box contenant le véhicule
		* Retourne vrai si l'opération s'est bien déroulée, faux sinon
	*/


	// La meilleur solution ??
	public boolean removeVehicule (String idVehicule) {
		boolean etat = false;

		for(int i = 0; etages.size()> i ; i++)
		{
			if(!etat)
			{
				etat=((Etage) etages.get(i)).removeVehicule(idVehicule);
			}
			else
			{
				return etat;
			}
		}
		return false;
	}
	 
	public String toString () {return "Parking ";}
}