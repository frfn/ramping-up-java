package Leetcode;



public class Easy_MergeSortedLinkedList {

    public static void main(String[] args) {

        ListNode one = new ListNode(1);


        ListNode two = new ListNode(1);
        two.next = new ListNode(3);
        two.print(two);

        System.out.println("\nSorted");

        ListNode sorted = one.mergeTwoLists(one, two);
        sorted.print(sorted);


    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int data) {
            this.val = data;
        }

        public ListNode() {
            val = 0;
        }

        public ListNode getNext() {
            return next;
        }

        ////

        public void print(ListNode node){
            while(node != null){
                System.out.print(node.val + ", ");
                node = node.next;
            }
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode sortedNode = new ListNode(0);
            ListNode temp = sortedNode;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            }
            // this makes sense, since the list already moved up, just append the remainder since it is already sorted!
            temp.next = l1 == null ? l2 : l1;

//            while (l1 != null) {
//                temp.next = l1;
//                l1 = l1.next;
//                temp = temp.next;
//            }
//            while (l2 != null) {
//                temp.next = l2;
//                l2 = l2.next;
//                temp = temp.next;
//            }
            return sortedNode.next;
        }
    }
}

