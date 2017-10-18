package Character;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

/**
 * Created by Patrick on 18/10/2017.
 */
public class CharacterProxy extends Colleague {

        public CharacterProxy(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {

    }
}