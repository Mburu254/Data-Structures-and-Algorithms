
/**
 * Created by paulo on 10/7/15.
 *
 * Better array is an improvement of java array to increase the size
 */
public class BetterArray<E> {

    private E[] arr;
    private int size;

    public BetterArray(){
        this(10);
    }
    public BetterArray(int sizeOne){

        arr = (E[]) new Object[sizeOne];
        size=0;
    }
/*
* These are different methods to manipulate the arraylist
*
*
* Append adds elements to the array
 */
    public int append(E element){
        arr[size++]= element;
        if (size==arr.length) {
            E[] dSizeArr= (E[]) new Object[arr.length*2];
            for (int i=0;i<arr.length;i++) {
                dSizeArr[i]= arr[i];
            }
            this.arr= dSizeArr;
        }
        this.arr[size++] = element;

    }
    /*
    * This adds elemnts in to the array with reference to the position or array index
     */
    public boolean insert(int position, E element) {
        boolean status = false;
        if (position == size) {
            append(element);
            status = true;
        } else if (position > size) {
            status = false;
        }
        return status;
    }

    /*
    * Contains is a check for a given element in the arraylist
     */
    public boolean contains(E element){
        for (int i = 0; i < arr.length; i++) {
            if(!(arr[i] == null))
                if(arr[i].equals(element))
                    return true;
        }
        return false;
    }
    /*
    *Index is a check for a position in the array and returns the element in that position
     */
    public int index(E element){
        for (int i = 0; i < arr.length; i++) {
            if(!(arr[i] == null))
                if(arr[i].equals(element))
                    return i;
        }
        return -1;
    }
    public int get(int i){
        try{
        if (i<size) {
            return arr[i];
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Not available");
        }
        return (i);

    }
    /*
    *Remove is used to eliminate an element in the array list
     */
    public Object remove(int i){
        if(i< size){
            Object obj = arr[i];
            arr[i] = null;
            int tmp = i;
            while(tmp < size){
                arr[tmp] = arr[tmp+1];
                arr[tmp+1] = null;
                tmp++;
            }
            size--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    /*
    *Shift moves the elements in the array from the first position
     */
    public void shift(E element) {
        insert(0, element);
    }


    public static void main(String[] args) {
        /*
        * below is an insert of several objects in to the array
         */
        BetterArray demo =new BetterArray();
            demo.insert(0,10);
            demo.insert(1,20);
            demo.insert(2,30);
            demo.insert(3,40);
            demo.insert(4,50);
            demo.contains(40);
            demo.index(0);
    }
}