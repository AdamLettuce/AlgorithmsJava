package datastructures.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        System.out.println(l);

        LinkedList<String> r = new LinkedList<>();
        Iterator<String> li = l.iterator();
        while(li.hasNext()) {
            r.addFirst(li.next());
        }
        System.out.println(r);
    }
}
