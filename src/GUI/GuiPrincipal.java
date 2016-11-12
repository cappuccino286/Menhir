package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
* <h1>Jeu de Menhir</h1>
* Panel pour utiliser dans le Frame principal
* Repeindre après chaque partie
* @author  Sy Hung NGHIEM - Nguyen Quoc Cuong TRAN
* @version 1.0
* @since   Automne 2015
*/

public class GuiPrincipal extends JPanel {
	public JPanel panelNo1 = new JPanel();
	public JPanel panelNo2 = new JPanel();
	public JPanel panelNo3 = new JPanel();
	JButton btnIcon1= new JButton();
	JButton btnIcon2= new JButton();
	JButton btnIcon3= new JButton();
	JButton btnIcon4= new JButton();
	public JButton[] ArrayButton ={btnIcon1,btnIcon2,btnIcon3,btnIcon4};
	JLabel lblIcon5 = new JLabel();
	JLabel lblIcon6 = new JLabel();
	JLabel lblIcon7 = new JLabel();
	JLabel lblIcon8 = new JLabel();
	public JLabel[] ArrayLabel1={lblIcon5,lblIcon6,lblIcon7,lblIcon8};
	JLabel lblIcon9 = new JLabel();
	JLabel lblIcon10 = new JLabel();
	JLabel lblIcon11 = new JLabel();
	JLabel lblIcon12 = new JLabel();
	public JLabel[] ArrayLabel2={lblIcon9,lblIcon10,lblIcon11,lblIcon12};
	JLabel lblIcon13 = new JLabel();
	JLabel lblIcon14 = new JLabel();
	JLabel lblIcon15 = new JLabel();
	JLabel lblIcon16 = new JLabel();
	public JLabel[] ArrayLabel3={lblIcon13,lblIcon14,lblIcon15,lblIcon16};
	public JLabel[][] ArrayLabel={ArrayLabel1,ArrayLabel2,ArrayLabel3};
	private JLabel lblsaison;
	private JLabel lbltour;
	private JLabel lblaction;
	private static JLabel lblCarteAJoueur = new JLabel();
	private static JLabel lblCarteAAI1 = new JLabel();
	private static JLabel lblCarteAAI2 = new JLabel();
	private static JLabel lblCarteAAI3 = new JLabel();
	public static JLabel[] lblCarteA={lblCarteAJoueur,lblCarteAAI1,lblCarteAAI2,lblCarteAAI3};
	public static JLabel lblalli;
	JLabel lblJoueur;
	JLabel lblAI1;
	JLabel lblAI2;
	JLabel lblAI3;
	public JLabel getLblJoueur() {
		return lblJoueur;
	}

	public void setLblJoueur(JLabel lblJoueur) {
		this.lblJoueur = lblJoueur;
	}
	public JLabel getLblsaison() {
		return lblsaison;
	}
	public JLabel getLblalli() {
		return lblalli;
	}
	public JLabel getLbltour() {
		return lbltour;
	}
	public JLabel getLblaction() {
		return lblaction;
	}
	public JLabel getLblAI1() {
		return lblAI1;
	}

	public void setLblAI1(JLabel lblAI1) {
		this.lblAI1 = lblAI1;
	}

	public JLabel getLblAI2() {
		return lblAI2;
	}

	public void setLblAI2(JLabel lblAI2) {
		this.lblAI2 = lblAI2;
	}

	public JLabel getLblAI3() {
		return lblAI3;
	}

	public void setLblAI3(JLabel lblAI3) {
		this.lblAI3 = lblAI3;
	}

	JButton btnGeants;
	JButton btnEngrais;
	JButton btnFarfadets;

