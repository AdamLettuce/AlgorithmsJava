package leetcode.hard;

public class MergeKLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }

        ListNode it = new ListNode();
        ListNode r = it;

        do {
            int min = 10001;
            int minI = -1;
            ListNode minNode = null;
            for(int i=0;i<lists.length;++i) {
                if(lists[i]!=null && lists[i].val<min) {
                    minNode = lists[i];
                    min = minNode.val;
                    minI = i;
                }
            }

            it.next = minNode;


            if(minNode==null) {
                break;
            }

            lists[minI] = lists[minI].next;
            it = it.next;


        } while(true);

        return r.next;
    }

}


/*
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}