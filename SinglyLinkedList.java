import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;
    
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    // write your codes here
    public void swap(){
         if (size < 2) {
            return;
        }
 
        
        List<Node<E>> nodes = new ArrayList<>(size);
        Node<E> current = head;
        while (current != null) {
            nodes.add(current);
            current = current.getNext();
        }
 
        
        Integer[] order = new Integer[size];
        for (int i = 0; i < size; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> nodes.get(a).getElement().compareTo(nodes.get(b).getElement()));
 
        
        for (int i = 0; i < size / 2; i++) {
            int posLow = order[i];
            int posHigh = order[size - 1 - i];
            Collections.swap(nodes, posLow, posHigh);
        }
 
        for (int i = 0; i < size - 1; i++) {
            nodes.get(i).setNext(nodes.get(i + 1));
        }
        nodes.get(size - 1).setNext(null);
        head = nodes.get(0);
        tail = nodes.get(size - 1);
    }

    }
   


