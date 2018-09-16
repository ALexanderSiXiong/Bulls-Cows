package Setting;

import CodeProcessor.Interface;

import java.util.ArrayList;

public class Setting {
    public boolean weatherBouns;
    public boolean auto;
    public ArrayList<String> codeList;
    public int totalRound = 7;
    public String fundamentalCode = "0123456789";
    public int guessCodeCapacity = 4;

    public void start() {
        SuppliedCode suppliedCode = new SuppliedCode();
        Bonus bonus = new Bonus();
        System.out.println("-------------------------------------------------");
        System.out.println("Would you like to play Bonus ? y/n");
        weatherBouns = suppliedCode.ask();
        if (weatherBouns) {
            totalRound = bonus.modifyRound();
            fundamentalCode = bonus.modifyFundamentalCode();
            guessCodeCapacity = bonus.modifyCapacity(fundamentalCode);
        }
        if(!weatherBouns) {
            System.out.println("-------------------------------------------------");
            System.out.println("Would you like to use supplied code ? y/n");
            auto = suppliedCode.ask();
            if (auto) {
                codeList = suppliedCode.getSuppliedCode();
            }
        }
        choose();
    }

    public void choose() {

        System.out.println("choose level");
        String userChoose = Keyboard.readInput();
        if (userChoose.equals("1")
                || userChoose.equals("2")
                || userChoose.equals("3")
                || userChoose.equals("4")) {

            switch (Integer.parseInt(userChoose)) {
                case 1:
                    new Interface().runGame(1, auto, codeList, totalRound, fundamentalCode, guessCodeCapacity);
                    break;
                case 2:
                    new Interface().runGame(2, auto, codeList, totalRound, fundamentalCode, guessCodeCapacity);
                    break;
                case 3:
                    new Interface().runGame(3, auto, codeList, totalRound, fundamentalCode, guessCodeCapacity);
                    break;
                default:
                    System.out.println("invalid input");
            }
        } else {
            System.out.println("invalid input, please input 1/2/3/4");
            System.out.println();
            Setting inputAgain = new Setting();
            inputAgain.choose();
        }
    }
}
