//package Interceptor;
//
//public class testapp {
//
//    public static void main(String[] args) {
//        System.out.println("main");
//
//        LogMove valid = new LogMove("directionInterceptor");
//
//        Context t = new ConcreteInterceptor("error");
//        Dispatcher.getInstance().registerErrorMessageInterceptor(Context);

//                    public void errorMessageReceiver(Interceptor.RequestInterceptor context) {
//                valid.printError(context.getFinalErrorMessage());
//            }


//        Interceptor interceptor = new Interceptor() ;
//        {
//            Interceptor.LogMove valid = new Interceptor.LogMove(getClass().getName());
//
//            @Override
//            public void errorMessageReceiver(Interceptor.RequestInterceptor context) {
//                valid.printError(context.getFinalErrorMessage());
//            }
//        };
//        // Needs to be in void
//        Dispatcher.getInstance().registerErrorMessageInterceptor(interceptor);
//
//        Dispatcher.getInstance().errorMessageReceiver(new Interceptor.ConcreteInterceptor("Invalid Input."));
//        Dispatcher.getInstance().unregisterErrorMessageInterceptor(interceptor);
//    }
//}
