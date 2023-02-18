
public class Priority {
    public static void main(String[] args) {
      
        Queue myPriorityQueue = new Queue(10);
        myPriorityQueue.enqueue(1); 
        myPriorityQueue.enqueue(3); 
        myPriorityQueue.enqueue(5);
        myPriorityQueue.enqueue(7); 
        myPriorityQueue.enqueue(9); 

        System.out.println("peek : " +myPriorityQueue.peek());
        myPriorityQueue.dequeue();

        myPriorityQueue.enqueue(2); 
        myPriorityQueue.enqueue(4); 
        myPriorityQueue.enqueue(6); 
        myPriorityQueue.enqueue(8); 
        myPriorityQueue.enqueue(10); 

        System.out.println("peek : " +myPriorityQueue.peek());
        myPriorityQueue.print();

    }

}

class Queue{
    private int MAX;
    private int[] arr;
    private int nItems;

    public Queue(int capaticy) {
       MAX = capaticy;
       arr = new int[MAX];
       nItems = 0;
    }

    public void enqueue(int data){
        int i;

        if(nItems==0){
            arr[0]=data;
            nItems++;
            return;
        }

        for (i = nItems-1; i >=0; i--) {

            if( data > arr[i]){
                arr[i+1] = arr[i];    
            }else{
                break;
            }

        }

        arr[i+1] = data;
        nItems++;
    }

    public int dequeue(){
        return arr[--nItems];
    }

    public int peek(){
        return arr[nItems-1];
    }

    public void print(){
        for (int i = 0; i < nItems; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public boolean isFull(){
        return nItems == MAX;
    }

    public boolean isEmpty(){
        return nItems == 0;
    }



    
}