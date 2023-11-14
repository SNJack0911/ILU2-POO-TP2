package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
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
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois newen =new Gaulois("Newen", 999);
		Gaulois jason =new Gaulois("Jason", 999);
		Gaulois nura =new Gaulois("Nura", 999);
		Gaulois gay =new Gaulois("Gay", 999);
		village.ajouterHabitant(newen);
		village.ajouterHabitant(jason);
		village.ajouterHabitant(nura);
		village.ajouterHabitant(gay);
		village.installerVendeur(newen, "gun", 10);
		village.installerVendeur(nura, "gun", 10);
		village.installerVendeur(jason, "gun", 10);
		village.installerVendeur(gay, "gun", 10);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		int numero = controlPrendreEtal.prendreEtal("Napoleon","gun", 99);
		assertEquals(1, numero);
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.verifierIdentite("Obelisk"));
		assertFalse(controlPrendreEtal.verifierIdentite("Bonemine"));
	}

	@Test
	void testIsNotVendeur() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertFalse(controlPrendreEtal.isNotVendeur("Obelisk"));
		assertTrue(controlPrendreEtal.isNotVendeur("Napoleon"));
	}

}
