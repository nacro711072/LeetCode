package com.example.forleetcode.thread.fizzbuzz1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

abstract class FizzBuzz {
    private int n;
    private int i = 1;
    private Semaphore semaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    abstract void fizz(Runnable printFizz) throws InterruptedException;

    // printBuzz.run() outputs "buzz".
    abstract void buzz(Runnable printBuzz) throws InterruptedException;

    // printFizzBuzz.run() outputs "fizzbuzz".
    abstract void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException;

    // printNumber.accept(x) outputs "x", where x is an integer.
    abstract void number(IntConsumer printNumber) throws InterruptedException;

    public int getMax() {
        return n;
    }

    protected boolean isByThree(int v) {
        return isBy(v, 3);
    }

    protected boolean isByFive(int v) {
        return isBy(v, 5);
    }

    protected boolean isByFifteen(int v) {
        return isBy(v, 15);
    }

    protected boolean isBy(int v, int d) {
        return (v % d == 0);
    }
}