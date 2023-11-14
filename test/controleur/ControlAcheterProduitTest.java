package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;
import controleur.ControlLibererEtal;
class ControlAcheterProduitTest {

	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
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
		controlVerifierIdentite= new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit);
	}

	@Test
	void testTrouverEtalProduit() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		String[] vendeursGun = controlAcheterProduit.trouverEtalProduit("gun");
		assertEquals(vendeursGun[0],"Obelisk");
		assertNotEquals(vendeursGun[0],"Napoleon");
		String[] vendeursFleurs = controlAcheterProduit.trouverEtalProduit("fleurs");
		assertNull(vendeursFleurs);
	}

	@Test
	void testStock() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertEquals(10,controlAcheterProduit.stock("Obelisk"));
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertEquals(2,controlAcheterProduit.acheterProduit("Obelisk", 2));
		assertEquals(8,controlAcheterProduit.acheterProduit("Obelisk", 100));
		assertEquals(0,controlAcheterProduit.acheterProduit("Obelisk", 2));
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		controlLibererEtal.libererEtal("Obelisk");
		assertEquals(0,controlAcheterProduit.acheterProduit("Obelisk", 2));
		}

	@Test
	void testVerifierAcheteur() {
		ControlAcheterProduit controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.verifierAcheteur("Napoleon"));
	}

}
