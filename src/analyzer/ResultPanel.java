package analyzer;

import static utility.Constants.*;

import utility.PokeDex;
import javax.swing.JLabel;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
// import javax.swing.table.DefaultTableColumnModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;

public class ResultPanel extends JScrollPane{
    JScrollPane resultPanel;    //結果を表示するパネル
    JTable resultTable; //static必要？
    ArrayList<Object[]> resultObj = new ArrayList<Object[]>();  //1行(1対戦)を扱う

    //検索時にパネルを作り直すためにメソッド化
    public JScrollPane ResultPanelMake(ArrayList<String[]> resultStr){
        resultObj.clear();
        //表の作成
        for(int i = 0; i < resultStr.size(); i++){
            Object[] tmp = new Object[15];  //resultObjに入れる配列のObject
            tmp[0] = resultStr.get(i)[0];    //日付
            tmp[1] = resultStr.get(i)[1];    //試合結果
            //自分のPTのアイコン
            for(int j = 0; j < myPtPokeNameIdx.length; j++){    //2は表の上での自分のPTアイコンの開始位置
                tmp[j + 2] = (PokeDex.SearchPoke(resultStr.get(i)[myPtPokeNameIdx[j]])).getIcon();
            }
            //自分の相手の間に入れる空白
            tmp[8] = "";
            //相手のPTのアイコン
            for(int j = 0; j < opponentPtPokeNameIdx.length; j++){    //2は表の上での自分のPTアイコンの開始位置
                tmp[j + 9] = (PokeDex.SearchPoke(resultStr.get(i)[opponentPtPokeNameIdx[j]])).getIcon();
            }
            resultObj.add(tmp);
        }

        DefaultTableModel tableModel = new MyTableModel(columnNames, 0);    //デフォルトのテーブルモデルで画像を表示できるように
        //resultObj(対戦結果)を tableModel に渡す
        for(int i = 0 ; i < resultObj.size() ; i++){
            tableModel.addRow(resultObj.get(i));
        }
        resultTable = new JTable(tableModel);          //tableModel　→　resultTable に格納

        //背景色について
        MyTableCellRenderer tableCellRenderer = new MyTableCellRenderer();
        for(int i = 2; i < 8; i++){ //自分のPT側の選出について  iはどの列かを示す
            TableColumn col = resultTable.getColumnModel().getColumn(i);  //colは列iを持ってきている
            col.setCellRenderer(tableCellRenderer);
        }
        
        for(int i = 9; i < 15; i++){ //自分のPT側の選出について  iはどの列かを示す
            TableColumn col = resultTable.getColumnModel().getColumn(i);  //colは列iを持ってきている
            col.setCellRenderer(tableCellRenderer);
        }

        //テーブル(表)の成形
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  //リサイズをオフに？
        TableColumn column = null;
        for (int i = 0 ; i < resultTable.getColumnModel().getColumnCount() ; i++){
            column = resultTable.getColumnModel().getColumn(i);
            if(i == 0) column.setPreferredWidth(80);      //日付の列幅
            else if(i == 1)column.setPreferredWidth(25);  //勝敗の列幅
            else if(i == 8) column.setPreferredWidth(10); //自PTと相手PTの間の幅
            else column.setPreferredWidth(PT_ICON_WIDTH);            //ポケモンアイコンの幅
        }
        resultTable.setRowHeight(PT_ICON_HEIGHT);   //高さの指定

        resultPanel = new JScrollPane(resultTable); //resultTable　をスクロール機能のついたパネルに入れる
        resultPanel.setPreferredSize(new Dimension(738, 790));  //パネルの成形  (横, 縦)の長さ
        return resultPanel;
    }

    //試合数,勝率etcの表示
    public String matchcalc(ArrayList<String[]> resultString){
        int matchNum = AllResultStr.size();    //試合数
        int searchNum = resultString.size();   //検索したポケモンがいる数
        int win = 0;  //勝率
        for(int i = 0; i < resultString.size(); i++){
            if(resultString.get(i)[1].equals("○"))  win++;
        }
        if (matchNum == 0) {
            return "";
        }
        String tmp = "試合数: " + searchNum + "/" + matchNum + "  試合割合: " + (searchNum * 100 ) / matchNum  + "%  勝ち数: " + win + "  勝率: " + (win * 100) / searchNum + "%";
        return tmp;
    }


    //---------------------ここから関数---------------------//
    class MyTableModel extends DefaultTableModel{
        MyTableModel(String[] columnNames, int rowNum){
            super(columnNames, rowNum);
        }
    
        public Class<?> getColumnClass(int col){
            return getValueAt(0, col).getClass();
        }
    }

    class MyTableCellRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column){
    
            Component renderer = super.getTableCellRendererComponent(
                table, 
                value, 
                isSelected, 
                hasFocus, 
                row, 
                column);
    
            if(value == null){
                return renderer;
            }
            table.getColumnModel().getColumn(column).setCellRenderer(new IconCellRenderer());
            return renderer;
            }
    }

    class IconCellRenderer implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            JLabel label = new JLabel();
        
            Icon icon = (Icon)value;
            label.setIcon(icon);
            label.setOpaque(true);
            if(column < 8){
                switch(SearchPanel.tmpResult.get(row)[2*column-1]){      //2*column-1で自分の選出のセルを持ってこれる
                    case "1": label.setBackground(Color.YELLOW); break;
                    case "2": label.setBackground(Color.ORANGE); break;
                    default: label.setBackground(Color.LIGHT_GRAY); break;
                }
            } else{
                switch(SearchPanel.tmpResult.get(row)[2*column-3]){      //2*column-3で相手の選出のセルを持ってこれる
                    case "1": label.setBackground(Color.YELLOW); break;
                    case "2": label.setBackground(Color.ORANGE); break;
                    default: label.setBackground(Color.LIGHT_GRAY); break;
                }
            }
            return label;
        }        
    }
}
