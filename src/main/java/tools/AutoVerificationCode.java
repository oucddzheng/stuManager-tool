package tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;



public class AutoVerificationCode {
	
	private  final long serialVersionUID = 1L;
    private  Random    r             = new Random();
    private  char[]    chs           = "0123456789".toCharArray();
    private  final int NUMBER_OF_CHS = 4;
    private  final int IMG_WIDTH     = 75;
    private  final int IMG_HEIGHT    = 25;  
	
    private   BufferedImage image;
    private   String  autoCode;    
    
   public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getAutoCode() {
		return autoCode;
	}

	public void setAutoCode(String autoCode) {
		this.autoCode = autoCode;
	}

public AutoVerificationCode() {	   
	   image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB); 
       Graphics2D g = (Graphics2D) image.getGraphics();
       Color c = new Color(200, 200, 255); 
       g.setColor(c);
       g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT); 
       g.setFont(new Font("Arial Black", Font.PLAIN, 15));

       StringBuffer sb = new StringBuffer(); 
       int index; 
       for (int i = 0; i < NUMBER_OF_CHS; i++) {
           index = r.nextInt(chs.length); 
           g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));
           g.drawString(chs[index] + "", 15 * i + 3, 18); 
           sb.append(chs[index]); 
       }
       autoCode = sb.toString();
		
	}
}
