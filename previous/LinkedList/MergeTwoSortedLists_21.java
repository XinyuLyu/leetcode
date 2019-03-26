/*21. Merge Two Sorted Lists
Easy

2007

279

Favorite

Share
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/
public class MergeTwoSortedLists_21 {/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                current.next =new ListNode(l1.val);
                l1=l1.next;
            }else{
                current.next =new ListNode(l2.val);
                l2=l2.next;
            }
            current=current.next;
        }
        if(l1!=null){
            current.next=l1;
        }
        if(l2!=null){
            current.next=l2;
        }
        return dummy.next;
    }
}
}
