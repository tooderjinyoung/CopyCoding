import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DynamicBeat extends JFrame {
    private String imagesPath = "/images/";
    private Image screenImage;
    private Graphics screenGraphic;


    private Image BackGround = new ImageIcon(Main.class.getResource(imagesPath + "introbackGround.jpg")).getImage();

    private Image selectedImage =new ImageIcon(Main.class.getResource(imagesPath + "jjez.jpg")).getImage();

    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource(imagesPath + "bar.png")));
    private  JButton exitButton = new JButton("EXIT");

    private ImageIcon startButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "start.png"));
    private ImageIcon startButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "start_2.png"));
    private ImageIcon quitButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "end.png"));
    private ImageIcon quitButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "end_2.png"));

    private JButton startButton = new JButton(startButtonBasic);
    private JButton quitButton = new JButton(quitButtonBasic);

    private int mouseX;
    private int mouseY;

    private boolean isMainScreen = false;


    // 생성자 생성
    public DynamicBeat() {
        setUndecorated(true);

        setTitle("DynamicBeat");

        //화면 설정
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); // 화면 크기 고정
        setLocationRelativeTo(null); // 화면 정중앙설정
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 게임 종료시 프로그램 전체 종료 설정
        setVisible(true); // 컴퓨터에 출력 true
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null); // 그위치 그대로 넣어짐


        // 메뉴바 및 나가기 버튼 ----------------------------------
        exitButton.setBounds(Main.SCREEN_WIDTH-30,0,30,30);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new  MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3",false);
                mouseClick.start();
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ex){ex.printStackTrace();}
                System.exit(0);
            }
        });
        add(exitButton);

        //시작 버튼
        int startbuttonw =280;
        int menubtnx=100,menubtny=200;
        // 끝 버튼
        quitButton.setBounds(menubtnx,menubtny*2,startbuttonw,200);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new  MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e)
            {

                quitButton.setIcon(quitButtonEntered);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3",false);
                mouseClick.start();
            }
            @Override
            public void mouseExited(MouseEvent e)
            {
                quitButton.setIcon(quitButtonBasic);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3",false);
                mouseClick.start();
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ex){ex.printStackTrace();}
                 System.exit(0);
            }
        });
        add(quitButton);
        startButton.setBounds(menubtnx,menubtny,startbuttonw,200);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new  MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e)
            {

                startButton.setIcon(startButtonEntered);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3",false);
                mouseClick.start();

            }
            @Override
            public void mouseExited(MouseEvent e)
            {
                startButton.setIcon(startButtonBasic);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3",false);
                mouseClick.start();
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ex){ex.printStackTrace();}
                // 시작버튼 만들기 //
                startButton.setVisible(false);
                quitButton.setVisible(false);
                BackGround = new ImageIcon(Main.class.getResource(imagesPath + "mainbackGrond.png.")).getImage();
                isMainScreen = true;
            }
        });
        add(startButton);







        // 메뉴바 움직이는법
        menuBar.setBounds(0, 0, Main.SCREEN_WIDTH, 30);
        menuBar.addMouseListener(new  MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new  MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x-mouseX, y-mouseY);
            }
        });
        add(menuBar);


        Music introMusic = new Music("introMusic.mp3", true);
        introMusic.start();
    }

    // 첫번째로 프린트하는 함수
    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, this);
    }

    // 계속 프린트해주는 함수
    public void screenDraw(Graphics g) {
        g.drawImage(BackGround, 0, 0, null);
        if(isMainScreen)
        {
            g.drawImage(selectedImage, 338,100, null);
        }


        paintComponents(g);
        this.repaint();
    }
}