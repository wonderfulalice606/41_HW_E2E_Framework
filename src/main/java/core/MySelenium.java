package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySelenium {
public String[][] a2dim() throws IOException {
	
	String csvFile = "./src/main/resources/My_Title_Validation.csv";
			BufferedReader br = null;
	String line = null;
	String[] column = null;
	int lines = 0;
	int columns = 0;
	String SplitBy = "@";
	String testcase_id = null;
	String url_address = null;
	String expected_title = null;
	
	//counting lines and columns
	
	
	
	br = new BufferedReader(new FileReader(csvFile));
	while ((line = br.readLine()) !=null) {
		lines++;
		column = line.split(SplitBy);
		columns = column.length;
	}
	br.close();
	
	String s2dim[][] = new String[lines][columns];
	br = new BufferedReader(new FileReader(csvFile));
	WebDriver driver = new FirefoxDriver();
	int i = 0;
	while ((line = br.readLine()) !=null) {
		
		String[] csv = line.split(SplitBy);
		
		testcase_id = csv[0];
		url_address = csv[1];
		expected_title = csv[2];
		
		driver.get(url_address);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String actual_title = driver.getTitle();
		
		s2dim[i][0] = testcase_id;
		s2dim[i][1] = expected_title;
		s2dim[i][2] = actual_title;
		i++;
	}
	
	driver.quit();
	br.close();
	return s2dim;
}

	public static void main(String[] args) throws IOException {
		core.MySelenium selenium = new core.MySelenium();
		selenium.a2dim();
	}
}
