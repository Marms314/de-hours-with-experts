package com.labs1904;

import java.util.Arrays;

public class NextBiggestNumber {

    public static void main(String[] args) {
        Integer input = Integer.parseInt(args[0]);
        Integer nextBiggestNumber = getNextBiggestNumber(input);
        System.out.println("Input: " + input);
        System.out.println("Next biggest number: " + nextBiggestNumber);
    }

    public static int getNextBiggestNumber(Integer i) {
        // Break i into char array to allow number places to be compared
        char[] splitNum = i.toString().toCharArray();

        // Find if a larger number is to the right of a smaller one. If so, track the location
        int placeToMove = -1;
        for(int index = splitNum.length - 1; index > 0; index--) {
            if (splitNum[index - 1] < splitNum[index]) {
                placeToMove = index - 1;
                break;
            }
        }

        // Return -1 if loop was fruitless, as there are no moves that can be made (Will include single digit numbers)
        if (placeToMove == -1) return -1;

        // Compare the number at index placeToMove with numbers from right to left, trade places when you find one bigger
        for (int index = splitNum.length - 1; index > placeToMove; index--) {
            if (splitNum[placeToMove] < splitNum[index]) {
                char holdPlaceTemp = splitNum[placeToMove];
                splitNum[placeToMove] = splitNum[index];
                splitNum[index] = holdPlaceTemp;
                break;
            }
        }

        // Sort the places to the right of placeToMove from smallest to largest to minimize the number
        Arrays.sort(splitNum, placeToMove + 1, splitNum.length);

        // Return the new number
        return Integer.parseInt(String.valueOf(splitNum));
    }
}
