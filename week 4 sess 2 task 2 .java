import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                alice++;
            } else if (a.get(i) < b.get(i)) {
                bob++;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(alice);
        result.add(bob);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aTemp = bufferedReader.readLine().split(" ");
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            a.add(Integer.parseInt(aTemp[i]));
        }

        String[] bTemp = bufferedReader.readLine().split(" ");
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            b.add(Integer.parseInt(bTemp[i]));
        }

        List<Integer> result = Result.compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

output:
nput (stdin)
5 6 7
3 6 10
Your Output (stdout)
1 1
Expected Output
1 1