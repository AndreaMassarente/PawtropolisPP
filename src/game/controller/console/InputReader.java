
package game.controller.console;

import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log
public class InputReader {
    // non ci interessa istanziare questa classe, ne usiamo solo i metodi static stateless
    private InputReader() {
    }

    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            log.log(Level.WARNING,"Error while reading user input");
            return "";
        }
    }
}
