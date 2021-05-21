public class MergeSort<T extends Comparable<T>> {

    public void sort(int[] array){
        sort(array,0,array.length-1);
    }

    private void sort(int[] array, int start, int end){
        if(start<end){
            int middle = start + (end - start)/2;

            sort(array,start,middle);
            sort(array,middle + 1,end);
            merge(array, start, end, middle);
        }
    }

    public void merge(int[] array, int start, int end, int middle){
        int[] a = new int[middle-start+1];
        int[] b = new int[end - middle];

        for(int i = 0; i < a.length; i++){
            a[i] = array[start+i];
        }
        for(int j = 0; j < b.length; j++){
            b[j] = array[middle+1+j];
        }

        int i = 0, j = 0;
        int ind = start;
        boolean merged = false;

        while (i < a.length && j < b.length)
        {
            if(a[i] <= b[j])
            {
                array[ind] = a[i];
                i++;
            }
            else
            {
                array[ind] = b[j];
                j++;
            }
            ind++;
        }
            /*while(merged == false)
            {
                if(i > a.length && j > b.length)
                {
                    merged = true;
                }
                if(a[i] <= b[i])
                {
                    array[ind] = a[i];
                    i++;
                }
                else
                {
                    array[ind] = b[j];
                    j++;
                }
                ind++;
            }
        */
        while(i < a.length)
        {
            array[ind] = a[i];
            i++;
            ind++;
        }
        while(j < b.length)
        {
            array[ind] = b[j];
            j++;
            ind++;
        }
    }



    public void print(int[] array){
        int ind = array.length;
        for(int i = 0; i < ind; i++){
            System.out.print(array[i] + " ");
        }
    }

}

