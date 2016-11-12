package Manager;

import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import GUI.DrawCarte;
import GUI.GuiPrincipal;
import GUI.MenhirGUI;

public abstract class Partie {
	int tour;
	int saison = 0;
	CartesIngredients c = new CartesIngredients();
	int action;
	Scanner scanIn = new Scanner(System.in);

	public abstract void lancer(Jeu jeu);
	/**
	   * La méthode updateView utiliser un paramère jeu du Jeu actuel
	   * @param jeu Jeu actuel
	*/
	public void updateView(Jeu jeu) {
		jeu.viewGUI.getLblJoueur().setText("Joueur " + MenhirGUI.txtNom.getText() + " - Grains: "
				+ jeu.listjoueur.get(0).getNbgrains() + " Menhirs: " + jeu.listjoueur.get(0).getNbmenhirs());
		jeu.viewGUI.getLblAI1().setText("AI 1 - Grains: " + jeu.listjoueur.get(1).getNbgrains() + " Menhirs: "
				+ jeu.listjoueur.get(1).getNbmenhirs());
		jeu.viewGUI.lblFinalJoueur.setText("Joueur " + MenhirGUI.txtNom.getText() + " - Grains: "
				+ jeu.listjoueur.get(0).getNbgrainsFinal() + " Menhirs: " + jeu.listjoueur.get(0).getNbmenhirsFinal());
		jeu.viewGUI.lblFinalAI1.setText("AI 1 - Grains: " + jeu.listjoueur.get(1).getNbgrainsFinal() + " Menhirs: "
				+ jeu.listjoueur.get(1).getNbmenhirsFinal());
		switch (jeu.nbJoueur) {
		case 3:
			jeu.viewGUI.getLblAI2().setText("<html>AI 2  <br>Grains: " + jeu.listjoueur.get(2).getNbgrains() + "</br>"
					+ "<br>Menhirs: " + jeu.listjoueur.get(2).getNbmenhirs() + "</br></html>");
			jeu.viewGUI.lblFinalAI2.setText("AI 2 - Grains: " + jeu.listjoueur.get(2).getNbgrainsFinal() + " Menhirs: "
					+ jeu.listjoueur.get(2).getNbmenhirsFinal());
			break;
		case 4:
			jeu.viewGUI.getLblAI2().setText("<html>AI 2  <br>Grains: " + jeu.listjoueur.get(2).getNbgrains() + "</br>"
					+ "<br>Menhirs: " + jeu.listjoueur.get(2).getNbmenhirs() + "</br></html>");
			jeu.viewGUI.getLblAI3().setText("<html>AI 3  <br>Grains: " + jeu.listjoueur.get(3).getNbgrains() + "</br>"
					+ "<br>Menhirs: " + jeu.listjoueur.get(3).getNbmenhirs() + "</br></html>");
			jeu.viewGUI.lblFinalAI2.setText("AI 2 - Grains: " + jeu.listjoueur.get(2).getNbgrainsFinal() + " Menhirs: "
					+ jeu.listjoueur.get(2).getNbmenhirsFinal());
			jeu.viewGUI.lblFinalAI3.setText("AI 3 - Grains: " + jeu.listjoueur.get(3).getNbgrainsFinal() + " Menhirs: "
					+ jeu.listjoueur.get(3).getNbmenhirsFinal());
			break;
		}
	}
}

class Rapide extends Partie {
	private int[] points = new int[4];
	private Jeu jeu;

