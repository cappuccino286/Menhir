package Manager;
import java.util.ArrayList;

public class CarteAllies extends Carte{
    //Carte TaupeGeante
    public final static int[] TAUPE1 = {1,1,1,1};
    public final static int[] TAUPE2 = {0,2,2,0};
    public final static int[] TAUPE3 = {0,1,2,1};
    //Carte ChiensDeGarde
    public final static int [] CHIEN1 = {2,0,2,0};
    public final static int [] CHIEN2 = {1,2,0,1};
    public final static int [] CHIEN3 = {0,1,3,0};
    public final static int[][] TAUPE={TAUPE1,TAUPE2,TAUPE3};
    public final static int[][] CHIEN={CHIEN1,CHIEN2,CHIEN3};   
    
    protected int[] all;
    public CarteAllies(){	
    }   
}
class TaupeGeante extends CarteAllies{
	/**
	* Déterminer les cartes Taupe Geante
	*/
	private int hello;
    public TaupeGeante(int i){
        this.all=TAUPE[i-1];
        hello =i;
    }
    public String toString(){
    	return "CarteTaupe"+ hello;
    }
    /**
	* Action de la carte Taupe Geante
	*/
    public void taupegeante(Joueur adversaire, int saison){
        if(this.all[saison]<adversaire.getNbmenhirs())
            adversaire.setNbmenhirs(-this.all[saison]);
        else
            adversaire.setNbmenhirs(-adversaire.getNbmenhirs());
    }

}
class ChiensDeGarde extends CarteAllies{
	/**
	* Déterminer les cartes Chiens de Garde
	*/
	private int hello;
    public ChiensDeGarde(int i){
         this.all = CHIEN[i-1];
         hello =i;
    }
    public String toString(){
    	return "CarteChien"+ hello;
    }
    /**
	* Action de la carte Chiens de Garde
	*/
    public void chiensdegarde(Joueur joueur,Joueur adversaire, int saison, int a){
        int b=adversaire.getNbgrains()-a;
     	if(b>all[saison]){ 
            adversaire.setNbgrains(-this.all[saison]);
            joueur.setNbgrains(this.all[saison]);
        }  else{
            adversaire.setNbgrains(-b);
            joueur.setNbgrains(b);
        }
    }

}