package site.laoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Img {

	public static void drawTextInImg(String filePath,String outPath) {
        ImageIcon imgIcon = new ImageIcon(filePath);
        Image img = imgIcon.getImage();
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bimage.createGraphics();
        g.setColor(getColor("#ffffff"));
        g.setBackground(Color.white);
        g.drawImage(img, 0, 0, null);
        Font font = new Font("6", Font.BOLD,180);
        g.setFont(font);
        g.drawString("6", 89, 200);

        g.setColor(getColor("#1E3869"));
        font = new Font("", Font.BOLD,100);
        g.setFont(font);
        g.drawString("Dec.2018", 230, 200);

        g.setColor(getColor("#ffffff"));
        font = new Font("", Font.BOLD,180);
        g.setFont(font);
        g.drawString("_", 89, 240);

        font = new Font("", Font.BOLD,120);
        g.setFont(font);
        g.drawString("第一次打卡成功", 89, 500);

        font = new Font("", Font.BOLD,80);
        g.setFont(font);
        g.drawString("英语阅读10天", 89, 680);
        
        String eng = "The important thing in life is to have a";
        String eng1 = "great aim，and the determination to ";
        String eng2 = "attain it。";
        g.setColor(getColor("#000000"));
        font = new Font("", Font.PLAIN,60);
        g.setFont(font);
        g.drawString(eng, 89, 1120);
        g.drawString(eng1, 89, 1190);
        g.drawString(eng2, 89, 1260);
        
        String che = "人生最重要的是树立一个远大目标，并";
        String che2 = "下定决心去实现。";
        g.setColor(getColor("#808080"));
        font = new Font("", Font.PLAIN,60);
        g.setFont(font);
        g.drawString(che, 89, 1400);
        g.drawString(che2, 89, 1470);
        
        BufferedImage imageCode = null;
        
        try {
			imageCode = ImageIO.read(new File("G://head.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        g.drawImage(imageCode, 89, 1650, 200, 200, null);
        
        String name = "陈洪波";
        g.setColor(getColor("#000000"));
        font = new Font("", Font.PLAIN,70);
        g.setFont(font);
        g.drawString(name, 320, 1730);
        
        String label = "长按关注三立阅读";
        g.setColor(getColor("#888888"));
        font = new Font("", Font.PLAIN,50);
        g.setFont(font);
        g.drawString(label, 320, 1830);
        
        try {
			imageCode = ImageIO.read(new File("G://mini.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        g.drawImage(imageCode, 900, 1650, 200, 200, null);
        
        g.dispose();

        try {
            FileOutputStream out = new FileOutputStream(outPath);
            ImageIO.write(bimage, "PNG", out);
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // color #2395439
    public static Color getColor(String color) {
        if (color.charAt(0) == '#') {
            color = color.substring(1);
        }
        if (color.length() != 6) {
            return null;
        }
        try {
            int r = Integer.parseInt(color.substring(0, 2), 16);
            int g = Integer.parseInt(color.substring(2, 4), 16);
            int b = Integer.parseInt(color.substring(4), 16);
            return new Color(r, g, b);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "/opt/apache-tomcat-9.0.12-8082/webapps/sign.png";
        String outPath = "./";
        drawTextInImg(filePath, outPath);
	}

}
