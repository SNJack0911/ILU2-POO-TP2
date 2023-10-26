package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomGaulois) {
		return village.trouverHabitant(nomGaulois)!=null;
	}
	public boolean isNotVendeur(String nomVendeur) {
		Gaulois gaulois = village.trouverHabitant(nomVendeur);
		return village.rechercherEtal(gaulois)==null;
	}
}
