package ru.geekbrains.api.lesson4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;



public class lesson4 {
    static Scanner scanner = new Scanner(System.in);


    /**
     * Задача:
     * Реализовать stack с помощью массива. Нужно реализовать методы:
     * size(), empty(), push(), peek(), pop().
     */
    public static void task3(){

        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(5);
        arrayStack.push(15);
        arrayStack.push(25);

        System.out.println("Кол-во элементов: " + arrayStack.size());

        arrayStack.push(35);
        arrayStack.push(45);

        System.out.println("Кол-во элементов: " + arrayStack.size());

        //arrayStack.push(55);

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());


    }

    /**
     * Задача:
     * Реализовать консольное приложение, которое:
     * 1. Принимает от пользователя и “запоминает” строки.
     * 2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
     * 3. Если введено revert, удаляет предыдущую введенную строку из памяти.
     */
    public static void task2(){

        ArrayDeque deque = new ArrayDeque();
        while (true){
            System.out.print("Введите строку: ");
            String inputString = scanner.nextLine();
            if (inputString.equals("")){
                System.out.println("Завершение работы подпрограммы.");
                break;
            }

            switch (inputString){
                case "print":
                    for (Object o : deque){
                        System.out.println(o);
                    };
                    System.out.println("~~~~~~~~~~~~~");

                    Iterator iterator = deque.iterator();
                    while (iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                case "revert":
                    System.out.printf("Удаление элемента \"%s\"\n", deque.pollFirst());
                    break;
                default:
                    deque.push(inputString);
                    break;
            }
        }


    }

    /**
     * Задача:
     * Реализовать консольное приложение, которое:
     * 1. Принимает от пользователя строку вида
     * text~num
     * 2. Нужно воспользоваться методом split строку по ~, сохранить text в связный список на позицию num.
     * 3. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
     */

    public static void task1(){

        LinkedList<String> linkedList = new LinkedList<>();

        while (true){
            System.out.print("Введите строку: ");
            String inputString = scanner.nextLine();
            if (inputString.equals("")){
                System.out.println("Завершение работы подпрограммы.");
                break;
            }

            String[] parts = inputString.split("~");
            Integer num;
            if (parts.length < 2 || (num = tryParseInt(parts[1])) == null){
                System.out.println("Строка указана некорректно. Повторите попытку ввода.");
                continue;
            }

            if (parts[0].equals("print")){
                System.out.printf("Удаление элемента \"%s\"\n", linkedList.remove((int)num));
            }
            else{
                /*if (num >= 0 && num < linkedList.size()){
                    linkedList.add(num, parts[0]);
                }
                else {
                    linkedList.add(0, parts[0]);
                    //linkedList.addFirst(parts[0]);
                }*/
                linkedList.add(num >= 0 && num < linkedList.size() ? num : 0, parts[0]);
            }

            System.out.println();
            System.out.println("Элементы списка: ");
            System.out.println("~~~~~~~~~~~~~~~~~");
            System.out.println(linkedList);
            System.out.println();

        }
    }

    static Integer tryParseInt(String text){
        try {
            return  Integer.parseInt(text);
        }
        catch (NumberFormatException e){
            return null;
        }

    }

    public static void main(String[] args) {
        task3();
        //task2();
        //task1();
        ArrayList<UUID> arrayList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i ++){
            arrayList.add(UUID.randomUUID());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Операция выполнена за " + (endTime - startTime) + " мс.");

        arrayList = new ArrayList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i ++){
            arrayList.add(UUID.randomUUID());
        }
        endTime = System.currentTimeMillis();
        System.out.println("Операция выполнена за " + (endTime - startTime) + " мс.");

        LinkedList<UUID> linkedList = new LinkedList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i ++){
            linkedList.add(UUID.randomUUID());
        }
        endTime = System.currentTimeMillis();
        System.out.println("Операция выполнена за " + (endTime - startTime) + " мс.");

    }
}
