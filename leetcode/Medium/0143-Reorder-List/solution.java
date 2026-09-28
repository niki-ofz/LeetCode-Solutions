// LeetCode Problem: Reorder List
// Link: https://leetcode.com/problems/reorder-list/
// Difficulty: Medium
// Language: java

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list
        ListNode second = slow.next;
        slow.next = null; // Split the list into two halves
        
        ListNode prev = null;
        while (second != null) {
            ListNode nextTemp = second.next;
            second.next = prev;
            prev = second;
            second = nextTemp;
        }

        // 3. Merge the two halves
        ListNode first = head;
        second = prev; // 'prev' is the head of the reversed second half
        
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}