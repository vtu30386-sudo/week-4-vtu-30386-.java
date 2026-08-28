import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int n = s.length();

            String left = s.substring(0, n / 2);
            String right;

            if (n % 2 == 0) {
                right = s.substring(n / 2);
            } else {
                right = s.substring(n / 2 + 1);
            }

            char[] a = left.toCharArray();
            char[] b = right.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            if (Arrays.equals(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

output:
Sample Input
6
gaga
abcde
rotor
xyzxy
abbaab
ababc
Your Output
YES
NO
YES
YES
NO
NO