	public void enableAction(boolean b){
		btnGeants.setEnabled(b);
		btnEngrais.setEnabled(b);
		btnFarfadets.setEnabled(b);
	}
	public void enableCarte(boolean b){
		btnIcon1.setEnabled(b);
		btnIcon2.setEnabled(b);
		btnIcon3.setEnabled(b);
		btnIcon4.setEnabled(b);	
	}
	public static int action=-1;
	public static int carte=-1;
	public static boolean run = false;
	public final JLabel lblFinalJoueur = new JLabel("Joueur:");
	public final JLabel lblFinalAI1 = new JLabel("AI 1:");
	public final JLabel lblFinalAI2 = new JLabel("AI 2:");
	public final JLabel lblFinalAI3 = new JLabel("AI 3:");
	public JPanel panelFinal = new JPanel();
	private final JLabel lblFinal = new JLabel("Points final du manche");
	/**
	 * Create the frame.
	 */
	public GuiPrincipal() {
		setBackground(new Color(0, 128, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		int a=120;
		Image imgx =null;
		URL srcx=getClass().getResource("/x.jpg");
		try {
			imgx= ImageIO.read(srcx);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconx= new ImageIcon(imgx.getScaledInstance(a,a,Image.SCALE_SMOOTH));
		Image imga =null;
		URL srca=getClass().getResource("/a.jpg");
		try {
			imga= ImageIO.read(srca);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icona= new ImageIcon(imga.getScaledInstance(a,a,Image.SCALE_SMOOTH));
		
		btnGeants = new JButton("Geants");
		btnGeants.setBounds(159, 511, 102, 31);
		btnGeants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action=0;
				enableAction(false);
				run = true;
			}
		});
		setLayout(null);
		this.add(btnGeants);
		btnGeants.setEnabled(false);
		
		btnEngrais = new JButton("Engrais");
		btnEngrais.setBounds(159, 553, 102, 31);
		btnEngrais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action=1;
				enableAction(false);
				run = true;
			}
		});
		this.add(btnEngrais);
		btnEngrais.setEnabled(false);
		
		btnFarfadets = new JButton("Farfadets");
		btnFarfadets.setBounds(159, 596, 102, 31);
		btnFarfadets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action=2;
				enableAction(false);
				run = true;
			}
		});
		this.add(btnFarfadets);
		btnFarfadets.setEnabled(false);
		btnIcon1.setBounds(303, 511, 120, 120);
//4 buttons cartes de joueur

		btnIcon1.setMargin(new Insets(0, 0, 0, 0));
		this.add(btnIcon1);
		btnIcon1.setIcon(iconx);
		btnIcon1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIcon1.setBounds(548, 356, 120, 120);
				enableAction(true);
				enableCarte(false);
				btnIcon1.setEnabled(true);
				carte=0;
			}
		});
		btnIcon2.setBounds(433, 511, 120, 120);
		
		btnIcon2.setMargin(new Insets(0, 0, 0, 0));
		this.add(btnIcon2);
		btnIcon2.setIcon(iconx);
		
		btnIcon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIcon2.setBounds(548, 356, 120, 120);
				enableAction(true);
				enableCarte(false);
				btnIcon2.setEnabled(true);
				carte=1;
			}
		});
		btnIcon3.setBounds(563, 511, 120, 120);
		btnIcon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIcon3.setBounds(548, 356, 120, 120);
				enableAction(true);
				enableCarte(false);
				btnIcon3.setEnabled(true);
				carte=2;
			}
		});
		btnIcon3.setMargin(new Insets(0, 0, 0, 0));
		this.add(btnIcon3);
		btnIcon3.setIcon(iconx);
		btnIcon4.setBounds(693, 511, 120, 120);
		
		btnIcon4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIcon4.setBounds(548, 356, 120, 120);
				enableAction(true);
				enableCarte(false);
				btnIcon4.setEnabled(true);
				carte=3;
			}
		});
		btnIcon4.setMargin(new Insets(0, 0, 0, 0));
		this.add(btnIcon4);
		btnIcon4.setIcon(iconx);
		
		lblJoueur = new JLabel("Joueur: "+MenhirGUI.txtNom.getText());
		lblJoueur.setBounds(435, 474, 519, 31);
		lblJoueur.setForeground(Color.WHITE);
		lblJoueur.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblJoueur);
		lblCarteAJoueur.setBounds(823, 511, 120, 120);
		this.add(lblCarteAJoueur);
		lblCarteAJoueur.setVisible(false);
		panelNo1.setBounds(433, 11, 325, 318);
		
		panelNo1.setBackground(new Color(0, 128, 0));
		this.add(panelNo1);
		panelNo1.setLayout(null);
