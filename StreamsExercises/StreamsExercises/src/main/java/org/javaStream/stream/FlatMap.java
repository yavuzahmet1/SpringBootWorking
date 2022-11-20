package org.javaStream.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        //transform2(("a", "b", "c"),("d","e","f"));

    }
    //elimde iki boyutlu bir liste var
    //{a,b,c}
    //{d,e,f} bu gördüğünüz iç içe geçmiş iki listeyi flat yapar flatMap yani bu listeyi {a,b,c,d,e,f} yapar.
    //nested list-iç içe geçen listelere denilir.
    //-nested list'e değerleri al=>stream()
//Her bir elemanı bir listeye ekle=>flatMap
    public static List<String> transform(List<List<String>> collection) {
        List<String> newCollection = new ArrayList<>();
        for (List<String> subCollection : collection) {
            for (String value : subCollection) {
                newCollection.add(value);
            }
        }
        return newCollection;
    }
    public static List<String> transform2(List<List<String>> collection) {
        return collection.stream()
                .flatMap(Collection::stream)  //stream<Stream<String>> i Stream<String> listesine düz liste hale getirir.
                .collect(Collectors.toList());//Stream<String> i List<String>'e çevirdi.
    }
}
