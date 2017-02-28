package com.MiscellaneousProjects;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    /**
     * @Author: Pinaki (javajane@github)
     * @param args
     * this program takes an array of Integers are input and sorts them using quicksort algorithm
     * QuickSort Algorigthm: Typically last element is used as a 'pivot' and creates two subarray where the first(left)
     * array is all elements that are less than the pivot and the second(right) subarray has elements that are all greater
     * than the pivot.  This subdivision process continues till array has one or two elements which are returned as sorted
     * all the sorted subarrays and the pivot elements are then combined to return a sorted array
     */
    public static void main(String[] args) {

        //int[] inarray=new int[]{35,33,42,10,14,19,27,44,26,31};


        ArrayList<Integer> integerArrayList = new ArrayList<>();
        try {
            for (String str : args) {
                int num=Integer.valueOf(str);
                integerArrayList.add(num);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid argument, please try again" + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please try again " + e.getMessage() );
            System.exit(1);
        }

        int[] inarray = new int[integerArrayList.size()];
        int i=0;
        for(Integer num:integerArrayList){
            inarray[i++]=num;
        }


        int[] sortedarray=quickSort(inarray);

        for(int num: sortedarray){
            System.out.println("Sorted Array: " + num);
        }


    }


    /**
     *
     * @param inarray - takes an input of unsorted integer array
     * @return - returns a sorted array of integers
     * QuickSort Algorigthm: Typically last element is used as a 'pivot' and creates two subarray where the first(left)
     * array is all elements that are less than the pivot and the second(right) subarray has elements that are all greater
     * than the pivot.  This subdivision process continues till array has one or two elements which are returned as sorted
     * all the sorted subarrays and the pivot elements are then combined to return a sorted array
     * This method is called recursively on subarray(s) and eventually combined to return the sorted array
     */

    public static int[] quickSort(int[] inarray){

        int[] returnarray = new int[inarray.length];



        if(inarray.length==1){
            System.arraycopy(inarray,0,returnarray,0,inarray.length);
        }
        else if(inarray.length==2){
            if(inarray[0]<inarray[1]){
                returnarray[0]=inarray[0];
                returnarray[1]=inarray[1];
            }
            else{
                returnarray[0]=inarray[1];
                returnarray[1]=inarray[0];
            }
        }
        else {

            int pivotindex = inarray.length - 1;
            int loindex = 0;
            int hiindex = pivotindex - 1;
            int pivot = inarray[pivotindex];
            int lo = inarray[loindex];
            int hi = inarray[hiindex];
            boolean pivotnotinposition = true;


            while (pivotnotinposition) {

                while (lo < pivot) {
                    loindex++;
                    lo = inarray[loindex];

                }

                while (hi > pivot) {
                    hiindex--;
                    hi = inarray[hiindex];
                }
                if (loindex < hiindex) {
                    inarray[hiindex] = lo;
                    inarray[loindex] = hi;
                    lo = inarray[loindex];
                    hi = inarray[hiindex];

                } else {
                    inarray[loindex] = pivot;
                    inarray[pivotindex] = lo;
                    pivotnotinposition = false;
                    int[] leftpartition = new int[loindex];
                    int[] rightpartition;
                    int[] sortedrightpartition;

                    if(inarray.length - (loindex + 1)>0){

                        rightpartition = new int[inarray.length - (loindex + 1)];
                        System.arraycopy(inarray, loindex + 1, rightpartition, 0, inarray.length - (loindex + 1));

                        sortedrightpartition= quickSort(rightpartition);
                        System.arraycopy(sortedrightpartition,0,returnarray,loindex+1,sortedrightpartition.length);

                    }


                    System.arraycopy(inarray, 0, leftpartition, 0, loindex);

                    int[] sortedleftpartition=quickSort(leftpartition);
                    System.arraycopy(sortedleftpartition,0,returnarray,0,sortedleftpartition.length);
                    returnarray[loindex]=pivot;

                }
            }
        }


        return returnarray;

    }




}
