package Manager;
import GUI.DrawCarte;
import GUI.GuiPrincipal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StrategyMediumAvancee implements Strategy {
	private CartesIngredients c;
	private AI ai;
	private int saison;
	private int action;
	private ArrayList<Joueur> joueur;
	public StrategyMediumAvancee(AI ai,ArrayList<Joueur> joueur,int saison){
		this.ai=ai;
		this.saison=saison;
		this.joueur=joueur;
	}
	public static int r;
	@Override
	//Get AI action
	public int getAIAction(){
		if(ai.getNbgrains()>=3){
			return 1;
		} else if(verifier(0,4)){
			return 0;
		} else if(verifier(1,2)&&ai.getNbgrains()==2){
			return 1;
		} else if(ai.listeCarte.size()==1&&ai.getNbgrains()>0&&verifier(1, 1)){
			return 1;
		} else if(verifier(2,2)){
			return 2;
		} else if(verifier(0,3)){
			return 0;
		} else if(verifier(0,2)&&!verifier(2,1)){
			return 0;
		}
		return 2;
	}
	public boolean verifier(int action,int nb){
		for(int i=0;i<ai.listeCarte.size();i++){
			if(((CartesIngredients) ai.listeCarte.get(i)).getVal(action,saison)>=nb)
				return true;
		}
		return false;
	}

	@Override
	//Choisir une carte pour jouer
	public CartesIngredients setAICarte() {
		int index = 0;
		action = getAIAction();
		for (int i = 1; i < ai.listeCarte.size(); i++) {
			if (((CartesIngredients) ai.listeCarte.get(index)).getVal(action,
					saison) < ((CartesIngredients) ai.listeCarte.get(i)).getVal(action, saison)) {
				index = i;
			}
		}
		c = (CartesIngredients) ai.listeCarte.get(index);
		ai.listeCarte.remove(index);
		return c;
	}

	@Override
	//Choisir une action
	public void setAIAction() {
		switch (action) {
		case 0:
			c.geant(ai, saison);
			break;
		case 1:
			c.engrais(ai, saison);
			break;
		case 2:
			int nb = ai.getNbgrains();
			int x = getJoueurMaxGrains();
			c.farfadets(ai, saison, joueur.get(x));
			if (joueur.get(x).getCarteA() instanceof ChiensDeGarde) {
				if (x == 0) {
					int k = JOptionPane.showConfirmDialog(null, "Voulez-vous utiliser votre carte Chiens de Garde",
							"Utiliser Carte Chiens de Garde", JOptionPane.YES_NO_OPTION);
					if (k == 0) {
						ChiensDeGarde a = (ChiensDeGarde) joueur.get(0).getCarteA();
						a.chiensdegarde(joueur.get(0), ai, saison, nb);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						GuiPrincipal.lblalli.setVisible(true);
						GuiPrincipal.lblalli.setText("Vous avez utilisé carte Chiens de Gardes");
						GuiPrincipal.lblCarteA[0].setVisible(false);
						joueur.get(0).setCarteA(null);
					}
				}
				else {
					if (((AI) joueur.get(x)).utiliseAllies(joueur.get(x).getCarteA(), saison)) {
						ChiensDeGarde a = (ChiensDeGarde) joueur.get(x).getCarteA();
						a.chiensdegarde(joueur.get(x), ai, saison, nb);
						DrawCarte m = new DrawCarte(joueur.get(x).getCarteA().toString());
						GuiPrincipal.lblCarteA[x].setIcon(m.afficher());
						GuiPrincipal.lblalli.setVisible(true);
						GuiPrincipal.lblalli.setText("Joueur AI "+x+" a utilisé carte Chiens de Garde");
						switch (x) {
						case 1:
							GuiPrincipal.lblCarteA[x].setBounds(116, 198, 120, 120);
							break;
						case 2:
							GuiPrincipal.lblCarteA[x].setBounds(230, 87, 120, 120);
							break;
						case 3:
							GuiPrincipal.lblCarteA[x].setBounds(0, 87, 120, 120);
							break;
						default:
							break;
						}
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						GuiPrincipal.lblCarteA[x].setVisible(false);
						joueur.get(x).setCarteA(null);
					}
				}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			GuiPrincipal.lblalli.setVisible(false);
		}
			break;
		default:
			break;
		}
	}

	private int indexJMG = 0;

	@Override
	//Déterminer le joueur qui a le plus grains
	public int getJoueurMaxGrains() {
		Joueur j = joueur.get(0);
		for (int i = 1; i < joueur.size(); i++) {
			if (joueur.get(i) != ai) {
				if (j.getNbgrains() < joueur.get(i).getNbgrains()) {
					j = joueur.get(i);
					indexJMG = i;
				}
			}
		}
		return indexJMG;
	}

	@Override
	//Utiliser la carte Taupe Geante
	public void joueTaupeGeante() {
		TaupeGeante a = (TaupeGeante) ai.getCarteA();
		a.taupegeante(getJoueurMaxMenhirs(), saison);
		ai.setCarteA(null);
	}

	private int indexJMM = 0;
	//Déterminer le joueur qui a le plus menhirs
	public Joueur getJoueurMaxMenhirs() {
		Joueur j = joueur.get(0);
		for (int i = 1; i < joueur.size(); i++) {
			if (joueur.get(i) != ai) {
				if (j.getNbmenhirs() < joueur.get(i).getNbmenhirs()) {
					j = joueur.get(i);
					indexJMM = i;
				}
			}
		}
		return joueur.get(indexJMM);
	}
}