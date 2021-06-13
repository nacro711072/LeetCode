package com.example.forleetcode.thread.fizzbuzz1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

public class SemaphoreImpl extends FizzBuzz {
    private int i = 1;
    private Semaphore semaphore = new Semaphore(1);

    public SemaphoreImpl(int n) {
        super(n);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        shouldPrint(printFizz, i -> !isByFifteen(i) && isByThree(i));
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        shouldPrint(printBuzz, i -> !isByFifteen(i) && isByFive(i));
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        shouldPrint(printFizzBuzz, this::isByFifteen);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        shouldPrint(() -> printNumber.accept(i), i -> !isByFifteen(i) && !isByFive(i) && !isByThree(i));
    }

    private void shouldPrint(Runnable runnable, Predicate<Integer> predicate) throws InterruptedException {
        while (i <= getMax()) {
            semaphore.acquire();
            if (i <= getMax()) {
                if (predicate.test(i)) {
                    runnable.run();
                    i++;
                }
            }
            semaphore.release();
        }
    }

}
