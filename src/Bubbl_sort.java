import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;

public class Bubbl_sort {
    public class student{
        String name;
        int grade;
    }
    public static void Bubblesort(student arr[]){
        student temp;
        boolean flag=true;
        for(int i=1;i<arr.length-1 && flag;i++){//趟数

            flag=false;//每一趟都设为false,每一趟在运行的时候都有可能交换数据

            for(int j=0;j<arr.length-i;j++){//交替比较
                if(arr[j].grade>arr[j+1].grade){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
        }
    }
    //按行读取文件
    public static ArrayList<student> readFileByLines(String fileName) {
        File file = new File(fileName);
        ArrayList<student> stu=new ArrayList<student>();
        /*静态的方法中不能直接调用非静态的方法或属性。
        因为一个类的静态方法在这个Class文件被加载之后，
        就可以由这个Class类型对象来调用，
        而非静态的方法需要一个实例对象，
        有可能还未被创建，所以为了避免在静态方法中调用一个还不存在的实例对象的非静态方法，
        编译期就会直接阻止这个行为*/
        Bubbl_sort bubble_sort=new Bubbl_sort();
        student temp = bubble_sort.new student();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));//应该存在于工程目录下，而不是工程的子目录，生成的文件也在工程目录下.
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                //System.out.println(tempString);
                //存入student链表
                String[] str=tempString.split(" ");
                //System.out.println(str[0]+" "+str[1]);
                temp.name=str[0].toString();
                temp.grade=Integer.parseInt(str[1]);
                //System.out.println(temp.name);
                stu.add(temp);
            }
            for(int i =0;i<stu.size();i++){
                System.out.println(stu.get(i).name);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return stu;
    }
    public static void main(String args[]){
        ArrayList<student> stu_arr=new ArrayList<student>();
        stu_arr=readFileByLines("grade");//读取文件，传参

//        for(int i =0;i<stu_arr.size();i++){
//            System.out.println(stu_arr.get(i).name);
//        }
        student[] stu=new student[stu_arr.size()];
        for(int i=0;i<stu_arr.size();i++){
            stu[i].name=stu_arr.get(i+1).name;
            stu[i].grade=stu_arr.get(i+1).grade;

        }
        //排序
        Bubblesort(stu);
        for(int i=0;i<stu_arr.size();i++){
            System.out.println(stu[i].name+":"+stu[i].grade);
        }
    }
}
