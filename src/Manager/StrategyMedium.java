package Manager;
import java.util.ArrayList;

public class StrategyMedium implements Strategy {
	private CartesIngredients c;
	private AI ai;
	private int saison;
	private int action;
	private ArrayList<Joueur> joueur;
	public StrategyMedium(AI ai,ArrayList<Joueur> joueur,int saison){
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
	//Choisir une carte pour jouer en faisant au hasard 
	public CartesIngredients setAICarte() {
		int index=0;
		action = getAIAction();
		for(int i=1;i<ai.listeCarte.size();i++){
			if(((CartesIngredients) ai.listeCarte.get(index)).getVal(action,saison) < ((CartesIngredients) ai.listeCarte.get(i)).getVal(action,saison)){
				index=i;
			}
		}
		c= (CartesIngredients) ai.listeCarte.get(index);
		ai.listeCarte.remove(index);
		return c;
	}
	@Override
	//Choisir une action
	public void setAIAction() {
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
	public void joueTaupeGeante() {
		// TODO Auto-generated method stub
		
	}
}