package CodeProcessor;

import java.util.ArrayList;

public class MediumProcessor extends GameProcessor{

    @Override
    public String getAiGuess(ArrayList<String> allPossibleAnswers) {
        String mediumGuess = getCode(allPossibleAnswers);
        allPossibleAnswers.remove(mediumGuess); // To avoid guessing the same code
        return mediumGuess;
    }
}
