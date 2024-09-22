import java.io.*;
import java.util.*;
import java.util.function.Consumer;


public class Contest371MakeIsomorphic {


    public static final int MOD = 1000000007;

    void permute(int[] p, int pos, Consumer<int[]> f)
    {
        if(pos == p.length)
        {
            f.accept(p);
            return;
        }

        for(int j=pos;j<p.length;j++)
        {
            int tmp = p[pos];
            p[pos] = p[j];
            p[j] = tmp;

            permute(p, pos+1, f);

            p[j] = p[pos];
            p[pos] = tmp;
        }
    }

    long cost = Long.MAX_VALUE;

    public void solve() throws IOException {
        int n = in.nextInt();

        int[][] H = new int[n][n];
        int[][] G = new int[n][n];

        int gE = in.nextInt();
        for(int i=0;i<gE;i++)
        {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            G[u][v] = G[v][u] = 1;
        }

        int hE = in.nextInt();
        for(int i=0;i<hE;i++)
        {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            H[u][v] = H[v][u] = 1;
        }

        int[][] A = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                A[i][j] = A[j][i] = in.nextInt();

        int[] perm = new int[n];
        for(int i=0;i<n;i++)
            perm[i] = i;



        permute(perm, 0, p->{
            long curCost = 0;
            for(int i=0;i<n;i++)
                for(int j=i+1;j<n;j++)
                {
                    int uG = i;
                    int vG = j;
                    int uH = perm[i];
                    int vH = perm[j];

                    if(G[uG][vG] != H[uH][vH])
                        curCost += A[uH][vH];
                }
            cost = Math.min(cost, curCost);
        });

        out.println(cost);
    }


    private QuickReader in;
    private PrintWriter out;

    public Contest371MakeIsomorphic(QuickReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public static void main(String[] args) throws IOException {
        QuickReader in = new QuickReader(System.in);

        try(PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));)
        {
            new Contest371MakeIsomorphic(in, out).solve();
        }
    }

    static class QuickReader {
        StringTokenizer st;
        BufferedReader br;

        public QuickReader(InputStream s) {
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

