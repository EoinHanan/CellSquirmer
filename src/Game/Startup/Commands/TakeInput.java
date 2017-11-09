package Game.Startup.Commands;

import java.util.Scanner;

/**
 * Created by EoinH on 08/11/2017.
 */
public class TakeInput {

    public String userinput (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Command");
        String command = sc.nextLine();

        return command;
    }
}

