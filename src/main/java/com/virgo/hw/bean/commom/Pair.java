package com.virgo.hw.bean.commom;

/**
 * javadoc 单例化map
 *
 * @author weng xiaoyong
 * @date 2020/3/5 14:28
 * @version 1.0.0
 */
public class Pair<K, V> {

    private K k;

    private V v;

    private Pair(){

    }

    private Pair(K k, V v){
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }


    public static <K, V>Pair<K, V> empty(){
        return new Pair<>();
    }

    public static <K, V> Pair<K, V> of(K k, V v){
        return new Pair<>(k, v);
    }
}
