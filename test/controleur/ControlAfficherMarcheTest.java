package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initialiisation...");
		village = new Village("le village des irrductibles",10,5);
		Chef abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		Gaulois obelisk =new Gaulois("Obelisk", 999);
		Gaulois napoleon= new Gaulois("Napoleon",999);
		village.ajouterHabitant(obelisk);
		village.ajouterHabitant(napoleon);
		village.installerVendeur(obelisk, "gun", 10);
	}

	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche);
	}

	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		String[] donnesMarche =controlAfficherMarche.donnerInfosMarche();
		assertEquals("Obelisk",donnesMarche[0]);
		assertEquals("10",donnesMarche[1]);
		assertEquals("gun",donnesMarche[2]);
	}

}
