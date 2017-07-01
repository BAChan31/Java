public class SelectionSort {
   static int arr[] = {5,3,8,2,10, 1};
      
      
      public static void main(String args[])
      {
         Sorting(arr);
         
         for(int i=0; i < arr.length; i++)
            System.out.print(arr[i] +  " ");
      }
      
      static int[] Sorting(int[] newArray)
      {
         int smallestIndex;
         int smallest;
         
         for(int i=0; i < newArray.length; i++)
         {
            smallest = newArray[i];
            smallestIndex = i;
            
            for(int j=i+1; j < newArray.length; j++)
            {
               if(newArray[j] < smallest)
               {
                  smallest = newArray[j];
                  smallestIndex = j;
               }
            }
            
            int temp = newArray[i];
            newArray[i] = smallest;
            newArray[smallestIndex] = temp;
         }
         
         return newArray;
      }
}