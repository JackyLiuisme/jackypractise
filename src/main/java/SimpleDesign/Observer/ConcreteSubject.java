package SimpleDesign.Observer;

public class ConcreteSubject extends Subject {

    public String getSubjectState() {
        return super.subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
