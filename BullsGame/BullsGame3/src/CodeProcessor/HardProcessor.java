package CodeProcessor;


import java.util.ArrayList;

import static Setting.Utility.checkBulls;
import static Setting.Utility.checkCows;

public class HardProcessor extends GameProcessor implements modifyPossibleAnswers{

    @Override
    public String getAiGuess(ArrayList<String> allPossibleAnswers) {
        String hardGuess = getCode(allPossibleAnswers);
        return hardGuess;
    }
    @Override
    public ArrayList<String> processPossibleAnswers(ArrayList<String> possibleAnswers, String previousCode,
                                                    int previousBulls, int previousCows) {
        ArrayList<String> newPossibleAnswers = new ArrayList<>();
        for (String element : possibleAnswers) {
            // System.out.println("element:" + element);
            if ((checkBulls(previousCode, element) == previousBulls
                    && checkCows(previousCode, element) == previousCows)) {
                newPossibleAnswers.add(element);
            }
        }
        return newPossibleAnswers;
    }

}
