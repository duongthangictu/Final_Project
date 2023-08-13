package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.DetailProduct;
import automation.PageLocation.FilterProduct;
import automation.common.CommonBase;

public class ChuongTrinhKM_Test extends CommonBase {

	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("https://bepantoan.vn/");
	}

	@Test
	public void SDT_ThongTinKM() {
		FilterProduct homePage = new FilterProduct(driver);
		homePage.filterHomePage();

		DetailProduct detailProduct = new DetailProduct(driver);
		detailProduct.nhapSDTThongTinKM();
	}

	@AfterTest
	public void closeChome() {
		pause(2000);
		quitDriver(driver);
	}

}
