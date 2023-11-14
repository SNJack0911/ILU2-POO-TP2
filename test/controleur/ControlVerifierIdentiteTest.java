package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

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
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertTrue(controlVerifierIdentite.verifierIdentite("Obelisk"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Bonemine"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
	}

	@Test
	void testIsNotVendeur() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertFalse(controlVerifierIdentite.isNotVendeur("Obelisk"));
		assertTrue(controlVerifierIdentite.isNotVendeur("Napoleon"));
	}

}
