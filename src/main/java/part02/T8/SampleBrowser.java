package part02.T8;

public class SampleBrowser {

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public void open(String url){
        if (this.currentPage!=null){
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url,"open");
    }

    public boolean canGoBack(){
        return this.backStack.size>0;
    }

    public boolean canGoForward(){
        return this.forwardStack.size>0;
    }

    public String goBack(){
        if (this.canGoBack()){
            this.forwardStack.push(this.currentPage);
            String backUrl = this.backStack.pop();
            showUrl(backUrl,"back");
            return backUrl;
        }
        return null;
    }

    public String goForward(){
        if (this.canGoForward()){
            this.backStack.push(this.currentPage);
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl,"forward");
            return forwardUrl;
        }
        return null;
    }

    public void showUrl(String url,String prefix){
        this.currentPage = url;
        System.out.println(prefix+" "+url);
    }

    public void checkCurrentPage(){

    }

    public static class LinkedListBasedStack{
        private int size;
        private Node top;

        static Node createNode(String data,Node next){
            return new Node(data,next);
        }

        public void clear(){
            this.top = null;
            this.size = 0;
        }

        public void push(String data){
            Node node = createNode(data,this.top);
            this.top = node;
            this.size++;
        }

        public String pop(){
            Node popNode = this.top;
            if (popNode==null){
                return null;
            }
            this.top = popNode.next;
            if (this.size>0){
                this.size--;
            }
            return popNode.data;
        }

        public String getTopData(){
            if (this.top==null){
                return null;
            }
            return this.top.data;
        }

        public int size(){
            return this.size;
        }

        public void print(){
            Node currentNode = this.top;
            while (currentNode!=null){
                String data = currentNode.getData();
                System.out.println(data+"\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }

    public static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this(data,null);
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
