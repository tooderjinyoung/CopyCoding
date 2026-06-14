import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Note extends Thread{

    private Image notebasicImage = new ImageIcon(Main.class.getResource(Main.imagesPath + "notebasic.png")).getImage();

    private int x,y=500-(1000/Main.SLEEP_TIME*Main.NOTE_SPEED) * Main.REACH_TIME;
    private String noteType;
    private boolean proceeded =true;

    public String getNoteType() {
        return noteType;
    }
    public boolean isProceeded(){
        return proceeded;
    }
    public void colse()
    {
        proceeded=false;
    }

    public Note(String noteType)
    {
        if(noteType.equals("S"))
        {
            x=228;
        }
        else if(noteType.equals("D"))
        {
            x=332;
        }
        else if(noteType.equals("F"))
        {
            x=436;
        }
        else if(noteType.equals("Space"))
        {
            x=540;
        }
        else if(noteType.equals("J"))
        {
            x=744;
        }
        else if(noteType.equals("K"))
        {
            x=848;
        }
        else if(noteType.equals("L"))
        {
            x=952;
        }
        this.noteType=noteType;
    }

    public void SceenDraw(Graphics2D g)
    {
        if(noteType.equals("Space"))
        {
            g.drawImage(notebasicImage,x,y,null);
            g.drawImage(notebasicImage,x+100,y,null);

        }
        else
        {            g.drawImage(notebasicImage,x,y,null);
        }
    }
    public void drop()
    {
        y+=Main.NOTE_SPEED;
        if(y>620) {
            System.out.println("Miss");
            colse();
        }
    }

    @Override
    public void run()
    {
        try{
           while(true)
           {
               drop();
               if(proceeded)
               {
                   Thread.sleep(Main.SLEEP_TIME);

               }
               else{
                   interrupt();
                   break;
               }
           }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    public void judge() {
        // 판정 기준을 위아래로 넓게 벌려 여유를 주었습니다.
        if(y >= 630) {
            System.out.println("Late");
            colse();
        } else if(y >= 610) {
            System.out.println("Good");
            colse();
        } else if(y >= 595) {
            System.out.println("Great");
            colse();
        } else if(y >= 565) {
            // Perfect 구간을 565 ~ 594 (30픽셀)로 대폭 확대!
            System.out.println("Perfect");
            colse();
        } else if(y >= 550) {
            System.out.println("Great");
            colse();
        } else if(y >= 530) {
            System.out.println("Good");
            colse();
        } else if(y >= 500) {
            System.out.println("Early");
            colse();
        } else if(y >= 400) {
            System.out.println("Miss (Too Early)");
            colse();
        }
    }




}
