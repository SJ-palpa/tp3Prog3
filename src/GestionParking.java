

import java.util.*;
/**
 * Module 633-1-Programmation - TP3 - Parking - Application parking silo -
 *
 * Gestion du parking silo : 
 *	mémorisation des données;
 *	présentation du rapport;
 *	retirer un ensemble de véhicules;
 *	présentation du nouveau rapport.
 *
 * @author VOTRE NOM														 
*/
public class GestionParking {
		
    /* Liste des délimiteurs */
    private static final String DELIM_ETAGE = "\r\n";
    private static final String DELIM_CHAMP = ";";
    private static final String DELIM_NO_BOX = "-";


    /* Le parking */
    private static Parking parking;

    /* Méthodes de service */
    private static int str2int(String s) {return Integer.parseInt(s);} 

    /* Mémorise les données du parking */
    private static void memoriseParking(String donneesParking) {
        parking = new Parking(); 
        StringTokenizer st = new StringTokenizer(donneesParking,DELIM_ETAGE);
        while(st.hasMoreTokens())
        {
            StringTokenizer stC = new StringTokenizer(st.nextToken(),DELIM_CHAMP);
            while (stC.hasMoreTokens())
            {
                StringTokenizer stCIden = new StringTokenizer(stC.nextToken(),DELIM_NO_BOX);
                int numEtage = str2int(stCIden.nextToken());
                int numBox = str2int(stCIden.nextToken());
                int typeVeh = str2int(stC.nextToken());
                int temps = str2int(stC.nextToken());
                String nom = stC.nextToken();
                String prenom= stC.nextToken();
                String immatriculation= stC.nextToken();


                Etage et = parking.getEtage(numEtage);
                if(et == null)
                {
                    et = new Etage(numEtage);
                    parking.add(et);
                }

                Box bx = et.getBox(numBox);
                if(bx == null)
                {
                    bx = new Box(numBox,temps,creationVehicule(typeVeh,nom,prenom,immatriculation));
                    et.add(bx);
                }
            }
        }
    }

    private static VehiculePrix creationVehicule(int type, String nom, String prenom,String immatriculation)
    {
        VehiculePrix vh = null;
        if(type == Vehicule.TYPE_VELO)
        {
            vh = new VeloPrix(nom,prenom,immatriculation);
        }
        else if(type == Vehicule.TYPE_MOTO)
        {
            vh = new MotoPrix(nom,prenom,immatriculation);
        }
        else if (type == Vehicule.TYPE_VOITURE)
        {
            vh = new VoiturePrix(nom,prenom,immatriculation);
        }
        return  vh;
    }

    /* Prépare et affiche le rapport */
    private static void afficheRapport() {
        System.out.println("Rapport parking");
        System.out.println( "Il y a : " +parking.getNbVehicules()+ " véhicules parqués" );
        System.out.println("    VELO : "+parking.getNbVehicules(Vehicule.TYPE_VELO)+" pour un montant actuel : " +parking.getMontant(Vehicule.TYPE_VELO));
        System.out.println("    MOTO : "+parking.getNbVehicules(Vehicule.TYPE_MOTO)+" pour un montant actuel : "+parking.getMontant(Vehicule.TYPE_MOTO));
        System.out.println("    VOITURE : "+parking.getNbVehicules(Vehicule.TYPE_VOITURE)+" pour un montant actuel : "+parking.getMontant(Vehicule.TYPE_VOITURE));
        System.out.println("----------------------------------------------------------");
        System.out.println("Liste des véhicules dans le parking :");
        System.out.println(parking);
    }

    /* VOUS NE DEVEZ PAS MODIFIER LE CODE DE CETTE METHODE */
    private static void recuperationVehicules() {
        System.out.println("----------------------------------------------------------");
        parking.removeVehicule("GE657665");
        parking.removeVehicule("NE342078");
        parking.removeVehicule("AG456");
        parking.removeVehicule("BE87350");
        parking.removeVehicule("NE563458");
        parking.removeVehicule("GE356");

        System.out.println("Les véhicules suivants ont été récupérés (supprimés) :");
        System.out.println("	 GE657665, NE342078, AG456, BE87350, NE563458 et GE356");
        System.out.println("----------------------------------------------------------");
    }

    /*public static void main (String[] args) {
        if (args.length < 1) {
            System.out.println("Il faut saisir le fichier de données.");
        } else {
            System.out.println("Mémorisation du parking (fichier : \"" + args[0] + "\")");
            System.out.println("----------------------------------------------------------");
            memoriseParking(outils.FileToStr.read(args[0]));
            afficheRapport();
            recuperationVehicules();
            afficheRapport();
        }
    }*/

    public static void main (String[] args) {

            System.out.println("Mémorisation du parking (fichier : ");
            System.out.println("----------------------------------------------------------");
            memoriseParking(FileToStr.read("parking.txt"));
            afficheRapport();
            recuperationVehicules();
            afficheRapport();

    }
}