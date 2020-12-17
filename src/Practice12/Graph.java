package Practice12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int V = 0;
    private int E = 0;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;

        adj = new List[V];

        for(int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    public Graph(File file) {
        int c = 1;

        try {
            file = new File("//C:/Users/bogun/IdeaProjects/algorithm/src/Practice12/"+file);

            // 파일에서 입력받음
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            // 라인단위로 불러오기
            String l = "";
            // 여기서 바로 라인 단위하면 배열 에러생김

            while((l = br.readLine()) != null) {
                // if로 하면 마지막 break때문에 출력에 문제?
                switch(c) {
                    case 1:
                        V = Integer.parseInt(l);

                        // new Graph(V);

                        adj = new List[V];

                        for(int v = 0; v < V; v++) {
                            adj[v] = new LinkedList<Integer>();
                        }

                        break;

                        case 2:
                        E = Integer.parseInt(l);

                        break;

                    default:
                        String[] tmp = l.split(" ");

                        adj[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
                        adj[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));

                        break;
                }
                c++;
            }
            // 입출력 후에 닫아주기
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        for(List<Integer> list : adj) {
            E += list.size();
        }
        return E/2;
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for(int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;

        for(int v = 0; v < G.V(); v++) {
            if(degree(G,v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    public static double averageDegree(Graph G) {
        return 2.0 * G.E() /G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count =0;
        for(int v=0;v<G.V();v++) {
            for(int w : G.adj(v)) {
                if(v==w) count ++;
            }
        }
        return count/2;
    }

    public String toString() {
        String s = V +" vertices, "+ E + " edges, 4까지의 path\n\n";

        for(int v = 0; v < V; v++) {
            s += v + ": ";

            for(int w : this.adj(v))
                s += w+" ";

            s += "\n";
        }
        return s;
    }

}
