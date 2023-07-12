package ru.geekbrains.api.lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class Programm{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean f = true;
        while(f){
            System.out.println("Укажите номер задачи:");
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("0 - Завершение работы приложения");
            System.out.println("================================");
            int no = Integer.parseInt(scanner.nextLine());

            switch(no){
                case 3:
                    task3("Добро пожаловать на курс по Java");
                    break;
                case 1:
                    printName();
                    break;

                case 2:
                    int[] array2 = {1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1};
                    System.out.printf("Максимальное кол-во подряд идущих единиц: %d\n", task2(array2));
                    int[] array3 = {1, 0, 1, 1, 1, 0, 0, 1, 1};
                    System.out.printf("Максимальное кол-во подряд идущих единиц: %d\n", task2(array3));       
                    break;
                
                case 0:
                    System.out.println("Завершение рабоыт приложения.");
                    f = false;
                    break;
                
                default:
                    System.out.println("Вы указали некорректный номер задачи.\nПовторите попытку ввода.");
                break;

            }
        }

    }

     /*
     * Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.
     */
    static void task3(String str){


        for (int i = 0, j = 10; i < j; i++, j--){
            System.out.printf("i=%d - j=%d\n", i, j);
        }


        String[] words = str.split(" ");

        for (int i = words.length - 1; i >= 0 ; i--){
                //System.out.print(words[i] + " ");
                System.out.printf("%s ", words[i]);
        }
        System.out.println();
    }


    /*
     * Написать программу, которая запросит пользователя ввести <Имя> в консоли.
     * Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!” 
     */
    static void printName(){

        int i = 12;
        double j = 14.15;
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");
        System.out.printf("Привет, %.2s !  %d   %.2f\n", name, i, j);
    }

     /*
     * Дан массив двоичных чисел, например [1,1,0,1,1,1,0,1], вывести
     * максимальное количество подряд идущих 1.
     */
    static int task2(int[] inputArray){
        int[] array = new int[5];
        array[0] = 1;
        //array[1] = 0;
        array[2] = 1;
        //array[3] = 0;
        //array[4] = 0;

        int max = 0;
        int counter = 0;

        for(int e : inputArray){
            if (e == 1){
                counter++; // counter = counter + 1;
            }
            else{
                if (counter > max){
                    max = counter;
                }
                counter = 0;
            }
        }
        if (counter > max)
             max = counter;  
        return max;
        

    }

}