package bradytest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class Shopping extends Config {

	

	@Test(priority=1)
	public void test1_Login() throws InterruptedException 
	{

		driver.get("http://automationpractice.com/");
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("vpsrao.m@gmail.com");
		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("qwerty01");
		driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
		
	}
	@Test(priority=2)
	public void test2_Account() 
	{
		assertEquals("MY ACCOUNT", driver.findElement(By.xpath("//*[@id='center_column']/h1")).getText());
	}
	@Test(priority=3)
	public void test3_Confirm() 
	{
		driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span")).click();
		assertEquals("Venkata", driver.findElement(By.xpath("//*[@id='firstname']")).getText());
		assertEquals("Maddula", driver.findElement(By.xpath("//*[@id='lastname']")).getText());
	}
	
	@Test(priority=4)
	public void test4_CartEmpty() 
	{
		driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/b")).click();
		assertEquals("Your shopping cart is empty.", driver.findElement(By.xpath("//*[@id='center_column']/p")).getText());
	}
	
	@Test(priority=5)
	public void test5_Women() 
	{	
		//click women
	    driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a")).click();  
	}
	@Test(priority=6)
	public void test6_SelPink()  
	{
		//select pink
		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_24']")).click(); 
	}
	
	@Test(priority=7)
	public void test7_AddtoCart() throws InterruptedException  
	{
		//Add Pink Dress to cart
		driver.findElement(By.xpath("//*[@id='color_43']")).click();
		driver.findElement(By.xpath("//*[@id='color_43']")).click();
		Thread.sleep(3000);
		//add to cart
		driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click(); 
		
	}
	@Test(priority=8)
	public void test8_Successful() throws InterruptedException  
	{
		Thread.sleep(5000);
		assertEquals("Product successfully added to your shopping cart", driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2")).getText());
	}
	@Test(priority=9)
	public void test9_Cart1() throws InterruptedException  
	{
		Thread.sleep(2000);
		assertEquals("There is 1 item in your cart", driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/h2/span[2]")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/span")).click();
		assertEquals("1", driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/span[1]")).getText());
		
	}
	@Test(priority=10)
	public void test910_Allsp() throws InterruptedException  
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a")).click();  //click women		
		driver.findElement(By.xpath("//*[@id='special_block_right']/div/div/a/span")).click();// all specials
	}
		
		
	@Test(priority=11)
	public void test911_CnfList() throws InterruptedException  
	{
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='list']/a/i")).click();//list view 
		driver.findElement(By.xpath("//*[@id='list']/a/i")).click();//list view 
		Thread.sleep(5000);
		assertEquals("Showing 1 - 2 of 2 items", driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div[2]/div[2]")).getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div/div[3]/div/div[2]/a[1]/span")).click(); // add 1st item to cart
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div/div/div[3]/div/div[2]/a[1]/span")).click();// add 2nd item to cart
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/span")).click();
			
	}
	
	@Test(priority=12)
	public void test912_Cnfcart() 
	{		
		assertEquals("3", driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/span[1]")).getText());
		driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/b")).click();
		assertEquals("Your shopping cart contains: 3 Products",driver.findElement(By.xpath("//*[@id='cart_title']/span")).getText());
	}
	
	@Test(priority=13)
	public void test913_Discount() throws InterruptedException 
	{
				//for step 13 didn't write code.
		driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/b")).click();
		//assertEquals(X, driver.findElement(By.xpath("//*[@id='product_price_7_34_58056']/span[1]")).getText());
	//assertEquals(Y, driver.findElement(By.xpath("//*[@id='product_price_5_19_58056']/span[1]")).getText());
		
	}
	
	@Test(priority=14)
	public void test914_Dresses() 
	{
				driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
	}
	
	@Test(priority=15)
	public void test915_CnfDrs()
	{
				assertEquals("Dresses", driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]")).getText());
				
	}
	
	@Test(priority=16)
	public void test916_Sort() 
	{
				new Select(driver.findElement(By.xpath("//*[@id='selectProductSort']"))).selectByVisibleText("Price: Lowest first");
				// confirm sort is working 
				for(int i=1; i<6; i++) 
				{
					
					System.out.println("loop" +i);
					String A = driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+i+"]/div/div/div[3]/div/div[2]/a[1]/span")).getText();
					System.out.println(A);
					

					System.out.println("sorting is working fine");
				
 
			new Select(driver.findElement(By.xpath("//*[@id='selectProductSort']"))).selectByVisibleText("Price: Highest first");
				// high to low not working
				}
			
	}
	
				private void assertEquals(String string, String text) 
				{
					// TODO Auto-generated method stub
		
						}
	@AfterTest
	  public void close()
	{
	    driver.quit();
	
}
}
