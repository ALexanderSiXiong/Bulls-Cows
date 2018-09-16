package Setting;

import java.util.ArrayList;

public class SuppliedCode {

    public boolean ask(){
        String isAuto;
        boolean resutl = false;
        int i = 0;
        do {
            if (i != 0){
                System.out.println("illegal input, please input y/n");
            }
            isAuto = Keyboard.readInput();
            i = 1;
        } while (!(isAuto.equals("y") || isAuto.equals("n")));

        if (isAuto.equals("y")){
            resutl = true;
        } else if (isAuto.equals("n")){
            resutl = false;
        }
        return resutl;
    }

    public ArrayList<String> getSuppliedCode(){
        ExtractCodeFile extractCodeFile = new ExtractCodeFile();
        return extractCodeFile.extractCodeList();
    }
}
