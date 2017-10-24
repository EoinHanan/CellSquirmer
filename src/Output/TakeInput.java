package Output;

import java.util.Scanner;

public class TakeInput {

    public String userinput (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Command");
        String command = sc.nextLine();

        return command;
    }
}

