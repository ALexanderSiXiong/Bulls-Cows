package CodeProcessor;

import java.util.ArrayList;

import static Setting.Utility.converArrayToString;
import static Setting.Utility.converStringToArray;


public class PossibleGuesses {
    public static int count; // to check the number of guesses

//        ------Test------
//        public static void main(String[] args) {
//        String elment = "012asd678";
//            PossibleGuesses test = new PossibleGuesses();
//        System.out.println(test.merge(elment,2));
//        System.out.println(count);
//        }

    /**  put all the possible guess in one ArrayList
     *
     */
    public ArrayList<String> merge(String str, int capacity) {
        ArrayList<String> result = new ArrayList<>();
        String[] arr = converStringToArray(str);
        ArrayList<String> basicElements = confirmCapacity(arr, 0, 0, capacity);
        for (String element : basicElements) {
            element = split(element);
            ArrayList<String> temp = permute2(element);
            if (!result.contains(temp)) {
                result.addAll(temp);
            }
        }
        return result;
    }
    /** permute all the basic possible guess according to the capacity
    */
    public ArrayList<String> permute2(String str) {
        String[] num = str.split(",");
        ArrayList<String> result2 = new ArrayList<>();
        permute(num, 0, result2);
        return result2;
    }

    private void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    void permute(String[] num, int start, ArrayList<String> result2) {
        if (start >= num.length) {
            String element = converArrayToString(num);
            result2.add(element);
            count++; // to check the number of guesses
        }
        for (int j = start; j <= num.length - 1; j++) {
            swap(num, start, j);
            permute(num, start + 1, result2);
            swap(num, start, j);
        }
    }

    /** get all the basic possible guess according to the capacity
     */
    public static String[] tempArr;
    public static ArrayList<String> baseElement = new ArrayList<>();

    public ArrayList<String> confirmCapacity(String[] arr, int count, int count2, int capacity) {
        if (count2 == capacity) {
            String temp = converArrayToString(tempArr);
            baseElement.add(temp);
        } else if (count2 != capacity) {
            if (count2 == 0) {
                tempArr = new String[capacity];
            }
            for (int i = count; i < arr.length; i++) {
                tempArr[count2] = arr[i];
                confirmCapacity(arr, i + 1, count2 + 1, capacity);
            }
        }
        return baseElement;
    }

    public static String split(String element) {
        String splited = "";
        for (int i = 0; i < element.length(); i++) {
            if (i == element.length() - 1) {
                splited += element.charAt(i);
            } else if (i != element.length()) {
                splited += element.charAt(i) + ",";
            }
        }
        return splited;
    }
}
