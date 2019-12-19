package part02.T6LinkedList;

public class LRUBaseLinkedList<T> {

    private final static Integer DEFAULT_CAPACITY = 10;
    private SNode<T> headNode;
    private Integer length;
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<T>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;

    }

    public void add(T data){
        SNode preNode = findPreNode(data);
        if (preNode != null){
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        }else {
            if (length>=this.capacity){
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    private void deleteElemOptim(SNode preNode){
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    public void insertElemAtBegin(T data){
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }

    private void deleteElemAtEnd(){
        SNode ptr = headNode;
        if (ptr.getNext() == null){
            return;
        }
        while (ptr.getNext().getNext()!=null){
            ptr = ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll(){
        SNode node = headNode.getNext();
        while (node!=null){
            System.out.println(node.getElement()+",");
            node = node.getNext();
        }
        System.out.println();
    }



    private SNode findPreNode(T data){
        SNode node = headNode;
        while (node.getNext()!=null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }















    public class SNode<T>{
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode(){
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}
