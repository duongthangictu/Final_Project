package bepAnToan_DucThang;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class MuaNgay_Test_ChuyenKhoan extends CommonBase {

	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("https://bepantoan.vn/");
	}

	@Test
	public void orderProduc_Success_Bank() {
		FilterProduct homePage = new FilterProduct(driver);
		homePage.filterHomePage();

		DetailProduct detailProduct = new DetailProduct(driver);
		detailProduct.buyNow();
		pause(2000);

		WebElement isSelected_RadioChuyenKhoan = driver.findElement(detailProduct.radioChuyenKhoan);
		if (isSelected_RadioChuyenKhoan.isSelected() == false) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", isSelected_RadioChuyenKhoan);
		}

		OrderProduct orderDetail = new OrderProduct(driver);
		orderDetail.orderProduct("abc", "0998878555", "123", "123");
		

		pause(2000);
		WebElement titleSuccess = driver.findElement(OrderProduct.titleOrderDetailSuccess);
		assertTrue(titleSuccess.isDisplayed());
	}

	@Test
	public void orderProduc_Fail_BlankHoVaTen_Bank() {
		FilterProduct homePage = new FilterProduct(driver);
		homePage.filterHomePage();

		DetailProduct detailProduct = new DetailProduct(driver);
		detailProduct.buyNow();
		pause(2000);

		WebElement isSelected_RadioChuyenKhoan = driver.findElement(detailProduct.radioChuyenKhoan);
		if (isSelected_RadioChuyenKhoan.isSelected() == false) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", isSelected_RadioChuyenKhoan);
		}

		OrderProduct orderDetail = new OrderProduct(driver);
		orderDetail.orderProduct("", "0998878555", "123", "123");

		WebElement titleFAIL = driver.findElement(OrderProduct.titleOrderDetail_FAIL_HoVaTen);
		assertTrue(titleFAIL.isDisplayed());
	}

	@Test
	public void orderProduc_Fail_BlankSDT_Bank() {
		FilterProduct homePage = new FilterProduct(driver);
		homePage.filterHomePage();

		DetailProduct detailProduct = new DetailProduct(driver);
		detailProduct.buyNow();

		pause(2000);
		WebElement isSelected_RadioChuyenKhoan = driver.findElement(detailProduct.radioChuyenKhoan);
		if (isSelected_RadioChuyenKhoan.isSelected() == false) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", isSelected_RadioChuyenKhoan);
		}

		OrderProduct orderDetail = new OrderProduct(driver);
		orderDetail.orderProduct("abc", "", "123", "123");

		WebElement titleFAIL = driver.findElement(OrderProduct.titleOrderDetail_FAIL_SDT);
		assertTrue(titleFAIL.isDisplayed());
	}
	
	
	@Test
	public void orderProduc_Fail_SDT_Invalid_Bank() {
		FilterProduct homePage = new FilterProduct(driver);
		homePage.filterHomePage();

		DetailProduct detailProduct = new DetailProduct(driver);
		detailProduct.buyNow();

		pause(2000);
		WebElement isSelected_RadioChuyenKhoan = driver.findElement(detailProduct.radioChuyenKhoan);
		if (isSelected_RadioChuyenKhoan.isSelected() == false) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", isSelected_RadioChuyenKhoan);
		}

		OrderProduct orderDetail = new OrderProduct(driver);
		orderDetail.orderProduct("abc", "abc", "123", "123");

		WebElement titleFAIL = driver.findElement(OrderProduct.titleOrderDetail_FAIL_SDT);
		assertTrue(titleFAIL.isDisplayed());
	}

	@Test
	public void orderProduc_Fail_BlankDiaChi_Bank() {
		FilterProduct homePage = new FilterProduct(driver);
		homePage.filterHomePage();

		DetailProduct detailProduct = new DetailProduct(driver);
		detailProduct.buyNow();
		pause(2000);


		WebElement isSelected_RadioChuyenKhoan = driver.findElement(detailProduct.radioChuyenKhoan);
		if (isSelected_RadioChuyenKhoan.isSelected() == false) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", isSelected_RadioChuyenKhoan);
		}

		OrderProduct orderDetail = new OrderProduct(driver);
		orderDetail.orderProduct("abc", "0998878555", "", "123");

		WebElement titleFAIL = driver.findElement(OrderProduct.titleOrderDetail_FAIL_DiaChi);
		assertTrue(titleFAIL.isDisplayed());
	}

	@Test
	public void orderProduc_Fail_BlankAll_Bank() {
		FilterProduct homePage = new FilterProduct(driver);
		homePage.filterHomePage();

		DetailProduct detailProduct = new DetailProduct(driver);
		detailProduct.buyNow();
		pause(2000);

		WebElement isSelected_RadioChuyenKhoan = driver.findElement(detailProduct.radioChuyenKhoan);
		if (isSelected_RadioChuyenKhoan.isSelected() == false) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", isSelected_RadioChuyenKhoan);
		}

		OrderProduct orderDetail = new OrderProduct(driver);
		orderDetail.orderProduct("", "", "", "123");

		WebElement titleFAIL_HoTen = driver.findElement(OrderProduct.titleOrderDetail_FAIL_HoVaTen);
		assertTrue(titleFAIL_HoTen.isDisplayed());

		WebElement titleFAIL_SDT = driver.findElement(OrderProduct.titleOrderDetail_FAIL_SDT);
		assertTrue(titleFAIL_SDT.isDisplayed());

		WebElement titleFAIL_DiaChi = driver.findElement(OrderProduct.titleOrderDetail_FAIL_DiaChi);
		assertTrue(titleFAIL_DiaChi.isDisplayed());
	}
	
//	@Test
//	public void tongDaiTuVan() throws InterruptedException {
//		HomePage homePage = new HomePage(driver);
//		homePage.filterHomePage();
//
//		DetailProduct detailProduct = new DetailProduct(driver);
//		click(detailProduct.tongDaiTuVan);
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		Thread.sleep(2000);
//		alert.dismiss();
////		driver.switchTo().alert().dismiss();
//	}

//	@Test
//	public void hotline() {
//		HomePage homePage = new HomePage(driver);
//		homePage.filterHomePage();
//
//		DetailProduct detailProduct = new DetailProduct(driver);
//		click(detailProduct.hotline);
//		driver.switchTo().alert().dismiss();
//	}

	@AfterTest
	public void closeChome() {
		pause(2000);
		quitDriver(driver);
	}

}
