/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.romannumericals;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author King Carmo
 */
import java.util.TreeMap;
import java.util.*;
import java.util.Scanner;

public class RomanNumbers {

    private final static TreeMap<Integer, String> NumRom = new TreeMap<Integer, String>();

    static {

        NumRom.put(1000, "M");
        NumRom.put(900, "CM");
        NumRom.put(500, "D");
        NumRom.put(400, "CD");
        NumRom.put(100, "C");
        NumRom.put(90, "XC");
        NumRom.put(50, "L");
        NumRom.put(40, "XL");
        NumRom.put(10, "X");
        NumRom.put(9, "IX");
        NumRom.put(5, "V");
        NumRom.put(4, "IV");
        NumRom.put(1, "I");

    }

    public final static String toRoman(int random) {
        int l = NumRom.floorKey(random);
        if (random == l) {
            return NumRom.get(random);
        }
        return NumRom.get(l) + toRoman(random - l);
    }
    
// This function returns value of a Roman symbol 
    int RomNum(char r) {
        if (r == 'I') {
            return 1;
        }
        if (r == 'V') {
            return 5;
        }
        if (r == 'X') {
            return 10;
        }
        if (r == 'L') {
            return 50;
        }
        if (r == 'C') {
            return 100;
        }
        if (r == 'D') {
            return 500;
        }
        if (r == 'M') {
            return 1000;
        }
        return -1;
    }

    // Finds decimal value of a given romal numeral 
    int RomToDec(String str) {
        // Initialize result 
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            // Getting value of symbol s[i] 
            int s1 = RomNum(str.charAt(i));
            // Getting value of symbol s[i+1] 
            if (i + 1 < str.length()) {
                int s2 = RomNum(str.charAt(i + 1));
                // Comparing both values 
                if (s1 >= s2) {
                    // Value of current symbol is greater 
                    // or equalto the next symbol 
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++; // Value of current symbol is 
                    // less than the next symbol 
                }
            } else {
                res = res + s1;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        //User will enter info here
        System.out.println("Enter your decimal number ");
        int random = enter.nextInt();
        System.out.println("Your Roman Number is " + RomanNumbers.toRoman(random));

        RomanNumbers ob = new RomanNumbers();
        // Where user enters information
        System.out.println("Enter your Roman number ");
        String str = enter.next();
        System.out.println(
                "Here is the Decimal form of Roman Numeral you wanted"
                + " is " + ob.RomToDec(str));
    }
}

