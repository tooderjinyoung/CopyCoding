import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread {
    private Image gameInfo = new ImageIcon(Main.class.getResource(Main.imagesPath + "gameinfo.png")).getImage();

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

    private String titlename;
    private String difficulty;
    private String musictitle;
    private Music gamemusic;

    ArrayList<Note> noteList = new ArrayList<>();


    public Game(String titlename, String difficulty,String musicTitle)
    {
        this.titlename = titlename;
        this.difficulty = difficulty;
        this.musictitle =musicTitle;
        gamemusic = new Music(this.musictitle,false);
        gamemusic.start();
        dropNotes(titlename);


    }


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
        g.drawImage(gameInfo, 0 ,600, null);
        g.drawImage(judgmentLineImage, 0 ,500, null);

        for(int i=0;i<noteList.size();i++)
        {
            Note n = noteList.get(i);
            n.SceenDraw(g);
        }

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));

        g.setColor(Color.yellow);
        g.drawString("S",270,609);
        g.drawString("D",374,609);
        g.drawString("F",478,609);
        g.drawString("Space Bar",580,609);
        g.drawString("J",784,609);
        g.drawString("K",889,609);
        g.drawString("L",993,609);

        g.setColor(Color.LIGHT_GRAY);
        g.drawString(difficulty, 1190, 710);
        g.drawString("00000",562,702);
        g.drawString(titlename,20,702);
    }


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
    public void close()
    {
        gamemusic.close();

        this.interrupt(); //쓰레드 종료
    }
    public void dropNotes(String titlename)
    {
        Note note = new Note(228,"short");
        note.start();
        noteList.add(note);
    }
}
