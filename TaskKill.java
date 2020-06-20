package battleship;

import java.io.IOException;

public class TaskKill{//‚±‚ÌƒNƒ‰ƒX‚ÍŒã‚Åmain‚É“ü‚ê‚Ä‚à‚¢‚¢‚©‚à
    public TaskKill() throws IOException{
        String[] Command = {"cmd","/c","exit"};
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(Command);
    }
}