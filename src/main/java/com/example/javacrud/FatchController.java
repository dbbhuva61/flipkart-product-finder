package com.example.javacrud;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FatchController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/products")
	public Boolean getproductlist() {
		String url = "https://1.rome.api.flipkart.com/api/4/page/fetch";
		// String body = "{}";

		MultiValueMap<String, String> headers = new HttpHeaders();
//		headers.add("Sec-Fetch-Mode", "cors");
//		headers.add("Cookie",
//				"SN=VI011E9CB47CE14754AA58F8AC002E48EA.TOKF3ABC9C7E8D44D98AE2E16506069AF85.1652860307.LO; T=TI165286029533700392254656494277597077629170660654039629194413331613");
//		headers.add("Postman-Token","<calculated when request is sent>");
//		headers.add("Accept-Encoding", "gzip, deflate, br");
//		headers.add("Accept", "*/*");
//		headers.add("Accept-Language", "en-US,en;q=0.9,hi;q=0.8");
//		headers.add("Connection", "keep-alive");
//		headers.add("Content-Type", "application/json");
//		headers.add("Cookie","T=SD.d3f8a8a8-bcfa-43bd-a73f-8a07c3f7fdda.1633531610521; _pxvid=9dde53ed-28fe-11ec-9aab-674576696543; _gcl_au=1.1.1430612436.1652509902; _fbp=fb.1.1652509967560.1990793124; _gac_UA-172010654-1=1.1652509985.Cj0KCQjwg_iTBhDrARIsAD3Ib5iaArLNmsXKPDiaMtUEoObIlBC02TAPfjfVCILgc6NaQF1inrRPIWwaArbtEALw_wcB; _gac_=1.1652509998.Cj0KCQjwg_iTBhDrARIsAD3Ib5iaArLNmsXKPDiaMtUEoObIlBC02TAPfjfVCILgc6NaQF1inrRPIWwaArbtEALw_wcB; _gac_UA-39979546-1=1.1652510152.Cj0KCQjwg_iTBhDrARIsAD3Ib5iaArLNmsXKPDiaMtUEoObIlBC02TAPfjfVCILgc6NaQF1inrRPIWwaArbtEALw_wcB; _ga=GA1.1.825253924.1633531614; _gcl_aw=GCL.1652510538.Cj0KCQjwg_iTBhDrARIsAD3Ib5iaArLNmsXKPDiaMtUEoObIlBC02TAPfjfVCILgc6NaQF1inrRPIWwaArbtEALw_wcB; AMCV_55CFEDA0570C3FA17F000101%40AdobeOrg=-227196251%7CMCIDTS%7C19127%7CMCMID%7C46518020040280211998992469539093887668%7CMCAID%7CNONE%7CMCOPTOUT-1652517738s%7CNONE; s_nr=1652510538168-Repeat; _ga_0SJLGHBL81=GS1.1.1652509901.3.1.1652510575.0; Network-Type=4g; AMCVS_17EB401053DAF4840A490D4C%40AdobeOrg=1; AMCV_17EB401053DAF4840A490D4C%40AdobeOrg=-227196251%7CMCIDTS%7C19131%7CMCMID%7C08320708100644938683063832067887835537%7CMCAAMLH-1653455271%7C12%7CMCAAMB-1653455271%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1652857671s%7CNONE%7CMCAID%7CNONE; s_cc=true; pxcts=77be7277-d668-11ec-a3ba-616543574668; SN=VIF62BCEE73CF54F63A635DAE84FB06B69.TOKDCD728ACEFF745E6816FE4FAD1DE79E9.1652850491.LO; gpv_pn=Search%20%3AWatches%7CWrist%20Watches; gpv_pn_t=Search%20Page; s_sq=%5B%5BB%5D%5D; _px3=016a11a91c8e1a6835f2be3a6423ef2cb1c90e56c3f6a7dfb0e6aae79d8b5e0e:3fwG9Hgkdc/W2vqnHzMK/7WzYkNQfSxvfR+6q82YTPfyqBz+rSknShUVwZEIO8kS7qf6VteeqKRltN+O19SGCw==:1000:oQlYMNZb9akvVLnGWz1hakQpZG6JmZ3ThNGaZDUv/AP76U+z3uOEHFTv/6jB1mWlT21hcEbESK1kUTTbEcSOpu4OjtZnX8kVkXOK6A9L7cJZ1fAhDu9y/SxUqyYmEBxts0kxEfrsnJ0kOR1S4iO+MXDIRFgUYwbhbBqykC5fsD8Qg/1z1meQgow5tKl6/KAGCvqxDXC031z3u3f0YQyBlQ==; S=d1t13fXtIHHQ/Pz9PWD8/CHY/P4wOtbOMfiWSxiaqFEt8RXHZL3SnV1Bs41lC3KLxdM7gJz/v2cOL9SbGBrPz7YpeOg==");
//		headers.add("DNT", "1");
//		headers.add("Origin", "https://www.flipkart.com");
//		headers.add("Referer", "https://www.flipkart.com/");
//		headers.add("Sec-Fetch-Dest", "empty");
//		headers.add("Sec-Fetch-Site", "same-site");
//		headers.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36");
		headers.add("Content-Length", "300");
		headers.add("Host", "<calculated when request is sent>");
		headers.add("X-User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36 FKUA/website/42/website/Desktop");
//		headers.add("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"101\", \"Google Chrome\";v=\"101\"");
//		headers.add("sec-ch-ua-mobile", "?0");
//		headers.add("sec-ch-ua-platform", "\"Windows\"");

		// System.out.println(b1);

		// System.out.println(response.getBody());

	//	String p = "\"productBrand\": \"LAHEJA\"";
		// String p = "productbrand palkaano";
		int a = 1;
		while (true) {
			Map<String, Object> b1 = new HashMap();
			b1.put("pageUri",
					"/search?q=lahenga%20for%20women&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
			Map<String, Object> b2 = new HashMap();
			b1.put("pageContext", b2);
			b2.put("fetchSeoData", "true");
			b2.put("paginatedFetch", "false");

			b2.put("pageNumber", a);
			Map<String, Object> b3 = new HashMap();
			b1.put("requestContext", b3);
			b3.put("type", "BROWSE_PAGE");
			b3.put("ssid", "xi7y5nrfkg0000001652850894171");
			b3.put("sqid", "k5512h0ycg0000001652851341777");

			HttpEntity<Object> request = new HttpEntity<Object>(b1, headers);

			try {
				ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
				String b = response.getBody();
				String c = b;

				// System.out.println(c);

				final Pattern pattern = Pattern.compile("\"productBrand\":\"PaLkAaNo\"", Pattern.CASE_INSENSITIVE);
				// Match regex against input
				final Matcher matcher = pattern.matcher(c);

				if (matcher.find()) {
					System.out.println(b);
					System.out.println("Found: ");
					System.out.println("Page No: " + a);

					break;

				} else {
					a++;
					System.out.println("Page No: " + a);
				}
			} catch (Exception e) {

			}
		}
		return true;
	}

	public static void main(String[] args) {

		// System.out.println(response.getBody());
		String test = "           \"showDiscountAsAmount\": false,\r\n"
				+ "                                            \"title\": null,\r\n"
				+ "                                            \"totalDiscount\": 76\r\n"
				+ "                                        },\r\n"
				+ "                                        \"productBrand\": \"PaLkAaNo\",\r\n"
				+ "                                        \"productCardTagDetails\": [],\r\n"
				+ "                                        \"rating\": {";

		String p = "\"productBrand\": \"PaLkAaNo\"";
		// String p = "productbrand palkaano";

		// test = test.toLowerCase();
		if (test.matches("productBrand...PaLkAaNo")) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

	}
}