	public void lancer(final Jeu jeu) {
		//Creer un deck pour la partie
		Deck deck = new Deck(jeu);
		for (int i = 0; i < jeu.nbJoueur; i++) {
			System.out.println("Joueur " + i + ": " + jeu.listjoueur.get(i).listeCarte);
		}
		//Peindre des cartes utilisées
		for (int i = 0; i < 4; i++) {
			DrawCarte x = new DrawCarte(jeu.listjoueur.get(0).listeCarte.get(i).toString());
			jeu.viewGUI.ArrayButton[i].setIcon(x.afficher());
		}
		updateView(jeu);
		/**
		 * SwingWorker
		 * @see Exception
		 */
		final SwingWorker worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {

				for (int saison = 0; saison < 4; saison++) {
					switch (saison) {
					case 0:
						jeu.viewGUI.getLblsaison().setText("Saison: Printemps");
						break;
					case 1:
						jeu.viewGUI.getLblsaison().setText("Saison: Été");
						break;
					case 2:
						jeu.viewGUI.getLblsaison().setText("Saison: Automne");
						break;
					case 3:
						jeu.viewGUI.getLblsaison().setText("Saison: Hiver");
						break;
					default:
						break;
					}
					for (int k = 0; k < jeu.nbJoueur; k++) {
						Joueur joueur = jeu.listjoueur.get(k);
						/**
						   * @param k pour citer le joueur
						   * k=0 -> Joueur physique
						   * k!=0 -> AI
		    			*/
						if (k == 0) {
							jeu.viewGUI.getLbltour().setText("Tour: Joueur " + MenhirGUI.txtNom.getText());
							jeu.viewGUI.getLblaction().setText("Action: ");
							jeu.viewGUI.enableCarte(true);
							while (GuiPrincipal.run != true) {
								Thread.sleep(1000);
							}
							GuiPrincipal.run = false;
							c = joueur.SelectionCarte(jeu.viewGUI.carte);
							action = jeu.viewGUI.action;
							switch (action) {
							case 0://Utiliser l'action Geant
								jeu.viewGUI.getLblaction().setText("Action: Geant");
								c.geant(joueur, saison);
								break;
							case 1://Utiliser l'action Engrais
								jeu.viewGUI.getLblaction().setText("Action: Engrais");
								c.engrais(joueur, saison);
								break;
							case 2://Utiliser l'action Farfadets
								int choice;
								int adversaire;
								if (jeu.nbJoueur == 2)
									adversaire = 1;
								else if (jeu.nbJoueur == 3) {
									String[] options = { "AI No1", "AI No2" };
									choice = JOptionPane.showOptionDialog(null, "Qui voulez-vous faire farfadets?",
											"Choisir adversaire", JOptionPane.YES_NO_OPTION,
											JOptionPane.INFORMATION_MESSAGE, null, options, "AI No1");
									if (choice == 0) {
										adversaire = 1;
									} else
										adversaire = 2;
								} else {
									String[] options = { "AI No1", "AI No2", "AI No3" };
									choice = JOptionPane.showOptionDialog(null, "Qui voulez-vous faire farfadets?",
											"Choisir adversaire", JOptionPane.YES_NO_OPTION,
											JOptionPane.INFORMATION_MESSAGE, null, options, "AI No1");
									if (choice == 0)
										adversaire = 1;
									else if (choice == 1)
										adversaire = 2;
									else
										adversaire = 3;
								}
								jeu.viewGUI.getLblaction().setText("Action: Farfadets Joueur AI " + adversaire);
								c.farfadets(joueur, saison, jeu.listjoueur.get(adversaire));
								break;
							default:
								break;
							}
						} else {
							jeu.viewGUI.getLbltour().setText("Tour: AI " + k);
							AI ai = (AI) joueur;
							if (jeu.getNiveau().equalsIgnoreCase("Debutant")) {
								ai.setStrategy(new StrategyDebutant(ai, jeu.listjoueur, saison));
							} else
								ai.setStrategy(new StrategyMedium(ai, jeu.listjoueur, saison));
							switch (ai.getStrategy().getAIAction()) {
							case 0://Utiliser l'action Geant
								jeu.viewGUI.getLblaction().setText("Action: Geant");
								break;
							case 1://Utiliser l'action Engrais
								jeu.viewGUI.getLblaction().setText("Action: Engrais");
								break;
							case 2://Utiliser l'action Farfadets
								if (ai.getStrategy().getJoueurMaxGrains() == 0)
									jeu.viewGUI.getLblaction().setText("Action: Farfadets vous");
								else
									jeu.viewGUI.getLblaction().setText(
											"Action: Farfadets Joueur AI " + ai.getStrategy().getJoueurMaxGrains());
								break;
							default:
								break;
							}
							ai.doMission();
							DrawCarte y = new DrawCarte(ai.getCarte().toString());
							switch (k) {
							case 1:
								jeu.viewGUI.ArrayLabel1[3 - saison].setIcon(y.afficher());
								jeu.viewGUI.ArrayLabel1[3 - saison].setBounds(116, 198, 120, 120);
								break;
							case 2:
								jeu.viewGUI.ArrayLabel2[3 - saison].setIcon(y.afficher());
								jeu.viewGUI.ArrayLabel2[3 - saison].setBounds(230, 87, 120, 120);
								break;
							case 3:
								jeu.viewGUI.ArrayLabel3[3 - saison].setIcon(y.afficher());
								jeu.viewGUI.ArrayLabel3[3 - saison].setBounds(0, 87, 120, 120);
								break;
							default:
								break;
							}
						}
						updateView(jeu);
						Thread.sleep(2000);
					}
					Thread.sleep(2000);
					jeu.viewGUI.ArrayButton[jeu.viewGUI.carte].setVisible(false);
					;
					for (int m = 0; m < jeu.nbJoueur - 1; m++) {
						jeu.viewGUI.ArrayLabel[m][3 - saison].setVisible(false);
					}
				}
				int max = 0;
				for (int i = 0; i < jeu.nbJoueur; i++) {
					Joueur joueur = jeu.listjoueur.get(i);
					points[i] = joueur.getNbmenhirs() * 100 + joueur.getNbgrains();
					if (max < points[i]) {
						max = points[i];
					}
				}
				for (int i = 0; i < jeu.nbJoueur; i++) {
					if (max == points[i]) {
						if (i == 0) {
							JOptionPane.showMessageDialog(null, "Vous gagnez");
						} else
							JOptionPane.showMessageDialog(null, "AI No " + i + " gagne");
					}
				}
				int newgame = JOptionPane.showConfirmDialog(null, "Voulez-vous encore jouer?", "{Encore une fois}",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				switch (newgame) {
				case 0:
					Jeu x = new Jeu(MenhirGUI.txtNom.getText(), MenhirGUI.cbBox.getSelectedIndex() + 2,
							MenhirGUI.getTypeJeu(), MenhirGUI.getNiveau(), jeu.frameGUI);
					x.getTypeJeu().lancer(x);
					break;
				case 1:
					System.exit(0);
					break;
				default:
					break;
				}
				return null;
			}
		};
		worker.execute();
	}
}

