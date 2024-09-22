package utility;

//定数ファイルの読み込み
import static utility.Constants.*;

import javax.swing.ImageIcon;


//0:非選出　1:選出(後発)　2:先発
public class Elect{
    private int num;
    private ImageIcon icon;     //matcherの○,★のイメージ

    Elect(int num){
        this.num = num;
        this.icon = new ImageIcon(Path_elect + num + ".png");
    }

    //ゲッタ
    public int getNum(){ return num; }
    public ImageIcon getIcon(){ return icon; }
}