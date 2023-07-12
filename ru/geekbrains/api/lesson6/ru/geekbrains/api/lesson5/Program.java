package ru.geekbrains.api.lesson5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class Program {

    private static Random random = new Random();


    /**
     * Задача:
     * 1. Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24.
     * 2. Создайте метод, в который передайте заполненный выше массив и с помощью Set
     * вычислите процент уникальных значений в данном массиве
     * и верните его в виде числа с плавающей запятой.
     * Для вычисления процента используйте формулу:
     * процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
     */
    public static void task1(){
        Integer[] array = new Integer[100];
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(0, 25);
        }
        task2(array);
    }

    public static void task2(Integer[] array){
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(array));
        //hashSet.addAll(Arrays.asList(array));
        System.out.println("% уникальных чисел: " + (double) hashSet.size() * 100 / array.length);
    }

    public static void main(String[] args) {

        task1();

        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        int size = random.nextInt(10, 21);
        System.out.println("Общее кол-во элементов: " + size);
        System.out.print("Случайные числа: ");
        for (int i = 0; i < size; i++){
            int number = random.nextInt(-9, 10);
            System.out.printf("%d ", number);
            hashSet.add(number);
            linkedHashSet.add(number);
            treeSet.add(number);
        }

        System.out.println();
        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);



        Fraction fraction1 = new Fraction(3, 2);
        fraction1.setNumerator(3);
        System.out.println(fraction1.getNumerator());
        fraction1.setDenominator(2);
        System.out.println(fraction1);

        Fraction fraction2 = new Fraction(1, 4);
        //fraction2.numerator = 1;
        //fraction2.denominator = 0;
        System.out.println(fraction2);

        Fraction fraction3 = fraction1.plus(fraction2);
        Fraction fraction4 = Fraction.plus(fraction1, fraction2);

        System.out.println(fraction1.getFraction()  + "  + " + fraction2.getFraction() + " = " + fraction3.getFraction());


        HashSet<Fraction> hashSet1 = new HashSet<>();
        hashSet1.add(new Fraction(3, 4));
        hashSet1.add(new Fraction(1, 2));
        hashSet1.add(new Fraction(4, 5));
        hashSet1.add(new Fraction(-3, 12));
        hashSet1.add(new Fraction(3, 4));
        hashSet1.add(new Fraction(3, 4));

        System.out.println(hashSet1);
        System.out.println(new Fraction(3, 4).equals(new Fraction(3, 4)));
    }
}