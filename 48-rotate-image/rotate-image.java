class Solution {
    class ListNode {
        int val;
        ListNode next;
    }
    public void rotate(int[][] matrix) {
        ListNode head = null;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                ListNode temp = new ListNode();
                temp.val = matrix[i][j];
                temp.next = null;
                if(head == null) {
                    head = temp;
                } else {
                    ListNode current = head;
                    while(current.next != null) {
                        current = current.next;
                    }
                    current.next = temp;
                }
            }
        }
        ListNode current = head;
        for(int i = matrix.length-1; i>=0; i--) {
            for(int j=0; j<matrix[0].length; j++) {
                matrix[j][i] = current.val;
                current = current.next;
            }
        }
    }
}
