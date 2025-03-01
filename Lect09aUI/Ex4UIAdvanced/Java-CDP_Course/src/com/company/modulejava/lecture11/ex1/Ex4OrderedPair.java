package com.company.modulejava.lecture11.ex1;

public class Ex4OrderedPair <K, V> implements Ex3Pair<K, V>{
    private K key;
    private V value;

    public Ex4OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }

    public static void main(String[] args) {
        Ex3Pair<String, Integer> p1 = new Ex4OrderedPair<String, Integer>("Even", 8);
        Ex3Pair<String, String>  p2 = new Ex4OrderedPair<String, String>("hello", "world");

        Ex3Pair<String, Integer> p5 = new Ex4OrderedPair<>("Even", 8);
        Ex3Pair<String, Integer> p6 = new Ex4OrderedPair<>("Even", 8);


        Ex4OrderedPair<String, Integer> p3 = new Ex4OrderedPair<>("Even", 8);
        Ex4OrderedPair<String, String>  p4 = new Ex4OrderedPair<>("hello", "world");

        Ex4OrderedPair<String, Ex2Box<Integer>> p = new Ex4OrderedPair<>("primes", new Ex2Box<Integer>());
        Ex4OrderedPair<String, Ex2Box<Integer>> p12 = new Ex4OrderedPair<>("primes", new Ex2Box<>());

    }
}
