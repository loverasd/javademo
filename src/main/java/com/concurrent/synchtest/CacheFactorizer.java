package com.concurrent.synchtest;


import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * @program: javademo
 * @description: 缓存
 * @author: chenp
 * @create: 2018-10-29 20:00
 **/

public class CacheFactorizer  {
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;
    private long hits;//命中计数器
    private long cacheHits;//缓存命中计数器
    public synchronized long getHits(){return hits;}
    public synchronized double getCacheHitRatio(){
        return (double)cacheHits / (double)hits;
    }
    public void service(ServletRequest req, ServletResponse resp){
//        BigInteger i = extractFromReqst(req);
        BigInteger i =BigInteger.probablePrime(10,new Random());
        BigInteger[] factors = null;
        synchronized (this){
            ++hits;
            if (i.equals(lastNumber)){
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null){
            factors = Arrays.copyOf(factors,factors.length+1);
            synchronized (this){
                lastNumber = i;
                lastFactors =factors.clone();
            }
        }
    }
}