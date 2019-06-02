package SimpleDesign.Observer;

import java.util.LinkedList;
import java.util.List;

public  class Subject {
    public String subjectState;

    List<Observer> list = new LinkedList<>();
        public void Attach(Observer observer){
            list.add(observer);
        }
        public void Detach(Observer observer){
            list.remove(observer);
        }

        public void Notify(){
            for (Observer o :
                    list) {
                o.update(this);
            }
        }
}
