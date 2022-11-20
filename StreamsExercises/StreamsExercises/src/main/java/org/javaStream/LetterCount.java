package org.javaStream;

import java.util.Arrays;

public class LetterCount {
    public static void main(String[] args) {
        getTotalNumberOfLettersofNamesLongerThanFive("a", "b", "c");

    }
    //Gelen elemanlarını al-->stream()
    //5 den uzun isimleri al veya filtrele-->filter()
    //geri kalan listedeki tüm harflerin sayısını geti-->mapToInt()
    //harf sayılarını topla-->sum()
    public static int getTotalNumberOfLettersofNamesLongerThanFive(String...names){
        return Arrays.stream(names)
                .filter(name->name.length()>5)
                .mapToInt(String::length)
                .sum();//karakter sayolarından oluşan bir integer listen var oldu.

        /*return Arrays.stream(names)
                .filter(name->name.length()>5)//Stream<String>
                .mapToInt(name->name.length())//Stream<Integer>
                .sum();*///integer listelerimizi toplarız

    }
}
