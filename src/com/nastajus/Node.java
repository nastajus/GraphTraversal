package com.nastajus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by IAN on 20/11/14.
 */
public class Node {

    public char id;
    public HashSet<Node> neighbours;

    public static Node Get(char id){
        if (lookup.containsKey(id)){
            return lookup.get(id);
        }else{
            return new Node(id);
        }
    }

    /////////The rest of the code is useless to your current activity. Feel free to look at it later/////

    //Static Constructor
    static{
        lookup = new HashMap<Character, Node>();
        SetupGraph(); }
    //You are not allowed to make nodes without checking the lookup.
    private Node(char id){
        this.id = id;
        neighbours = new HashSet<Node>();
        Memoize(id);
    }

    private static void SetupGraph(){
        Node.Get('A').ConnectTo('D').ConnectTo('C').ConnectTo('Q');
        Node.Get('A').ConnectTo('E').ConnectTo('F').ConnectTo('P');
        Node.Get('A').ConnectTo('H').ConnectTo('G').ConnectTo('O');
        Node.Get('A').ConnectTo('J').ConnectTo('K').ConnectTo('I');
        Node.Get('J').ConnectTo('M').ConnectTo('N');
        Node.Get('M').ConnectTo('K').ConnectTo('H').ConnectTo('L');
        Node.Get('G').ConnectTo('E').ConnectTo('D');
        Node.Get('A').ConnectTo('B');
    }

    private Node ConnectTo(char id){
        Node n = Node.Get(id);
        n.neighbours.add(this);
        this.neighbours.add(n);
        return n;
    }

    //A short Puzzle. Find out what this code does.
    private static HashMap<Character, Node> lookup;

    private void Memoize(char id) {
        if (lookup.containsKey(id)){
            Node old = lookup.get(id);
            for(Node n : old.neighbours){
                while(n.neighbours.contains(old)){
                    n.neighbours.remove(old);
                }
            }
            lookup.remove(id);
        }
        lookup.put(id, this);
    }
}
