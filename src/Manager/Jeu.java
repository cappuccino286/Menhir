package Manager;
import java.util.ArrayList;
import java.util.Scanner;

import GUI.FramePrincipal;
import GUI.GuiPrincipal;
/**
* <h1>Jeu de Menhir</h1>
*
* @author  Sy Hung NGHIEM - Nguyen Quoc Cuong TRAN
* @version 1.0
* @since   Automne 2015
*/
public class Jeu{
    private Scanner scanIn = new Scanner(System.in);
    GuiPrincipal viewGUI;
    FramePrincipal frameGUI;
    int nbJoueur;
    private Partie typeJeu;
    String niveau;
    ArrayList<Joueur> listjoueur = new ArrayList<Joueur>();
    
    public Jeu(String nom,int nbJoueur,String type,String niveau,FramePrincipal frame){
    	viewGUI=new GuiPrincipal();
    	frameGUI=frame;
    	if(type.equalsIgnoreCase("Rapide")){
    		viewGUI.panelFinal.setVisible(false);
    	}
    	this.listjoueur.add(new Joueur(nom));//cree joueur physique
    	this.choisirType(type);
    	this.niveau=niveau;
        this.nbJoueur = nbJoueur;
        //cree joueur virtuel
        for(int i=1;i<this.nbJoueur;i++){
            this.listjoueur.add(new AI());
        }
        switchFrame();
    }
    public Partie getTypeJeu(){
    	return typeJeu;
    }
    //installer le type du jeu
    public Partie choisirType(String type) {
       if(type.equalsIgnoreCase("Rapide")){
    	   typeJeu=new Rapide();
       } else typeJeu=new Avancee();
       return typeJeu;
    }
    public String getNiveau(){
    	return niveau;
    }
    //installer points de chacun pour commencer une nouvelle partie
    public void setPoint0(){
        for(int i=0; i<this.nbJoueur;i++)
        {
        	Joueur j = listjoueur.get(i);
            j.setNbgrains(-j.getNbgrains()+2);
            j.setNbmenhirs(-j.getNbmenhirs());
        }
    }
    public void setViewGUI(GuiPrincipal viewGUI){
        this.viewGUI = viewGUI;
    }
    public void switchFrame(){
        frameGUI.setContentPane(this.viewGUI);
        if(nbJoueur==2){
			viewGUI.panelNo2.setVisible(false);
			viewGUI.panelNo3.setVisible(false);
			viewGUI.lblFinalAI2.setVisible(false);
			viewGUI.lblFinalAI3.setVisible(false);
		} else if(nbJoueur==3){
			viewGUI.panelNo3.setVisible(false);
			viewGUI.lblFinalAI3.setVisible(false);
		}
    }
}
