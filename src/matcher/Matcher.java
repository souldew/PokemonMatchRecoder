package matcher;

//定数ファイルの読み込み
import static utility.Constants.*;
import utility.Poke;


import utility.PokeDex;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.io.File;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Calendar;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


class Matcher extends JFrame implements ActionListener{
    //PT関連の変数
    JButton[] myPtEnter_Button = new JButton[6];
    JLabel[] myPtIcon_Label = new JLabel[6];
    JTextField[] myPt_text = new JTextField[6];
    JButton[] opponentPtEnter_Button = new JButton[6];
    JLabel[] opponentPtIcon_Label = new JLabel[6];
    JTextField[] opponentPt_text = new JTextField[6];
    //選出の管理に使用
    int[] myEnterPattern = new int[6];
    int[] opponentEnterPattern = new int[6];
    //試合結果の管理に使用
    int winLosePattern = 0;

    //interfacePanel
    JButton writeMyPtButton = new JButton("MyPTを保存");
    JButton getIconButton = new JButton("取得");
    JButton winLoseButton = new JButton();
    JButton resultWriteButton = new JButton("結果保存");
    JButton[][] formChangeButtons = new JButton[2][6];   //フォルムチェンジボタン

    //自分のptをcsvから読み込んだものを一度保存する
    static String[] myPtData = new String[6];

    public static void main(String[] args){
        //myPTのデータの読み込み
        try{
            File f = new File(Path_MyPtData);
            BufferedReader br = new BufferedReader(new FileReader(f));
            for(int i = 0; i < myPtData.length; i++){
                String line = br.readLine();
                myPtData[i] = line;
            }
            br.close();
        }catch(IOException e){
            System.out.println(e);
        }
        Matcher frame = new Matcher("Matcher");
        frame.setAlwaysOnTop(true); //最前面表示
        frame.setVisible(true);
    }

    MemoPanel Memo_panel_inst = new MemoPanel();
    Matcher(String title){
        setTitle(title);                //タイトルの設定
        //メモ横配置(x, x, 650, 480)
        //メモ縦配置(x, x, 500, 810)
        //左配置(10, 10, x, x)
        //右配置(2100, 10, x, x)
        setBounds(2000, 10, 500, 810);    //フレームの初期位置,大きさ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //xを押したときにプログラムを終了する

        //レイアウト
        JPanel myPtPanel = new JPanel();
        JPanel opponentPtPanel = new JPanel();
        JPanel interfacePanel = new JPanel();
        TodHpCalcPanel TOD_HPcalc_panel_inst = new TodHpCalcPanel();
        JPanel TOD_HPcalc_panel = TOD_HPcalc_panel_inst.create_tod_HPcalc_panel();
        JPanel Memo_panel = Memo_panel_inst.create_panel(); 
        //ここから下で主にレイアウトを調整する
        //メモ横配置ver
        /*
        setLayout(new BorderLayout());
        JPanel icon_display_panel_plus_btn = new JPanel(new BorderLayout());
        JPanel icon_display_panel = new JPanel(new GridLayout(1,2));
        icon_display_panel.add(myPtPanel);
        icon_display_panel.add(opponentPtPanel);
        icon_display_panel_plus_btn.add("Center", icon_display_panel);
        icon_display_panel_plus_btn.add("South", interfacePanel);
        add("Center", icon_display_panel_plus_btn);
        JPanel south_borderLayout_panel = new JPanel(new BorderLayout());
        south_borderLayout_panel.add("Center", TOD_HPcalc_panel);
        add("South", south_borderLayout_panel);
        add("East", Memo_panel);
        */
        //メモ縦配置ver
        setLayout(new BorderLayout());
        add("North", new JLabel(" "));   //枠調整のdummy
        JPanel icon_display_panel_plus_btn = new JPanel(new BorderLayout());
        JPanel icon_display_panel = new JPanel(new GridLayout(1,2));
        icon_display_panel.add(myPtPanel);
        icon_display_panel.add(opponentPtPanel);
        icon_display_panel_plus_btn.add("Center", icon_display_panel);
        icon_display_panel_plus_btn.add("South", interfacePanel);
        add("Center", icon_display_panel_plus_btn);
        JPanel south_borderLayout_panel = new JPanel(new BorderLayout());
        south_borderLayout_panel.add("North", TOD_HPcalc_panel);
        south_borderLayout_panel.add("Center", Memo_panel);
        add("South", south_borderLayout_panel);
        //レイアウトここまで

        PtGUILayout(myPtPanel, myPtEnter_Button, myPtIcon_Label, myPt_text, MY_PT, formChangeButtons[0]);
        PtGUILayout(opponentPtPanel, opponentPtEnter_Button, opponentPtIcon_Label, opponentPt_text, OPPONENT_PT, formChangeButtons[1]);

        winLoseButton.setPreferredSize(new Dimension(WIN_LOSE_BUTTON_WIDTH, WIN_LOSE_BUTTON_HEIGHT));
        interfacePanel.setLayout(new FlowLayout());
        interfacePanel.add(writeMyPtButton);
        interfacePanel.add(getIconButton);
        interfacePanel.add(winLoseButton);
        interfacePanel.add(resultWriteButton);

        //Enterで取得ボタンを押下するようにする
        getRootPane().setDefaultButton(getIconButton);
        //tabの操作順
        setFocusTraversalPolicy(new MyFocusPolicy());
        
        //下記ボタンの操作をできるようにする
        getIconButton.addActionListener(this);
        for(int i = 0; i < myPtEnter_Button.length; i++){
            myPtEnter_Button[i].addActionListener(this);
            opponentPtEnter_Button[i].addActionListener(this);
            formChangeButtons[0][i].addActionListener(this);
            formChangeButtons[1][i].addActionListener(this);
        }
        writeMyPtButton.addActionListener(this);
        winLoseButton.addActionListener(this);
        resultWriteButton.addActionListener(this);

        //起動時に行われる操作
        //読み込んだcsvからテキストをセット
        for(int i = 0; i < myPtData.length; i++){
            myPt_text[i].setText(myPtData[i]);
        }

    }

