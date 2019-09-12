import java.util.*;

// Creating max heap by the priority queue
// By default the priority queue is min heap in order to use max heap we are using 
// Collection.reverseOrder()

public class HeapByPriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            pq.add(sc.nextInt());
        }
        for(Integer integer : pq) {
            System.out.print(integer + "  ");
        }
        System.out.println(" ");
        System.out.println("Peek top element : "+ pq.peek());

        System.out.println("Removing top element");
        pq.poll();
        for(Integer integer : pq) {
            System.out.print(integer + "  ");
        }
        System.out.println("Remove 30 if it contains it ");

        pq.remove(30);
        for (Integer i: pq ) {
            System.out.print(i + "  ");

        }



    }
}
