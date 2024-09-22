import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Contest371Jiro {
    public static void main(String[] args) throws IOException {
        FScanner scanner = new FScanner(System.in);
        String input = scanner.nextLine();
        char SAB = input.charAt(0);
        char SAC = input.charAt(2);
        char SBC = input.charAt(4);

        // Possible orders of the brothers
        String[] orders = {"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};

        for (String order : orders) {
            char first = order.charAt(0);
            char second = order.charAt(1);
            char third = order.charAt(2);

            boolean valid = true;

            // Check SAB
            if (SAB == '<' && !(first == 'A' && second == 'B' || first == 'A' && third == 'B' || second == 'A' && third == 'B')) {
                valid = false;
            }
            if (SAB == '>' && !(first == 'B' && second == 'A' || first == 'B' && third == 'A' || second == 'B' && third == 'A')) {
                valid = false;
            }

            // Check SAC
            if (SAC == '<' && !(first == 'A' && second == 'C' || first == 'A' && third == 'C' || second == 'A' && third == 'C')) {
                valid = false;
            }
            if (SAC == '>' && !(first == 'C' && second == 'A' || first == 'C' && third == 'A' || second == 'C' && third == 'A')) {
                valid = false;
            }

            // Check SBC
            if (SBC == '<' && !(first == 'B' && second == 'C' || first == 'B' && third == 'C' || second == 'B' && third == 'C')) {
                valid = false;
            }
            if (SBC == '>' && !(first == 'C' && second == 'B' || first == 'C' && third == 'B' || second == 'C' && third == 'B')) {
                valid = false;
            }

            if (valid) {
                System.out.println(second);
                break;
            }
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