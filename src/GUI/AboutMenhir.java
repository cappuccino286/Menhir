package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
/**
* <h1>Jeu de Menhir</h1>
* Frame contenant les informations concernant à les auteurs et la version du jeu
* @author  Sy Hung NGHIEM - Nguyen Quoc Cuong TRAN
* @version 1.0
* @since   Automne 2015
*/
public class AboutMenhir extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public AboutMenhir() {
		setTitle("About");
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/bw.chapardeur.jpg"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 85, 391, 2);
		contentPane.add(separator);
		
		JLabel lblIcon = new JLabel("Icon");
		URL src1=getClass().getResource("/about1.jpg");
		lblIcon.setIcon(drawIcon(src1,40,60));
		lblIcon.setBounds(29, 99, 40, 60);
		contentPane.add(lblIcon);
		
		JLabel lblMenhir = new JLabel();
		lblMenhir.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenhir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMenhir.setText("<html>\r\nVersion 1.0<br><br>\r\nMenhir est un jeu de cartes dont des r\u00E8gles est d\u00E9velopp\u00E9 par l'association Pandocr\u00E9on.<br><br>\r\nVersion \u00E9lectronique du jeu de Menhir d\u00E9velopp\u00E9 par <br>Sy Hung NGHIEM et Nguyen Quoc Cuong TRAN\r\n</html>");
		lblMenhir.setBounds(86, 98, 326, 100);
		contentPane.add(lblMenhir);
		
		JLabel lblPandocreon = new JLabel("Icon");
		lblPandocreon.setBackground(Color.WHITE);
		lblPandocreon.setBounds(176, 4, 75, 75);
		URL src2=getClass().getResource("/about.png");
		lblPandocreon.setIcon(drawIcon(src2,75,75));
		contentPane.add(lblPandocreon);
	}
	static ImageIcon drawIcon(URL src,int wide,int height ){
		Image img = null;
		try {
			img= ImageIO.read(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon= new ImageIcon(img.getScaledInstance(wide,height,Image.SCALE_SMOOTH));
		return icon;
		
	}
}
