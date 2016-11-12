package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Label;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
* <h1>Jeu de Menhir</h1>
* Frame principal pour jouer
* @author  Sy Hung NGHIEM - Nguyen Quoc Cuong TRAN
* @version 1.0
* @since   Automne 2015
*/
public class FramePrincipal extends JFrame {
	public FramePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/bw.chapardeur.jpg"));
        setTitle("Menhir");
        setBounds(100, 0, 1200, 730);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu game = new JMenu("Game");
        game.setMnemonic(KeyEvent.VK_G);
        menuBar.add(game);
        
        JMenuItem mnNew = new JMenuItem("New Game");
        mnNew.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		MenhirGUI frame1 = new MenhirGUI();
				frame1.setVisible(true);
        	}
        });
        mnNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        mnNew.setMnemonic(KeyEvent.VK_F2);
        game.add(mnNew);
        mnNew.setMnemonic(KeyEvent.VK_F5);
        
        JMenuItem mnExit = new JMenuItem("Exit");
        mnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
        mnNew.setMnemonic(KeyEvent.VK_E);
        game.add(mnExit);
        
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        menuBar.add(help);
        
        JMenuItem mnHelp = new JMenuItem("View Help");
        mnHelp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HelpMenhir help= new HelpMenhir();
        		help.setVisible(true);
        	}
        });
        mnHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        mnHelp.setMnemonic(KeyEvent.VK_F1);
        help.add(mnHelp);
        
        JMenuItem mnAbout = new JMenuItem("About Menhir");
        mnAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
        mnAbout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AboutMenhir about=new AboutMenhir();
        		about.setVisible(true);
        	}
        });
        help.add(mnAbout);
        setVisible(true);
	}
}
