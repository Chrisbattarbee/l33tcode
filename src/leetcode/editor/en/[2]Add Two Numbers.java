//You are given two non-empty linked lists representing two non-negative 
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
// Related Topics Linked List Math Recursion 👍 13877 👎 3104


//leetcode submit region begin(Prohibit modification and deletion)

import java.math.BigInteger;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int acc = 0;
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode result = new ListNode();
        ListNode currentResult = result;
        while (current1 != null || current2 != null || acc != 0) {
            if (current1 != null) {
                acc += current1.val;
                current1 = current1.next;
            }
            if (current2 != null) {
                acc += current2.val;
                current2 = current2.next;
            }
            currentResult.val = acc % 10;
            acc = acc / 10;
            if (current1 != null || current2 != null || acc != 0) {
                currentResult.next = new ListNode();
                currentResult = currentResult.next;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
