
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
         int pivot = arr[(left + right)/2]; //pivot���� �ε�����  �ƴ� ���� ������ �ϴ� ������ ���� ���� ���ҿ� ������ ���� ����������� �Ǻ����� ������ ������ ���� �ٲ�� �빮�� ���Ұ� ��ü�� �Ǻ����� �����Ѵ�.
         
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