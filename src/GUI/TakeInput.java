package GUI;

import java.util.Scanner;

public class TakeInput {

    public String userinput (){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Command:");
        String command = sc.nextLine();

        return command;
    }
}

