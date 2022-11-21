package org.javaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String name = "Ahmet";
        char[] charArray = name.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length ; i++) {

            System.out.print(charArray[i]);
            System.out.print(",");
        }

    }
}
