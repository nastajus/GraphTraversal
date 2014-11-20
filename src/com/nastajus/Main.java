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
        while (q.size() > 0 ){
            Node cur = q.remove();
            v.add(cur);
            //Node cur = q.poll();
            for ( Node n : cur.neighbours ){
                if ( cur.id == target ) {
                    return n;
                }
                else {
                    v.add(n);
                    q.add(n);
                }
            }
        }
        return null;
    }
}
