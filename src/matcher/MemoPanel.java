package matcher;

//定数ファイルの読み込み
import javax.swing.*;
import java.awt.*;


class MemoPanel /*extends JFrame implements ActionListener*/{
    JPanel ret_panel = new JPanel(new FlowLayout());
    int hight = 17;
    int width = 23; //frameが500の時，2つのメモ欄を並べられる最大数
    JTextArea memo_area_left = new JTextArea(hight, width);     //試合中のみのメモ欄
    JTextArea memo_area_right = new JTextArea(hight, width);    //アプリ起動中はそのまま
    public JPanel create_panel(){
        create_panel_layout();
        return ret_panel;
    }

    public void create_panel_layout(){
        JLabel jlabel_memo_title_left = new JLabel("試合Memo");
        jlabel_memo_title_left.setHorizontalAlignment(JLabel.CENTER);
        JLabel jlabel_memo_title_right = new JLabel("所感Memo");
        jlabel_memo_title_right.setHorizontalAlignment(JLabel.CENTER);
        JPanel panel_left = new JPanel(new BorderLayout());
        JPanel panel_right = new JPanel(new BorderLayout());
        panel_left.add("North", jlabel_memo_title_left);
        panel_left.add("Center", memo_area_left);
        panel_right.add("North", jlabel_memo_title_right);
        panel_right.add("Center", memo_area_right);
        ret_panel.add(panel_left);
        ret_panel.add(panel_right);
    }

    public void text_clear(){
        memo_area_left.setText("");
    }
}