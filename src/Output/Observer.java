package Output;

public interface Observer {

    //update observer from subject
    void update();

    //attache subject
    void setSubject(Subject sub);
}