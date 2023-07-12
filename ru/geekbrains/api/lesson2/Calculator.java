package ru.geekbrains.api.lesson2;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Calculator {

    static File logFile = null;
    static FileWriter fileWriter = null;

    public static void main(String[] args) /*throws Exception*/  {

        try{
            logFile = new File("log.txt");
            fileWriter = new FileWriter(logFile, true);


            for (int i = 0; i < 5; i++){
                fileWriter.append("hello " + i + '\n');
            }
            fileWriter.flush();
            

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            double x = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите операцию (+ - / *): ");
            char operation = scanner.nextLine().charAt(0);
            System.out.print("Введите второе число: ");
            double y = Double.parseDouble(scanner.nextLine());

            if (operation == '+'){
                System.out.println(x + " + " + y + " = " + plus(x, y));
                System.out.printf("%.2f + %.2f = %.2f\n", x, y, plus(x, y));
            }
            if (operation == '-'){
                System.out.println(x + " - " + y + " = " + minus(x, y));
                System.out.printf("%.2f - %.2f = %.2f\n", x, y, minus(x, y));
            }

            fileWriter.close();
        }
        catch(Exception ex){
            System.out.println("Работа приложения будет завершена.");
        }
       

    }

    static double plus(double a, double b) /*throws Exception*/{
        try
        {
            fileWriter.append(a + " +  " + b + " = " + (a + b) + '\n' );
            fileWriter.flush();
        }
        catch (Exception ex){
            System.out.println("Ошибка работы с файлом.");
        }
        
        return a + b;
    }

    static double minus(double a, double b){
        return a - b;
    }
    
}