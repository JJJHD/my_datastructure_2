package part02.T17;

import java.util.Random;

public class SkipList2 {

    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    private Node head = new Node(MAX_LEVEL);
    private Random r = new Random();

    public Node find(int value){
        Node p = head;
        for (int i=levelCount-1;i>=0;--i){
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p = p.forwards[i];
            }
        }

        if (p.forwards[0]!=null && p.forwards[0].data==value){
            return p.forwards[0];
        }else {
            return null;
        }
    }

    public void insert(int value){
        int level = head.forwards[0] == null?1:randomLevel();
        if (level>levelCount){
            level = ++levelCount;
        }
        Node newNode = new Node(level);
        newNode.data = value;
        Node[] update = new Node[level];
        for (int i=0;i<level;++i){
            update[i] = head;
        }

        Node p = head;
        for (int i=levelCount-1;i>=0;--i){
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p = p.forwards[i];
            }
            if (level>i){
                update[i] = p;
            }
        }
        for (int i=0;i<level;++i){
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
    }

    public void insert2(int value){
        int level = head.forwards[0] == null ? 1 : randomLevel();
        if (level>levelCount){
            level = ++levelCount;
        }

        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;

        for (int i=levelCount-1;i>=0;--i){
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p=p.forwards[i];
            }
            if (level>i){
                if (p.forwards[i]==null){
                    p.forwards[i] = newNode;
                }else {
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    public void insert(int value,int level){
        if (level == 0){
            level = randomLevel();
        }
        Node newNode = new Node(level);
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i=0;i<level;++i){
            update[i] = head;
        }

        Node p = head;
        for (int i=level-1;i>=0;--i){
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p = p.forwards[i];
            }
            update[i] = p;
        }
        for (int i=0;i<level;++i){
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
        if (levelCount<level)levelCount=level;
    }

    public void delete(int value){
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i=levelCount-1;i>=0;--i){
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p=p.forwards[i];
            }
            update[i] = p;
        }
        if (p.forwards[0]!=null && p.forwards[0].data==value){
            for (int i=levelCount-1;i>=0;--i){
                if (update[i].forwards[i]!=null &&
                        update[i].forwards[i].data==value){
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    private int randomLevel(){
        int level = 1;
        for (int i=1;i<MAX_LEVEL;++i){
            if (r.nextInt()%2 == 1){
                level++;
            }
        }
        return level;
    }

    public void printAll(){
        Node p = head;
        while (p.forwards[0]!=null){
            System.out.print(p.forwards[0]+" ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public void printAll_beaf(){
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;

        int maxLevel = c.length;
        for (int i=maxLevel-1;i>=0;i--){
            do{
                System.out.print((d[i]!=null?d[i].data:null)+":"+i
                +"--------");
            }while (d[i]!=null && (d=d[i].forwards)[i] !=null);
            System.out.println();
            d=c;
        }
    }


    public class Node{
        private int data = -1;
        private Node[] forwards;
        private int maxLevel = 0;

        public Node(int level){
            forwards = new Node[level];
        }
    }


}
