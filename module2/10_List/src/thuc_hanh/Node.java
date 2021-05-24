package thuc_hanh;

public class Node {
    Node next;
    Object element;

    public Node() {
    }

    public Node(Object element) {
        this.element = element;
    }
    public Object getElement(){
        return element;
    }
}
