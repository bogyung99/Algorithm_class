package Practice12;

import java.io.File;

public class client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("DFS.txt");
        Graph g = new Graph(file);

        DepthFirstPaths dfs = new DepthFirstPaths(g,0);

        System.out.println(g.toString());
        System.out.println(dfs.pathTo(4));
    }
}