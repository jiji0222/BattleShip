package battleship;

import java.io.IOException;

public class TaskKill{//このクラスは後でmainに入れてもいいかも
    public TaskKill() throws IOException{
        String[] Command = {"cmd","/c","exit"};
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(Command);
    }
}