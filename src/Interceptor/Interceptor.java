package Interceptor;
import Character.CheckpointCaretaker;
import Game.Play;

//@FunctionalInterface
public interface Interceptor {

    //    @Override
    void errorMessageReceiver(Context context);

    void updateMomento(ConcreteMomentoInterceptor play);
}
