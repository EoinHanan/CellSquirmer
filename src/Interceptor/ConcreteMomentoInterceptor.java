package Interceptor;
import Character.CheckpointCaretaker;

/**
 * Created by Patrick on 07/11/2017.
 */
public class ConcreteMomentoInterceptor implements ContextMomento {


        private CheckpointCaretaker object;
        private int x;
        private int y;


        private String finalErrorMessage = "";


        public ConcreteMomentoInterceptor(CheckpointCaretaker object) {
            this.object = object;

        }


        @Override
        public CheckpointCaretaker getErrorMessage() {
            return object;
        }

        @Override
        public void setFinalErrorMessage(String finalMessage){
            this.finalErrorMessage = finalMessage;
        }

        @Override
        public CheckpointCaretaker getFinalErrorMessage() {
            return object;
        }

        public void setX(int X){ x = X; }

        public void setY(int Y ){y = Y;}

        public int getX(){

            return object.getXValue(); }

        public int getY(){ return object.getYValue();}



    }

