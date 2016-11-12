package Manager;

import java.util.ArrayList;
import java.util.Arrays;

public class CartesIngredients extends Carte {
	/**
	 * Déterminer les cartes Ingredients
	 */
	public final static int NOMBRE_CARTE = 24;

	public final static int[][] CARTE1 = { { 1, 1, 1, 1 }, { 2, 0, 1, 1 }, { 2, 0, 2, 0 } };
	public final static int[][] CARTE2 = { { 2, 0, 1, 1 }, { 1, 3, 0, 0 }, { 0, 1, 2, 1 } };
	public final static int[][] CARTE3 = { { 0, 0, 4, 0 }, { 0, 2, 2, 0 }, { 0, 0, 1, 3 } };
	public final static int[][] CARTE4 = { { 1, 3, 1, 0 }, { 1, 2, 1, 1 }, { 0, 1, 4, 0 } };
	public final static int[][] CARTE5 = { { 2, 1, 1, 1 }, { 1, 0, 2, 2 }, { 3, 0, 0, 2 } };
	public final static int[][] CARTE6 = { { 1, 2, 2, 0 }, { 1, 1, 2, 1 }, { 2, 0, 1, 2 } };
	public final static int[][] CARTE7 = { { 2, 1, 1, 2 }, { 1, 1, 1, 3 }, { 2, 0, 2, 2 } };
	public final static int[][] CARTE8 = { { 0, 3, 0, 3 }, { 2, 1, 3, 0 }, { 1, 1, 3, 1 } };
	public final static int[][] CARTE9 = { { 1, 2, 1, 2 }, { 1, 0, 1, 4 }, { 2, 4, 0, 0 } };
	public final static int[][] CARTE10 = { { 1, 3, 1, 2 }, { 2, 1, 2, 2 }, { 0, 0, 3, 4 } };
	public final static int[][] CARTE11 = { { 2, 2, 0, 3 }, { 1, 1, 4, 1 }, { 1, 2, 1, 3 } };
	public final static int[][] CARTE12 = { { 2, 2, 3, 1 }, { 2, 3, 0, 3 }, { 1, 1, 3, 3 } };
	public final static int[][] CARTE13 = { { 2, 2, 3, 1 }, { 2, 3, 0, 3 }, { 1, 1, 3, 3 } };
	public final static int[][] CARTE14 = { { 2, 2, 2, 2 }, { 0, 4, 4, 0 }, { 1, 3, 2, 2 } };
	public final static int[][] CARTE15 = { { 3, 1, 3, 1 }, { 1, 4, 2, 1 }, { 2, 4, 1, 1 } };
	public final static int[][] CARTE16 = { { 4, 1, 1, 1 }, { 1, 2, 1, 3 }, { 1, 2, 2, 2 } };
	public final static int[][] CARTE17 = { { 2, 3, 2, 0 }, { 0, 4, 3, 0 }, { 2, 1, 1, 3 } };
	public final static int[][] CARTE18 = { { 2, 2, 3, 0 }, { 1, 1, 1, 4 }, { 2, 0, 3, 2 } };
	public final static int[][] CARTE19 = { { 3, 1, 4, 1 }, { 2, 1, 3, 3 }, { 2, 3, 2, 2 } };
	public final static int[][] CARTE20 = { { 2, 4, 1, 2 }, { 2, 2, 2, 3 }, { 1, 4, 3, 1 } };
	public final static int[][] CARTE21 = { { 3, 3, 3, 0 }, { 1, 3, 3, 2 }, { 2, 3, 1, 3 } };
	public final static int[][] CARTE22 = { { 1, 2, 2, 1 }, { 1, 2, 3, 0 }, { 0, 2, 2, 2 } };
	public final static int[][] CARTE23 = { { 4, 0, 1, 1 }, { 1, 1, 3, 1 }, { 0, 0, 3, 3 } };
	public final static int[][] CARTE24 = { { 2, 0, 1, 3 }, { 0, 3, 0, 3 }, { 1, 2, 2, 1 } };
	public final static int[][][] C = { CARTE1, CARTE2, CARTE3, CARTE4, CARTE5, CARTE6, CARTE7, CARTE8, CARTE9, CARTE10,
			CARTE11, CARTE12, CARTE13, CARTE14, CARTE15, CARTE16, CARTE17, CARTE18, CARTE19, CARTE20, CARTE21, CARTE22,
			CARTE23, CARTE24 };
	int[][] val;
	private int hello;

	public CartesIngredients(int i) {
		this.val = C[i - 1];
		hello = i;
	}
	//Afficher le nom de la Carte
	public String toString() {
		return "Carte" + hello;
	}
	//Get la valeur de la Carte en fonction de la ligne et le column
	public int getVal(int ligne, int column) {
		return this.val[ligne][column];
	}

	public CartesIngredients() {
	};
	/**
	* Action Geant
	* @param joueur Joueur utilisant l'action Geant
	* @param saison Get valeur du carte en fonction de la saison
	*/
	public void geant(Joueur joueur, int saison) {
		joueur.setNbgrains(this.val[0][saison]);
	}
	/**
	* Action Engrais
	* @param joueur Joueur utilisant l'action Geant
	* @param saison Get valeur du carte en fonction de la saison
	*/
	public void engrais(Joueur joueur, int saison) {
		if (this.val[1][saison] < joueur.getNbgrains()) {
			joueur.setNbmenhirs(this.val[1][saison]);
			joueur.setNbgrains(-this.val[1][saison]);
		} else {
			joueur.setNbmenhirs(joueur.getNbgrains());
			joueur.setNbgrains(-joueur.getNbgrains());
		}
	}
	/**
	* Action Farfadets
	* @param joueur Joueur utilisant l'action Geant
	* @param saison Get valeur du carte en fonction de la saison
	* @param adversaire L'adversaire qui va perdre des grains
	*/
	public void farfadets(Joueur joueur, int saison, Joueur adversaire) {
		if (this.val[2][saison] < adversaire.getNbgrains()) {
			adversaire.setNbgrains(-this.val[2][saison]);
			joueur.setNbgrains(this.val[2][saison]);
		} else {
			int tg = adversaire.getNbgrains();
			adversaire.setNbgrains(-tg);
			joueur.setNbgrains(tg);
		}
	}
}