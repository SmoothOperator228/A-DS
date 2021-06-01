public class SinglyLinkedList implements ListInterface {
    public class Node {
        private Object obj;
        private Node next;

        protected Object getObj() {
            return obj;
        }

        protected Node getNext() {
            return next;
        }

        protected void setObj(Object obj) {
            this.obj = obj;
        }

        protected void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "obj=" + obj +
                    ", next=" + next +
                    '}';
        }
    }


    private Node head;
    private Node tail;
    private int elements = 0;

    public Node getHead() {
        return head;
    }


    public Node getTail() {
        return tail;
    }


    public int getElements() {
        return elements;
    }

    public boolean isEmpty() {
        if (head == null || tail == null) {
            return true;
        }
        return false;
    }


    public void add(Object obj) {
        //додавання за замовчуванням = додавання останнього елемента (у хвіст)
        Node node = new Node();
        node.setObj(obj);
        if (!isEmpty()) {
            tail.setNext(node);
        }
        tail = node;
        if (isEmpty()) {
            head = node;
        }

        elements++;
    }

    public void addHead(Object obj) {
        Node node = new Node();
        node.setObj(obj);

        node.setNext(head);

        head = node;
        if (isEmpty()) {
            tail = node;
        }

        elements++;
    }

    public void insert(Object obj, int index) {
        if (index < 0 || index > elements) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі списку");
        }
        if (index == 0) {
            addHead(obj);
            return;
        }
        if (index == elements) {
            add(obj);
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < elements; i++) {
            if (i == 0) {
                currentNode = head;
            } else {
                currentNode = currentNode.next;
            }
            if (i == index - 1) {
                Node node = new Node();
                node.setObj(obj);
                Node tempNode = currentNode.next;
                currentNode.setNext(node);
                node.setNext(tempNode);
                elements++;
                break;
            }

        }
    }

    public void removeTail() {
        Node currentNode = head;
        for (int i = 0; i < elements - 1; i++) {
            if (i == 0) {
                currentNode = head;
            } else {
                currentNode = currentNode.next;
            }
            if (i == elements - 2) {
                currentNode.setNext(null);
                tail = currentNode;
                elements--;
                return;
            }
        }
    }

    public void removeHead() {
        head = head.getNext();
        elements--;
    }

    public void remove(int index) throws ObjectNotFoundException {
        if(index < 0 || index > elements - 1){
            throw new IndexOutOfBoundsException("Індекс" + index + "виходить за межі списку");
        }
        if (isEmpty()) {
            throw new ObjectNotFoundException("Нема чого видаляти, список порожній");
        }
        if (index == 0) {
            removeHead();
            return;
        }
        if (index == elements - 1) {
            removeTail();
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < elements - 1; i++) {
            if (i == 0) {
                currentNode = head;
            } else {
                currentNode = currentNode.next;
            }
            if (i == index - 1) {
                currentNode.setNext(currentNode.getNext().getNext());
                elements--;
                return;
            }
        }
    }


    public void replace(int index, Object obj) {
        if (index < 0 || index >= elements) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі списку");
        }
        if(index == 0){
            head.setObj(obj);
        }

        if(index == elements - 1){
            tail.setObj(obj);
        }
        Node currentNode = head;
        for (int i = 0; i < elements - 1; i++) {
            if (i == 0) {
                currentNode = head;
            } else {
                currentNode = currentNode.next;
            }
            if (i == index) {
                currentNode.setObj(obj);
            }
        }
    }


    public void replace(Object changed, Object changer) throws ObjectNotFoundException{
        Node currentNode = head;
        for (int i = 0; i < elements; i++) {
            if (i == 0) {
                currentNode = head;
            } else {
                currentNode = currentNode.next;
            }
            if(currentNode.getObj().equals(changed)){
                replace(i, changer);
                return;
            }
        }
        throw new ObjectNotFoundException("Об'єкту, який ви хочете замінити не знайдено.");
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head.toString() +
                ", tail=" + tail.toString() +
                ", elements=" + elements +
                '}';
    }

    public int getLength(){
        return elements;
    }
}
