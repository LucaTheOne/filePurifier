package purifier;

public class HeapSorter{
    public static void heapSort(String[] vectorToHeap,String separatorUsedInFile,int indexOfColumYouWantToSort ){
        Heap heap = new Heap(vectorToHeap,separatorUsedInFile,indexOfColumYouWantToSort);
        for (int i = 0; i < vectorToHeap.length; i++) {
           vectorToHeap[i] =  heap.delete();
        }
    }
}

class Heap {
    private String[] heapBuilt;
    private int n = 0;
    private String separatorBetweenColumns;
    private int indexColumnToConsider;
    
    public Heap (String[] vectorToHeapVector,String separator,int indexOfColumToConsider) {
        heapBuilt = new String[vectorToHeapVector.length+1];
        separatorBetweenColumns = separator;
        this.indexColumnToConsider = indexOfColumToConsider;
        buildBottomUp(vectorToHeapVector);
    }    
    
    private boolean less(int index1, int index2){
        String x = heapBuilt[index1].split(separatorBetweenColumns)[indexColumnToConsider];
        String y = heapBuilt[index2].split(separatorBetweenColumns)[indexColumnToConsider];

        for (int i = 0; i < x.length() && i<y.length(); i++) {
            if(Character.valueOf(x.charAt(i)) == Character.valueOf(y.charAt(i))) continue;
            else{ return Character.valueOf(x.charAt(i)) < Character.valueOf(y.charAt(i)); }
        }
        return(x.length()<y.length());
    }
    
    private void exchange(int i, int j){
        String aux = heapBuilt[i];
        heapBuilt[i] = heapBuilt[j];
        heapBuilt[j] = aux;
    }
    
    private void sink(int index){
        while(2*index <=n){
          int x = 2*index;
          if(x<n && less(x,x+1)) x++;
          if(!less(index,x)) break;
          exchange(index, x);
          index = x;
        }
    }
    
    public String delete(){
        String max = heapBuilt[1];
        exchange(1, n--);
        heapBuilt[n+1] = null;
        sink(1);
        return max;
    }
    
    public void buildBottomUp(String[] array){
        if (array.length>heapBuilt.length-1) return;
        
        n = array.length;
        for(int i = 0;i<array.length;i++){
            heapBuilt[i+1] = array[i]; 
        }
        
        for(int i = n/2;i>=1;i--){
                sink(i);
        }
    }
}