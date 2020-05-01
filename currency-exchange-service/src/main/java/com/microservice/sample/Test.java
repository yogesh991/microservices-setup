package com.microservice.sample;/*
@Author : Yogesh Deshmukh
*/


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

/*        Float f1 = new Float("3.0");
        int x = f1.intValue();
        byte b = f1.byteValue();
        double d = f1.doubleValue();
        System.out.println(b+x+d);*/

        System.out.print(findSubstring("azerdii", 5));


    }

    /* static String timeConversion(String s) {
         String getNoonInfo = s.substring(s.length()-2);
         if(getNoonInfo.equals("AM"))
             return s.substring(0,s.length()-2);
         else
             return(Integer.parseInt(s.substring(0,2))+12)+""+s.substring(2,s.length()-1);
          }
 */
    public static String findSubstring(String s, int k) {
        int noOfVowels = -1;
        String result = "", temp = "";
        for (int i = k, val = 0; i <= s.length(); i++,val++) {
            temp = s.substring(val, i);
            int tempCount = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == 'a' || temp.charAt(j) == 'e' || temp.charAt(j) == 'i' || temp.charAt(j) == 'o' || temp.charAt(j) == 'u') {
                    tempCount++;
                }
            }
            if (tempCount > noOfVowels) {
                result = temp;
                noOfVowels = tempCount;
            }

        }

        if (noOfVowels == 0)
            return "Not Found!";

        return result;

    }

   /* class Comparator{


        boolean compare(int[] t1, int t2[]){
            if(Arrays.equals(t1,t2)) return true;
            else return false;
        }

        boolean compare(int t1, int t2){
            if(t1 == t2) return true;
            return false;
        }
        boolean compare(String t1, String t2){
            if(t1.equals(t2)) return true;
            else return false;
        }
    }
}
*/

/*
interface BaseI { void method(); }

class BaseC
{
    public void method()
    {
        System.out.println("Inside BaseC::method");
    }
}

class ImplC extends BaseC implements BaseI
{
    public static void main(String []s)
    {
        (new ImplC()).method();
    }
}
*/
/*
interface Syrupable {
 void getSugary();
 }
 abstract class Pancake implements Syrupable { }

         class BlueBerryPancake implements Pancake {
     public void getSugary() { ; }
 }
 class SourdoughBlueBerryPancake extends BlueBerryPancake {
     void getSugary(int s) { ; }
 }*/
}