package Character;

/*
Created by KieranF on 24/10/17
 */
public interface Originator {
    void restore(Memento m);
    Memento createMemento();
}
