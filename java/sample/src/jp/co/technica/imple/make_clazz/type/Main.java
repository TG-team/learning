package jp.co.technica.imple.make_clazz.type;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Command> commands = new ArrayList<Command>() {
            {
                add(Command.DIR);
                add(Command.IP_ADDRESS);
            }
        };

        for (Command command : commands) {
            command.execute();
        }
    }
}
