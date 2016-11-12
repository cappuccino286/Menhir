package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JTextPane;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;
import java.awt.Toolkit;
/**
* <h1>Jeu de Menhir</h1>
* Frame contenant la règle du jeu de Menhir 
* @author  Sy Hung NGHIEM - Nguyen Quoc Cuong TRAN
* @version 1.0
* @since   Automne 2015
*/
public class HelpMenhir extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HelpMenhir() {
		setTitle("Help");
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/bw.chapardeur.jpg"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 100, 791, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setFocusTraversalKeysEnabled(false);
		scrollPane.setFocusable(false);
		scrollPane.setBounds(0, 0, 775, 427);
		contentPane.add(scrollPane);

		JTextPane txtHelp = new JTextPane();
		int caretPosition = txtHelp.getCaretPosition();
		txtHelp.setEditable(false);
		txtHelp.setContentType("text/html");
		txtHelp.setText("<h1 style=\"color:blue\">R\u00E8gles rapides</h1>\r\nPrenez uniquement les cartes avec le G\u00E9ant au verso.<br>\r\nLe but du jeu est de faire pousser plus de menhirs que les adversaires. En cas d'\u00E9galit\u00E9, le nombre de graines restantes sert \u00E0 d\u00E9partager les joueurs. Les \u00E9galit\u00E9s compl\u00E8tes (autant de menhirs et de graines) sont possibles.<br>\r\nChaque joueur place devant lui un Champ (carte verte), et pose \u00E0 c\u00F4t\u00E9 2 graines (petits cailloux). Distribuez 4 cartes Ingr\u00E9dient par joueur.<br>\r\n\u00C0 savoir : un caillou pos\u00E9 \u00E0 c\u00F4t\u00E9 d'un Champ repr\u00E9sente une graine de menhir, alors qu'un caillou pos\u00E9 sur le Champ est un menhir adulte.<br>\r\nUne partie se d\u00E9roule en 4 tours de jeu (printemps, \u00E9t\u00E9, automne, hiver). La plus jeune joueuse commence la partie. \u00C0 tour de r\u00F4le, les joueurs posent une carte et choisissent l'action \u00E0 effectuer parmi les trois possibles.<br>\r\nLa \"force\" d'une action d\u00E9pend de la carte jou\u00E9e, de la saison en cours et de l'action choisie.<br>\r\n<h3><i>G\u00E9ant Gardien de la Montagne</i></h3>\r\nEn offrant un ingr\u00E9dient au G\u00E9ant, vous r\u00E9cup\u00E9rez des graines en \u00E9change. Prenez dans le pot commun le nombre de cailloux indiqu\u00E9 sur la carte, et placez-les \u00E0 c\u00F4t\u00E9 de votre Champ.<br>\r\n<h3><i>Engrais Magique</i></h3>\r\nConfectionner de l'Engrais vous permet de faire pousser vos graines. Vous prenez le nombre indiqu\u00E9 de graines en votre possession et les placez sur votre Champ ; ce sont maintenant des menhirs adultes. Si vous avez moins de graines que la valeur de la carte,\r\nl'exc\u00E9dent est perdu<br>\r\n<h3><i>Farfadets Chapardeurs</i></h3>\r\nEn soudoyant les Farfadets, vous volez les graines d'un autre joueur, pour les ajouter aux v\u00F4tres. Vous ne pouvez pas voler les menhirs qui ont d\u00E9j\u00E0 pouss\u00E9. Si le joueur que vous chapardez poss\u00E8de moins de graines que la valeur de la carte, vous lui prenez toutes ses graines, et l'exc\u00E9dent est perdu. Un chapardage se fait sur un seul joueur \u00E0 la fois ; il n'est pas possible de le r\u00E9partir sur plusieurs adversaires.<br>\r\n\r\n<h1 style=\"color:blue\">R\u00E8gles avanc\u00E9es</h1>\r\nCes r\u00E8gles utilisent toutes les cartes du jeu, celles avec le G\u00E9ant et celles avec le Farfadet au verso. Une partie est constitu\u00E9e de plusieurs manches ; il y a autant de manches que de joueurs. Chaque manche se joue comme une partie rapide : les joueurs re\u00E7oivent 4 cartes Ingr\u00E9dient, et la manche se d\u00E9roule en 4 tours correspondant aux saisons de l'ann\u00E9e. Le premier joueur doit \u00EAtre diff\u00E9rent \u00E0 chaque manche. Le but du jeu a chang\u00E9 : il faut maintenant \u00EAtre le joueur dont le total de menhirs pouss\u00E9s est le plus grand \u00E0 la fin de toutes les manches de la partie (voir le comptage des points).<br>\r\nLes nouvelles cartes sont de 2 types :<br>\r\n- Les cartes de comptage de points, qui sont comme des Champs avec des nombres port\u00E9s dessus.<br>\r\n- Les cartes d'alli\u00E9s : les Taupes G\u00E9antes et les Chiens de Garde.<br>\r\n<h3><i>Comptage des points</i></h3>\r\nTous les joueurs prennent une carte de comptage de points, et la posent pr\u00E8s de leur Champ. \u00C0 la fin de chaque manche, les joueurs ajoutent le nombre de menhirs qu'ils ont fait pousser au total de ceux qu'ils ont fait pousser pendant les manches pr\u00E9c\u00E9dentes. Pour mat\u00E9rialiser cela, les joueurs prennent chacun un caillou qu'il font avancer sur les\r\nnombres inscrits sur la carte de comptage.<br>\r\n\u00C0 la fin de la partie, quand toutes les manches ont \u00E9t\u00E9 jou\u00E9es, le joueur ayant cumul\u00E9 le plus de points est le gagnant.<br>\r\n<h3><i>Alli\u00E9s</h3></i>\r\nAu d\u00E9but de chaque manche, les joueurs choisissent : soit de prendre 2 graines (comme pour les parties rapides), soit de piocher une carte Alli\u00E9s. Ces cartes ont des capacit\u00E9s sp\u00E9ciales, dont la \"force\" d\u00E9pend de la saison en cours. Elles sont jou\u00E9es en plus des 4\r\ncartes habituelles, mais si une carte n'est pas jou\u00E9e pendant la manche, elle est perdue et il faut la rendre. <br>\r\n<h3><i>Taupes G\u00E9antes</i></h3>\r\nQuand vous envoyez des Taupes G\u00E9antes chez un adversaire, elles d\u00E9truisent un certain nombre de menhirs adultes.<br>\r\nEn fonction de la saison en cours, vous retirez le nombre de cailloux indiqu\u00E9 sur la carte ; vous prenez les cailloux sur le champ de l'adversaire et les remettez dans le pot commun. Les Taupes G\u00E9antes peuvent \u00EAtre utilis\u00E9es contre les menhirs qui ont d\u00E9j\u00E0 pouss\u00E9\r\nuniquement, et pas contre les graines de menhir. Vous pouvez les utiliser m\u00EAme pendant le tour de jeu des autres joueurs.<br>\r\n<h3><i>Chiens De Garde</i></h3>\r\nLes Chiens de Garde permettent de prot\u00E9ger vos graines de menhir contre les Farfadets Chapardeurs.<br>\r\nExemple : Un adversaire envoit ses Farfadets pour vous voler 4 graines ; si votre carte Chiens de Garde vous permet de prot\u00E9ger 3 graines en cette saison, une seule graine vous sera d\u00E9rob\u00E9e.<br>\r\nLes Chiens de Garde ne prot\u00E8gent que contre les Farfadets Chapardeurs. Il ne peuvent pas emp\u00EAcher les Taupes G\u00E9antes de d\u00E9truire vos menhirs.<br>\r\n<h3>Exemple points:</h3><br>\r\n\r\n");
		txtHelp.insertIcon(AboutMenhir.drawIcon(getClass().getResource("/ex.jpg"), 200, 100));
		txtHelp.setCaretPosition(caretPosition);
		scrollPane.setViewportView(txtHelp);
	}
}
