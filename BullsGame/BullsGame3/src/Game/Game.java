package Game;

import Setting.Keyboard;
import Setting.SaveInFile;
import Setting.Setting;

import javax.imageio.IIOException;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Game {

    public static void main(String[] args) throws IIOException {
        FileOutputStream propFile = null;
        SaveInFile multi = null;
        System.out.println("-------------------------------------------------");
        System.out.println("------------"+"   Bulls & Cows   "+"-------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("------------" + "Welcome My Friend" + "--------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("Would you like save all the information in a file? \nPress y/Y to save. \n\n" +
                "Press anything to continue.");
        String weatherSave = Keyboard.readInput();
        if (weatherSave.equals("y") || weatherSave.equals("Y")) {
            System.out.println("Please name the file.");
            String fileName = Keyboard.readInput();
            try {
                propFile = new FileOutputStream(fileName + ".txt");
                multi = new SaveInFile(new PrintStream(propFile), System.out);
                System.setOut(new PrintStream(multi));
                // ---- main program ----
                Setting a = new Setting();
                a.start();
                // ----------------------
                System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Setting a = new Setting();
            a.start();
        }
    }
}
