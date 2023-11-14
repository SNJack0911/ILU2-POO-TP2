package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] trouverEtalProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if (vendeurs==null) { 
			return null;
		}else{
			String[] nomVendeurs = new String[vendeurs.length];
			for (int i=0;i<vendeurs.length;i++) {
				nomVendeurs[i]=vendeurs[i].getNom();
			}
			return nomVendeurs;
		}
	}
	public int stock(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.getQuantite();
	}

	public int acheterProduit(String nomVendeur, int nbProduitAcheter) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal.isEtalOccupe()) {
			int nbProduitEtal=etal.getQuantite();
			if(nbProduitAcheter >  nbProduitEtal) {
				etal.acheterProduit(nbProduitAcheter);
				return nbProduitEtal;
			}else {
				etal.acheterProduit(nbProduitAcheter);
				return nbProduitAcheter;
			}
		}else {
			etal.acheterProduit(nbProduitAcheter);
			return 0;
		}
	}
	public Boolean verifierAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
}
