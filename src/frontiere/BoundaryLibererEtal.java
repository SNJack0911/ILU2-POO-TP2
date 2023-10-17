package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!(controlLibererEtal.isVendeur(nomVendeur))) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marche aujourd'hui !");
		}else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			Boolean etalOccupe = Boolean.valueOf(donneesEtal[0]);
			String quantiteVendu = donneesEtal[4];
			String quantiteInitial = donneesEtal[3];
			String produit = donneesEtal[2];
			if (etalOccupe) {
				System.out.println("Vous avez vendu "+quantiteVendu+" sur "+ quantiteInitial+" "+produit+".");
				System.out.println("En revoir "+nomVendeur+",passez une bonne journee");
			}
		}
	}

}
