package purifier;

/**
 *
 * @author big
 */
public class Sorter extends Purifier {

    private int n = 0;
    private String[] heap;
    int indexOfColumnToHSort;
    
    public Sorter(int dim,int indexOfColumnToHSort){
        heap = new String[dim+1];
        this.indexOfColumnToHSort = indexOfColumnToHSort;
    }
    
    
    public void heapSort(String[] s, int index){
        Sorter pq = new Sorter(s.length+1,index);
        buildBottomUp(s);
        for(int i = s.length-1;i>=0;i--){
            s[i] = delete();
        }
    }
   
    public boolean isEmpty() { return n==0;}
   
    public int size() {return n;}
   
    public void insert(String s){
      heap[++n] = s;
      swim(n);
    }
   
    public String read() { return heap[1];}
   
    public String delete() {
       String max = heap[1];
       exch(1, n--);
       heap[n+1] = null;
       sink(1);
       return max;
    }
    
    public void buildBottomUp(String[] s){
        if(s.length > heap.length-1) return;
        
        n = s.length;
        for(int i = 0; i< s.length; i++){
            heap[i+1] = s[i];
        }
        
        for (int i = n/2; i >=1; i--) {
            sink(i);
        }
   
    }
    
    private boolean less(int index1,int index2,String separator,int indexColumnToCompare){
        String x = heap[index1].split(separator)[indexColumnToCompare];
        String y = heap[index2].split(separator)[indexColumnToCompare];

        for (int i = 0; i < x.length() && i<y.length(); i++) {
            if(Character.valueOf(x.charAt(i)) == Character.valueOf(y.charAt(i))) continue;
            else{ return Character.valueOf(x.charAt(i)) < Character.valueOf(y.charAt(i)); }
        }
        return(x.length()<y.length());
    }
    
    private void exch(int x, int y){
        String aux = heap[x];
        heap[x] = heap[y];
        heap[y] = aux;
    }
    
    private void swim(int k){
        while(k>1&&less(k/2,k,super.separator,indexOfColumnToHSort)){
            exch(k/2, k);
            k=k/2;
        }
    }
    
    private void sink(int k){
        while(2*k <= n){
            int j = 2*k;
            if(j<n &&less(j,j+1,separator,indexOfColumnToHSort)) j++;
            if (!less(k,j,super.separator,indexOfColumnToHSort)) break;
            exch(k,j);
            k = j;
        }
    }
}
