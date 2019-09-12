import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindStreamMedian {
    private static  PriorityQueue<Integer> minHeap =new PriorityQueue<Integer>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        FindMedian(arr);
    }
   private   static void FindMedian(int[] arr){
        for(int i =0; i<arr.length; i++){
            addElement(arr[i]);
            System.out.println(getMedian());
        }
    }
   private  static  void addElement(int n){
       if(maxHeap.isEmpty()){
           maxHeap.add(n);
       }
       else if(maxHeap.size() == minHeap.size()){
           if(n> minHeap.peek()){
               maxHeap.add(minHeap.remove());
               minHeap.add(n);
           }
           else{
               maxHeap.add(n);
           }

        }
        else if(maxHeap.size()> minHeap.size()){
            if(n<maxHeap.peek()){
                minHeap.add(maxHeap.remove());
                maxHeap.add(n);
            }
            else {
                minHeap.add(n);
            }
       }


    }

   private static double getMedian(){
        if(maxHeap.isEmpty())
            return 0;
        if(maxHeap.size() ==  minHeap.size()){
            double i = (maxHeap.peek() + minHeap.peek()) / 2.0;
            return i;
        }
        else{
            return maxHeap.peek();
        }

    }



}
