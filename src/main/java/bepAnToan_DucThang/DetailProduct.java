package bepAnToan_DucThang;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automation.common.CommonBase;

public class DetailProduct extends CommonBase {
	private By outer_Click = By.xpath("//span[text()='tại sao mua hàng ở bếp an toàn']");
	private By muaNgay = By.xpath("(//span[text()='Giao hàng và lắp đặt miễn phí 100%'])[1]");

	public By tongDaiTuVan = By.xpath("//span[text()='Tổng đài tư vấn']");
	public By hotline = By.xpath("//span[text()='Hotline']");

	public By nhapSDTThongTinKM = By.xpath("(//input[@placeholder='Nhập số điện thoại nhận thông tin khuyến mãi'])[1]");
	public By btnDangKyNgay = By.xpath("(//div[normalize-space()='Đăng ký ngay'])[2]");
	public By dangKyThanhCong = By.xpath("(//div[text()='Đăng ký thành công'])[1]");

	public By radioChuyenKhoan = By.xpath("//input[@id='checkout-type-1']");
//	@FindBy(xpath = "(//span[@class='checkmark'])[2]")
//	private WebElement radioChuyenKhoan_2;

	public DetailProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Chuc nang Mua ngay
	public void buyNow() {
		click(outer_Click); // click ra 1 cho bat ki
		pause(500);
		click(muaNgay);
	}

	public void nhapSDTThongTinKM() {
		click(outer_Click); // click ra 1 cho bat ki
		((JavascriptExecutor) driver).executeScript("window.scroll(0, 400)");
		click(nhapSDTThongTinKM);
		WebElement thongTinKM = driver.findElement(nhapSDTThongTinKM);
		thongTinKM.sendKeys("0998878555");
		click(btnDangKyNgay);
		pause(2000);
		WebElement checkDangKyThanhCong = driver.findElement(dangKyThanhCong);
		Assert.assertTrue(checkDangKyThanhCong.isDisplayed());
	}
}
