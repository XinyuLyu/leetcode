/*Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:





Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.*/
public class DeleteNodeinaLinkedList_237 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ListNode node) {
            node.val=node.next.val;
            node.next=node.next.next;
        }
    }
        /*
        if(head.val == node.val) {
            head=head.next;
            return;
        }
        ListNode current= head;
        ListNode previous = head;
        while(current.next!=null){
            if(current.val==node.val)
                break;
            else{
                previous = current;
                current=currnet.next;
            }
        }
        previous.next=current.next;
        return;
    }*/

}