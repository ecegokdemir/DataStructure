
public class StackImplementation {
    public static void main(String[] args) {
        int [] arr = {3,4,5,6,4,2,3,4};
        Stack<Integer> den1 = new Stack(arr.length);
        for (int i = 0; i < arr.length; i++) {
            den1.pushLeft(arr[i]);
        }
        den1.write();
    }
}
class Stack<T>{
    private T [] data;
    private int N;

    public Stack(int start){
        if(start < 1)
            start = 1;
        data = (T[]) new Object[start];
        N = data.length;
    }
    private void resize(){
        T[] newarr = (T[]) new Object[data.length*2];
        for (int i = 0; i < data.length; i++) {
            newarr[i] = data[i];
        }
        data = newarr;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public void pushLeft(T newValue){
        if(N==data.length) resize();
        for (int i = N; i > 0; i--) {
            data[i] = data[i-1];
        }
        data[0] = newValue;
        N++;
    }
    public void pushRight(T newValue){
        if(N==data.length) resize();
        data[N] = newValue;
        N++;
    }
    public T popLeft(){
        T value = data[--N];
        data[N] = null;
        return value;
    }
    public T popRight(){
        T value = data[0];
        for (int i = 0; i < N; i++) {
            data[i] = data[i+1];
        }
        data[--N] = null;
        return value;
    }
    public void write(){
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
