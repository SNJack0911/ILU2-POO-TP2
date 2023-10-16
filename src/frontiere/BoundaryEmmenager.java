package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}
	private int demanderForce() {
		int Force = Clavier.entrerEntier("Quelle est votre force ?");
		return Force;
	}

	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue villageois "+nomVisiteur);
		int Force = demanderForce();
		controlEmmenager.ajouterGaulois(nomVisiteur, Force);
	}
	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide "+nomVisiteur);
		int Force = demanderForce();
		int effetPotionMax= 0;
		int effetPotionMin= 1;
		while (effetPotionMin>effetPotionMax) {
			effetPotionMin= Clavier.entrerEntier("Quelle est la force la plus faible que vous produisez ?");
			effetPotionMax= Clavier.entrerEntier("Quelle est la force la plus forte que vous produisez ?");
			if (effetPotionMin>effetPotionMax) {
				System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, Force, effetPotionMin, effetPotionMax);
	}
}
