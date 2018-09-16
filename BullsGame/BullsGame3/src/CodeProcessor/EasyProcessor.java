package CodeProcessor;


import java.util.ArrayList;

public class EasyProcessor extends GameProcessor {

    @Override
    public String getAiGuess(ArrayList<String> possibleAnswers) {
        String easyGuess = getCode(possibleAnswers);
        return easyGuess;
    }
}