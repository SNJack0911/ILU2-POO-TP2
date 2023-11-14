package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private  Village village;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialiisation...");
		village = new Village("le village des irrductibles",10,5);
		Chef abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Constructeur ne renvoie pas null");
	}
	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}
	@Test
	void tesAjouterDruide() {
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}
	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
	}
	@Test
	void testAjouterDepasseCapacite() {
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("1", 10);
		controlEmmenager.ajouterGaulois("2", 10);
		controlEmmenager.ajouterGaulois("3", 10);
		controlEmmenager.ajouterGaulois("4", 10);
		controlEmmenager.ajouterGaulois("5", 10);
		controlEmmenager.ajouterGaulois("6", 10);
		controlEmmenager.ajouterGaulois("7", 10);
		controlEmmenager.ajouterGaulois("8", 10);
		controlEmmenager.ajouterGaulois("9", 10);
		controlEmmenager.ajouterGaulois("10", 10);
		controlEmmenager.ajouterGaulois("11", 10);
		assertFalse(controlEmmenager.isHabitant("11"));
	}

}
