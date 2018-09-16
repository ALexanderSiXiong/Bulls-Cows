package CodeProcessor;

import java.util.ArrayList;

import static Setting.Utility.checkBulls;
import static Setting.Utility.checkCows;

public class Interface {

    /** get the secret code
     *  get human guess
     *  get ai guess
     * */
    public void runGame(int level, boolean auto, ArrayList<String> codeList,
                        int totalRound, String fundamentalCode, int capacity){
//        Get all the possible code combinations (all the possible answers)
        PossibleGuesses pG = new PossibleGuesses();
        ArrayList<String> allPossibleAnswers = pG.merge(fundamentalCode, capacity);

//        Human secret code
        System.out.print("your secret code: ");
        String humanSecretCode = new HumanProcessor(capacity,fundamentalCode).getHumanGuess();
//        AI secret code
        String aiSecretCode = new EasyProcessor().getAISecretCode(allPossibleAnswers);
        System.out.println("ai secret code: " + aiSecretCode);

//        Confirm AI Level
        Object AI = null;
        if (level == 1 ){
            AI = new EasyProcessor();
        } else if (level == 2 ){
            AI = new MediumProcessor();
        } else if (level == 3){
            AI = new HardProcessor();
        }

        for (int i = 1; i <= totalRound; i++){
//          ------------ Human ---------------
            System.out.println("----------------"+"Round "+i+"--------------------");
            System.out.print("your guess: ");
            HumanProcessor human = new HumanProcessor(capacity,fundamentalCode);
            String humanGuess = human.getSuppliedCode(totalRound, i, auto, codeList);

            int bulls = checkBulls(aiSecretCode, humanGuess);
            int cows = checkCows(aiSecretCode, humanGuess);

            System.out.println(bulls + " bulls and " + cows + " cows");
            if(bulls == 4){
                System.out.println("-------------------------------------------------");
                System.out.println("player win");
                break;
            }
//          ------------- AI ------------------
            String aiGuess = "";
            if (level == 1 ){
                aiGuess = ((EasyProcessor)AI).getAiGuess(allPossibleAnswers);
            } else if (level == 2){
                aiGuess = ((MediumProcessor)AI).getAiGuess(allPossibleAnswers);
            } else if (level == 3){
                aiGuess = ((HardProcessor)AI).getAiGuess(allPossibleAnswers);
            }
            System.out.println("length = " + allPossibleAnswers.size());
            System.out.println("hardAI guess:" + aiGuess);

            bulls = checkBulls(humanSecretCode, aiGuess);
            cows = checkCows(humanSecretCode, aiGuess);

//             This reduce the possible answers each round in hard game
            if (level == 3){
                allPossibleAnswers = ((HardProcessor)AI).processPossibleAnswers(allPossibleAnswers, aiGuess, bulls, cows);
            }
            System.out.println(bulls + " bulls and " + cows + " cows");
            if (bulls == 4 ){
                System.out.println("-------------------------------------------------");
                System.out.println("computer win");
                break;
            }
            if (i == totalRound){
                System.out.println("-------------------------------------------------");
                System.out.println("Draw");
            }
        }
    }

}
