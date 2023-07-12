package ru.geekbrains.api.lesson4;


public class ArrayStack {

    static final int CAPACITY = 1000;
    int[] data;
    int topIndex = -1; // Индекс последнего добавленного элемента в стек

    public ArrayStack(){
        data = new int[CAPACITY];
    }

    public ArrayStack(int capacity){
        data = new int[capacity];
    }

    /**
     * Кол-во элементов в стеке
     */
    public int size(){
        return topIndex + 1;
    }

    /**
     * Признак пустого стека
     * @return true - стек пустой
     */
    public boolean empty(){
        return topIndex == -1;
    }

    /**
     * Добавление нового элемента в стек
     * @param e
     */
    public void push(int e){
        if (size() == data.length){
            throw new RuntimeException("Стек переполнен. Невозможно добавить новый элемент.");
        }
        //topIndex++;
        //data[topIndex] = e;
        data[++topIndex] = e;
    }

    /**
     * Вернуть очередной/первый элемент из стека
     * @return
     */
    public int peek(){
        if (empty()){
            throw new RuntimeException("Стек пустой. Невозможно вернуть значение элемента.");
        }
        return data[topIndex];
    }


    /**
     * Вернуть элемент из стека и удалить его
     * @return
     */
    public int pop(){
        if (empty()){
            throw new RuntimeException("Стек пустой. Невозможно вернуть значение элемента.");
        }
        //int answer = data[topIndex];
        //topIndex--;
        //return  answer;
        return data[topIndex--];
    }
}
