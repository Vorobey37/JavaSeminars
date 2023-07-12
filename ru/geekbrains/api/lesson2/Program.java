package ru.geekbrains.api.lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Program{

    public static void main(String[] args) {
        //task1();
        //System.out.println(task2(10, 'a', 'b'));
        //System.out.println(task3());
    }


    /**
     *  Метод проверяет, является ли одна строка, перестановкой другой
     * 
     * aabbcc  acbac
     */
    static boolean task4(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        String str1 = new String(arr1);
        String str2 = new String(arr2);
        
        return str1.equals(str2);
        //arr1.equals(arr2);
    }
    

    /**
     * Задача:
     * На вход программы подаются произвольные алфавитно-цифровые символы. (sdfS343343DShks.hsddSDFSFs45345234jkhasdfk34aSSDdkjfahsf334523)
     * Требуется написать программу, которая будет печатать последовательность строчных английских букв ('a' 'b'... 'z')
     * из входной последовательности и частот их повторения.
     * Печать должна происходить в алфавитном порядке. Например, пусть на вход подаются следующие символы:
     * fhb5kbfsh.fmsdfsdf.
     * '.' - завершение последовательности
     * В этом случае программа должна вывести:
     * b2
     * f3
     * h2
     * k1
     * m1
     * s1
     */
    static String task3(){
        char c = 'a';
        char c1 = '2';
        int codeA = c;
        char symbol;
        int j = 1;
        int[] statistic = new int[26];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String s = scanner.nextLine();
        s = s + ".";
        for (int i = 0; i < s.length(); i++){
            symbol = s.charAt(i);
            if (symbol >= 'a' && symbol <= 'z'){
                statistic[symbol - codeA]++;
            }
            if (symbol == '.')
                break;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < statistic.length; i++){
            if (statistic[i] > 0){
                char cc = (char)(codeA + i);
                stringBuilder
                    .append(cc)
                    .append(statistic[i])
                    .append('\n');
            }
        }
        return stringBuilder.toString();

    }

     /**
     * Дано четное число N (>0) и символы c1 и c2. Написать метод,
     * который вернет строку длины N, которая
     * состоит из чередующихся символов c1 и c2, начиная с c1.
     */
    static String task2(int n, char c1, char c2){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++){
            //stringBuilder.append(c1).append(c2);
            // if - then - else
            //String s = "";
            //s = i % 2 == 0 ? s + c1 : s + c2;
            stringBuilder.append(i % 2 == 0 ? c1 : c2);
            /*if (i % 2 == 0){
                s = s + c1;
                stringBuilder.append(c1);
            }
            else{
                s = s + c2;
                stringBuilder.append(c2);
            }*/
        }
        return stringBuilder.toString();
    }

    static void task1(){
        int a = 12;
        String str = "Hello!";
        String str1 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});
        str1 = str1 + "AAA" + "BBBB" + a + "CCC" + "DDD";
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        String buf = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++){
            buf += UUID.randomUUID();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Операция выполнена за " + (endTime - startTime) + "мс.");

        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(1000);
        for (int i = 0; i < 30000; i++){
            stringBuilder.append(UUID.randomUUID());
        }
        endTime = System.currentTimeMillis();
        System.out.println("Операция выполнена за " + (endTime - startTime) + "мс.");
    }


}
