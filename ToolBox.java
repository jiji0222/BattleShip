package battleship;
import java.util.ArrayList;

public class ToolBox {
    
    
    public ArrayList<String> initialize(){
        //配列を初期化
        ArrayList <String> board =new ArrayList<String>();
        //int squareCount=0;
        for(int Count=1; Count <= 7; Count++){
            board.add("A"+Count);
            //squareCount++;
        }
        for(int Count=1; Count <= 7; Count++){
            board.add("B"+Count);
            //squareCount++;
        }
        for(int Count=1; Count <= 7; Count++){
            board.add("C"+Count);
            //squareCount++;
        }
        for(int Count=1; Count <= 7; Count++){
            board.add("D"+Count);
            //squareCount++;
        }
        for(int Count=1; Count <= 7; Count++){
            board.add("E"+Count);
            //squareCount++;
        }
        for(int Count=1; Count <= 7; Count++){
            board.add("F"+Count);
            //squareCount++;
        }
        for(int Count=1; Count <= 7; Count++){
            board.add("G"+Count);
            //AsquareCount++;
        }
        return board;
    }      

    public String strBuilder(String S1,String S2){
        StringBuilder B1 =new StringBuilder();
        B1.append(S1);
        B1.append(S2);
        return B1.toString();
    }

    public String getInitial(String Word){
        char initial = Word.charAt(0);
        return String.valueOf(initial);
    }


    public String getAddress(String Word){
        char initial = Word.charAt(1);
        return String.valueOf(initial);
    }

    public String[] near(String Choise){
        //指定したマスの四方を返す。エラーなら指定した文字を返す
        ArrayList<String> board =this.initialize();
        int choiseAddress = board.indexOf(Choise);
        String[] nears = new String [4];
        try{
        nears[0] = strBuilder( board.get(choiseAddress -7),"E");
        }catch(Exception e){
            nears[0]=Choise;
        }
        try{
        nears[1]=strBuilder( board.get(choiseAddress -1),"E");
        }catch(Exception e){
            nears[1]=Choise;
        }
        try{
        nears[2]=strBuilder( board.get(choiseAddress +1),"E");
        }catch(Exception e){
            nears[2]=Choise;
        }
        try{
        nears[3]=strBuilder( board.get(choiseAddress +7),"E");
        }catch(Exception e){
            nears[3]=Choise;
        }
        return nears;
    }
}