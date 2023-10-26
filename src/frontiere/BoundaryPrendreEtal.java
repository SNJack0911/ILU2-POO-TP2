package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		Boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis desolee "+nomVendeur+" mais il faut etre un habitant de notre village pour commercer ici.");
			
		}else if (!controlPrendreEtal.isNotVendeur(nomVendeur)){
			System.out.println("Js suis desole "+nomVendeur+" mais vous pouvez ouvrir un seul etal ");
		}else {
			System.out.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver un etal.");
			Boolean etalDisponible= controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Desolee "+nomVendeur+" je n'ai plus d'etal qui ne soit pas deja occupe.");
			}else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder quotes= new StringBuilder();
		quotes.append("C'est parfait, il me reste un etal pour vous\n");
		quotes.append("Il me faudrait quelques renseignements :\n");
		quotes.append("Quel produit souhaitez-vous vendre ?");
		System.out.println(quotes.toString());
		String produit= scan.next();
		int nbProduit=Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			int nbAffiche=numeroEtal+1;
			System.out.println("Le vendeur "+nomVendeur+" s'est installe a l'etal no "+nbAffiche);
		}
	}
}
