package com.entrata.automation.tests;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.entrata.automation.pages.GuidePage;
import com.entrata.automation.pages.LandingPage;
import com.entrata.automation.testcomponents.BaseTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DownloadGuideTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(DownloadGuideTest.class);

//	@Test
//	public void forceFailTest() {
//		Assert.fail("Intentional failure to test screenshot capture.");
//	}

	@Test(dataProvider = "formDataProvider")
	public void testDownloadGuideForm(String firstName, String lastName, String email, String company, String phone,
			String jobTitle, int expectedValue) throws InterruptedException {

		logger.info("===== Starting test: testForm =====");

		LandingPage landingpage = new LandingPage(driver);
		GuidePage guidepage = new GuidePage(driver);
		// Scroll to the image
		landingpage.scrollToElement(driver, landingpage.imageElement);

		// Hover over the image
		landingpage.moveToElement(driver, landingpage.imageElement);

		// Click the link that appears on hover
		landingpage.hoverLink.click();

		// Wait for element to appear
		guidepage.waitForWebElementToAppear(guidepage.FirstName);

		logger.info("Filling form with test data: {}, {}, {}", firstName, lastName, email);

		guidepage.fillForm(firstName, lastName, email, company, phone, jobTitle, expectedValue);

		logger.info("Form filled successfully with unit count: {}", expectedValue);

		// verify Button Text is Correct
		String buttonText = guidepage.SubmitButton.getText();
		Assert.assertEquals(buttonText.trim(), "DOWNLOAD NOW", "DOWNLOAD NOW button text is incorrect.");

		logger.info("===== Test completed: testForm =====");
	}

	@DataProvider(name = "formDataProvider")
	public Object[][] formDataProvider() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("testdata/formData.json");
		List<Map<String, Object>> dataList = mapper.readValue(inputStream,
				new TypeReference<List<Map<String, Object>>>() {
				});

		Object[][] data = new Object[dataList.size()][];
		for (int i = 0; i < dataList.size(); i++) {
			Map<String, Object> map = dataList.get(i);
			data[i] = new Object[] { map.get("firstName"), map.get("lastName"), map.get("email"), map.get("company"),
					map.get("phone"), map.get("jobTitle"), ((Number) map.get("expectedValue")).intValue() };
		}
		return data;
	}
}
