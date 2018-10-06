

/**
 * Module 633-1-Programmation - TP3 - Parking - Application parking silo -
 *
 * Modélisation du "box" contenant le véhicule : cette classe est un "WRAPPER" de Vehicule
 * Mémorisation du n° de box et de la référence sur un Vehicule
 *
*/		
public class Box {
	 
    private int no; /* Identifiant */
    private int nbQuartHeures;
    private VehiculePrix vehicule;

    public int getNo() {
        return no;
    }

    public Box(int no, VehiculePrix vehicule) {
        this.no = no;
        this.vehicule = vehicule;
        nbQuartHeures = 0;
    }

    public Box(int no,int temps ,VehiculePrix vehicule) {
        this.no = no;
        this.vehicule = vehicule;
        this.nbQuartHeures = temps ;
    }

    public boolean isNotEmpty()
    {
        if(vehicule== null)
            return false;
        return true;
    }

    public boolean removeVehicule()
    {
        vehicule = null;
        return true;	// Pour être certain que le vehicule est supprimé
    }


    public Box(int no) {this(no, null);} /* Pour la recherche */

    public double getPrix()
    {
        return vehicule.getPrix()*nbQuartHeures;
    }

    public int getNbQuartHeures() {return nbQuartHeures;}
    public void setNbQuartHeures(int nbQuartHeures) {this.nbQuartHeures = nbQuartHeures;}
    
    public boolean memeIdVehicule(String id) {return vehicule.equalsId(id);}
    public boolean memeTypeVehicule(int type) {return vehicule.equalsType(type);}

    /* Deux Box sont égaux si leurs numéros sont identiques */
    public boolean equals(Object obj) {return ((Box)obj).no == no;}

    public String toString() {return "Box no " + no + ", contenant : " + vehicule;}

}