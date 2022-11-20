package org.javaStream.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionBy {
    public static void main(String[] args) {


    }
    public Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;
    }
    //Bu person listesini bir map değere değiştir, ama neye göre yaşı 18'den yukarı büyük olanlar true veya false olarak ayıralım
    //Bir listeyi map'e çevirmenin iki yöntemi vardır.
    //--gruplamak
    //yani List<Integer> x={1,2,3,4,5,6} çiftleri bir listeye tekleri bir listeye atabilirim gibi

    public Map<Boolean, List<Person>> partitionAdults2(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge()>=18,Collectors.toList()));
    }
}
