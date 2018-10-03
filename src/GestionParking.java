import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Gestion du parking silo : 
 *		 mémorisation des données;
 *		 présentation du rapport;
 *		 retirer un ensemble de véhicules;
 *		 présentation du nouveau rapport.
 *
 * @author VOTRE NOM														 
*/
public class GestionParking {
		
	/* Liste des délimiteurs */
	private static final String DEL_ETAGE = "\r\n";
	private static final String DEL_CHAMP = ";";
	private static final String DEL_NO_BOX = "-";

	private static final int TYPE_VELO = 0;
	private static final int TYPE_MOTO = 1;
	private static final int TYPE_VOITURE = 2;
		
	/* Le parking */
	private static Parking parking; 
	
	/* Méthodes de service */
	private static int str2int (String s) {return Integer.parseInt (s);} 
	
	/* Mémorise les données du parking */
	private static void memoriseParking (String donneesParking) {
		/* Création du parking */	
		parking = new Parking(); 
		StringTokenizer stE = new StringTokenizer(donneesParking,DEL_ETAGE);
		while (stE.hasMoreTokens())
		{
			StringTokenizer stC = new StringTokenizer(stE.nextToken(),DEL_CHAMP);
			while(stC.hasMoreTokens())
			{
				StringTokenizer stN = new StringTokenizer(stC.nextToken(),DEL_NO_BOX);
				int etage = str2int(stN.nextToken());
				int nbBox = str2int(stN.nextToken());

				int typeVehicule = str2int(stC.nextToken());
				int tempsQuart = str2int(stC.nextToken());
				String nom = stC.nextToken();
				String prenom = stC.nextToken();
				String numImmatriculation = stC.nextToken();

				Etage et = parking.getEtage(etage);
				if(et==null)
				{
					et = new Etage(etage);
					parking.add(et);
				}

				Box bx = et.getBox(nbBox);
				if(bx == null)
				{
					bx = new Box(nbBox,creerVehiculeBox(typeVehicule,nom,prenom,numImmatriculation));
					et.add(bx);
				}
				bx.setNbQuartHeures(tempsQuart);
			}
		}
	}

	private static Vehicule creerVehiculeBox(int typeVehi, String nom, String prenom, String numImmatri)
	{
		Vehicule vc;
		if(typeVehi == Vehicule.TYPE_VELO)
		{
			vc = new Velo(numImmatri,prenom,nom);
		}
		else if( typeVehi == Vehicule.TYPE_MOTO)
		{
			vc = new Moto(numImmatri,prenom,nom);
		}
		else if(typeVehi == Vehicule.TYPE_VOITURE)
		{
			vc = new Voiture(numImmatri,prenom,nom);
		}
		else
		{
			vc = null;
		}
		return vc;
	}

	
	/* Prépare et affiche le rapport */
	private static void afficheRapport () {
		System.out.println("Rapport parking");
		System.out.println("Il y a : " +parking.getNbVehicules() +" véhicule(s) parqués");
		System.out.println("VELO "+ parking.getCompteType(TYPE_VELO) +" pour un montant actuel : " +parking.getPrixType(TYPE_VELO) +" CHF");
		System.out.println("MOTO "+ parking.getCompteType(TYPE_MOTO) +" pour un montant actuel : " +parking.getPrixType(TYPE_MOTO) +" CHF");
		System.out.println("VOITURE "+ parking.getCompteType(TYPE_VOITURE) +" pour un montant actuel : " +parking.getPrixType(TYPE_VOITURE) +" CHF");
	}
	
	/* VOUS NE DEVEZ PAS MODIFIER LE CODE DE CETTE METHODE */
	private static void recuperationVehicules () {
		System.out.println("----------------------------------------------------------");
		parking.removeVehicule("GE657665");
		parking.removeVehicule("NE342078");
		parking.removeVehicule("AG456");
		parking.removeVehicule("BE87350");
		parking.removeVehicule("NE563458");
		parking.removeVehicule("VD15646");

		System.out.println("Les véhicules suivants ont été supprimés :");
		System.out.println("	 GE657665, NE342078, AG456, BE87350, NE563458 et VD15646");
		System.out.println("----------------------------------------------------------");
	}
	
	/* LE CODE DE CETTE MÉTHODE NE DOIT PAS ÊTRE MODIFIÉ */
	public static void main (String[] args) {
		//if (args.length < 1) { 																			/// A MODIFIFFIIFIEIIRIERIR
			System.out.println("Il faut saisir le fichier de données.");
		//} else {																							/// A MODIFIFFIIFIEIIRIERIR
			System.out.println("Mémorisation du parking (fichier :");
			//System.out.println("Mémorisation du parking (fichier : \"" + args[0] + "\")");				/// A MODIFIFFIIFIEIIRIERIR
			System.out.println("----------------------------------------------------------");
			memoriseParking(FileToStr.read("parking.txt")); 											/// A MODIFIFFIIFIEIIRIERIR

			afficheRapport();
			recuperationVehicules();
			afficheRapport();
		//}																									/// A MODIFIFFIIFIEIIRIERIR
	}
}