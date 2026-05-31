import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;

public class Music extends Thread {
    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    private String Musicpath = "/Music/";

    public Music(String name, boolean isLoop) {
        try {
            this.isLoop = isLoop;

            try{
                file = new File(Main.class.getResource(Musicpath + name).toURI());
            }
            catch(URISyntaxException ex){ex.printStackTrace();}
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int getTime(){
        if (player == null) { return 0;}
        return player.getPosition();
    }

    public void close()
    {
        isLoop = false;
        player.close();
        this.interrupt();
    }

    @Override
    public void run()
    {
        try{
            do {
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            }while (isLoop);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}