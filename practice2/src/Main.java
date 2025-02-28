import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={4,6,3,7,4,-1,1,0};
        mergesort(arr,0,arr.length-1);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

    private static void mergesort(int[] arr, int left, int right) {
        if(left<right){
            int mid=left+(right-left)/2;
            mergesort(arr,left,mid);
            mergesort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    public static void merge(int[] arr,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int leftarr[]=new int[n1];
        int rightarr[]=new int[n2];
        System.arraycopy(arr,left,leftarr,0,n1);
        System.arraycopy(arr,mid+1,rightarr,0,n2);
        int i=0,j=0,k=left;
        while(i<n1 && j<n2){
            if(leftarr[i]<=rightarr[j]){
                arr[k++]=leftarr[i++];
            }
            else{
                arr[k++]=rightarr[j++];
            }
        }
            while(i<n1){
                arr[k++]=leftarr[i++];
            }
            while(j<n2){
                arr[k++]=rightarr[j++];
            }






    }

}