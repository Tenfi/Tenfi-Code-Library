package structurePractice;

import org.junit.Test;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }
}


public class ListNodeTest {

    // 创建
    public ListNode initData() {
        ListNode head = new ListNode(-1);
        head.next = new ListNode();
        ListNode node = head.next;
        for (int i = 0; i < 10; i++) {
            node.val = i;
            node.next = new ListNode(i + 1);
            node = node.next;
        }
        return head;
    }

    // 插入
    public ListNode insert(ListNode head, int num){
        ListNode node = head.next;
        ListNode insertNum = new ListNode(num);
        insertNum.next = node.next;
        node.next = insertNum;
        return head;
    }

    // 迭代遍历
    public void trans1(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }

    // 递归遍历
    public void trans(ListNode head){
        if (head!=null){
            trans(head.next);
            System.out.println(head.val);
        }
    }

    @Test
    public void test() {
        ListNode head = initData();
        ListNode head2 = insert(head, 22);
        trans(head2);
    }

}
