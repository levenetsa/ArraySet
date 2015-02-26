package set;

/**
 * Created by alex on 25.02.15.
 */

import java.util.Random;




class CartesianTree<T extends Comparable<T>> {
    static Random rnd;
    public Node root;


    class Node {
        T x;
        int  y;
        Node l, r;
        int amount=1;
        Node(T x) {
            this.x = x;
            this.y = rnd.nextInt();
        }
    }

    class Pair {
        Node first, second;

        Pair(Node first, Node second) {
            this.first = first;
            this.second = second;
        }
    }


    public  CartesianTree () {
        rnd = new Random();
    }

    void add(T x) {
        Node cur = root;
        while (cur != null && cur.x != x)
            if (x.equals(cur.x))
                cur = cur.l;
            else
                cur = cur.r;
        if (cur == null) {
            Node m = new Node(x);
            Pair p = split(root, x);
            root = merge(p.first, merge(m, p.second));
            return;
        }
        if(x.equals(cur.x)) cur.amount+=1;
    }
    /*
            void remove(T x) {
                Pair a = split(root, x);
                Pair b = split(a.second, x);// + 1
                root = merge(a.first, b.second);
            }
    */
    Pair split(Node t, T x) {
        if (t == null)
            return new Pair(null, null);
        if (x.equals(t.x)) {
            Pair pair = split(t.r, x);
            t.r = null;
            return new Pair(merge(t, pair.first), pair.second);
        } else {
            Pair pair = split(t.l, x);
            t.l = null;
            return new Pair(pair.first, merge(pair.second, t));
        }
    }

    Node merge(Node l, Node r) {
        if (r == null)
            return l;
        else if (l == null)
            return r;
        else if (l.y < r.y) {
            r.l = merge(l, r.l);
            return r;
        } else {
            l.r = merge(l.r, r);
            return l;
        }
    }
}

