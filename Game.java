package battleship;
import java.util.ArrayList;

public class Game {
    private ArrayList<String> board = new ArrayList<String>();
    private Enemy enemyA;
    private Enemy enemyB;
    private Enemy enemyC;
    private ToolBox tool =new ToolBox();
    
    public void setBoard(ArrayList<String> board){
        this.board = board;
    }
    
    public ArrayList<String> getBoard(){
        //ArrayList <String> copyBoard = (ArrayList<String>)board.clone();
        return board;
    }
    
    public Game(){
        //ゲーム開始
        //一箇所とんでる船が存在する　解消済み
        board = tool.initialize();
        enemyA =new Enemy(); //真ん中が抜けてる場合あり
        board = enemyA.setEnemy(board);
        enemyB =new Enemy();
        board = enemyB.setEnemy(board);
        enemyC =new Enemy();
        board = enemyC.setEnemy(board);

    }
    
    
  
    
    
    
    
    public int check(String choise){
        //選択したコマを判定して結果を表示    reloadと共通化出来るかも
        //敵ならヒットで撃破判定を呼ぶ
        //抜ける場合は0を返す  
        String choiseE=tool.strBuilder(choise,"E");
        if(board.contains(choise) ){
            board.remove(choise);
            if(this.enemyClose(choise)){
                System.out.println("　CLOSE  (Enemy is in TOP or BOTTOM or LEFT or RIGHT)");
                return 0;
            }else{
                System.out.println("　MISS");
                return 0;
            }
        }
        if(board.contains(choiseE) ){
            board.remove(choiseE);
            System.out.println("　Hit!!");
            //撃破判定A 
            enemyA.destroy(choiseE);
            //撃破判定B 
            enemyB.destroy(choiseE);
            //撃破判定C　
            enemyC.destroy(choiseE);
            return 0;
        }
        if(choise.equals("ALL")){//デバッグ用
            board.clear();
            this.reload();
            enemyA =new Enemy();
            enemyB =new Enemy();
            enemyC =new Enemy();
            System.out.println("　I don't like intuitive kids");
            return 0;
        }
        System.out.println("　MISS  Stupid should be aimed well !!!");
        return 0;
    }
    private boolean enemyClose(String choise){
        //周囲４マスの敵の有無を返すOK 
        //但し死んでる敵にも反応してる？  →たまに
        String[] nears =tool.near(choise);
        for(String point : nears){
            if(enemyA.enemyHere(point) ){
                return true;
            }
            if(enemyB.enemyHere(point) ){
                return true;
            }
            if(enemyC.enemyHere(point) ){
                return true;
            }
        }
        return false;

    }
    
    public boolean finish(){
        //ゲームが終了したか判定。終わったらture
         if(enemyA.destroy() && enemyB.destroy() && enemyC.destroy() ){
             return true;
         }
        return false;
    }

//-------------------------------------------------------------------------------------------

    public void reload(){
        //表示を更新
        /*
        頭文字が変わった時は改行するOK
        未選択と選択済みのマスを区別するOK
        当たりとハズレを区別するOK
         */
        ArrayList <String> originBoard = tool.initialize();
        String[] initialList ={"A","B","C","D","E","F","G"};
        int initialCount = 0;
        for(int i=0; i<49; i++){
            String getIAndE =tool.strBuilder(originBoard.get(i),"E");
            String nowPoint =tool.getInitial( originBoard.get(i) );
            if(i==0){
                System.out.print("  ");
            }
            try{
                if(nowPoint.equals(tool.getInitial( originBoard.get(i-1) )) ==false){
                
                    //頭文字が変わった時
                    System.out.println(" "+initialList[initialCount]);
                    System.out.print("  ");
                    initialCount++;
                }
            }catch(Exception e){/*何もしない*/}
            if(board.contains( originBoard.get(i) ) ){//未選択の時
                System.out.print("_");
                continue;
            }
            if(board.contains( getIAndE)){//未選択の時2
                System.out.print("_");
                continue;
            }
            if(enemyA.enemyPointHere(getIAndE)){//命中したマスA 
                System.out.print("H");
                continue;
            }
            if(enemyB.enemyPointHere(getIAndE)){//命中したマスB
                System.out.print("H");
                continue;
            }
            if(enemyC.enemyPointHere(getIAndE)){//命中したマスC
                System.out.print("H");
                continue;
            }
            System.out.print("M");//ハズレたマス
            
        }
        System.out.println(" G");
        System.out.println("  1234567");

    }
    
    
    
    
    
    public int enemyCount(){
        //残り敵数を表示
        /*
        最初に敵数を表示するOK
        敵数が減ったら数を減らすNO destroy()が反応してない可能性あり
        */
        int enemyCount=3;
        if(enemyA.destroy() ){
            enemyCount = enemyCount-1;
        }
        if(enemyB.destroy() ){
            enemyCount--;
        }
        if(enemyC.destroy() ){
            enemyCount--;
        }
        return enemyCount;
    }
    
    
}

