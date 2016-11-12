package Manager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Deck {
	
	public ArrayList<CartesIngredients> Ingredients = new ArrayList();
    public ArrayList<CarteAllies> CarteTaupe = new ArrayList<>();
    public ArrayList<CarteAllies> CarteChien = new ArrayList<>();
    public ArrayList<CarteAllies> getTaupe(){
    	return CarteTaupe;
    }
    public ArrayList<CarteAllies> getChien(){
    	return CarteChien;
    }
	private int h=0;
	Scanner scanIn= new Scanner(System.in);
	public Deck(Jeu jeu){
		//Creer des cartes ingredients
		for(int i=1;i<=24;i++){
			Ingredients.add(new CartesIngredients(i));
		}
		//Faire au hasard les cartes ingredients
		Collections.shuffle(Ingredients);
        for(int i=0;i<4;i++){
        	for(int k=0;k<jeu.nbJoueur;k++){
        		jeu.listjoueur.get(k).setListeCarte(Ingredients.get(h));
        		h++;
        	}
        }
        //Creer des cartes allies dans la partie Avancee
        if(jeu.getTypeJeu() instanceof Avancee){
        	for(int i=1;i<=3;i++){
        		CarteTaupe.add(new TaupeGeante(i));
        	}
        	for(int i=1;i<=3;i++){
        		CarteChien.add(new ChiensDeGarde(i));
        	}
        	Collections.shuffle(CarteTaupe);
        	Collections.shuffle(CarteChien);
        	int ta=0;
        	int ch=0;
    		for(int k=0;k<jeu.nbJoueur;k++){
    			/**
				   * @param k pour citer le joueur
				   * k=0 -> Joueur physique
				   * k!=0 -> AI
    			*/
    			if(k==0){
    				if(jeu.listjoueur.get(k).prendreAllies()==true){
    					String[] options ={"Taupe Geant","Chiens de Garde"};
    					int x = JOptionPane.showOptionDialog(null, "Taupe Geant ou Chiens de Garde?", "Choisir carte", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null,options,"Taupe Geant");
	    				if(x==0){
	    					if(ta<3){
		    					(jeu.listjoueur.get(k)).setCarteA(CarteTaupe.get(ta));
		    					ta++;
	    					} else {
	    						JOptionPane.showMessageDialog(null, "Il n'y a pas encore Taupe Geant");
	    					}
	    				} else {
	    					if(ch<3){
		    					jeu.listjoueur.get(k).setCarteA(CarteChien.get(ch));
		    					ch++;
	    					} else {
	    						JOptionPane.showMessageDialog(null, "il n'a pas encore Chiens De Garde");
	    					}
	    				}
    				}
    			} else {
    				if(((AI)jeu.listjoueur.get(k)).prendreAllies()==true){
    					//Faire au hasard les cartes Allies
    					Random rd= new Random();
    					int x = rd.nextInt(2);
	    				if(x==0){
	    					(jeu.listjoueur.get(k)).setCarteA(CarteTaupe.get(ta));
	    					ta++;
	    				} else {
	    					jeu.listjoueur.get(k).setCarteA(CarteChien.get(ch));
	    					ch++;
	    				}
    				}
    			}
        	}
        }
	}
}
