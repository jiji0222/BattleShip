package battleship ;

import java.io.IOException;
import java.util.Scanner;

public class BattleShipMain{
    public static void main(String[] args){
        boolean roop =true;
        while(roop){
            Game game = new Game();
            int turn = 0;
            
            
            while(game.finish() == false){
                game.reload();
            System.out.println("  Please select an attack cell (ForExample:D6)"+"   "+"Remaining enemies   "+game.enemyCount() );
            System.out.print("  ");
            Scanner scanner = new Scanner(System.in);//�W�����͂͌�ł��g���̂ŕ��Ȃ�
            String choise = scanner.nextLine();
            //System.out.println(choise);
            game.check(choise);
            /*if(battleShip.finish())
            {
                    scanner.close();
            }*/
            turn++;
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" Finish!");
        System.out.println(" YOU WIN");
        int Score = 49-turn;
        System.out.println(" Score" + " " + Score );
        System.out.println(" Please input F or R  ");
        Scanner ForR = new Scanner(System.in);
        String strForR = ForR.nextLine();
        String F = "F";
        String f = "f";
        if(F.equals(strForR) ||f.equals(strForR) ){
            
            ForR.close();
            roop=false;
            try{
                TaskKill taskKill =new TaskKill();//�K�v�ȏ����̓R���X�g���N�^�Ŏ��s
            
            }catch(IOException e){
                //�������Ȃ��B�G���[�ŗ�����͕̂s�C���Ȃ̂ňꉞ
            }
            
         }
        }
        
    }
}