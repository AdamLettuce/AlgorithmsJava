package datastructures.array;

public class Array {
    private int count = 0;
    private int[] data;

    public Array(int size) {
        data = new int[size];
    }

    public void insert(int item) {
        if(count==data.length) {
            int[] newData = new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[count++]=item;
    }

    public void removeAt(int index) {
        if(index>=0 && index<count) {
            for (int i = index; i < count-1; i++) {
                data[i] = data[i+1];
            }
            --count;
        }
    }

    public int indexOf(int item) {
        int i =0;
        while (i<count && data[i]!=item) {
            ++i;
        }
        if(i==count) {
            return -1;
        }
        return i;
    }

    public static void main(String[] args) {
        Array a = new Array(3);
        a.insert(1);
        a.insert(2);
        a.insert(3);
//        a.insert(4);
//        a.insert(5);
        a.print();
        System.out.println(a.indexOf(3));
        System.out.println(a.indexOf(7));

        System.out.println("remove at");
//        a.removeAt(0);
//        a.removeAt(3);
//        a.removeAt(1);
//        a.removeAt(0);
//        a.removeAt(0);
a.removeAt(2);
        a.print();
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }
}
