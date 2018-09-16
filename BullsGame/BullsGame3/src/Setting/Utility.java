package Setting;

public class Utility {

    public static int checkBulls (String secret, String guess){
        int bulls = 0;
        String[] a = converStringToArray(secret);
        String[] b = converStringToArray(guess);

        for(int i = 0; i < a.length; i++){
            if(a[i].equals(b[i])){
                bulls += 1;
            }
        }
        return bulls;
    }

    public static int checkCows(String secret, String guess){
        int cows = 0;
        String[] a = converStringToArray(secret);
        String[] b = converStringToArray(guess);

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                if(a[i].equals(b[j])){
                    cows++;
                }
            }
        }
        cows = cows - checkBulls(secret, guess);
        return cows;
    }

    public static String[] converStringToArray(String str) {
        String[] arr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Character.toString(str.charAt(i));
        }
        return arr;
    }

    public static String converArrayToString(String[] arr) {
        String str = "";
        for (String elment : arr) {
            str += elment;
        }
        return str;
    }
}
