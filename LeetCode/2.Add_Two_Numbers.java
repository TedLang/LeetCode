/*
2. Add Two Numbers
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        int upgrade = 0;
        ListNode tmp = new ListNode(0);
        tmp.val = l1.val + l2.val;
        if(tmp.val >= 10){
            upgrade = 1;
            tmp.val = tmp.val - 10;
        }
        ListNode root = tmp;

        while(l1.next!=null || l2.next!=null){
            ListNode next = new ListNode(0);
            if(l1.next!= null){
                l1 = l1.next;
                next.val += l1.val;
            }

            if(l2.next!= null){
                l2 = l2.next;
                next.val += l2.val;
            }
            next.val += upgrade;
            if(next.val >= 10){
                next.val -= 10;
                upgrade = 1;
            } else {
                upgrade = 0;
            }
            tmp.next = next;
            tmp = next;
        }
        if(upgrade == 1){
            ListNode next = new ListNode(1);
            tmp.next = next;
            tmp = next;
        }

        return root;
    }
  }
}
