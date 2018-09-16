package CodeProcessor;

import java.util.ArrayList;

public class HumanProcessor {

    String fundamentalCode;
    int capacity;
    HumanCode human;

    public HumanProcessor(int capacity, String fundamentalCode){
        this.capacity = capacity;
        this.fundamentalCode = fundamentalCode;
    }

    public String getHumanGuess(){
        this.human = new HumanCode(capacity, fundamentalCode);
        String humanGuess = human.getCode(null);
        return humanGuess;
    }

    public String getSuppliedCode(int totalRound,int iRound,boolean auto, ArrayList<String> suppliedCode){
        String humanGuess = "";
        HumanProcessor human = new HumanProcessor(capacity, fundamentalCode);
        if (!auto){
            humanGuess = human.getHumanGuess();
            System.out.println(humanGuess);
        } else if (auto){
            // To check the number of supplied code weather equal the round
            if (suppliedCode.size() == totalRound){
                humanGuess = suppliedCode.get(iRound - 1);
                System.out.println(humanGuess);
            } else if (suppliedCode.size() != totalRound){
                // To check the number of supplied code is more or less than the round
                if (suppliedCode.size() > totalRound){
                    humanGuess = suppliedCode.get(iRound - 1);
                    System.out.println(humanGuess);
                } else if (suppliedCode.size() < totalRound){
                    // There are not enough supplied code for the total round in this case
                    // To check weather need human guesses the code
                    if (suppliedCode.size() >= iRound){
                        humanGuess = suppliedCode.get(iRound- 1);
                        System.out.println(humanGuess);
                    } else if (suppliedCode.size() < iRound){
                        humanGuess = human.getHumanGuess();
                    }
                }
            }
        }
        return humanGuess;
    }
}
