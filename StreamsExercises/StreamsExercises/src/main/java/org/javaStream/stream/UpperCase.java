package org.javaStream.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UpperCase {
    public static void main(String[] args) {
        mapToUppercase("a", "b", "c");

    }

    // String değerleri upperCase yapacak program
    public static Collection<String> mapToUppercase(String... names) {//String... String array aldığını belirtiyor.
        // Burdan istediğin kadar paramaetre verebilirsiniz bu da java 8den sonra gelmiş.

        Collection<String> uppercaseNames = new ArrayList<>();
        for (String name : names) {
            uppercaseNames.add(name.toUpperCase());
        }
        return uppercaseNames;
    }
    //Array elemenalerının tamamını al--->stream()
    //Büyük harflere çevir--------------->map()
    //liste olarak geri ver-------------->collect()

    public static Collection<String> mapToUppercase2(String... names) {
        return Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
        //return Arrays.asList(names).stream().map(name -> name.toUpperCase()).collect(Collectors.toList());

        //Arrays.asList(names)=Bu aldığı arayyi listeye çeviriyor.
        //Arrays.asList(names).stream()=stream() adında collectiona çeviriyor,stream() yapmandan diğer metotlara ulaşamayız.Bu strema bir collection değildir nihayetinde de bu stream() ı daalıp listeye cevireceğiz.
        // Arrays.asList(names).stream().map()=name olarak ulaşabilirm her nesneye/arayyin içerisine
    }
}
