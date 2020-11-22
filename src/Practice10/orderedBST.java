package Practice10;

import java.util.Scanner;
import static java.lang.System.exit;

public class orderedBST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;

        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    // rank 서브트리 노드 카운트 size에서 가져오기
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;

        int cmp = key.compareTo(x.key);

        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);

        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;

        // 자기자신 포함
        x.size = 1 + size(x.left) + size(x.right);

        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        // x가 널이면 널 반환 -> 시작
        if (x == null) return null;

        int cmp = key.compareTo(x.key);

        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    // floor와 반대 같거나 큰것 중 가장 가까운 것
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }

        return ceiling(x.right, key);
    }

    public void inorder(Node node) {
        if(node == null) return;

        inorder(node.left);

        System.out.print(node.key + " ");

        inorder(node.right);
    }

    public static void  main(String[] args) {
        orderedBST<String, Integer> bst = new orderedBST<String,Integer>();

        Scanner s= new Scanner(System.in);

        int v = 0;

        while(true){
            System.out.println("\n수행할 작업을 선택하세요");
            System.out.println("1.Insert 2.Delete 3.Show BST 4.exit");

            int n = s.nextInt();

            switch (n){
                case 1:
                    System.out.println("\n노드를 넣어주세요.");
                    String key = s.next();

                    bst.put(key, v);
                    v++;
                    break;

                case 2:
                    if(bst.root == null)
                        System.out.println("\n트리가 비었습니다.");
                    else{
                        System.out.println("\n삭제할 노드의 키를 입력하세요.");
                        String k = s.next();
                        bst.delete(k);
                    }

                    break;

                case 3:
                    if(bst.root == null)
                        System.out.println("\n트리가 비었습니다.");
                    else{
                        System.out.print("\n");
                        bst.inorder(bst.root);
                        System.out.print("\n");
                    }
                    break;

                default:
                    exit(0);
                    break;
            }
        }
    }
}
