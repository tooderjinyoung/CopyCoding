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
    private Image blueFlareImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "flare.png")).getImage();
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
        g.drawImage(judgmentLineImage, 0 ,580, null);

        for(int i=0;i<noteList.size();i++)
        {
            Note n = noteList.get(i);
            if(!n.isProceeded())
            {
                noteList.remove(i);
                i--;

            }
            else{
                n.SceenDraw(g);
            }
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
        g.drawImage(blueFlareImage, 320 ,370, null);
    }


    public void pressS()
    {
        judge("S");
        notRouteSImage  = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Hi-Hat.mp3",false).start();

    }
    public void pressD()
    {
        judge("D");
        notRouteDImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Rim.mp3",false).start();


    }
    public void pressF()
    {
        judge("F");
         notRouteFImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Snare.mp3",false).start();

    }
    public void pressSpace()
    {
        judge("Space");
         notRouteSpaceImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
         notRouteSpaceImage2 = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Kick.mp3",false).start();

    }
    public void pressJ()
    {
        judge("J");
        notRouteJImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Snare.mp3",false).start();

    }
    public void pressK()
    {
        judge("K");
         notRouteKImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "bluebar.png")).getImage();
        new Music("Rim.mp3",false).start();

    }
    public void pressL()
    {
        judge("L");
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
        dropNotes(this.titlename);
    }
    public void close()
    {
        gamemusic.close();

        this.interrupt(); //쓰레드 종료
    }
    public void dropNotes(String titlename) {
        Beat[] beats = null;
        int gap =125;
        if (titlename.equals(("moodmode")) && difficulty.equals("easy")) {

            int startTIme =1000-Main.REACH_TIME*1000;
            beats = new Beat[]{


                    new Beat(1000, "Space"), // 실제 2.0초 타격 (첫 시작 포인트)
                    new Beat(3000, "J"),
                    new Beat(5000, "F"),
                    new Beat(7000, "Space"),
                    new Beat(9000, "D"),
                    new Beat(11000, "K"),
                    new Beat(13000, "S"),
                    new Beat(15000, "L"),
                    new Beat(17000, "Space"),
                    new Beat(19000, "F"),


                    new Beat(21000, "D"),
                    new Beat(22000, "F"),
                    new Beat(23500, "J"), // 엇박자
                    new Beat(25000, "K"),
                    new Beat(27000, "Space"),
                    new Beat(29000, "S"),
                    new Beat(31000, "L"),
                    new Beat(32500, "K"), // 엇박자
                    new Beat(34000, "J"),
                    new Beat(36000, "Space"),


                    new Beat(40000, "S"),
                    new Beat(40500, "D"),
                    new Beat(41000, "F"),
                    new Beat(42000, "J"),
                    new Beat(42500, "K"),
                    new Beat(43000, "L"),
                    new Beat(45000, "Space"),
                    new Beat(47000, "F"),
                    new Beat(49000, "J"),
                    new Beat(51000, "D"),
                    new Beat(55000, "K"),
                    new Beat(58000, "Space"),


                    new Beat(61000, "S"),
                    new Beat(61500, "D"),
                    new Beat(62000, "F"),
                    new Beat(62500, "J"), // 계단식 노트
                    new Beat(63000, "K"),
                    new Beat(63500, "L"),
                    new Beat(65000, "Space"),
                    new Beat(67000, "F"),
                    new Beat(67000, "J"), // 양손 동시 치기
                    new Beat(70000, "D"),
                    new Beat(70000, "K"),


                    new Beat(75000, "F"),
                    new Beat(75750, "D"),
                    new Beat(77000, "J"),
                    new Beat(77750, "K"),
                    new Beat(80000, "Space"),
                    new Beat(85000, "S"),
                    new Beat(88000, "L"),
                    new Beat(90000, "Space"),
                    new Beat(95000, "F"),
                    new Beat(95000, "J"),

                    new Beat(101000, "S"),
                    new Beat(101500, "D"),
                    new Beat(102000, "F"),
                    new Beat(103000, "J"),
                    new Beat(103500, "K"),
                    new Beat(104000, "L"),
                    new Beat(105000, "Space"),
                    new Beat(107000, "S"),
                    new Beat(107000, "L"), // 양쪽 끝 동시 타격
                    new Beat(109000, "D"),
                    new Beat(109000, "K"),
                    new Beat(111000, "F"),
                    new Beat(111000, "J"),
                    new Beat(113000, "Space"),


                    new Beat(115000, "S"),
                    new Beat(115250, "D"),
                    new Beat(115500, "F"),
                    new Beat(116000, "J"),
                    new Beat(116250, "K"),
                    new Beat(116500, "L"),
                    new Beat(120000, "Space"),
                    new Beat(125000, "F"),
                    new Beat(128000, "J"),

                    new Beat(131000, "D"),
                    new Beat(133000, "K"),
                    new Beat(136000, "F"),
                    new Beat(139000, "J"),
                    new Beat(142000, "Space"),
                    new Beat(145000, "S"),
                    new Beat(147000, "L"),

                    // 마지막 하이햇 심벌즈 딱! 치고 종료
                    new Beat(149000, "Space")
            };
        }
        else if (titlename.equals("NoCopyright")&& difficulty.equals("hard"))
        {
            beats = new Beat[]{
                    new Beat(1000,"Space")
            };
        }

        else if (titlename.equals("NoCopyright")&& difficulty.equals("easy"))
        {
            beats = new Beat[]{
                    new Beat(1000,"Space")
            };
        }
        else if (titlename.equals("NoCopyright")&& difficulty.equals("hard"))
        {
            beats = new Beat[]{
                    new Beat(1000,"Space")
            };
        }
        else if(titlename.equals("prettyjohn1")&& difficulty.equals("easy")) {
            beats = new Beat[]{
                    new Beat(1000, "Space")
            };
        }
        else if(titlename.equals("prettyjohn1")&& difficulty.equals("hard")) {
            beats = new Beat[]{
                    new Beat(1000, "Space")
            };
        }
        int i=0;
        gamemusic.start();
        while(i<beats.length && !isInterrupted())
        {
            boolean dropped =false;

            if(beats[i].getTime() <= gamemusic.getTime())
            {
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
            if(!dropped)
            {
                try{
                    Thread.sleep(5);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void judge(String input)
    {
        for(int i=0;i<noteList.size();i++)
        {
            Note note = noteList.get(i);
            if(input.equals(note.getNoteType()))
            {
                note.judge();
                break;
            }
        }
    }

}
