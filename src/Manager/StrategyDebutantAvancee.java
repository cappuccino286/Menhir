package Manager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import GUI.DrawCarte;
import GUI.GuiPrincipal;

public class StrategyDebutantAvancee implements Strategy{
	private int action;
	private CartesIngredients c;
	private AI ai;
	private int saison;
	private ArrayList<Joueur> joueur;
	public StrategyDebutantAvancee(AI ai,ArrayList joueur,int saison){
		this.ai=ai;
		this.saison=saison;
		this.joueur=joueur;
	}
	public static int r;
	@Override
	//Choisir une carte pour jouer en faisant au hasard 
	public CartesIngredients setAICarte() {
		return c;
	}
	public CartesIngredients setCarte(){
		Collections.shuffle(ai.listeCarte);
		c=(CartesIngredients) ai.listeCarte.get(0);
		ai.listeCarte.remove(0);
		return c;
	}
	@Override
	//Get AI action
	public int getAIAction() {
		setCarte();
		int index = 0;
		int max= c.getVal(0, saison);
		if(ai.getNbgrains()>=4){
			index = 1;
		} else if(ai.getNbgrains()!=0){
			for(int i=1;i<3;i++){
				if(max<c.getVal(i, saison)){
					max=c.getVal(i, saison);
					index = i;
				}
			}
		} else {
			if(max<c.getVal(2, saison)){
				index= 2;
			} else {
				index= 0;
			}
		}
		action = index;
		return index;
	}
	@Override
	//Choisir une action
	public void setAIAction(){
		switch(action){
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
	private int indexJMG=0;
	@Override
	//Déterminer le joueur qui a le plus grains
	public int getJoueurMaxGrains() {
		Joueur j = joueur.get(0);
		for(int i=1;i< joueur.size();i++){
			if(joueur.get(i)!=ai){
				if(j.getNbgrains()< joueur.get(i).getNbgrains()){
					j= joueur.get(i);
					indexJMG=i;
				}
			}
		}
		return indexJMG;
	}
	@Override
	//Utiliser la carte Taupe Geante
	public void joueTaupeGeante(){
		TaupeGeante a = (TaupeGeante) ai.getCarteA();
		a.taupegeante(getJoueurMaxMenhirs(), saison);
		ai.setCarteA(null);
	}
	//Déterminer le joueur qui a le plus menhirs
	public Joueur getJoueurMaxMenhirs() {
		Joueur j= joueur.get(0);
		int i;
		for(i=1;i< joueur.size();i++){
			if(joueur.get(i)!=ai){
				if(j.getNbmenhirs()< joueur.get(i).getNbmenhirs()){
					j= joueur.get(i);
				}
			}
		}
		if(j!=joueur.get(0)){
			AI t = (AI) j;
			return t;
		}
		return j;
	}
}
