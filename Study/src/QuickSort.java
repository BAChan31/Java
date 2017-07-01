
public class QuickSort {

   static int newArr[] = {5,3,100,2,10,12,1,0,14};
      
      public static void main(String args[])
      {
         sorting(newArr, 0, newArr.length-1);
         
         for(int i=0; i < newArr.length; i++)
            System.out.print(newArr[i] +  " ");
      }
      
      static void sorting(int[] arr, int start, int end)
      {
         if(start < end)
         {
            int pivotIndex = partition(arr, start, end);
            
            sorting(arr, start, pivotIndex-1);
            sorting(arr, pivotIndex+1, end);
         }
      }
      
      static int partition(int[] arr, int left, int right)
      {
         int pivot = arr[(left + right)/2]; //pivot값을 인덱스가  아닌 원소 값으로 하는 이유는 추후 왼쪽 원소와 오른쪽 원소 변경과정에서 피봇으로 선정한 원소의 값이 바뀌기 대문에 원소값 자체를 피봇으로 설정한다.
         
         while(left < right)
         {
            while(arr[left] < pivot && left < right) 
               left++;
            while(pivot < arr[right] && left < right)
               right--;
            
            if(left < right)
            {
               int temp = arr[left];
               arr[left] = arr[right];
               arr[right] = temp;   
            }
         }
         
         return left;
      }
}