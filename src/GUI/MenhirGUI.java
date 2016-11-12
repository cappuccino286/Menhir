package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Manager.Jeu;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
/**
* <h1>Jeu de Menhir</h1>
* Frame pour que l'utilisateur saisisse les informations du jeu
* @author  Sy Hung NGHIEM - Nguyen Quoc Cuong TRAN
* @version 1.0
* @since   Automne 2015
*/
public class MenhirGUI extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNom;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public static JComboBox cbBox;
	private static String type;
	private static String niveau;
	
	public static String getTypeJeu() {
		return type;
	}
	public static String getNiveau() {
		return niveau;
	}
	public JComboBox getcbBox(){
		return cbBox;
	}
	/**
	 * Create the frame.
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenhirGUI frame1 = new MenhirGUI();
					frame1.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MenhirGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/bw.chapardeur.jpg"));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 22, 355, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Type du jeu");
		lblNewLabel_1.setBounds(10, 105, 95, 31);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		JLabel lblNiveau = new JLabel("Niveau");
		lblNiveau.setBounds(10, 154, 95, 31);
		panel.add(lblNiveau);
		lblNiveau.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 11, 95, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		txtNom = new JTextField();
		txtNom.setName("");
		txtNom.setBounds(123, 16, 198, 24);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		JRadioButton rdRapide = new JRadioButton("Rapide");
		buttonGroup.add(rdRapide);
		rdRapide.setSelected(true);
		rdRapide.setBounds(123, 105, 84, 31);
		panel.add(rdRapide);
		
		JRadioButton rdAvance = new JRadioButton("Avanc\u00E9e");
		buttonGroup.add(rdAvance);
		rdAvance.setBounds(227, 105, 74, 31);
		panel.add(rdAvance);
		
		JRadioButton rdDebutant = new JRadioButton("Debutant");
		buttonGroup_1.add(rdDebutant);
		rdDebutant.setSelected(true);
		rdDebutant.setBounds(123, 154, 84, 31);
		panel.add(rdDebutant);
		
		JRadioButton rdMedium = new JRadioButton("Medium");
		buttonGroup_1.add(rdMedium);
		rdMedium.setBounds(227, 154, 74, 31);
		panel.add(rdMedium);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre AI");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 59, 95, 31);
		panel.add(lblNewLabel_2);
		
		cbBox = new JComboBox();
		cbBox.setModel(new DefaultComboBoxModel(new String[] {"1","2","3"}));
		cbBox.setBounds(124, 63, 80, 23);
		panel.add(cbBox);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				if(rdRapide.isSelected()){
					type=rdRapide.getText();
				} else {
					type=rdAvance.getText();
				}
				if(rdDebutant.isSelected()){
					niveau=rdDebutant.getText();
				} else {
					niveau=rdMedium.getText();
				}
				FramePrincipal frame = new FramePrincipal();
				frame.setVisible(true);
				Jeu jeu = new Jeu(txtNom.getText(),cbBox.getSelectedIndex()+2,type,niveau,frame);    	
				jeu.getTypeJeu().lancer(jeu);
			}
		});
		btnOK.setFont(new Font("Arial", Font.PLAIN, 14));
		btnOK.setBounds(88, 227, 99, 27);
		contentPane.add(btnOK);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdRapide.setSelected(true);
				rdDebutant.setSelected(true);
				txtNom.setText("");
				txtNom.requestFocus();
				cbBox.setSelectedIndex(0);
			}
		});
		btnReset.setFont(new Font("Arial", Font.PLAIN, 14));
		btnReset.setBounds(217, 227, 99, 27);
		contentPane.add(btnReset);
	}
}
