package utility;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public final class Constants{
    public static final boolean DEBUG = true; //デバック情報の表示
    //ファイルパス
    public static final String Path_pokeDex = ".\\..\\database\\text\\pokemon.csv";
    public static final String Path_pokeImage = ".\\..\\database\\image\\icon\\";
    public static final String Path_elect = ".\\..\\database\\image\\elect\\";
    public static final String Path_result = ".\\..\\database\\image\\result\\";
    public static final String Path_formChangeIcon = ".\\..\\database\\image\\formchange\\0.png";
    //選出ボタンに使用する
    public static final Elect[] ELECTS = new Elect[3];
    public static final Result[] WINLOSE = new Result[3];

    //Matcher側から場所を移したもの
    //ファイルパス
    public static final String Path_MyPtData = ".\\myPT.csv";

    public static final int ENTER_BUTTON_WIDTH = 25;
    public static final int ENTER_BUTTON_HEIGHT = 25;
    public static final int PT_ICON_WIDTH = 50;
    public static final int PT_ICON_HEIGHT = 50;
    public static final int PT_TEXT_WIDTH = 100;
    public static final int PT_TEXT_HEIGHT = 20;
    public static final int FORMCHANGE_BUTTON_WIDTH = 30;
    public static final int FORMCHANGE_BUTTON_HEIGHT = 30;
    public static final int WIN_LOSE_BUTTON_WIDTH = 100;
    public static final int WIN_LOSE_BUTTON_HEIGHT = 26;
    public static final String MY_PT = "自分のPT";
    public static final String OPPONENT_PT = "相手のPT";
    public static final String TOD_HP_CALC_PANEL_TITLE = "TODのHP計算";

    //analyzer側から場所を移したもの
    /*
    [0]日付, [1]試合結果
    [2][4][6][8][10][12] MyPTのポケモン名
    [3][5][7][9][11][13] MyPTのそれぞれの選出
    [14][16][18][20][22][24] opponentPTのポケモン名
    [15][17][19][21][23][25] opponentPTのそれぞれの選出
    */
    public static final int[] myPtPokeSelectIdx = {3, 5, 7, 9, 11, 13};
    public static final int[] myPtPokeNameIdx = {2, 4, 6, 8, 10, 12};
    public static final int[] opponentPtPokeNameIdx = {14, 16, 18, 20, 22, 24};
    public static final ArrayList<String[]> AllResultStr = new ArrayList<String[]>(); //対戦結果のリスト
    public static final String[] columnNames = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",};

    //ファイルパス
    public static final String Path_resultData = ".\\resultData.csv";

    static {
        ELECTS[0] = new Elect(0);
        ELECTS[1] = new Elect(1);
        ELECTS[2] = new Elect(2);
        WINLOSE[0] = new Result(0, "");
        WINLOSE[1] = new Result(1, "○");
        WINLOSE[2] = new Result(2, "");

        //試合結果の読み込みを行う
        File f = new File(Path_resultData);
        try (
            BufferedReader br = new BufferedReader(new FileReader(f)); //対戦結果を読み込むのに使用
        ) {
            String line = br.readLine();
            for(; line != null; line = br.readLine()){
                AllResultStr.add(line.split(",", -1));
            }
            br.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}