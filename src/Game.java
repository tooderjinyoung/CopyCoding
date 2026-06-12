import javax.swing.*;
import java.awt.*;

public class Game extends Thread {
    private Image gameInfo = new ImageIcon(Main.class.getResource(Main.imagesPath + "gameinfo.png")).getImage();
    private Image notebasicImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "notebasic.png")).getImage();
    private Image judgmentLineImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "redbar.png")).getImage();
    private Image notRouteLineImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "hbar.png")).getImage();


    private Image notRouteSImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    private Image notRouteDImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    private Image notRouteFImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    private Image notRouteJImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    private Image notRouteKImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    private Image notRouteLImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    private Image notRouteSpaceImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    private Image notRouteSpaceImage2 = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();


    public void screenDraw(Graphics2D g) {

        g.drawImage(notRouteSImage, 228 ,30, null);
        g.drawImage(notRouteDImage, 332 ,30, null);
        g.drawImage(notRouteFImage, 436 ,30, null);
        g.drawImage(notRouteSpaceImage, 540 ,30, null);
        g.drawImage(notRouteSpaceImage2, 640 ,30, null);
        g.drawImage(notRouteJImage, 744 ,30, null);
        g.drawImage(notRouteKImage, 848 ,30, null);
        g.drawImage(notRouteLImage, 952 ,30, null);
        g.drawImage(notRouteLineImage, 224 ,30, null);
        g.drawImage(notRouteLineImage, 328 ,30, null);
        g.drawImage(notRouteLineImage, 432 ,30, null);
        g.drawImage(notRouteLineImage, 536 ,30, null);
        g.drawImage(notRouteLineImage, 740 ,30, null);
        g.drawImage(notRouteLineImage, 844 ,30, null);
        g.drawImage(notRouteLineImage, 948 ,30, null);
        g.drawImage(notRouteLineImage, 1052 ,30, null);

        g.drawImage(notebasicImage, 228 ,120, null);
        g.drawImage(notebasicImage, 332 ,500, null);
        g.drawImage(notebasicImage, 436 ,500, null);
        g.drawImage(notebasicImage, 540 ,340, null);
        g.drawImage(notebasicImage, 640 ,340, null);
        g.drawImage(notebasicImage, 744 ,305, null);
        g.drawImage(notebasicImage, 848 ,305, null);
        g.drawImage(notebasicImage, 952 ,300, null);
        g.drawImage(gameInfo, 0 ,600, null);
        g.drawImage(judgmentLineImage, 0 ,500, null);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));

        g.setColor(Color.yellow);
        g.drawString("S",270,609);
        g.drawString("D",374,609);
        g.drawString("F",478,609);
        g.drawString("Space Bar",580,609);
        g.drawString("J",784,609);
        g.drawString("J",889,609);
        g.drawString("L",993,609);

        g.setColor(Color.LIGHT_GRAY);
        g.drawString("easy", 1190, 710);
        g.drawString("00000",562,702);}


    public void pressS()
    {
        notRouteSImage  = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Hi-Hat.mp3",false).start();
    }
    public void pressD()
    {
        notRouteDImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Rim.mp3",false).start();

    }
    public void pressF()
    {
         notRouteFImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Snare.mp3",false).start();
    }
    public void pressSpace()
    {
         notRouteSpaceImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
         notRouteSpaceImage2 = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Kick.mp3",false).start();
    }
    public void pressJ()
    {
        notRouteJImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Snare.mp3",false).start();
    }
    public void pressK()
    {
         notRouteKImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Rim.mp3",false).start();
    }
    public void pressL()
    {
         notRouteLImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Hi-Hat.mp3",false).start();
    }


    public void releasS()
    {
         notRouteSImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    }
    public void releasD()
    {
         notRouteDImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    }
    public void releasF()
    {
         notRouteFImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    }
    public void releasSpace()
    {
         notRouteSpaceImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
         notRouteSpaceImage2 = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    }
    public void releasJ()
    {
        notRouteJImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    }
    public void releasK()
    {
         notRouteKImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    }
    public void releasL()
    {
         notRouteLImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "blackbar.png")).getImage();
    }
    @Override
    public void run()
    {


    }

}
