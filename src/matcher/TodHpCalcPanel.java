package matcher;

//定数ファイルの読み込み
import static utility.Constants.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//選出したポケモンの数のような定数を作っておいた方が絶対に良かった

class TodHpCalcPanel extends JFrame implements ActionListener{
    JPanel main_tod_HPcalc_panel = new JPanel();//返り値となるパネル

    public JPanel create_tod_HPcalc_panel(){
        create_tod_HPcalc_panel_layout();
        ratio_calc_btn.addActionListener(this);
        time_btn.addActionListener(this);
        return main_tod_HPcalc_panel;
    }

    JLabel panel_name_str_label = new JLabel(TOD_HP_CALC_PANEL_TITLE);
    JPanel north = new JPanel(new FlowLayout());
    JPanel center = new JPanel(new GridLayout(2,5)); //TOD計算パネルのメインのパネル
    JPanel my_panel[]       = new JPanel[5];   //自分側一番外のパネル
    JPanel opponent_panel[] = new JPanel[5];   //相手側一番外のパネル
    JLabel my_up_label   = new JLabel("    自分_最大HP");
    JLabel my_down_label = new JLabel("    自分_現在HP");
    JLabel opponent_up_label   = new JLabel("    相手_最大HP");
    JLabel opponent_down_label = new JLabel("    相手_現在HP");
    JTextField myPT_MAX_HP[]     = new JTextField[3];
    JTextField myPT_current_HP[] = new JTextField[3];
    JTextField opponentPT_MAX_HP[]     = new JTextField[3];
    JTextField opponentPT_current_HP[] = new JTextField[3];
    JLabel myPT_HP_ratio = new JLabel("%");
    JLabel opponentPT_HP_ratio = new JLabel("%");
    JButton ratio_calc_btn = new JButton("割合計算");
    //timerPanel
    JButton time_btn = new JButton("TimerStart");
    JLabel time_label = new JLabel("00：00");
    //タイム計測用
    Timer timer = new Timer(995, this);
    Integer battleTime = 1200;  //20分

    //使用する変数（主に配列の中身）の初期化
    public void TOD_panel_init(){
        for(int i = 0; i < my_panel.length; i++){
            my_panel[i]       = new JPanel(new GridLayout(2,1));
            opponent_panel[i] = new JPanel(new GridLayout(2,1));
        }
        for(int i = 0; i < myPT_MAX_HP.length; i++){
            myPT_MAX_HP[i]     = new JTextField();
            myPT_current_HP[i] = new JTextField();
            opponentPT_MAX_HP[i]     = new JTextField();
            opponentPT_current_HP[i] = new JTextField();
            myPT_MAX_HP[i].setPreferredSize(new Dimension(PT_TEXT_WIDTH, PT_TEXT_HEIGHT));
            myPT_current_HP[i].setPreferredSize(new Dimension(PT_TEXT_WIDTH, PT_TEXT_HEIGHT));
            opponentPT_MAX_HP[i].setPreferredSize(new Dimension(PT_TEXT_WIDTH, PT_TEXT_HEIGHT));
            opponentPT_current_HP[i].setPreferredSize(new Dimension(PT_TEXT_WIDTH, PT_TEXT_HEIGHT));
        }

        panel_insert();
    }

    public void create_tod_HPcalc_panel_layout(){
        main_tod_HPcalc_panel.setLayout(new BorderLayout());
        TOD_panel_init();
    }

