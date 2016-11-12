package GUI;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * Peindre les cartes utilisés
*/
public class DrawCarte {
	private String subName;
	public DrawCarte(String nameCarte){
		subName=nameCarte.substring(5);
	}
	public ImageIcon afficher(){
		int a=120;
		Image img1 = null;
		URL src=getClass().getResource("/"+subName+".png");
		try {
			img1= ImageIO.read(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon1= new ImageIcon(img1.getScaledInstance(a,a,Image.SCALE_SMOOTH));
		return icon1;
	}
}
