import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {
    private String imagesPath = "/images/";
    private Image screenImage;
    private Graphics screenGraphic;


    private Image BackGround = new ImageIcon(Main.class.getResource(imagesPath + "introbackGround.jpg")).getImage();


    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource(imagesPath + "bar.png")));


    private ImageIcon startButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "start.png"));
    private ImageIcon startButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "start_2.png"));
    private ImageIcon quitButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "end.png"));
    private ImageIcon quitButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "end_2.png"));


    private ImageIcon leftButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "left.png"));
    private ImageIcon leftButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "left_2.png"));
    private ImageIcon rightButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "right.png"));
    private ImageIcon rightButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "right_2.png"));

    private ImageIcon easyButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "easy.png"));
    private ImageIcon easyButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "easy_2.png"));
    private ImageIcon hardButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "hard.png"));
    private ImageIcon hardButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "hard_2.png"));

    private ImageIcon backButtonBasic = new ImageIcon(Main.class.getResource(imagesPath + "back.png"));
    private ImageIcon backButtonEntered = new ImageIcon(Main.class.getResource(imagesPath + "back_2.png"));

    private JButton startButton = new JButton(startButtonBasic);
    private JButton quitButton = new JButton(quitButtonBasic);
    private JButton leftButton = new JButton(leftButtonBasic);
    private JButton rightButton = new JButton(rightButtonBasic);
    private JButton easyButton = new JButton(easyButtonBasic);
    private JButton hardButton = new JButton(hardButtonBasic);
    private JButton backButton = new JButton(backButtonBasic);


    private JButton exitButton = new JButton("EXIT");

    private int mouseX;
    private int mouseY;

    private boolean isMainScreen = false;

    ArrayList<Track> tracksList = new ArrayList<>();
    private Music selectedMusic;
    private Image selectedImage;
    private int nowSelected = 0;

    Music introMusic = new Music("introMusic.mp3", true);

    // 생성자 생성
    public DynamicBeat() {
        setUndecorated(true);
        tracksList.add(new Track("moodmode.mp3", "jjez.jpg", "fulljjez.png"));
        tracksList.add(new Track("NoCopyright.mp3", "fruit.jpg", "fullfruit.jpg"));
        tracksList.add(new Track("prettyjohn1.mp3", "flower.jpg", "fullflower.jpg"));

        introMusic.start();
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
        exitButton.setBounds(Main.SCREEN_WIDTH - 30, 0, 30, 30);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(exitButton);

        int startbuttonw = 280;
        int menubtnx = 100, menubtny = 200;
        // 끝 버튼
        quitButton.setBounds(menubtnx, menubtny * 2, startbuttonw, 200);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                quitButton.setIcon(quitButtonEntered);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonBasic);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(quitButton);

        // 시작 버튼
        startButton.setBounds(menubtnx, menubtny, startbuttonw, 200);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                startButton.setIcon(startButtonEntered);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasic);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // 시작버튼 만들기 //
                enterMain();
            }
        });
        add(startButton);


        // mainscrean left 버튼
        leftButton.setVisible(false);
        leftButton.setBounds(0, 330, 120, 120);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                leftButton.setIcon(leftButtonEntered);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftButtonBasic);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                selectLeft();
            }
        });
        add(leftButton);

        // mainscrean right  버튼
        rightButton.setVisible(false);
        rightButton.setBounds(Main.SCREEN_WIDTH - 120, 330, 120, 120);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                rightButton.setIcon(rightButtonEntered);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightButtonBasic);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // 사진 변경
                selectRight();
            }
        });
        add(rightButton);

        // 이지 버튼
        easyButton.setVisible(false);
        easyButton.setBounds(300, 500, 300, 160);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                easyButton.setIcon(easyButtonEntered);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easyButton.setIcon(easyButtonBasic);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // 이지버튼 구현
                gameStart(nowSelected, "easy");
            }
        });
        add(easyButton);

        // 하드 버튼
        //
        hardButton.setVisible(false);
        hardButton.setBounds(Main.SCREEN_WIDTH - 580, 500, 300, 160);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                hardButton.setIcon(hardButtonEntered);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hardButton.setIcon(hardButtonBasic);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // 하드버튼 구현
                gameStart(nowSelected, "hard");

            }
        });
        add(hardButton);

        // 뒤로가기 버튼
        backButton.setVisible(false);
        backButton.setBounds(20, 50,60,60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                backButton.setIcon(backButtonEntered);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButtonBasic);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music mouseClick = new Music("MouseClick.mp3", false);
                mouseClick.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                backMain();
            }
        });
        add(backButton);

        // 메뉴바 움직이는법
        menuBar.setBounds(0, 0, Main.SCREEN_WIDTH, 30);
        menuBar.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);


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
        if (isMainScreen) {

            g.drawImage(selectedImage, 338, 100, null);
        }
        paintComponents(g);
        this.repaint();
    }

    public void selectTrack(int nowSelected) {
        if (selectedMusic != null) {
            selectedMusic.close();
        }
        selectedImage = new ImageIcon(Main.class.getResource(imagesPath + tracksList.get(nowSelected).getTileIamge())).getImage();
        selectedMusic = new Music(tracksList.get(nowSelected).getGameMusic(), true);
        selectedMusic.start();

    }

    public void selectLeft() {
        if (nowSelected == 0) {
            nowSelected = tracksList.size() - 1;
        } else {
            nowSelected = nowSelected - 1;
        }
        selectTrack(nowSelected);
    }

    public void selectRight() {
        if (nowSelected == tracksList.size() - 1) {
            nowSelected = 0;
        } else {
            nowSelected = nowSelected + 1;
        }
        selectTrack(nowSelected);
    }

    public void gameStart(int nowSelected, String difficulty) {
        if (selectedMusic != null) {
            selectedMusic.close();
        }
        isMainScreen = false;

        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        backButton.setVisible(true);

        BackGround = new ImageIcon(Main.class.getResource(imagesPath + tracksList.get(nowSelected).getStartImage())).getImage();
    }

    public void backMain()
    {
        isMainScreen =true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        BackGround = new ImageIcon(Main.class.getResource(imagesPath + "mainbackGrond.png.")).getImage();
        backButton.setVisible(false);
        selectTrack(nowSelected);
    }

    public void enterMain()
    {
        selectTrack(0);

        startButton.setVisible(false);
        quitButton.setVisible(false);

        BackGround = new ImageIcon(Main.class.getResource(imagesPath + "mainbackGrond.png.")).getImage();

        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        isMainScreen = true;
        selectTrack(nowSelected);
        introMusic.close();
    }

}