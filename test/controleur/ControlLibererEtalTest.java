package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.*;
class ControlLibererEtalTest {

	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	void setUpBeforeClass() {
		System.out.println("Initialiisation...");
		Village village = new Village("le village des irrductibles",10,5);
		Chef abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		Gaulois obelisk =new Gaulois("Obelisk", 999);
		Gaulois napoleon= new Gaulois("Napoleon",999);
		village.ajouterHabitant(obelisk);
		village.ajouterHabitant(napoleon);
		village.installerVendeur(obelisk, "gun", 10);
		controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal ,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertTrue(controlLibererEtal.isVendeur("Obelisk"),"Is Vendeur");
		assertFalse(controlLibererEtal.isVendeur("Napoleon"), "Is not vendeur");
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		String[] donneesEtal = controlLibererEtal.libererEtal("Hai");
		assertNull(donneesEtal, "Not a Gaulois");
		donneesEtal = controlLibererEtal.libererEtal("Napoleon");
		assertNull(donneesEtal,"Not a Vendeur");
		donneesEtal =controlLibererEtal.libererEtal("Obelisk");
		assertFalse(Boolean.getBoolean(donneesEtal[0]),"PartirVendeur");
		
	}

}
