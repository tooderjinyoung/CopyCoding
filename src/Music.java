import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread {
    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    private String path = "/Music/";

    public Music(String name, boolean isLoop) {
        try {
            this.isLoop = isLoop;
            file = new File(Main.class.getResource(path + name).toURI());
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int getTime(){
        // ✨ 유일하게 수정된 부분: != 가 아니라 == 로 변경했습니다.
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