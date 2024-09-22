package utility;

//定数ファイルの読み込み
import static utility.Constants.*;

import javax.swing.ImageIcon;

public class Poke{
    private String num, name, type1, type2;
    private ImageIcon icon;

    Poke(){
        this.num = null;
        this.name = null;
        this.type1 = null;
        this.type2 = null;
        this.icon = null;
    }

    Poke(String num, String name,String type1, String type2){
        this.num = num;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.icon = new ImageIcon(Path_pokeImage + num + ".png");
    }

    // ゲッタ
    public String getNum(){ return num; }
    public String getName(){ return name; }
    public String getType1(){ return type1; }
    public String getType2(){ return type2; }
    public ImageIcon getIcon(){ return icon; }
}