package analyzer;

import static utility.Constants.*;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
// import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


public class SearchPanel extends JFrame implements ActionListener{
    static JButton readBtn = new JButton("読込");
    JTextField[] searchPoke = new JTextField[6];    //相手側の検索
    public static ArrayList<String[]> tmpResult = new ArrayList<String[]>();


    public JPanel SearchPanelMake(){
        JPanel searchPanel = new JPanel();
        setLayout(new GridLayout(1, 7));
        readBtn.addActionListener(this);
        for(int i = 0; i < searchPoke.length; i++){
            searchPoke[i] = new JTextField(8);
            searchPanel.add(searchPoke[i]);
        }
        searchPanel.add(readBtn);
        return searchPanel;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == readBtn){
            //読み込みボタンの動作
            tmpResult.clear();

            for(int i = 0; i < Analyzer.resultString.size(); i++){
                yourPTpokeIdx:
                    //jは調べるポケモン(JText)
                    for(int j = 0; j < opponentPtPokeNameIdx.length; j++){
                        //kは相手のポケモン6匹を調べる
                        for(int k = 0; k < searchPoke.length; k++){
                            if(searchPoke[j].getText().equals("")){
                                break;
                            }else if(searchPoke[j].getText().equals(Analyzer.resultString.get(i)[opponentPtPokeNameIdx[k]])){
                                break;
                            }
                            //最後まで検索したポケモンがいなければ、次の対戦結果に移行する
                            if(k == 5) break yourPTpokeIdx;
                        }
                        //最後まで絞り込みが成功したらtmpResultに追加する
                        if(j == 5)tmpResult.add(Analyzer.resultString.get(i)); 
                    }
            }

            ResultPanel tmpResultPanel = new ResultPanel();
            //removeで一度入力されたTableを削除する
            if(Analyzer.MainPanel != null)Analyzer.MainPanel.removeAll();
            Analyzer.MainPanel.add(tmpResultPanel.ResultPanelMake(tmpResult));
            Analyzer.MainPanel.validate();
            Analyzer.matchLabel.setText(tmpResultPanel.matchcalc(tmpResult));
        }
    }
}