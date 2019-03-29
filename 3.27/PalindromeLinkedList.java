public class PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
/*
class Solution {
    public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
        return false;
}
}*/
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode prev = null;
            ListNode f = head;
            ListNode s = head;
            while( f!=null && f.next!=null){
                f=f.next.next;
                ListNode next = s.next;
                s.next=prev;
                prev=s;
                s=next;
            }
            if(f!=null){
                s=s.next;
            }
            while(s != null){
                if(s.val!=prev.val) return false;
                else {
                    s=s.next;
                    prev=prev.next;
                }
            }
            return true;
        }
    }

}
