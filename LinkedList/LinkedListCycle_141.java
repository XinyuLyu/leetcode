/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?*/
public class LinkedListCycle_141 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next==null) return false;
            ListNode fast = head.next;
            ListNode slow = head;
            while(slow != fast){
                if(fast == null || fast.next == null) return false;
                fast = fast.next.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
