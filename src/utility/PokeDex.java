//--- ポケモンの図鑑データを管理 ---//
package utility;

//定数ファイルの読み込み
import static utility.Constants.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//--- ファイルパス ---//

public class PokeDex  {
    private PokeDex(){} //インスタンスを作れないようにする

    public static ArrayList<Poke> pokeDex = new ArrayList<Poke>();
    public static ArrayList<Elect> elect = new ArrayList<Elect>();
    public static ArrayList<Result> result = new ArrayList<Result>();

    //クラス生成時にpokemon.csv(データベース)を読み込む
    static {
        //poken.csvからの読み込み
        try{
            File file = new File(Path_pokeDex);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                //↓ -1は制限なし　cf:https://www.javadrive.jp/start/string_class/index5.html
                String[] pokeInfoArray = line.split(",", -1);
                Poke tmp = new Poke(pokeInfoArray[0], pokeInfoArray[1], pokeInfoArray[2], pokeInfoArray[3]);
                pokeDex.add(tmp);
            }
            br.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }

    //名前から必要なPokeを読み込む
    public static Poke SearchPoke(String name){
        Poke poke = new Poke();
        for(int i = 0; i < pokeDex.size(); i++){
            if((pokeDex.get(i).getName()).equals(name)){
                poke = pokeDex.get(i);
                break;
            } 
        }
        return poke;
    }

    //図鑑番号から必要なPokeを読み込む
    public static Poke SearchPoke(char[] num){
        String str = String.valueOf(num);
        Poke poke = null;
        for(int i = 0; i < pokeDex.size(); i++){
            if((pokeDex.get(i).getNum()).equals(str)){
                poke = pokeDex.get(i);
                break;
            } 
        }
        return poke;
    }
}