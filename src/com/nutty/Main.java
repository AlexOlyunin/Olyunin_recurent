package com.nutty;

//
// created by Alexandr Olyunin
// 23501/3
//

public class Main {

    public static void main(String[] args) {

        Integer Volume[] = {193, 177, 112, 77, 154, 101, 37, 59, 81, 141, 99, 105, 86, 78, 94};

        // Print array

        System.out.print("Volume array: ");
        for (int iVolume = 0;
             iVolume < Volume.length;
             ++iVolume) {

            System.out.print(Volume[iVolume].toString());
            if (iVolume + 1 < Volume.length) {
                System.out.print(", ");
            }
        }
        System.out.print("\n\n");

        Integer Delta[] = new Integer[Volume.length - 1];
        for (int iDelta = 0;
             iDelta < Volume.length - 1;
             ++iDelta) {

            Delta[iDelta] = Volume[iDelta + 1] - Volume[iDelta];
        }

        Integer bestStart = 0;
        Integer bestEnd = 0;
        Integer bestSumm = 0;

        Integer newStart = -1;
        Integer newEnd = 0;
        Integer newSumm = 0;

        for (int iDelta = 0;
             iDelta < Volume.length - 1;
             ++iDelta) {
            Integer delta = Delta[iDelta];

            if (newStart == -1) {
                newStart = iDelta;
                newEnd = iDelta + 1;
                newSumm = delta;
            } else {
                ++newEnd;
                newSumm += delta;
            }

            if (newSumm <= 0) {
                newStart = -1;
                newEnd = 0;
                newSumm = 0;
            } else if (newSumm > bestSumm) {
                bestStart = newStart;
                bestEnd = newEnd;
                bestSumm = newSumm;
            }

        }

        // Result

        if (bestSumm == 0) {
            System.out.print("Not bad \n\n");
        } else {
            System.out.print("Volume at day #" + bestStart.toString() +
                    " (V: " + Volume[bestStart].toString() + ")" +
                    " and sell at day #" + bestEnd.toString() +
                    " (V: " + Volume[bestEnd].toString() + ")" + "\n");
            System.out.print("You can sell V: " + bestSumm.toString() + "");
        }

    }
}

