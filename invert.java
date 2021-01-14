import java.io.*;
import java.util.*;


//HackerRank lists challange:
//Write a reverse funciton for a doubly linked list

public class invert {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        //List is null do nothing
        if (head == null) return head;
        
        //if next is null return the head itself
        //1 element on the list
        if (head.next == null) return head;
        
        
        //store the head element on the list
        DoublyLinkedListNode currentNode = head;
        
        //we have to swich the next node with the previous node
        while(currentNode.next!=null){
            //switch the prev with next
            DoublyLinkedListNode bufferNode = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = bufferNode;
            
            //continue to the next node on the list
            currentNode = currentNode.prev ;
        }
        
        //one last time for the last node
        DoublyLinkedListNode bufferNode = currentNode.prev;
        currentNode.prev = currentNode.next;
        currentNode.next = bufferNode;
        
        //Store the last element so we can return it
        bufferNode = currentNode;

        //continue to the next node on the list
        currentNode = currentNode.prev ;
        
        return bufferNode;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
