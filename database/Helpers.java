package database;

import java.util.Arrays;

public class Helpers {
    public static String arrFormat(String[] arr){

        Arrays.toString(arr).replaceAll("[\\[\\]]", "");

        StringBuilder b = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            b.append("'");

            b.append(arr[i]);



            if (i == arr.length - 1){
                b.append("'");
            }else {
                b.append("',");
            }
        }

        return b.toString();
    }
}
