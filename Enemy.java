package battleship;
import java.util.ArrayList;
import java.util.Random;

public class Enemy {


private String name;
private ArrayList <String> enemyBody = new ArrayList<String>();
private ArrayList <String> enemyBodyPoint = new ArrayList<String>();
private ToolBox tool = new ToolBox();
//改善案：Enemy型の変数を中においてオーバーロードで他のenemyインスタンスを呼び出す

public Enemy(){
    
    String[] names ={"South Carolina","New York","Colorado","Massachusetts","Iowa","Iowa","Missouri","Kongo","Fuso","Nagato","Amagi","Yamato","Bismarck","Tirpitz","King George V","Warspite","Conqueror","Sinop","Vladivostok","Sovetsky Soyuz","Kremlin","Richelieu","Jean Bart","Roma","Gangut","Orion","Mutsu","ArchAngel" };
    Random random =new Random();
    name = names[random.nextInt(names.length)];
}


public ArrayList<String> setEnemy(ArrayList<String> board){
    
    String point[] ={"hoge","hoge","hoge"};
    while(true){
        while( board.contains(point[0]) == false || board.contains(point[1]) ==false || board.contains(point[2])  == false ){
            Random random =new Random();
            int pointInt = random.nextInt(49);
            int direction = random.nextInt(2);
            boolean examinationResult =this.examination(pointInt,direction);
            ArrayList<String> originBoard =tool.initialize();
            if(examinationResult){
                if(direction == 0){
                    point[1] = (String)originBoard.get(pointInt);
                    try{
                        point[0] = (String)originBoard.get(pointInt-1);
                    }catch(Exception E){
                        continue;
                    }
                    try{
                        point[2] = (String)originBoard.get(pointInt+1);
                    }catch(Exception E){
                        continue;
                    }
    
                    
                }else{
                    point[1] = (String)originBoard.get(pointInt);
                    try{
                        point[0] = (String)originBoard.get(pointInt-7);
                    }catch(Exception E){
                        continue;
                    }
                    try{
                        point[2] = (String)originBoard.get(pointInt+7);
                    }catch(Exception E){
                        continue;
                    }
                }
            }
        }
        try{
            for(String enemyPoint :point){
                String enemyPointE =tool.strBuilder(enemyPoint,"E");
                enemyBody.add(enemyPointE);
                enemyBodyPoint.add(enemyPointE);
                board.set(board.indexOf(enemyPoint),enemyPointE);
                
            }
            break;
        }catch(Exception E){
            
        }
    }
    
    
    return board;
}

private boolean examination(int pointInt , int direction){
    
    ArrayList <String> verticalEnemyError = new ArrayList<String>();
    verticalEnemyError.add("A");
    verticalEnemyError.add("G");
    ArrayList <String> horizontalEnemyError = new ArrayList<String>();
    horizontalEnemyError.add("1");
    horizontalEnemyError.add("7");
    ArrayList<String> board =tool.initialize();
    String point;
    if(direction==0){
        
            point=tool.getAddress(board.get(pointInt) );
        
        /*try{
            point[0]=tool.getAddress(board.get(pointInt-1) );
        }catch(Exception e){
            return false;
        }
        try{
            point[1]=tool.getAddress(board.get(pointInt+1) );
        }catch(Exception e){
            return false;
        }*///違う値を取っていたのでコメントアウト

        if(horizontalEnemyError.contains(point) ){
            return false;
        }else{
            return true;
        }
    }else{
        point=tool.getAddress(board.get(pointInt) );
        /*try{
            point[0]=tool.getAddress(board.get(pointInt-7) );
        }catch(Exception e){
            return false;
        }
        try{
            point[1]=tool.getAddress(board.get(pointInt+7) );
        }catch(Exception e){
            return false;*///違う値を取っていたのでコメントアウト
        
        if(verticalEnemyError.contains(point)  ){
            return false;
        }else{
            return true;
        }
    }
    
}

public  boolean destroy(){
    
    if(enemyBody.size() == 0){
        return true;
    }
    return false;
}

public boolean destroy(String choise){
    
    if(enemyBody.contains(choise) ){
        if(enemyBody.size()==1){
            System.out.println( " Enemy Battleship Sunk!!!" + "  ("+name+")");
            enemyBody.remove(choise);
            return true;
        }
        enemyBody.remove(choise);
    }
    return false;
}

public boolean enemyHere(String point){
    
    if(enemyBody.contains(point) ){
        return true;
    }
    return false;
}
public boolean enemyPointHere(String point){
    
    if(enemyBodyPoint.contains(point) ){
        return true;
    }
    return false;
}

}