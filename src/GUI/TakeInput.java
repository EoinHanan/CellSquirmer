package GUI;

import java.util.Scanner;

public class TakeInput {
    private boolean inCombat;

    public InputRequest userinput (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Command");
        String command = sc.nextLine();
        InputRequest input = new InputRequest(command,inCombat);

        return input;
    }
    public void setInCombat(boolean inCombat){
        this.inCombat = inCombat;
    }
}

