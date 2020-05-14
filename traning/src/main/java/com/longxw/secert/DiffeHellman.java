package com.longxw.secert;

/**
 * 迪菲赫尔曼算法
 * @author longxw
 * @since 2020/5/14
 */
public class DiffeHellman {

    public static void main(String[] args) {
        /**
         * 用户 diffe 和 hellman 约定使用 p=23 , g=5
         *
         * diffe选择一个数(秘钥) a=6, 计算 g的a次幂 mod p， 记做 diffe-public，发给 hellman
         * hellman 选择一个数(秘钥) b=15， 计算 g的b次幂 mod p，记做 hellman-public， 发给 diffe
         *
         * diffe 计算 hellman-public 的 a次幂 mod p，得出秘钥
         *
         * hellman 计算 diffe-public 的 b次幂 mod p，得出秘钥
         *
         */

        System.out.println(a());
        System.out.println(b());

    }

    public static Integer a(){
        Integer base = 2;
        Integer p = 17;
        Integer secret = 37;

        return (getPublicB() << secret) % p;
    }

    public static Integer b(){
        Integer base = 2;
        Integer p = 17;
        Integer secret = 71;
        return (getPublicA() << secret) % p;

    }

    public static Integer getPublicA(){
        return (2<<37) % 17;
    }

    public static Integer getPublicB(){
        Integer i =  (2 << 71) % 17;
        System.out.println("B 公钥:" + i);
        return i;
    }


}
