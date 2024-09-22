package analyzer;

import static utility.Constants.*;

import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.BorderLayout;

public class Analyzer extends JFrame{
    public static ArrayList<String[]> resultString = new ArrayList<String[]>();
    public static JPanel MainPanel = new JPanel();  //実際の試合結果を表示するパネル   (スクロールかは不明)
    public static JLabel matchLabel = new JLabel(); //試合数etcの表示

    public static void main(String[] args){
    //必要なデータ(ファイル)の読み込み
        //試合結果の読み込み
        File f = new File(Path_resultData);
        try (
            BufferedReader br = new BufferedReader(new FileReader(f)); //対戦結果を読み込むのに使用
        ){
            String line = br.readLine();
            for(; line != null; line = br.readLine()){
                resultString.add(line.split(",", -1));
            }
        }catch(IOException e){
            System.out.println(e);
        }
        //フレームの作成
        Analyzer frame = new Analyzer("Analyzer");
        frame.setVisible(true);
    }

    Analyzer(String title){
        setTitle(title);
        setBounds(10, 10, 920, 1000);    //フレームの大きさ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //xを押したときにプログラムを終了する

        setLayout(new BorderLayout());

        SearchPanel dummy_SearchPanel = new SearchPanel();

        //上(1枚目)のレイアウト
        add(dummy_SearchPanel.SearchPanelMake(), BorderLayout.NORTH);

        //下(2枚目)のレイアウト
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());

        //ラベルの整形
        matchLabel.setHorizontalAlignment(JLabel.CENTER);
        matchLabel.setFont(new Font("Dialog", Font.PLAIN, 13));

        resultPanel.add(matchLabel, BorderLayout.NORTH);
        resultPanel.add(MainPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.CENTER);
    }
}