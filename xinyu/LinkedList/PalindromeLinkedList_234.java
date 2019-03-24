/*Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?*/
public class PalindromeLinkedList_234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head==null)return true;
            ListNode slow = head;
            ListNode fast = head;
            while(fast!=null && fast.next!=null){
                slow= slow.next;
                fast= fast.next.next;
            }
            slow=reverse(slow);
            fast=head;
            while(slow!= null){
                if(slow.val!=fast.val) return false;
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }
        public ListNode reverse (ListNode head) {
            ListNode prev = null;
            while(head!=null){
                ListNode next = head.next;
                head.next=prev;
                prev=head;
                head=next;
            }
            return prev;
        }
    }
}
