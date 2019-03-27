public class addTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode c1 = l1;
            ListNode c2 = l2;
            int sum=0;
            ListNode zero = new ListNode(0);
            ListNode st = zero;
            while(c1!=null|| c2!=null){
                if(c1!=null) {
                    sum+=c1.val;
                    c1=c1.next;
                }
                if(c2!=null) {
                    sum+=c2.val;
                    c2=c2.next;
                }
                ListNode node = new ListNode(sum%10);
                st.next = node;
                st = st.next;
                sum /= 10;
            }
            if(sum==1) {
                ListNode node1 = new ListNode(sum);
                st.next = node1;
            }
            return zero.next;
        }
    }
}
