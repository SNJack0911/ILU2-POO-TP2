package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	
	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierAcheteur(nomAcheteur)) {
			System.out.println("Desolee "+nomAcheteur+" mais il faut etre un habitant de ce village pour acheter des produits !");
		}else {
			System.out.println("Quel produit voulez vous-acheter ?");
			String produit =scan.next();
			String[] vendeurs=controlAcheterProduit.trouverEtalProduit(produit);
			if (vendeurs==null) {
				System.out.println("Desole, personne ne vend ce produit au marche.");
			}else {
				StringBuilder question = new StringBuilder();
				question.append("Chez quel commercant voulez-vous acheter des fleurs ?\n");
				for (int i=1;i<=vendeurs.length;i++){
					question.append(i+" - "+vendeurs[i-1]+"\n");
				}
				int choix = Clavier.entrerEntier(question.toString());
				String nomVendeur=vendeurs[choix-1];
				System.out.println(nomAcheteur+" se deplace jusqu'a l'etal du vendeur " +nomVendeur+"\nBonjours "+nomAcheteur);
				int nbProduitAcheter=Clavier.entrerEntier("Combien de "+produit+" voulez-vous acheter ?\n");
				vendre(nomAcheteur, nomVendeur,produit, nbProduitAcheter);
			
			}
		}
		
	}
	public void vendre(String nomAcheteur,String nomVendeur,String produit,int nbProduitAcheter) {
		int stock = controlAcheterProduit.stock(nomVendeur);
		StringBuilder quotes=new StringBuilder();
		quotes.append(nomAcheteur+" veut acheter "+nbProduitAcheter+" "+produit);
		if (stock==0) {
			quotes.append(", malheuresement il n'y en a plus !");
			System.out.println(quotes.toString());
		}else if(stock <nbProduitAcheter) {
			quotes.append(", malheuresement "+nomVendeur+" n'en a plus que "+stock+". ");
			quotes.append(nomAcheteur+" acheter tout le stock de "+nomVendeur);
			System.out.println(quotes.toString());
			controlAcheterProduit.vendre(nomVendeur,nbProduitAcheter);
		}else {
			System.out.println(nomAcheteur+" achete "+nbProduitAcheter+" "+produit+" a "+nomVendeur);
			controlAcheterProduit.vendre(nomVendeur, nbProduitAcheter);
		}
	}
}
