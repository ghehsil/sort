package leetCode;

/**
 * 反转链表
 */
public class reverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        print(reverseList(head));
    }

    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode newHead = reverseList(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    static void print(ListNode head) {
        if (head == null) {
            System.out.print("null");
            return;
        }
        System.out.print(head.val + "->");
        print(head.next);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
