package controleur;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.*;
class ControlTrouverEtalVendeurTest {

	private  Village village;
	private Gaulois obelisk;
	@BeforeEach
	void setUp() {
		System.out.println("Initialiisation...");
		village = new Village("le village des irrductibles",10,5);
		Chef abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		obelisk =new Gaulois("Obelisk", 999);
		Gaulois napoleon= new Gaulois("Napoleon",999);
		village.ajouterHabitant(obelisk);
		village.ajouterHabitant(napoleon);
		village.installerVendeur(obelisk, "gun", 10);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Obelisk");
		assertNotNull(etal,"Etal is not null");
		etal = controlTrouverEtalVendeur.trouverEtalVendeur("Hai");
		assertNull(etal, "Pas un gaulois");
		etal = controlTrouverEtalVendeur.trouverEtalVendeur("Napoleon");
		assertNull(etal, "Pas un vendeur");
		
	}

	@Test
	void testPartirVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		controlTrouverEtalVendeur.partirVendeur(obelisk);
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Obelisk");
		assertFalse(etal.isEtalOccupe(), "Vendeur a partir");
	}

}
