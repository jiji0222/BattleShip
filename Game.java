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
        //�Q�[���J�n
        //��ӏ��Ƃ�ł�D�����݂���@�����ς�
        board = tool.initialize();
        enemyA =new Enemy(); //�^�񒆂������Ă�ꍇ����
        board = enemyA.setEnemy(board);
        enemyB =new Enemy();
        board = enemyB.setEnemy(board);
        enemyC =new Enemy();
        board = enemyC.setEnemy(board);

    }
    
    
  
    
    
    
    
    public int check(String choise){
        //�I�������R�}�𔻒肵�Č��ʂ�\��    reload�Ƌ��ʉ��o���邩��
        //�G�Ȃ�q�b�g�Ō��j������Ă�
        //������ꍇ��0��Ԃ�  
        String choiseE=tool.strBuilder(choise,"E");
        if(board.contains(choise) ){
            board.remove(choise);
            if(this.enemyClose(choise)){
                System.out.println("�@CLOSE  (Enemy is in TOP or BOTTOM or LEFT or RIGHT)");
                return 0;
            }else{
                System.out.println("�@MISS");
                return 0;
            }
        }
        if(board.contains(choiseE) ){
            board.remove(choiseE);
            System.out.println("�@Hit!!");
            //���j����A 
            enemyA.destroy(choiseE);
            //���j����B 
            enemyB.destroy(choiseE);
            //���j����C�@
            enemyC.destroy(choiseE);
            return 0;
        }
        if(choise.equals("ALL")){//�f�o�b�O�p
            board.clear();
            this.reload();
            enemyA =new Enemy();
            enemyB =new Enemy();
            enemyC =new Enemy();
            System.out.println("�@I don't like intuitive kids");
            return 0;
        }
        System.out.println("�@MISS  Stupid should be aimed well !!!");
        return 0;
    }
    private boolean enemyClose(String choise){
        //���͂S�}�X�̓G�̗L����Ԃ�OK 
        //�A������ł�G�ɂ��������Ă�H  �����܂�
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
        //�Q�[�����I������������B�I�������ture
         if(enemyA.destroy() && enemyB.destroy() && enemyC.destroy() ){
             return true;
         }
        return false;
    }

//-------------------------------------------------------------------------------------------

    public void reload(){
        //�\�����X�V
        /*
        ���������ς�������͉��s����OK
        ���I���ƑI���ς݂̃}�X����ʂ���OK
        ������ƃn�Y������ʂ���OK
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
                
                    //���������ς������
                    System.out.println(" "+initialList[initialCount]);
                    System.out.print("  ");
                    initialCount++;
                }
            }catch(Exception e){/*�������Ȃ�*/}
            if(board.contains( originBoard.get(i) ) ){//���I���̎�
                System.out.print("_");
                continue;
            }
            if(board.contains( getIAndE)){//���I���̎�2
                System.out.print("_");
                continue;
            }
            if(enemyA.enemyPointHere(getIAndE)){//���������}�XA 
                System.out.print("H");
                continue;
            }
            if(enemyB.enemyPointHere(getIAndE)){//���������}�XB
                System.out.print("H");
                continue;
            }
            if(enemyC.enemyPointHere(getIAndE)){//���������}�XC
                System.out.print("H");
                continue;
            }
            System.out.print("M");//�n�Y�����}�X
            
        }
        System.out.println(" G");
        System.out.println("  1234567");

    }
    
    
    
    
    
    public int enemyCount(){
        //�c��G����\��
        /*
        �ŏ��ɓG����\������OK
        �G�����������琔�����炷NO destroy()���������ĂȂ��\������
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

