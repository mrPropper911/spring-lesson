package task_leetcode_1;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.printf(addTwoNumbers.addTwoNumbers(l1,l2).toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer1= l1, pointer2 = l2, currentNode = result;
        int needAdd = 0;

        while (pointer1 != null || pointer2 != null){
            int pointer1Value = (pointer1 == null) ? 0 : pointer1.val;
            int pointer2Value = (pointer2 == null) ? 0 : pointer2.val;

            int sum = pointer1Value + pointer2Value + needAdd;
            needAdd = sum/10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            if(pointer1 != null){
                pointer1 = pointer1.next;
            }

            if(pointer2 != null){
                pointer2 = pointer2.next;
            }

        }

        if(needAdd > 0){
            currentNode.next = new ListNode(needAdd);
        }

        return result.next;
    }
}

