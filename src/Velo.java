import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Modélisation du véhicule deux roues "Velo".
 * La mémorisation est (héritée de Vehicule) : 
 *			- immatriculation (id);
 *			- nom et prénom du conducteur;
 *			- type de véhicule.
 *
 * VOUS POUVEZ MODIFIER LE CODE DE CETTE CLASSE SI VOUS LE SOUHAITEZ
 *
 * @author VOTRE NOM
*/
class Velo extends DeuxRoues {
	public Velo(String var1, String var2, String var3) {
		super(var1, var2, var3, 0);
	}

	public String toString() {
		return "VÃ©lo " + super.toString();
	}
}
