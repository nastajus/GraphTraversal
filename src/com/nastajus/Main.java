package com.nastajus;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Node> q = new LinkedList<Node>(); //q == a queue.
    static Queue<Node> v = new LinkedList<Node>(); //v == visited.

    public static void main(String[] args) {

        // write your code here
        char target = 'O';
        BFS(target);

    }

    public static Node BFS(char target){
        Node a = Node.Get('A');
        q.add(a);

        search:
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
            System.out.println("}");

            for ( Node n : cur.neighbours ){
                if ( q.contains(target) ){
                    System.out.println("break occurred");
                    break search;
                }
                if ( cur.id == target ) {
                    System.out.println("matches: " + cur.id);
                    return n;
                }
                else {
                    System.out.println("q: " + n.id);
                    q.add(n);
                }
            }
        }
        return null;
    }
}
