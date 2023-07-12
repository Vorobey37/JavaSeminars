package ru.geekbrains.api.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class lesson3 {
   static Random random = new Random();
    static ArrayList<ArrayList<String>> catalog = new ArrayList<>();


    /**
     * Задача:
     * Каталог товаров книжного магазина сохранен в виде двумерного
     * списка ArrayList<ArrayList<String>> так, что на 0й позиции каждого внутреннего списка
     * содержится название жанра, а на остальных позициях - названия книг.
     * Напишите метод для заполнения данной структуры.
     */
    static void task2(){
        addBook("Поэма", "Книга #1");
        addBook("Поэма", "Книга #2");
        addBook("Поэма", "Книга #3");
        addBook("Поэма", "Книга #4");
        addBook("Пьеса", "Книга #10");
        addBook("Пьеса", "Книга #15");
        printCatalog();
    }

    static void printCatalog(){
        int i = 0;
        boolean f = true;
        while (f){
            f = false;
            for(ArrayList<String> books : catalog){
                if (books != null && books.size() > i){
                    f = true;
                    System.out.printf("%s\t\t", books.get(i));
                }
            }
            System.out.println();
            i++;
        }
    }

    static void addBook(String genre, String bookName){
        for(ArrayList<String> books : catalog){
            if (books != null && books.size() > 0 && books.get(0).equals(genre)){
                books.add(bookName);
                return;
            }
        }
        ArrayList<String> books = new ArrayList<>();
        books.add(genre);
        books.add(bookName);
        catalog.add(books);
    }

    /**
     * Задача:
     * Заполнить список десятью случайными числами.
     * Отсортировать список методом sort() и вывести его на экран.
     */
    static void task1(){
        int size = random.nextInt(10, 21);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++){
            arrayList.add(random.nextInt(-9, 10));
        }
        System.out.println("До сортировки: " + arrayList);
        Collections.sort(arrayList);
        System.out.println("После сортировки: " + arrayList);
    }

    public static void main(String[] args) {

        task1();
        task2();
        int a = 15;
        int b = -5;
        String str1 = "Hello!";
        String str2 = "Hello!";
        String str5 = "Hello!";
        String str6 = "Hello!";
        String str7 = "He" + "ll" + "o!";
        String str3 = new String(new char[] {'A', 'b'});
        String str4 = new String("Hello!");

        Person person1 = new Person();
        person1.name = "User1";
        person1.age = 33;

        Person person2 = new Person();
        person2.name = "User2";
        person2.age = 33;

        System.out.println(str2);
        System.out.println(b );
        System.out.println(person1);
        System.out.println(person2);


        if ( a == b){

        }

        if (str1 == str2){

        }
        System.out.println(str1 == str4);
        System.out.println(str1.equals(str4));


        System.out.println(person1 == person2);
        System.out.println(person1.equals(person2));


        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("qwerty");
        arrayList1.add(12);
        arrayList1.add(false);
        arrayList1.add(person2);

        ArrayList<Person> arrayList3 = new ArrayList();
        arrayList3.add(person2);

        doProcess(arrayList1);

        MyArrayList<Person> myArrayList = new MyArrayList(new Person[1000]);
        myArrayList.add(person2);
        myArrayList.add(person1);
        System.out.println("Кол-во элементов: " + myArrayList.size());

    }

    static void doProcess(ArrayList arrayList){

        for (Object obj: arrayList) {
            if (obj instanceof Person){
                Person p = (Person)obj;
                System.out.println("Возраст: "+ p.age);
            }

        }

    }

}

class MyArrayList <E>{

    E[] array;
    int index = -1;

    public MyArrayList(E[] array){
        this.array = array;
    }

    public int size(){
        return index + 1;
    }

    public void add(E e){
        array[++index] = e;

    }

}

class Person{
    String name;
    int age;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person)
        {
            Person p = (Person)obj;
            if ( age == p.age)
            {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + name + "; " + age + "]";
    }
}
