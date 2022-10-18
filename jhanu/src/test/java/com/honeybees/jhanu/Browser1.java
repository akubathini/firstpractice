package com.honeybees.jhanu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser1 {
	WebDriver driver;
	@BeforeTest
	public void open_browser() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void open_fb() {
		String Expected_title="Facebook – log in or sign up";
		driver.get("http://facebook.com/");
		verify(Expected_title);
	}
	@Test(priority=3)
	public void open_amazon() {
		String Expected_title="Amazon Sign-In";
		driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		verify(Expected_title);
	}
	@Test(priority=2)
	public void open_flipkart() {
		String Expected_title="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		driver.get("https://www.flipkart.com/");
		verify(Expected_title);
	}
@AfterTest
public void close_browser() throws InterruptedException {
	Thread.sleep(3000);
	driver.close();
}
public void verify(String Expected_title) {
	String actual_title=driver.getTitle();
	System.out.println("driver.getTitle");
	Assert.assertEquals(Expected_title, actual_title);
}
	
}
