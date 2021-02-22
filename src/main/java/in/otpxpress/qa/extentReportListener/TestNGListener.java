package in.otpxpress.qa.extentReportListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestNGListener implements ITestListener{
	
	private static long endTime;
    private static void setStartTime(long startTime) {
    }
    private static void setEndTime(long endTime) {
    	TestNGListener.endTime = endTime;
    }

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("--------- Executing :- " + getSimpleMethodName(result) + " ---------");
        ExtentTestManager.createTest(result.getName(),result.getMethod().getDescription());
        ExtentTestManager.setCategoryName(getSimpleClassName(result));
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        addExtentLabelToTest(result);
        ExtentTestManager.endTest();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        ExtentTestManager.getTest().log(Status.FAIL, result.getName() + " Test is failed" +result.getThrowable());
        
        addExtentLabelToTest(result);
        ExtentTestManager.endTest();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, result.getName() + " Test is Skipped" +  result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
//		setStartTime(context.getStartDate().getTime());
//        setEndTime(context.getEndDate().getTime());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
     private synchronized String getSimpleClassName(ITestResult result) {
        return result.getMethod().getRealClass().getSimpleName();
    }
    private synchronized String getSimpleMethodName(ITestResult result) {
        return result.getName();
    }
    private synchronized void addExtentLabelToTest(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS)
            ExtentTestManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
        else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
        } else
            ExtentTestManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
    }

	
	

}
