import javax.swing.*;

public class DynamicBeat extends JFrame {

    // 생성자 생성
    public DynamicBeat()
    {
        setTitle("DynamicBeat");

        //화면 설정
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);// 화면 크기 고정
        setLocationRelativeTo(null);// 화면 정중앙설정
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 게임 종료시 프로그램 전체 종료 설정
        setVisible(true); // 컴퓨터에 출력 true
    }
}
