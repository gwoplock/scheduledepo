package org.gwoplock.scheduledepo;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        File toRead = null;
        if (args.length == 0) {
            toRead = new File("./sched.html");
        } else {
            toRead = new File(args[0]);
        }
        try {
            SchedulePage page = new SchedulePage(toRead);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
