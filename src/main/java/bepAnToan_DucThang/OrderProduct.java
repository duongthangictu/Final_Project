package bepAnToan_DucThang;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class OrderProduct extends CommonBase {

	WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Nhập họ và tên']")
	private WebElement txtHoVaTen;

	@FindBy(xpath = "(//input[@placeholder='Nhập họ và tên'])[2]")
	private WebElement txtHoVaTen_TraGop;

	@FindBy(xpath = "//input[@placeholder='Nhập số điện thoại']")
	private WebElement txtSDT;

	@FindBy(xpath = "//input[@placeholder='Nhập số nhà, tên đường, phường/ xã, quận/huyện, tỉnh/ thành phố']")
	private WebElement txtDiaChi;

	@FindBy(xpath = "//textarea[@placeholder='Nhập lưu ý']")
	private WebElement txtLuuY;

	@FindBy(xpath = "//span[text()='Thanh toán']")
	private WebElement btnThanhToan;

	private By thongTinQuyKhachHang = By.xpath("Thông tin quý khách hàng"); // de verify da chuyen sang man hinh thanh
																			// cong

	private By btnTHanhToan1 = By.xpath("//span[text()='Thanh toán']");

//	@FindBy(xpath = "//h1[text()='Đặt Hàng Thành Công']")
//	private WebElement titleOrderDetailSuccess;
	public static By titleOrderDetailSuccess = By.xpath("//h1[text()='Đặt Hàng Thành Công']");

	public static By titleOrderDetail_FAIL_HoVaTen = By.xpath("//small[normalize-space()='Họ và tên không hợp lệ']");
	public static By titleOrderDetail_FAIL_SDT = By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']");
	public static By titleOrderDetail_FAIL_DiaChi = By.xpath("//small[normalize-space()='Địa chỉ không hợp lệ']");

	public OrderProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void orderProduct(String hoVaTen, String SDT, String diaChi, String luuY) {
		pause(2000);
//		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinQuyKhachHang));

//		isElementPresent(thongTinQuyKhachHang);

		txtHoVaTen.sendKeys(hoVaTen);
		txtSDT.sendKeys(SDT);
		txtDiaChi.sendKeys(diaChi);
		txtLuuY.sendKeys(luuY);

		pause(2000);
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
		// btnThanhToan);
//		clickJavaScript(btnTHanhToan1);
		((JavascriptExecutor) driver).executeScript("window.scroll(0,-250)");
		btnThanhToan.click();
		
//		((JavascriptExecutor) driver).executeScript("window.scroll(0, 250)");
		

	}

	public void orderProduct_TraGop(String hoVaTen) {
		pause(2000);
		txtHoVaTen_TraGop.sendKeys(hoVaTen);

	}
}
