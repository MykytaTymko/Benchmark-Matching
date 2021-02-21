package com.mycompany.mavenprojec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.io.IOException;

/**
 *
 * @author Mykyta Tymko
 */
public class Main {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            Main.matchBenchmark(line);
        }
    }

    public static void matchBenchmark(String input) {
        String[] inputValue = input.split(":");
        String[] before = inputValue[0].split("!");
        String[] after = inputValue[1].split("!");

        for (int i = 0; i < after.length; i++) {
            String[] positionAfter = after[i].split(",");
            for (int j = 0; j < before.length; j++) {
                String[] positionBefore = before[j].split(",");
                if (positionAfter[0].equals(positionBefore[0])) {
                    if (positionAfter[1].equals(positionBefore[1])) {
                        if (Integer.parseInt(positionAfter[2]) < Integer.parseInt(positionBefore[2])) {
                            System.out.println(positionAfter[0] + "," + positionAfter[1] + "," + "SELL," + (Integer.parseInt(positionBefore[2]) - Integer.parseInt(positionAfter[2])));
                            break;
                        } else {
                            System.out.println(positionAfter[0] + "," + positionAfter[1] + "," + "BUY," + (Integer.parseInt(positionAfter[2]) - Integer.parseInt(positionBefore[2])));
                            break;
                        }
                    } else if (j == before.length - 1) {
                        System.out.println(positionAfter[0] + "," + positionAfter[1] + "," + "BUY," + positionAfter[2]);
                    }
                } else if (j == before.length - 1) {
                    System.out.println(positionAfter[0] + "," + positionAfter[1] + "," + "BUY," + positionAfter[2]);
                }
            }
        }
    }

}
