package random;

import java.util.ArrayList;
import java.util.Random;

public class IDPerson {
    private String id = "0123456789";
    private Random generate = new Random();

    public int rand(int min, int max) {
        return generate.nextInt(max - min + 1) + min;
    }

    public String getId() {
        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; ++i) {
            do {
                int number = rand(0, id.length() - 1);
                if (checkExit(number, result) == false) {
                    result.add(number);
                    char idPerson = id.charAt(number);
                    sb.append(idPerson);
                    break;
                }
            } while (true);

        }
        return sb.toString();
    }

    public boolean checkExit(int id, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            if (id == list.get(i)) {
                return true;
            }
        }
        return false;
    }

}
