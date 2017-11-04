package Interceptor;

public class testapp {

    public static void main(String[] args) {
        System.out.println("main");


        Interceptor interceptor = new Interceptor() {
            Move log = new Move(getClass().getName());

//            System.out.println(log.getClass().getName());
//            System.out.println("in main");

            @Override
            public void errorMessageReceiver(Request context) {
                log.printError(context.getFinalErrorMessage());
            }
        };
        // Needs to be in void
        Dispatcher.getInstance().registerErrorMessageInterceptor(interceptor);

        Dispatcher.getInstance().errorMessageReceiver(new ConcreteMove("Invalid direction Input."));
        Dispatcher.getInstance().unregisterErrorMessageInterceptor(interceptor);
    }
}
