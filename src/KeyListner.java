import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListner extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if(DynamicBeat.game == null){return;}
        if (e.getKeyCode() == KeyEvent.VK_S) {
            DynamicBeat.game.pressS();

        }
        else if(e.getKeyCode() == KeyEvent.VK_D)
        {
            DynamicBeat.game.pressD();
        }
        else if(e.getKeyCode() == KeyEvent.VK_F)
        {
            DynamicBeat.game.pressF();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            DynamicBeat.game.pressSpace();
        }
        else if(e.getKeyCode() == KeyEvent.VK_J)
        {
            DynamicBeat.game.pressJ();
        }
        else if(e.getKeyCode() == KeyEvent.VK_K)
        {
            DynamicBeat.game.pressK();
        }
        else if(e.getKeyCode() == KeyEvent.VK_L)
        {
            DynamicBeat.game.pressL();

        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(DynamicBeat.game == null){return;}
        if (e.getKeyCode() == KeyEvent.VK_S) {
            DynamicBeat.game.releasS();

        }
        else if(e.getKeyCode() == KeyEvent.VK_D)
        {
            DynamicBeat.game.releasD();
        }
        else if(e.getKeyCode() == KeyEvent.VK_F)
        {
            DynamicBeat.game.releasF();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            DynamicBeat.game.releasSpace();
        }
        else if(e.getKeyCode() == KeyEvent.VK_J)
        {
            DynamicBeat.game.releasJ();
        }
        else if(e.getKeyCode() == KeyEvent.VK_K)
        {
            DynamicBeat.game.releasK();
        }
        else if(e.getKeyCode() == KeyEvent.VK_L)
        {
            DynamicBeat.game.releasL();

        }
    }
}
