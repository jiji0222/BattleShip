package battleship;

import java.io.IOException;

public class TaskKill{//���̃N���X�͌��main�ɓ���Ă���������
    public TaskKill() throws IOException{
        String[] Command = {"cmd","/c","exit"};
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(Command);
    }
}