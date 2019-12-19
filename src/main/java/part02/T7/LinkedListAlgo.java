package part02.T7;

public class LinkedListAlgo {

    public static Node reverse(Node list){
        Node curr = list, pre = null;
        while (curr!=null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static boolean checkCircle(Node list){
        if (list == null)return false;

        Node fast = list.next;
        Node slow = fast;

        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast)return true;
        }
        return false;
    }

    public static Node deleteLastKth(Node list,int k){
        Node fast = list;
        int i = 1;

        while (fast!=null && i<k){
            fast = fast.next;
            ++i;
        }
        if (fast==null)return list;

        Node slow = list;
        Node prev = null;

        while (fast.next!=null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev==null){
            list=list.next;
        }else {
            prev.next = prev.next.next;
        }
        return list;
    }

    public static Node findMiddleNode(Node list){
        if (list==null)return null;
        Node fast = list;
        Node slow = list;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1!=null){
            p.next=l1;
        }
        if (l2!=null){
            p.next=l2;
        }
        return soldier.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }


    public static void printAll(Node list){
        Node p = list;
        while (p!=null){
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node fri = new Node(5,null);
        Node thi = new Node(4,fri);
        Node fir = new Node(3,thi);
        Node sec = new Node(2,fir);
        Node list = new Node(1,sec);
        LinkedListAlgo.printAll(list);
        System.out.println("-------------");
        LinkedListAlgo.printAll(LinkedListAlgo.reverse(list));
    }




    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }



}
