package CodeProcessor;

import Setting.Keyboard;

import java.util.ArrayList;

import static Setting.Utility.converStringToArray;

public class HumanCode implements isRepeated {
    public int capacity;
    public String fundamentalCode;

    public HumanCode(int capacity, String fundamentalCode){
        this.capacity = capacity;
        this.fundamentalCode = fundamentalCode;
    }

    public String getCode(ArrayList<String> empty) {
        String userCode = null;

        int i = 0;
        do {
            if (i != 0){
                System.out.println("illegal input, try again.");
            }
            userCode = Keyboard.readInput();
            i = 1;
        } while (
                !(contains(userCode) && isRepeated(userCode))
                        || userCode.length() != capacity
                );

        return userCode;
    }

    @Override
    public boolean isRepeated(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.indexOf(str.charAt(i), i + 1) != -1) {
                return false;
            }
        }
        return true;
    }
    // make sure every basic element human guess is one of a fundamental code
    // For example :
    // fundamental code---0123456789
    // then a guess code should be one of a num in the fundamental code
    public boolean contains(String str){
        String[] userCodeArr = converStringToArray(str);
        for(int i = 0; i < userCodeArr.length; i++){
            if (!fundamentalCode.contains(userCodeArr[i])){
                return false;
            }
        }
        return true;
    }

}
