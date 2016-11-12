package Manager;
import java.util.ArrayList;
import java.util.Collections;

import GUI.DrawCarte;

public class StrategyDebutant implements Strategy {
	private int action;
	private CartesIngredients c;
	private AI ai;
	private int saison;
	private ArrayList<Joueur> joueur;
	public StrategyDebutant(AI ai,ArrayList joueur,int saison){
		this.ai=ai;
		this.saison=saison;
		this.joueur=joueur;
	}
	//Choisir une carte pour jouer en faisant au hasard 
	public CartesIngredients setCarte(){
		Collections.shuffle(ai.listeCarte);
		c=(CartesIngredients) ai.listeCarte.get(0);
		ai.listeCarte.remove(0);
		return c;
	}
	@Override
	public CartesIngredients setAICarte() {
		return c;
	}
	@Override
	//Get AI action
	public int getAIAction() {
		setCarte();
		int index =0;
		int max= c.getVal(0, saison);
		if(ai.getNbgrains()>=4){
			index =1;
		} else if(ai.getNbgrains()!=0){
			for(int i=1;i<3;i++){
				if(max<c.getVal(i, saison)){
					max=c.getVal(i, saison);
					index =i;
				}
			}
		} else {
			if(max<c.getVal(2, saison)){
				index =  2;
			} else {
				index = 0;
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
				c.farfadets(ai, saison, joueur.get(getJoueurMaxGrains()));
				break;
			default:
				break;
		}
	}
	private int indexJMG=0;
	//Déterminer le joueur qui a le plus grains
	@Override
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
	public void joueTaupeGeante() {
		// TODO Auto-generated method stub
		
	}
	
}
