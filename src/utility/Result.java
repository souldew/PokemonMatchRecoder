package utility;

//定数ファイルの読み込み
import static utility.Constants.*;

import javax.swing.ImageIcon;

public class Result{
    private int num;
    private String mark;
    private ImageIcon icon;

    Result(int num, String mark){
        this.num = num;
        this.mark = mark;
        this.icon = new ImageIcon(Path_result + num + ".png");
    }

    // ゲッタ
    public int getNum(){ return num; }
    public String getMark(){ return mark; }
    public ImageIcon getIcon(){ return icon; }
}