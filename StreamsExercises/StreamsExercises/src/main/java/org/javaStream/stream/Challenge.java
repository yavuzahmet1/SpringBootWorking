package org.javaStream.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

public class Challenge {
    public static void main(String[] args) {

        System.out.println(getString(Arrays.asList(3, 44)));//output should be 'o3,e44'
        System.out.println(getString(singletonList(3))); //output should be 'o3'
    }

    public static String getString(List<Integer> list) {
        return list.stream()
                .map(i -> {
                    String s = "";
                    if (i % 2 == 0) {
                        s += "e" + i;
                    } else {
                        s += "o" + i;
                    }
                    return s;
                })//Stream<String>
                .collect(Collectors.joining(","));
    }
}
