package CodeProcessor;

import java.util.ArrayList;

public interface modifyPossibleAnswers {
     ArrayList<String> processPossibleAnswers(ArrayList<String> possibleAnswers, String previousCode,
                                                    int previousBulls, int previousCows);
}
