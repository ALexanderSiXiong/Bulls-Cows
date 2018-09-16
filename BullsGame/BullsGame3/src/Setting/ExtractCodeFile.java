package Setting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExtractCodeFile {

    public ArrayList<String> extractCodeList() {
        ArrayList<String> result = new ArrayList<>();
        System.out.println("Enter the name of the file（including file extensions）");

        String fileName;
        File f;

        int i = 0;
        do {
            if (i != 0){
                System.out.println("Wrong file name,please try again");
            }
            fileName = Keyboard.readInput();
            f = new File(fileName);
            i = 1;
        } while (!f.exists());

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String thisLine = scanner.next();
                result.add(thisLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return result;
    }

}