    //ボタンのアクション
    public void actionPerformed(ActionEvent e){
        //取得ボタン
        if(e.getSource() == getIconButton){
            for(int i = 0; i < 6; i++){
                myPtIcon_Label[i].setIcon(PokeDex.SearchPoke(myPt_text[i].getText()).getIcon());
                opponentPtIcon_Label[i].setIcon(PokeDex.SearchPoke(opponentPt_text[i].getText()).getIcon());
            }
        }
        //選出ボタンの挙動を制御
        for(int i = 0; i < 6; i++){
            if(e.getSource() == myPtEnter_Button[i]){
                myEnterPattern[i] = (myEnterPattern[i] + 1)%3;
                myPtEnter_Button[i].setIcon((ELECTS[myEnterPattern[i]]).getIcon());
            }
            if(e.getSource() == opponentPtEnter_Button[i]){
                opponentEnterPattern[i] = (opponentEnterPattern[i] + 1)%3;
                opponentPtEnter_Button[i].setIcon((ELECTS[opponentEnterPattern[i]]).getIcon());
            }        
        }
        //フォルムチェンジボタンの動作
        //自分側
        for(int i = 0; i < 6; i++){
            if(e.getSource() == formChangeButtons[0][i]){
                Poke poke = PokeDex.SearchPoke(myPt_text[i].getText());
                String changeNum = poke.getNum();
                char[] changeNum_ch = changeNum.toCharArray();
                //フォルム(アルファベットをひとつ進める)
                changeNum_ch[changeNum_ch.length - 1]++;
                Poke tmp = PokeDex.SearchPoke(changeNum_ch);
                //別フォルムがなかったらの処理
                if(tmp == null){
                    //次のフォルムがなかった場合→a(初期フォルムに戻す)
                    changeNum_ch[changeNum_ch.length - 1] = 'a';
                    tmp = PokeDex.SearchPoke(changeNum_ch);
                }
                myPt_text[i].setText(tmp.getName());
                getIconButton.doClick();
            }
        }
        //相手側
        for(int i = 0; i < 6; i++){
            if(e.getSource() == formChangeButtons[1][i]){
                Poke poke = PokeDex.SearchPoke(opponentPt_text[i].getText());
                String changeNum = poke.getNum();
                char[] changeNum_ch = changeNum.toCharArray();
                //フォルム(アルファベットをひとつ進める)
                changeNum_ch[changeNum_ch.length - 1]++;
                Poke tmp = PokeDex.SearchPoke(changeNum_ch);
                //別フォルムがなかったらの処理
                if(tmp == null){
                    //次のフォルムがなかった場合→a(初期フォルムに戻す)
                    changeNum_ch[changeNum_ch.length - 1] = 'a';
                    tmp = PokeDex.SearchPoke(changeNum_ch);
                }
                opponentPt_text[i].setText(tmp.getName());
                getIconButton.doClick();
            }
        }

        //自分のPTを保存するボタン
        if(e.getSource() == writeMyPtButton){
            try{
                FileWriter fw = new FileWriter(".\\myPT.csv", false);
                for(int i = 0; i < myPt_text.length; i++){
                    fw.write(myPt_text[i].getText() + "\n");
                }
                fw.close();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
        //試合結果を表示するボタン
        if(e.getSource() == winLoseButton){
            winLosePattern = (winLosePattern + 1)%3;
            winLoseButton.setIcon((WINLOSE[winLosePattern].getIcon()));
        }
        //結果保存のボタンの管理
        if(e.getSource() == resultWriteButton){
            //勝敗が正しく入力されている
            if(winLosePattern != 0){
                try{
                    FileWriter fw = new FileWriter(".\\resultData.csv", true);
                    //日付
                    fw.write(getCalString() + ",");
                    //試合結果
                    if(winLosePattern == 1) fw.write("○,");
                    else if(winLosePattern == 2) fw.write(" ,");
                    //自分側の選出
                    for(int i = 0; i < myPtData.length; i++){
                        fw.write(myPt_text[i].getText() + ",");
                        if(myEnterPattern[i] == 0) fw.write(ELECTS[0].getNum() + ",");
                        else if(myEnterPattern[i] == 1) fw.write(ELECTS[1].getNum() + ",");
                        else if(myEnterPattern[i] == 2) fw.write(ELECTS[2].getNum() + ",");
                    }
                    //相手側の選出
                    for(int i = 0; i < myPtData.length; i++){
                        fw.write(opponentPt_text[i].getText() + ",");
                        if(opponentEnterPattern[i] == 0) fw.write(ELECTS[0].getNum() + ",");
                        else if(opponentEnterPattern[i] == 1) fw.write(ELECTS[1].getNum() + ",");
                        else if(opponentEnterPattern[i] == 2) fw.write(ELECTS[2].getNum() + ",");
                }
                //改行+ファイルを閉じる
                fw.write("\n");
                fw.close();
                } catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            //勝敗が記載されていない場合に結果保存を押された場合含め必要箇所をリセットする
            for(int i = 0; i < opponentPt_text.length; i++){
                opponentPt_text[i].setText("");
                opponentPtIcon_Label[i].setIcon(null);
                opponentPtEnter_Button[i].setIcon(null);
                myPtEnter_Button[i].setIcon(null);
                myEnterPattern[i] = 0;
                opponentEnterPattern[i] = 0;
            }
            winLoseButton.setIcon(null);
            //メモエリアも初期化する
            Memo_panel_inst.text_clear();
            winLosePattern = 0;
        }

    }

    void PtGUILayout(JPanel panel, JButton[] Enter_Button,JLabel[] Icon_Label, JTextField[] Pt_text,String labelName, JButton[] formChangeButtons){
        JLabel label = new JLabel(labelName);
        label.setHorizontalAlignment(JLabel.CENTER);
        JPanel pokeInfoPanel = new JPanel();
        pokeInfoPanel.setLayout(new GridLayout(6,1));

        panel.setLayout(new BorderLayout());
        panel.add("North", label);
        panel.add("Center", pokeInfoPanel);

        for(int i = 0; i < 6; i++){
            JPanel oneLinePanel = new JPanel();
            oneLinePanel.setLayout(new FlowLayout());
            Enter_Button[i] = new JButton();
            Enter_Button[i].setPreferredSize(new Dimension(ENTER_BUTTON_WIDTH, ENTER_BUTTON_HEIGHT));
            Icon_Label[i] = new JLabel();
            Icon_Label[i].setPreferredSize(new Dimension(PT_ICON_WIDTH, PT_ICON_HEIGHT));
            Pt_text[i] = new JTextField();
            Pt_text[i].setPreferredSize(new Dimension(PT_TEXT_WIDTH, PT_TEXT_HEIGHT));
            //テキストフィールド選択時全選択に
            Pt_text[i].addFocusListener(new FocusAdapter(){
                @Override public void focusGained(FocusEvent e){
                ((JTextComponent) e.getComponent()).selectAll();
                }
            });
            //フォルムチェンジボタンのアイコン表示
            formChangeButtons[i] = new JButton();
            formChangeButtons[i].setIcon(new ImageIcon(Path_formChangeIcon));
            formChangeButtons[i].setPreferredSize(new Dimension(FORMCHANGE_BUTTON_WIDTH, FORMCHANGE_BUTTON_HEIGHT));
            //1行ごとにパネルに入れる
            oneLinePanel.add(Enter_Button[i]);
            oneLinePanel.add(Icon_Label[i]);
            oneLinePanel.add(Pt_text[i]);
            oneLinePanel.add(formChangeButtons[i]);

            pokeInfoPanel.add(oneLinePanel);
        }
    }

    //tabに関するクラス(クラス内のクラス？)
    class MyFocusPolicy extends LayoutFocusTraversalPolicy {
        @Override
        //tabフォーカスの変更   自分のPTテキスト→相手のPTテキスト→タイムボタン→取得ボタン→自分の選出→相手の選出→結果→データ保存ボタン→ループ
        public Component getComponentAfter(Container container, Component component) {
            for(int i = 0; i < myPt_text.length - 1; i++)
                if (component == myPt_text[i]) return myPt_text[i + 1];
            if(component == myPt_text[5])    return opponentPt_text[0];
            
            for(int i = 0; i < opponentPt_text.length - 1; i++)
                if(component == opponentPt_text[i]) return opponentPt_text[i + 1];
            if(component == opponentPt_text[5]) return getIconButton;
            else if(component == getIconButton) return myPtEnter_Button[0];

            for(int i = 0; i < myPtEnter_Button.length - 1; i++)
                if(component == myPtEnter_Button[i]) return myPtEnter_Button[i + 1];
            if(component == myPtEnter_Button[5]) return opponentPtEnter_Button[0];

            for(int i = 0; i < opponentPtEnter_Button.length - 1; i++)
                if(component == opponentPtEnter_Button[i]) return opponentPtEnter_Button[i + 1];
            if(component == opponentPtEnter_Button[5]) return winLoseButton;
            else if(component == winLoseButton) return resultWriteButton;
            else if(component == resultWriteButton) return myPt_text[0];
            else{return super.getComponentAfter(container, component);}
        }

        @Override
        //tabフォーカスの変更　Afterの逆を定義(tab + Shift)
        public Component getComponentBefore(Container container, Component component) {
            for(int i = 5; i > 0; i--)
                if(component == opponentPtEnter_Button[i]) return opponentPtEnter_Button[i-1];
            if(component == opponentPtEnter_Button[0]) return myPtEnter_Button[5];

            for(int i = 5; i > 0; i--)
                if(component == myPtEnter_Button[i]) return myPtEnter_Button[i-1];
            if(component == myPtEnter_Button[0]) return getIconButton;
            else if(component == getIconButton) return opponentPt_text[5];

            for(int i = 5; i > 0; i--)
                if(component == opponentPt_text[i]) return opponentPt_text[i-1];
            if(component == opponentPt_text[0]) return myPt_text[5];

            for(int i = 5; i > 0; i--)
                if(component == myPt_text[i]) return myPt_text[i-1];

            if(component == myPt_text[0]) return resultWriteButton;
            else if(component == resultWriteButton) return winLoseButton;
            else if(component == winLoseButton) return opponentPtEnter_Button[5];
            else {return super.getComponentBefore(container, component);}
        }
    }

    //関数(対戦時の日付を渡す)
    public String getCalString(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        return String.format("%04d/%02d/%02d",year, month, day);
    }
}