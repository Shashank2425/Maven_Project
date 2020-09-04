package org.openqa.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	@Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("On test Starter : "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("on Test Success : "+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Failure Method : "+result.getName());
        
    }
	@Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Skipped "+result.getName());
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("SuccessPercentage : "+ result.getName());
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("On Test Failed with Time out : "+result.getStartMillis());
    }
    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("On Start Method : "+context.getOutputDirectory());
    }
    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("On Finish Method : "+context.getPassedTests());
        System.out.println("On finish Method : "+context.getFailedTests());
    }
}
