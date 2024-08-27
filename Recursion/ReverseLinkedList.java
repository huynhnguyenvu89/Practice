package Recursion;

/**
Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.

Example 1:

Input: head = [0,1,2,3]

Output: [3,2,1,0]
Example 2:

Input: head = []

Output: []
Constraints:

0 <= The length of the list <= 1000.
-1000 <= Node.val <= 1000

 */
public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  public ListNode reverseList(ListNode head) {
    return reverse(head, null);
  }

  private ListNode reverse(ListNode node, ListNode prev) {
    if (node == null) {
        return prev;
    }
    ListNode next = node.next;
    node.next = prev; 
    ListNode n = reverse(next, node);
    return n;
  }
}
