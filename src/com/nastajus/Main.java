package com.nastajus;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Node> q = new LinkedList<Node>(); //q == a queue.
    static Queue<Node> v = new LinkedList<Node>(); //v == visited.

    public static void main(String[] args) {

        // write your code here
        char start = 'A';
        char target = 'O';
        BFS(start, target);

    }

    public static Node BFS(char start, char target){
        Node a = Node.Get(start);
        q.add(a);

        while (q.size() > 0 ){

            //Node cur = q.poll();
            Node cur = q.remove();
            System.out.println("cur: " + cur.id);
            v.add(cur);
            System.out.println("v: " + cur.id);

            System.out.print("Q: {");
            for( Node m : q ){
                System.out.print(m.id + ", ");
            }
            System.out.println("} @ " + q.size());

            if ( cur.id == target ) {
                System.out.println("matches: " + cur.id);
                return cur;
            }


            for ( Node n : cur.neighbours ){
                if (!q.contains(n) && !v.contains(n)) {
                        System.out.println("q: " + n.id);
                    q.add(n);
                }
            }
        }
        return null;
    }
}