class Avancee extends Partie {
	private int[] points = new int[4];
	private Jeu jeu;

	@Override
	public void lancer(final Jeu jeu) {
		final SwingWorker worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				for (int t = 0; t < jeu.nbJoueur; t++) {
					System.out.println("Hello");
					JOptionPane.showMessageDialog(null, "\nCommencer manche " + (t + 1));
					if (t > 0) {
						jeu.setViewGUI(new GuiPrincipal());
						jeu.switchFrame();
					}
					jeu.setPoint0();
					Deck deck = new Deck(jeu);
					System.out.println(deck.getChien());
					System.out.println(deck.getTaupe());

					for (int i = 0; i < 4; i++) {
						DrawCarte x = new DrawCarte(jeu.listjoueur.get(0).listeCarte.get(i).toString());
						jeu.viewGUI.ArrayButton[i].setIcon(x.afficher());
					}
					for (int h = 0; h < jeu.nbJoueur; h++) {
						if (h == 0 && jeu.listjoueur.get(h).getCarteA() != null) {
							DrawCarte a = new DrawCarte(jeu.listjoueur.get(0).getCarteA().toString());
							jeu.viewGUI.lblCarteA[h].setIcon(a.afficher());
						}
						if (jeu.listjoueur.get(h).getCarteA() != null) {
							jeu.viewGUI.lblCarteA[h].setVisible(true);
						}
					}
					for (int k = 0; k < jeu.nbJoueur; k++) {
						System.out.println("Joueur " + k + ": " + jeu.listjoueur.get(k).listeCarte + ", carteAllies: "
								+ jeu.listjoueur.get(k).getCarteA());
					}
					for (int saison = 0; saison < 4; saison++) {
						switch (saison) {
						case 0:
							jeu.viewGUI.getLblsaison().setText("Saison: Printemps");
							break;
						case 1:
							jeu.viewGUI.getLblsaison().setText("Saison: Été");
							break;
						case 2:
							jeu.viewGUI.getLblsaison().setText("Saison: Automne");
							break;
						case 3:
							jeu.viewGUI.getLblsaison().setText("Saison: Hiver");
							break;
						default:
							break;
						}
						for (int s = t; s < t + jeu.nbJoueur; s++) {
							int k = s % jeu.nbJoueur;
							Joueur joueur = jeu.listjoueur.get(k);
							updateView(jeu);
							if (k == 0) {
								jeu.viewGUI.getLbltour().setText("Tour: Joueur " + MenhirGUI.txtNom.getText());
								jeu.viewGUI.getLblaction().setText("Action: ");
								jeu.viewGUI.enableCarte(true);
								while (GuiPrincipal.run != true) {
									Thread.sleep(1000);
								}
								GuiPrincipal.run = false;
								c = joueur.SelectionCarte(jeu.viewGUI.carte);
								action = jeu.viewGUI.action;
								switch (action) {
								case 0://Utiliser l'action Geant
									c.geant(joueur, saison);
									jeu.viewGUI.getLblaction().setText("Action: Geant");
									break;
								case 1://Utiliser l'action Engrais
									c.engrais(joueur, saison);
									jeu.viewGUI.getLblaction().setText("Action: Engrais");
									break;
								case 2://Utiliser l'action Farfadets
									int choice;
									int adversaire = 0;
									switch (jeu.nbJoueur) {
									case 2:
										adversaire = 1;
										break;
									case 3:
										String[] options = { "AI No1", "AI No2" };
										choice = JOptionPane.showOptionDialog(null, "Qui voulez-vous faire farfadets?",
												"Choisir adversaire", JOptionPane.YES_NO_OPTION,
												JOptionPane.INFORMATION_MESSAGE, null, options, "AI No1");
										if (choice == 0) {
											adversaire = 1;
										} else {
											adversaire = 2;
										}
										break;
									case 4:
										String[] options1 = { "AI No1", "AI No2", "AI No3" };
										choice = JOptionPane.showOptionDialog(null, "Qui voulez-vous faire farfadets?",
												"Choisir adversaire", JOptionPane.YES_NO_OPTION,
												JOptionPane.INFORMATION_MESSAGE, null, options1, "AI No1");
										if (choice == 0)
											adversaire = 1;
										else if (choice == 1)
											adversaire = 2;
										else
											adversaire = 3;
										break;
									default:
										break;
									}
									AI ai = (AI) jeu.listjoueur.get(adversaire);
									int nb = jeu.listjoueur.get(k).getNbgrains();
									c.farfadets(joueur, saison, ai);
									jeu.viewGUI.getLblaction().setText("Action: Farfadets AI " + adversaire);
									Thread.sleep(1000);
									/**
									* Demander AI a une carte ChiensDeGarde?
									* Si oui, utiliser le Strategy pour déterminer la nécessité de l'utilisation la carte Chiens de Garde
									*/
									if (ai.getCarteA() instanceof ChiensDeGarde) {
										if (ai.utiliseAllies(ai.getCarteA(), saison)) {
											ChiensDeGarde a = (ChiensDeGarde) ai.getCarteA();
											a.chiensdegarde(ai, jeu.listjoueur.get(k), saison, nb);
											GuiPrincipal.lblalli.setVisible(true);
											GuiPrincipal.lblalli.setText(
													"Joueur AI " + adversaire + " a utilisé carte Chiens de Garde");
											DrawCarte m = new DrawCarte(ai.getCarteA().toString());
											jeu.viewGUI.lblCarteA[adversaire].setIcon(m.afficher());
											switch (adversaire) {
											case 1:
												jeu.viewGUI.lblCarteA[adversaire].setBounds(116, 198, 120, 120);
												break;
											case 2:
												jeu.viewGUI.lblCarteA[adversaire].setBounds(268, 87, 120, 120);
												break;
											case 3:
												jeu.viewGUI.lblCarteA[adversaire].setBounds(0, 87, 120, 120);
												break;
											default:
												break;
											}
											Thread.sleep(1000);
											jeu.viewGUI.lblCarteA[adversaire].setVisible(false);
											ai.setCarteA(null);
										}
									}
									break;
								default:
									break;
								}
							} else {
								Thread.sleep(1000);
								AI ai = (AI) joueur;
								if (jeu.getNiveau().equalsIgnoreCase("Debutant")) {
									ai.setStrategy(new StrategyDebutantAvancee(ai, jeu.listjoueur, saison));
								} else {
									ai.setStrategy(new StrategyMediumAvancee(ai, jeu.listjoueur, saison));
								}
								jeu.viewGUI.getLbltour().setText("Tour: AI " + k);
								switch (ai.getStrategy().getAIAction()) {
								case 0://Utiliser l'action Geant
									jeu.viewGUI.getLblaction().setText("Action: Geant");
									break;
								case 1://Utiliser l'action Engrais
									jeu.viewGUI.getLblaction().setText("Action: Engrais");
									break;
								case 2://Utiliser l'action Farfadets
									if (ai.getStrategy().getJoueurMaxGrains() == 0)
										jeu.viewGUI.getLblaction().setText("Action: Farfadets vous");
									else
										jeu.viewGUI.getLblaction().setText(
												"Action: Farfadets AI " + ai.getStrategy().getJoueurMaxGrains());
									break;
								default:
									break;
								}
								ai.doMission();
								DrawCarte y = new DrawCarte(ai.getCarte().toString());
								switch (k) {
								case 1:
									jeu.viewGUI.ArrayLabel1[3 - saison].setIcon(y.afficher());
									jeu.viewGUI.ArrayLabel1[3 - saison].setBounds(116, 198, 120, 120);
									break;
								case 2:
									jeu.viewGUI.ArrayLabel2[3 - saison].setIcon(y.afficher());
									jeu.viewGUI.ArrayLabel2[3 - saison].setBounds(268, 87, 120, 120);
									break;
								case 3:
									jeu.viewGUI.ArrayLabel3[3 - saison].setIcon(y.afficher());
									jeu.viewGUI.ArrayLabel3[3 - saison].setBounds(0, 87, 120, 120);
									break;
								default:
									break;
								}

							}
							updateView(jeu);
							Thread.sleep(2000);
						}
						Thread.sleep(2000);
						jeu.viewGUI.ArrayButton[jeu.viewGUI.carte].setVisible(false);
						for (int m = 0; m < jeu.nbJoueur - 1; m++) {
							jeu.viewGUI.ArrayLabel[m][3 - saison].setVisible(false);
						}

						// Utiliser carte TaupeGeante
						for (int j = 0; j < jeu.nbJoueur; j++) {
							Joueur jou = jeu.listjoueur.get(j);
							if (j == 0) {
								if (jou.getCarteA() instanceof TaupeGeante) {
									if (jou.utiliseAllies()) {
										int adversaire;
										int choice;
										TaupeGeante a = (TaupeGeante) jou.getCarteA();
										if (jeu.nbJoueur == 2) {
											adversaire = 1;
										} else if (jeu.nbJoueur == 3) {
											String[] options = { "AI No1", "AI No2" };
											choice = JOptionPane.showOptionDialog(null,
													"Qui voulez-vous faire Taupe Geant?", "Choisir adversaire",
													JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
													options, "AI No1");
											adversaire = choice + 1;
										} else {
											String[] options = { "AI No1", "AI No2", "AI No3" };
											choice = JOptionPane.showOptionDialog(null,
													"Qui voulez-vous faire Taupe Geant ?", "Choisir adversaire",
													JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
													options, "AI No1");
											adversaire = choice + 1;
										}
										GuiPrincipal.lblalli.setVisible(true);
										GuiPrincipal.lblalli.setText("Vous avez utilisé carte Taupe Geant");
										a.taupegeante(jeu.listjoueur.get(adversaire), saison);
										jou.setCarteA(null);
										jeu.viewGUI.lblCarteA[0].setVisible(false);
										Thread.sleep(2000);
									}
								}
							} else {
								AI ai = (AI) jou;
								/**
								* Demander AI a une carte Taupe Geante?
								* Si oui, utiliser le Strategy pour déterminer la nécessité de l'utilisation la carte Taupe
								*/
								if (ai.getCarteA() instanceof TaupeGeante) {
									if (ai.utiliseAllies(ai.getCarteA(), saison)) {
										if (jeu.getNiveau().equalsIgnoreCase("Debutant")) {
											ai.setStrategy(new StrategyDebutantAvancee(ai, jeu.listjoueur, saison));// sua
										} else
											ai.setStrategy(new StrategyMediumAvancee(ai, jeu.listjoueur, saison));
										GuiPrincipal.lblalli.setVisible(true);
										GuiPrincipal.lblalli.setText("Joueur AI " + j + " a utilisé carte Taupe Geant");
										DrawCarte m = new DrawCarte(jeu.listjoueur.get(j).getCarteA().toString());
										GuiPrincipal.lblCarteA[j].setIcon(m.afficher());
										switch (j) {
										case 1:
											GuiPrincipal.lblCarteA[j].setBounds(116, 198, 120, 120);
											break;
										case 2:
											GuiPrincipal.lblCarteA[j].setBounds(230, 87, 120, 120);
											break;
										case 3:
											GuiPrincipal.lblCarteA[j].setBounds(0, 87, 120, 120);
											break;
										default:
											break;
										}
										ai.getStrategy().joueTaupeGeante();
										Thread.sleep(2000);
										GuiPrincipal.lblCarteA[j].setVisible(false);
										ai.setCarteA(null);
										updateView(jeu);
										Thread.sleep(1000);
									}
								}
							}
						}
						jeu.viewGUI.getLblalli().setVisible(false);
					}
					jeu.listjoueur.get(0).listeCarte.clear();
					//Calculer les grains final et le menhirs finals après une partie
					for (int l = 0; l < jeu.nbJoueur; l++) {
						jeu.listjoueur.get(l).nbgrainsfinal += jeu.listjoueur.get(l).nbgrains;
						jeu.listjoueur.get(l).nbmenhirsfinal += jeu.listjoueur.get(l).nbmenhirs;
					}
					updateView(jeu);
					Thread.sleep(1000);
				}
				int max = 0;
				//Calculer les points de chacun pour déterminer ce qui gagne
				for (int i = 0; i < jeu.nbJoueur; i++) {
					Joueur joueur = jeu.listjoueur.get(i);
					points[i] = joueur.getNbmenhirsFinal() * 100 + joueur.getNbgrainsFinal();
					if (max < points[i]) {
						max = points[i];
					}
				}
				//Afficher un message pour infomer ce qui gagne
				for (int i = 0; i < jeu.nbJoueur; i++) {
					if (max == points[i]) {
						if (i == 0) {
							JOptionPane.showMessageDialog(null, "vous gagnez");
						} else {
							JOptionPane.showMessageDialog(null, "AI " + i + " gagne");
						}
					}
				}
				//Demander l'utiliser à jouer une nouvelle manche ou non?
				int newgame = JOptionPane.showConfirmDialog(null, "Voulez-vous encore jouer?", "{Encore une fois}",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				switch (newgame) {
				case 0:
					Jeu x = new Jeu(MenhirGUI.txtNom.getText(), MenhirGUI.cbBox.getSelectedIndex() + 2,
							MenhirGUI.getTypeJeu(), MenhirGUI.getNiveau(), jeu.frameGUI);
					x.getTypeJeu().lancer(x);
					break;
				case 1:
					System.exit(0);
					break;
				default:
					break;
				}
				return null;
			}
		};
		worker.execute();
	}
}