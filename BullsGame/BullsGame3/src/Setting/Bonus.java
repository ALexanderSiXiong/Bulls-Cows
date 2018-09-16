package Setting;


public class Bonus{

    public int modifyRound() {
        System.out.println("-------------------------------------------------");
        System.out.println("How many rounds you would like to play ?");
        String userRound;
        int i = 0;
        do {
            if (i != 0) {
                System.out.println("please input a number");
            }
            userRound = Keyboard.readInput();
            i = 1;
        } while (!isNum(userRound));

        return Integer.parseInt(userRound);
    }

    public String modifyFundamentalCode(){
        System.out.println("-------------------------------------------------");
        System.out.println("You can self-design the fundamental code.");
        String userFundamentalCode;
        int i = 0;
        do {
            if (i != 0) {
                System.out.println("Cannot be empty! Cannot have repeated element ! \nPlease redesign it.");
            }
            userFundamentalCode = Keyboard.readInput();
            i = 1;
        } while( !(isRepeated(userFundamentalCode) && !userFundamentalCode.isEmpty()) );

        return userFundamentalCode;
    }

    public int modifyCapacity(String fundamentalCode){
        System.out.println("-------------------------------------------------");
        System.out.println("Design the capacity ?");
        String userCapacity;
        int i = 0;
        do {
            if (i != 0) {
                System.out.println("please input a number");
            }
            userCapacity = Keyboard.readInput();
            i = 1;
        } while (!isNum(userCapacity) || !(Integer.parseInt(userCapacity) <= fundamentalCode.length()-1));

        return Integer.parseInt(userCapacity);
    }

    public boolean isNum(String userRound) {
        try {
            Integer.parseInt(userRound);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isRepeated(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.indexOf(str.charAt(i), i + 1) != -1) {
                return false;
            }
        }
        return true;
    }
}
