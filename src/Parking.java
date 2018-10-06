

import java.util.*;
/**
 * Module 633-1-Programmation - TP3 - Parking - Application parking silo -
 *
 * Modélisation du parking. Un parking est composé d'étages
 * Mémoriasation de la liste des référence sur des objets de classe Etage
 *
 * @author VOTRE NOM
*/
public class Parking {
		
    private ArrayList etages;

    /* Constructeur */ 
    public Parking() {
        etages = new ArrayList();
    }

    /* Accesseurs */ 
    public Etage getEtage(int noEtage) {
        int pos = etages.indexOf(new Etage(noEtage));
        return pos < 0 ? null : (Etage)etages.get(pos);
    }

    /* Ajoute un étage */
    public void add(Etage etage) {etages.add(etage);}

    /* Retourne le nombre de véhicules (somme de tous les types de véhicules de l'étage) */ 
    public int getNbVehicules() {
        int cpt = 0;
        for(int i=0 ; etages.size()> i ; i++)
        {
            cpt += ((Etage)etages.get(i)).getNbVehicules();
        }

        return cpt;
    }

    public int getNbVehicules(int type) {
        int cpt = 0;
        for(int i=0 ; etages.size()> i ; i++)
        {
            cpt += ((Etage)etages.get(i)).getNbVehicules(type);
        }

        return cpt;
    }


    /* Retourne le montant(sommes des montants de tous les types de véhicules de l'étage) */
    public double getMontant() {

        int cpt = 0;
        for(int i = 0; etages.size()> i ; i++)
        {
            cpt += ((Etage)etages.get(i)).getMontant();
        }
        return cpt;
    }

    /* Retourne le montant(sommes des montants de tous les types de véhicules de l'étage) */
    public double getMontant(int type) {

        double montant = 0;
        for(int i = 0; etages.size()> i ; i++)
        {
            montant += ((Etage)etages.get(i)).getMontant(type);
        }
        return montant;
    }

    /* Supprime le box contenant la voiture désignée par son IdVehicule
     * Tester tous les étages jusqu'à trouver le box contenant le véhicule
     * Retourne vrai si l'opération s'est bien déroulée, faux sinon
    */	
    public boolean removeVehicule(String idVehicule) {

        boolean etat = false;

        for(int i = 0; etages.size()> i ; i++)
        {
            if (etat) {
                return etat;
            } else {
                etat=((Etage) etages.get(i)).removeVehicule(idVehicule);
            }
        }
		return false;
    }

    public String toString() { String str=""; for (int i=0; i<etages.size(); i++) { str += etages.get(i); } return str; }

}