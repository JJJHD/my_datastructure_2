package part02.T5Array;

public class Array {

    public int[] data;
    private int n;
    private int count;

    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index){
        if (index < 0 || index >= count){
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index,int value){
        if (count == n){
            System.out.println("没有可插入的位置");
            return false;
        }
        if (index < 0 || index >count){
            System.out.println("位置不合法");
            return false;
        }
        for (int i = count; i > index; --i){
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index){
        if (index < 0 || index > count) return false;
        for (int i = index+1;i<count;++i){
            data[i-1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll(){
        for (int i=0;i<count;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
}
