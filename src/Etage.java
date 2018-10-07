

import java.util.*;
/**
 * Module 633-1-Programmation - TP3 - Parking - Application parking silo -
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
    public Etage(int no) {
        this.no = no;
        boxes = new ArrayList(); // Création effective de la liste des box
    }

    /* Accesseurs */ 
    public Box getBox(int noBox) {
        int pos = boxes.indexOf(new Box(noBox));
        return pos < 0 ? null : (Box)boxes.get(pos);
    }

    /* Ajoute un box */
    public void add(Box box) {boxes.add(box);}	

    /* Retourne le nombre de véhicules (somme de tous les types de véhicules) */ 
    public int getNbVehicules() {
        int cpt = 0;
        for(int i = 0; boxes.size()>i ; i++)
        {
            if(((Box)boxes.get(i)).isNotEmpty())
                cpt++;
        }
        return cpt;
    }	// ===== Nb de véhicules: pour tous les véhicules OU par type

    /* Retourne le nombre de véhicules (somme de tous les types de véhicules) */
    public int getNbVehicules(int type) {
        int cpt = 0;
        for(int i = 0; boxes.size()>i ; i++)
        {
            if(((Box)boxes.get(i)).memeTypeVehicule(type))
                cpt++;
        }
        return cpt;
    }	// ===== Nb de véhicules: pour tous les véhicules OU par type

    /* Retourne le montant total (sommes des montants de tous les types de véhicules) */ 
    public double getMontant() {
        int montant = 0;
        for(int i= 0; boxes.size()> i; i++)
        {
            if(((Box)boxes.get(i)).isNotEmpty())
                montant+= ((Box)boxes.get(i)).getPrix();
        }
        return montant;
    }

    /* Retourne le montant total (sommes des montants de tous les types de véhicules) */
    public double getMontant(int type) {
        double montant = 0;
        for(int i= 0; boxes.size()> i; i++)
        {
            if(((Box)boxes.get(i)).memeTypeVehicule(type))
                montant+= ((Box)boxes.get(i)).getPrix();
        }
        return montant;
    }

    /* Supprime le box contenant le véhicule designé par son IdVehicule
     * Retourne : vrai si l'opération s'est bien déroulée, faux sinon
    */	
    public boolean removeVehicule(String idVehicule) {

        for(int i = 0 ; boxes.size()> i ; i++)
        {
            if(((Box)boxes.get(i)).memeIdVehicule(idVehicule))
            {
                ((Box) boxes.get(i)).removeVehicule();
                ((Box) boxes.get(i)).setNbQuartHeures(0);
                boxes.remove(i);
                return true;
            }
        }
        return false; 
    }

    /* Retourne vrai s'il n'y a pas de véhicule sur l'étage */
    public boolean estVide() {return boxes.isEmpty();}

    /* Deux étages sont égaux si leur numéro est identique */
    public boolean equals(Object obj) {return ((Etage)obj).no == no;}

    public String toString() { String str = "  Étage no " + no + " :\n"; for (int i=0; i<boxes.size(); i++) { str += "    " + boxes.get(i) + "\n"; } return str; }
}