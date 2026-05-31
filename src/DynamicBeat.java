import javax.swing.*;

import java.awt.*;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackGround;

    private String imagesPath = "/images/";


    // 생성자 생성
    public DynamicBeat() {
        setTitle("DynamicBeat");

        //화면 설정
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);// 화면 크기 고정
        setLocationRelativeTo(null);// 화면 정중앙설정
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 게임 종료시 프로그램 전체 종료 설정
        setVisible(true); // 컴퓨터에 출력 true

        introBackGround = new ImageIcon(Main.class.getResource(imagesPath + "introbackGround.jpg")).getImage();
        Music introMusic = new Music("introMusic.mp3", true);
        introMusic.start();


    }

    // 첫번째로 프린트하는 함수
    public void paint(Graphics g)
    {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, this);
    }

    // 계속 프린트해주는 함수
    public void screenDraw(Graphics g)
    {
        g.drawImage(introBackGround, 0, 0, null);
        this.repaint();
    }
}
