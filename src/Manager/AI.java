package Manager;

import java.util.Random;

public class AI extends Joueur {
	private Strategy strategy;
	private CartesIngredients carteIn;

	/**
	 * Les m�thodes Get + Set pour le param�tre strategy
	 * @param strategy en fonction du type du jeu.
	 */
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Strategy getStrategy() {
		return this.strategy;
	}

	public AI() {
		super();
	}
	//R�aliser les missions du Strategy
	public void doMission() {
		carteIn = strategy.setAICarte();
		strategy.setAIAction();
	}

	public CartesIngredients getCarte() {
		return carteIn;
	}
	//Demander AI � prendre la carte Allies ou non?
	public boolean prendreAllies() {
		Random rd = new Random();
		int x = rd.nextInt(2);
		if (x == 1) {
			this.setNbgrains(-this.getNbgrains());
			return true;
		}
		return false;
	}
	//Demander AI � utiliser la carte Allies ou non?
	public boolean utiliseAllies(CarteAllies carteA, int saison) {
		if (carteA instanceof ChiensDeGarde) {
			if (carteA.all[saison] > 0) {
				return true;
			}
			return false;
		} else {
			if (carteA.all[saison] > 0 && saison > 1) {
				return true;
			}
			return false;
		}
	}
}
