package _EncodeDecodeStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//TC : O(n*m) where n is the size of the list and m is average length of string in the list
//SC : O(1)

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("we");
        list.add("say");
        list.add(":");
        list.add("yes");
        list.add("!@#$%^&*()");


        String str=encode(list);
        System.out.println(str);
        List<String> list1=decode(str);
        System.out.println(Arrays.toString(list1.toArray()));

    }
    public static String encode(List<String> list){
        StringBuilder str=new StringBuilder();

        for(String strTemp:list){
            int len=strTemp.length();

            if(len<=9){
                str.append(0);
                str.append(0);
                str.append(len);
            }else if(len<=99){
                str.append(0);
                str.append(len);
            }else{
                str.append(len);
            }

            str.append(strTemp);
        }

        return str.toString();

    }

    public static List<String> decode(String str){
        int n = str.length();
        List<String> list = new ArrayList<>();
        int i = 0;

        while (i < n) {
            String temp=str.substring(i, i+3);
            int len=Integer.parseInt(temp);

            i+=3;

            if (i + len > n) {
                break;
            }

            String tempStr = str.substring(i, i + len);
            list.add(tempStr);

            i += len;
        }

        return list;
    }
}
