/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
      Stack<Integer> m=new Stack<>();
      ListNode temp=head;
      while(temp!=null) {
         m.push(temp.val);
         temp=temp.next;
      }
      temp=head;
      while(temp!=null) {
         if(temp.val!=m.pop())
           return false;
        temp=temp.next;
      }
      return true;
    }
}
