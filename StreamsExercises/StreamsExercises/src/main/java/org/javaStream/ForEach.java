package org.javaStream;

import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> a= Arrays.asList(1,2,3,4,5,6,7);
        a.stream()
                .forEach(i-> System.out.println(i+2));
    }
}
