package game.controllers.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            System.err.println("Error while reading user input");
            return "";
        }
    }
}
