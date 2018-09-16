package CodeProcessor;

import java.util.ArrayList;


public abstract class GameProcessor {
    public int round;

    GameProcessor() {
        round = 7;
    }

    public String getAISecretCode(ArrayList<String> allPossibleAnswers){
            String aiSecretCode = getCode(allPossibleAnswers);
            return aiSecretCode;
    }

    public abstract String getAiGuess(ArrayList<String> allPossibleAnswers);

    public String getCode(ArrayList<String> possibleAnswers) {
        int length = possibleAnswers.size();
        String code = possibleAnswers.get((int) (Math.random() * length));
        return code;
    }


}