    //すべてのパネルを各入れ子に合わせて追加する
    public void panel_insert(){
        //my_panelへの挿入
        my_panel[0].add(my_up_label);
        my_panel[0].add(my_down_label);
        //+1はパネル一つ目がラベルであるため
        for(int i = 0; i < 3; i++){
                my_panel[i+1].add(myPT_MAX_HP[i]);
                my_panel[i+1].add(myPT_current_HP[i]);
        }
        my_panel[4].add(myPT_HP_ratio);
        //opponent_panelへの挿入
        opponent_panel[0].add(opponent_up_label);
        opponent_panel[0].add(opponent_down_label);
        for(int i = 0; i < 3; i++){
                opponent_panel[i+1].add(opponentPT_MAX_HP[i]);
                opponent_panel[i+1].add(opponentPT_current_HP[i]);
        }
        opponent_panel[4].add(opponentPT_HP_ratio);
        //centerパネルへの挿入
        for(int i = 0; i < 5; i++){
            center.add(my_panel[i]);
        }
        for(int i = 0; i < 5; i++){
            center.add(opponent_panel[i]);
        }
        //northパネルへの挿入
        north.add(panel_name_str_label);
        north.add(ratio_calc_btn);
        north.add(time_btn);
        north.add(time_label);
        //mainパネルへの挿入
        main_tod_HPcalc_panel.add("North", north);
        main_tod_HPcalc_panel.add("Center", center);
    }

    public double calc_HP_ratio(int[] MAX_HP, int[] current_HP){
        double sum_current_HP = 0.0;
        double sum_MAX_HP = 0.0;
        for(int i = 0; i < MAX_HP.length; i++){
            sum_current_HP += current_HP[i];
            sum_MAX_HP += MAX_HP[i];
        }
        return (sum_current_HP / sum_MAX_HP) * 100;
    }

    //ボタンのアクション
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ratio_calc_btn){
            //HP計算に必要な情報をintに変換
            int[] myPT_MAX_HP_int = new int[3];
            int[] myPT_current_HP_int = new int[3];
            int[] opponentPT_MAX_HP_int = new int[3];
            int[] opponentPT_current_HP_int = new int[3];
            for(int i = 0; i < myPT_MAX_HP.length; i++){
                //冗長だが空白の場合にエラーが出ないようにif分で0を挿入する
                //空白をparseIntするとエラー(Warning?)が発生する
                if(myPT_MAX_HP[i].getText().equals("")){
                    myPT_MAX_HP_int[i] = 0;
                }else{
                    myPT_MAX_HP_int[i] = Integer.parseInt(myPT_MAX_HP[i].getText());
                }
                if(myPT_current_HP[i].getText().equals("")){
                    myPT_current_HP_int[i] = 0;
                }else{
                    myPT_current_HP_int[i] = Integer.parseInt(myPT_current_HP[i].getText());
                }
                if(opponentPT_MAX_HP[i].getText().equals("")){
                    opponentPT_MAX_HP_int[i] = 0;
                }else{
                    opponentPT_MAX_HP_int[i]     = Integer.parseInt(opponentPT_MAX_HP[i].getText());
                }
                if(opponentPT_MAX_HP[i].getText().equals("")){
                    opponentPT_current_HP_int[i] = 0;
                }else{
                    opponentPT_current_HP_int[i] = Integer.parseInt(opponentPT_current_HP[i].getText());
                }
            }
            double ratio;
            int display_value;
            //自分側
            ratio = calc_HP_ratio(myPT_MAX_HP_int, myPT_current_HP_int);
            //表示を小数点以下2桁になるように調整する
            display_value = (int)(ratio * 100);
            myPT_HP_ratio.setText((display_value / 100) + "." + (display_value % 100) + "%");
            //相手側
            ratio = calc_HP_ratio(opponentPT_MAX_HP_int, opponentPT_current_HP_int);
            //表示を小数点以下2桁になるように調整する
            display_value = (int)(ratio * 100);
            opponentPT_HP_ratio.setText((display_value / 100) + "." + (display_value % 100) + "%");
        }

        //時間管理
            if(e.getSource() == time_btn){
                battleTime = 1200;  //対戦時間
                timer.start();
            }
            if(e.getSource() == timer){
                battleTime--;
                Integer min = battleTime / 60;
                Integer sec = battleTime % 60;
                String min_str = min.toString();
                String sec_str = sec.toString();
                if(min / 10 == 0){
                    min_str = "0" + min_str;
                }
                if(sec / 10 == 0){
                    sec_str = "0" + sec_str;
                }

                time_label.setText(min_str + "：" + sec_str);
            }
    }
}