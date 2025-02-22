package framework2.ExtentReportss;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count=0;
		int maxtry=1;
		if(count<maxtry) {
			count++;
			return true;
		}
		return false;
	}

}