//des cartes de AIs		
		lblIcon5.setBounds(0, 0, 120, 120);
		panelNo1.add(lblIcon5);
		lblIcon5.setIcon(iconx);
		
		lblIcon6.setBounds(50, 0, 120, 120);
		panelNo1.add(lblIcon6);
		lblIcon6.setIcon(iconx);
		
		lblIcon7.setBounds(100, 0, 120, 120);
		panelNo1.add(lblIcon7);
		lblIcon7.setIcon(iconx);
		
		lblIcon8.setBounds(150, 0, 120, 120);
		panelNo1.add(lblIcon8);
		lblIcon8.setIcon(iconx);
		

		lblCarteAAI1.setBounds(200, 0, 120, 120);
		lblCarteAAI1.setIcon(icona);
		lblCarteAAI1.setVisible(false);
		panelNo1.add(lblCarteAAI1);
		
		lblAI1 = new JLabel("AI: No1");
		lblAI1.setForeground(Color.WHITE);
		lblAI1.setBounds(0, 149, 237, 31);
		panelNo1.add(lblAI1);
		lblAI1.setFont(new Font("Arial", Font.BOLD, 14));
		panelNo2.setBounds(20, 183, 389, 290);
		
		panelNo2.setBackground(new Color(0, 128, 0));
		this.add(panelNo2);
		panelNo2.setLayout(null);
	
		lblIcon9.setBounds(0, 0, 120, 120);
		panelNo2.add(lblIcon9);
		lblIcon9.setIcon(iconx);
		
		lblIcon10.setBounds(0, 42, 120, 120);
		panelNo2.add(lblIcon10);
		lblIcon10.setIcon(iconx);

		lblIcon11.setBounds(0, 84, 120, 120);
		panelNo2.add(lblIcon11);
		lblIcon11.setIcon(iconx);
		
		lblIcon12.setBounds(0, 126, 120, 120);
		panelNo2.add(lblIcon12);
		lblIcon12.setIcon(iconx);
		
		lblAI2 = new JLabel("AI: No2");
		lblAI2.setHorizontalAlignment(SwingConstants.LEFT);
		lblAI2.setForeground(Color.WHITE);
		lblAI2.setVerticalAlignment(SwingConstants.TOP);
		lblAI2.setBounds(130, 98, 89, 65);
		panelNo2.add(lblAI2);
		lblAI2.setFont(new Font("Arial", Font.BOLD, 14));
		lblCarteAAI2.setBounds(0, 168, 120, 120);
		lblCarteAAI2.setIcon(icona);
		lblCarteAAI2.setVisible(false);
		panelNo2.add(lblCarteAAI2);
		panelNo3.setBounds(818, 183, 356, 290);
		
		panelNo3.setBackground(new Color(0, 128, 0));
		this.add(panelNo3);
		panelNo3.setLayout(null);

		lblIcon13.setBounds(236, 0, 120, 120);
		panelNo3.add(lblIcon13);
		lblIcon13.setIcon(iconx);

		lblIcon14.setBounds(236, 42, 120, 120);
		panelNo3.add(lblIcon14);
		lblIcon14.setIcon(iconx);

		lblIcon15.setBounds(236, 84, 120, 120);
		panelNo3.add(lblIcon15);
		lblIcon15.setIcon(iconx);

		lblIcon16.setBounds(236, 126, 120, 120);
		panelNo3.add(lblIcon16);
		lblIcon16.setIcon(iconx);
		
		lblAI3 = new JLabel("AI: No3");
		lblAI3.setVerticalAlignment(SwingConstants.TOP);
		lblAI3.setForeground(Color.WHITE);
		lblAI3.setBounds(145, 98, 85, 74);
		panelNo3.add(lblAI3);
		lblAI3.setFont(new Font("Arial", Font.BOLD, 14));
		lblCarteAAI3.setBounds(236, 163, 120, 120);
		lblCarteAAI3.setIcon(icona);
		lblCarteAAI3.setVisible(false);
		panelNo3.add(lblCarteAAI3);
		panelFinal.setBounds(0, 638, 1200, 33);
		add(panelFinal);
		panelFinal.setLayout(null);
		
		lblFinalJoueur.setBounds(150, 0, 200, 30);
		panelFinal.add(lblFinalJoueur);
		lblFinalAI1.setBounds(400, 0, 200, 30);
		panelFinal.add(lblFinalAI1);
		lblFinalAI2.setBounds(650, 0, 200, 30);
		panelFinal.add(lblFinalAI2);
		lblFinalAI3.setBounds(900, 1, 200, 29);
		panelFinal.add(lblFinalAI3);
		lblFinal.setBounds(0, 0, 140, 30);
		
		panelFinal.add(lblFinal);
		
		lblsaison = new JLabel("");
		lblsaison.setFont(new Font("Arial", Font.BOLD, 13));
		lblsaison.setForeground(Color.WHITE);
		lblsaison.setBounds(32, 11, 207, 38);
		add(lblsaison);
		
		lblalli = new JLabel("");
		lblalli.setForeground(Color.WHITE);
		lblalli.setFont(new Font("Arial", Font.BOLD, 13));
		lblalli.setBounds(31, 98, 281, 44);
		add(lblalli);
		lblalli.setVisible(false);
		
		lbltour = new JLabel("");
		lbltour.setFont(new Font("Arial", Font.BOLD, 13));
		lbltour.setForeground(Color.WHITE);
		lbltour.setBounds(32, 52, 134, 33);
		add(lbltour);
		lblaction = new JLabel("");
		lblaction.setFont(new Font("Arial", Font.BOLD, 13));
		lblaction.setForeground(Color.WHITE);
		lblaction.setBounds(176, 52, 221, 31);
		add(lblaction);
	}
}
