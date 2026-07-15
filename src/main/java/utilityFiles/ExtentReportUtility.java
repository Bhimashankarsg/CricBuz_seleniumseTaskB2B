package utilityFiles;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static ExtentReports getExtentReports() {
	ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report.html");
	spark.config().setReportName("CricBuz Automation report");
	spark.config().setDocumentTitle("CricBuzReport");
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS","Windows");
	report.setSystemInfo("Tester","Bhimashankar");
	return report;
	}
}
