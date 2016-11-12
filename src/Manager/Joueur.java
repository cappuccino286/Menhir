package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Joueur {
	private String nom;
	private Scanner scanIn = new Scanner(System.in);
	protected int nbmenhirs;
	protected int nbgrains;
	protected int nbmenhirsfinal;
	protected int nbgrainsfinal;
	private CarteAllies carteA;
	protected CartesIngredients c = new CartesIngredients();
	public ArrayList<Carte> listeCarte = new ArrayList();

	public void setListeCarte(Carte carte) {
		this.listeCarte.add(carte);
	}

	// Les methods Get + set pour carteA
	public CarteAllies getCarteA() {
		return carteA;
	}

	public void setCarteA(CarteAllies carteA) {
		this.carteA = carteA;
	}
	///
	
	// Les methods Get + set pour grains + menhirs
	public int getNbmenhirs() {
		return nbmenhirs;
	}

	public void setNbmenhirs(int nbmenhirs) {
		this.nbmenhirs += nbmenhirs;
	}

	public int getNbgrains() {
		return nbgrains;
	}

	public void setNbgrains(int nbgrains) {
		this.nbgrains += nbgrains;
	}

	public int getNbmenhirsFinal() {
		return nbmenhirsfinal;
	}

	public void setNbmenhirsFinal(int nbmenhirs) {
		this.nbmenhirsfinal += nbmenhirs;
	}

	public int getNbgrainsFinal() {
		return nbgrainsfinal;
	}

	public void setNbgrainsFinal(int nbgrains) {
		this.nbgrainsfinal += nbgrains;
	}

	///
	public Joueur(String nom) {
		this.nom = nom;
		this.nbgrains = 2;
		this.nbmenhirs = 0;
		this.nbgrainsfinal = 0;
		this.nbmenhirsfinal = 0;
	}

	public Joueur() {
		this.nbgrains = 2;
		this.nbmenhirs = 0;
		this.nbgrainsfinal = 0;
		this.nbmenhirsfinal = 0;
	}
	//Demander l'utilisateur à prendre une carte allies ou non?
	public boolean prendreAllies() {
		int x = JOptionPane.showConfirmDialog(null, "Voulez-vous prendre une carte Allies", "prendre carte Allies",
				JOptionPane.YES_NO_OPTION);
		if (x == 0) {
			this.setNbgrains(-this.getNbgrains());
			return true;
		}
		return false;
	}
	
	public CartesIngredients SelectionCarte(int numeroCarte) {
		c = (CartesIngredients) listeCarte.get(numeroCarte);
		return c;
	}
	//Demander l'utilisateur à utiliser sa carte Taupe Geant ou non?
	public boolean utiliseAllies() {
		int y = JOptionPane.showConfirmDialog(null, "Voulez-vous utiliser votre carte Taupegeant?",
				"utiliser carte Taupegeant", JOptionPane.YES_NO_OPTION);
		if (y == 0) {
			return true;
		}
		return false;
	}
}
