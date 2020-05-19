package com.longxw.demo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import org.openjdk.jol.info.ClassLayout;

import java.nio.charset.Charset;

/**
 * @author longxw
 * @since 2020/5/19
 */
public class TestBloomFilter {

    private static long size = 1024 * 1024;
    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create((Funnel<String>) (from, into) -> into.putString((CharSequence) from, Charset.forName("UTF-8")), size);
        bloomFilter.put("123");
        System.out.println(ClassLayout.parseInstance(bloomFilter).toPrintable());
    }
}
