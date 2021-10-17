package console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner  input = new Scanner (System.in);
    public static void main(String[] args) {
        Game game = null;
        try {

            game = parseArgs(args);
        }
        catch(NumberFormatException e){
            System.out.println("Incorrect integer values in command line arguments: " + Arrays.toString(args));
            System.exit(1);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        for(;;) {
            System.out.println(game);

            String cmdLine = input.nextLine().trim();
            if(cmdLine.equals("quit")){
                break;
            }
            ArrayList<String > cmdArgs = new ArrayList<>();
            Scanner cmdInput = new Scanner(cmdLine);
            String firstArg = cmdInput.next();
            switch(firstArg){
                case "left":
                    int row = cmdInput.nextInt();
                    int col = cmdInput.nextInt();
                    game.left(row,col);

                    break;
                case "right":
                    break;


            }

        }
    }

    static Game parseArgs(String [] args ){
        int width = 9;
        int height = 9;
        int mines = 10;

        if(args.length == 0) {
            return new Game(height, width, mines);
        }
        if (args.length == 3) {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
            mines = Integer.parseInt(args[2]);
            return new Game(height, width, mines);
        }


        throw new RuntimeException("Incorrect number of command lines arguments");




    }

}


