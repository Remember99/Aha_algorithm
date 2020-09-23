public class Bucket_sort {
    //可以去重，只能排序整数
    static int[] bucket=new int[100];//用来装数的桶,默认初始值为0

    public static void Bucketsort(int num[]){
        //入桶
        for(int i=0;i<num.length;i++){
            bucket[num[i]]++;
        }
        //按序输出
        for(int i=0;i<bucket.length;i++){
            if(bucket[i]!=0)
                System.out.print(i+" ");
        }
    }
    public static void main(String args[]){
        int[] num={6,8,9,7,4,3,9,4};
        Bucketsort(num);
        //System.out.println("123");
    }
}
