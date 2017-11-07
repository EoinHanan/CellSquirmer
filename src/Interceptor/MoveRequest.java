package Interceptor;

public class MoveRequest {

    public MoveRequest(String classname){
        System.out.println("In MoveRequest");
    }


    public void printError(String message){

        System.out.println(message);

    }
}
