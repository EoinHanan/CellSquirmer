//package Interceptor;
//
//public class createInterceptor {
//
//    public Interceptor blah;
//
////    public void createInterceptorNow(String className) {
////        System.out.println("createInterceptor");
////
////
////        Interceptor interceptor = new Interceptor() {
////            MoveRequest request = new MoveRequest(className);
////
////            public void errorMessageReceiver(Context context) {
////                request.printError(context.getFinalErrorMessage());
////            }
////        };
////
////        blah = interceptor;
//
//
////        System.out.println(interceptor);
////        // Needs to be in void
////        Dispatcher dis = new Dispatcher();
////
////        dis.errorMessageReceiver(new ConcreteInterceptor("Invalid direction Input."));
////        dis.unregisterErrorMessageInterceptor(interceptor);
//        //        Dispatcher dis = new Dispatcher();
////        dis.errorMessageReceiver(new ConcreteInterceptor("Invalid direction Input."));
////        dis.unregisterErrorMessageInterceptor(interceptor);
////        Dispatcher.getInstance().registerErrorMessageInterceptor(interceptor);
//
////        Dispatcher.getInstance().errorMessageReceiver(new ConcreteInterceptor("Invalid direction Input."));
////        Dispatcher.getInstance().unregisterErrorMessageInterceptor(interceptor);
//
////        System.out.println(Dispatcher.getInstance());
//
//    }
//    public Interceptor returnInterceptor(){
//        return this.blah;
//    }
//}
