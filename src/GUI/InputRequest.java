package GUI;

import Interceptor.Request;

/**
 * Created by EoinH on 04/11/2017.
 */
public class InputRequest implements Request {
    private boolean combat;
    private String input;

    public InputRequest(String input, boolean combat){
        this.input = input;
        this.combat = combat;
    }

    public boolean getCombat(){return combat;}
    public void setCombat(boolean combat){
        this.combat = combat;
    }

    public String getInput(){return input;}
    public void setInput(String input){
        this.input = input;
    }
    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public void setFinalErrorMessage(String finalMessage) {

    }

    @Override
    public String getFinalErrorMessage() {
        return null;
    }
}