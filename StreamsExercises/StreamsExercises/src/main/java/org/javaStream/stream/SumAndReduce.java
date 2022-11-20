package org.javaStream.stream;

import java.util.List;

public class SumAndReduce {
    public static void main(String[] args) {


    }
    public static int calculate(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
    public static int calculate2(List<Integer> numbers) {
        return numbers.stream().reduce(Integer::sum).orElse(0);//lambda biçimi
        //return numbers.stream().reduce((i,sum)->i+sum).orElse(0);
    }
    //i--> o andaki değer değişkeni
    //reduce()-->azaltarak her döngüde değeri alıyor ve o listeden çıkartıyor veya bütünden çıkartıyor.
}
