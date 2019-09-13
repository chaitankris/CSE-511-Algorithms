import static java.lang.Integer.sum;

public class SegmentTreeForSum {

    private static  void constructSegmentTree(int[] arr, int[] segTree, int i, int j , int pos){
        if(i == j)
            segTree[pos] = arr[i];
        else{
            int mid = (i+j)/2;
            constructSegmentTree(arr,segTree,i,mid,2*pos+1);
            constructSegmentTree(arr,segTree,mid+1,j,2*pos+2);
            segTree[pos] = sum(segTree[2*pos+1], segTree[2*pos+2]);


        }
    }
    private static int parent(int pos){
        return (pos-1)/2;
    }

    private static int leftChild(int pos){
        return  (2*pos)+1;
    }

    private static int rightChild(int pos){
        return (2*pos)+2;
    }
    /*
      Low = starting index of the array , high = ending index of the array

     */
    private static  int rangeMinimumQuery(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos){
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            return 0;
        }
        int mid = (low+high)/2;
        return sum(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
                rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2));
    }

    // which updates the  current value of the segment tree.

    private  static  void update(int arr[], int[] segtree, int i, int x){
        arr[i] = x;
        int index = i+arr.length -1;
        segtree[index] = x;
        int p = parent(index);
        int flag =0;
        while(p>=0 ) {
            segtree[p] = sum(segtree[leftChild(p)], segtree[rightChild(p)]);
            if(flag == 1) break;
            p = parent(p);
            if(p==0){
                 flag = 1;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr= {6,14,12,98,45,2,9,56};

        int[] segTree = new int[15];

        constructSegmentTree(arr,segTree,0,7,0);

        for (int i= 0; i<segTree.length; i++){
            System.out.print(segTree[i]+ " ");
        }

        System.out.print("\n");

        update(arr, segTree,1,1);
        for (int i= 0; i<segTree.length; i++){
            System.out.print(segTree[i]+ " ");
        }

        System.out.print("\n");
       System.out.println("The range Sum query for 0 to 4 is "+ rangeMinimumQuery(segTree,0,7,1,3,0));
    }
}

