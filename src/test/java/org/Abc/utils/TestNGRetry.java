package org.Abc.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry implements IRetryAnalyzer {
    //private int retryCount = 0;
    ThreadLocal<Integer> retryCount = ThreadLocal.withInitial(()->0);
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount.get() < maxRetryCount) {
            retryCount.set(retryCount.get()+1);
            return true;
        }
        return false;
    }
}
