import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Note extends Thread{

    private Image notebasicImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "notebasic.png")).getImage();

    private int x,y=500-1000/Main.SLEEP_TIME*Main.NOTE_SPEED;
    private String noteType;

    public Note(int x,String noteType)
    {
        this.x=x;
        this.noteType=noteType;
    }

    public void SceenDraw(Graphics2D g)
    {
        if(noteType.equals("short"))
        {
            g.drawImage(notebasicImage,x,y,null);
        }
        else if(noteType.equals("long"))
        {
            g.drawImage(notebasicImage,x,y,null);
            g.drawImage(notebasicImage,x+100,y,null);
        }
    }
    public void drop()
    {
        y+=Main.NOTE_SPEED;

    }

    @Override
    public void run()
    {
        try{
           while(true)
           {
               drop();
               Thread.sleep(Main.SLEEP_TIME);
           }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }




}
