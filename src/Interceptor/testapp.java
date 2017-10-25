package Interceptor;

public class testapp {

    public static void main(String[] args) {
        System.out.println("main");


        MoveInterceptor interceptor = new MoveInterceptor() {
            Move log = new Move(getClass().getName());

//            System.out.println(log.getClass().getName());
//            System.out.println("in main");

            @Override
            public void errorMessageReceiver(MoveRequest context) {
                log.printError(context.getFinalErrorMessage());
            }
        };
        // Needs to be in void
        MoveDispatcher.getInstance().registerErrorMessageInterceptor(interceptor);

        MoveDispatcher.getInstance().errorMessageReceiver(new ConcreteMove("Invalid direction Input."));
        MoveDispatcher.getInstance().unregisterErrorMessageInterceptor(interceptor);
    }
}
