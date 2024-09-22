import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Contest371Taro {
    public static void main(String[] args) throws IOException {
        FScanner scanner = new FScanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Map<Integer, Boolean> isTaro = new HashMap<>();

        while (m-- > 0) {
            int family = scanner.nextInt();
            char gender = scanner.next().charAt(0);

            if (gender == 'F') {
                System.out.println("No");
                continue;
            }
            if (isTaro.containsKey(family)) isTaro.put(family, false);
            else isTaro.put(family, true);

            if (isTaro.get(family)) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    static class FScanner {
        StringTokenizer st;
        BufferedReader br;

        public FScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}