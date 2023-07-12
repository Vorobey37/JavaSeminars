package ru.geekbrains.api.lesson5;

import java.util.Objects;

public class Fraction {
    
    /**
     * Числитель
     */
    private int numerator;


    /**
     * Знаменатель
     */
    private int denominator;

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0){
            throw new RuntimeException("Знаменатель не может быть равен 0.");
        }
        this.denominator = denominator;
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    public int getNumerator(){
        return this.numerator;
    }

    public Fraction plus(Fraction f){
        int den = denominator * f.denominator;
        int num = numerator * f.denominator + f.numerator * denominator;
        return new Fraction(num, den);
    }

    public static Fraction plus(Fraction f1, Fraction f2){
        int den = f1.denominator * f2.denominator;
        int num = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        return new Fraction(num, den);
    }

    public Fraction(){
        numerator = 1;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if (denominator == 0){
            throw new RuntimeException("Знаменатель не может быть равен 0.");
        }
        else {
            this.denominator = denominator;
        }

    }


    public double getFraction(){
        return (double) numerator / denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }


    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        //return numerator + "/" + denominator;
        return String.format("%d/%d", numerator, denominator);
        //String str = "AABBCC";
        //return str.charAt(0) + "" +  str.charAt(1);
        //return String.format("%.2s", str);
    }
}
