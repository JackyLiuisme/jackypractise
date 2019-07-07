package company.practise18;

import java.util.*;

public class Pinduoduo2018c {
     static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<LinkedList<Integer> >linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++){
            LinkedList<Integer> list = new LinkedList<>();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(x);
            list.add(y);
            linkedList.add(list);
        }
        LinkedList<LinkedList<Integer> >list = new LinkedList<>();
        isTarget(linkedList,0,list);
        System.out.println(count);
    }

    public static void isTarget( LinkedList<LinkedList<Integer> > lists,int index,
                          LinkedList<LinkedList<Integer> > list){
        if (list.size() == 3){
            Iterator<LinkedList<Integer>> iterator = list.iterator();
            LinkedList<Integer> node1 = iterator.next();
            LinkedList<Integer> node2 = iterator.next();
            LinkedList<Integer> node3 = iterator.next();
            if (!isNode( node1,node2,node3) ){
                count++;
            }
            return;
        }
        int length = lists.size();
        int i = index;
        for (; i < length; i++){
            list.add(lists.get(i));
            isTarget(lists,i+1,list);
            list.remove(lists.get(i));
        }
    }
    public static boolean isNode(LinkedList<Integer> node1,LinkedList<Integer> node2,LinkedList<Integer> node3){
        int x1 = node1.get(0),y1 = node1.get(1);
        int x2 = node2.get(0),y2 = node2.get(1);
        int x3 = node3.get(0),y3 = node3.get(1);

        if((x1-x2)*(y1-y3) == (x1 - x3)*(y1 - y2)){
            return true;
        }else {
            return false;
        }
    }
}
