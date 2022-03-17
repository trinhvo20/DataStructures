import java.util.*;

class Node {
    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class CustomStack {
    int length = 0;
    Node top = null;

    public CustomStack() {
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(top);
        top = newNode;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node node = top;
        top = top.getNextNode();
        length--;
        return node.getData();
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getData();
    }
}

class Main {
    public static void main(String[] args) {
        CustomStack mystack = new CustomStack();
        System.out.println(mystack.isEmpty());

        mystack.push(5);
        mystack.push(2);
        mystack.push(8);
        mystack.push(3);

        System.out.println(mystack.size());
        System.out.println(mystack.peek());
    }
}