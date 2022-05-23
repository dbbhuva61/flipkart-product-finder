package com.example.javacrud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	@GetMapping(value = "/flipkart")
	public Boolean getproductlist() {
		String url = "https://1.rome.api.flipkart.com/api/4/page/fetch";

		MultiValueMap<String, String> headers = new HttpHeaders();

		headers.add("Content-Length", "300");
		headers.add("Host", "<calculated when request is sent>");
		headers.add("X-User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36 FKUA/website/42/website/Desktop");

		int a = 1;
		while (true) {
			Map<String, Object> b1 = new HashMap();
			b1.put("pageUri",
					"/search?q=saree&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
			Map<String, Object> b2 = new HashMap();
			b1.put("pageContext", b2);
			b2.put("fetchSeoData", "true");
			b2.put("paginatedFetch", "false");

			b2.put("pageNumber", a);
			Map<String, Object> b3 = new HashMap();
			b1.put("requestContext", b3);
			b3.put("type", "BROWSE_PAGE");

			HttpEntity<Object> request = new HttpEntity<Object>(b1, headers);

			try {
				ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
				Map<String, Object> m_body = response.getBody();

				Map<String, Object> m_response = (Map<String, Object>) m_body.get("RESPONSE");

				List<Object> m_slots = (List<Object>) m_response.get("slots");

				for (int i = 0; i < m_slots.size(); i++) {

					Map<String, Object> m_allslots = (Map<String, Object>) m_slots.get(i);
					// System.out.println(allslots);
					
					String wid = "WIDGET";
					Object stype = m_allslots.get("slotType");

					if (stype.equals(wid)) {
						Map<String, Object> m_widget = (Map<String, Object>) m_allslots.get("widget");

						Object tp = m_widget.get("type");
						String psumary = "PRODUCT_SUMMARY";

						if (tp.equals(psumary)) {

							Map<String, Object> m_data = (Map<String, Object>) m_widget.get("data");

							List<Object> m_products = (List<Object>) m_data.get("products");

							for (int j = 0; j < m_products.size(); j++) {

								Map<String, Object> m_product = (Map<String, Object>) m_products.get(j);

								Map<String, Object> m_proInfo = (Map<String, Object>) m_product.get("productInfo");

								Map<String, Object> m_value = (Map<String, Object>) m_proInfo.get("value");

								Object brand = m_value.get("productBrand");
								//System.out.println(brand);

/* product brand name  ---> */	String searchBrand = "Rudra Fashion";

								if (brand.equals(searchBrand)) {

									System.out.println("Found: " + searchBrand);
									System.out.println("Page No: " + a);
									return true;
								}
							}
						}
					}
				}
				a++;
				System.out.println("Current pageno: " + a);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//				ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//				String b = response.getBody();
//				String c = b;

	// System.out.println(c);

//				final Pattern pattern = Pattern.compile("\"productBrand\":\"PaLkAaNo\"", Pattern.CASE_INSENSITIVE);
//				// Match regex agains t input  
//				final Matcher matcher = pattern.matcher(c);
//
//				if (matcher.find()) {
//					System.out.println(b);
//					System.out.println("Found: ");
//					System.out.println("Page No: " + a);
//
//					break;
//
//				} else {
//					a++;
//					System.out.println("Page No: " + a);
//				}

//		return true;

	public static void main(String[] args) {
//		String test = "           \"showDiscountAsAmount\": false,\r\n"
//				+ "                                            \"title\": null,\r\n"
//				+ "                                            \"totalDiscount\": 76\r\n"
//				+ "                                        },\r\n"
//				+ "                                        \"productBrand\":\"PaLkAaNo\",\r\n"
//				+ "                                        \"productCardTagDetails\": [],\r\n"
//				+ "                                        \"rating\": {";
//
//		String p = "\"productBrand\":\"PaLkAaNo\"";
//
//		if (test.matches("productBrand...PaLkAaNo")) {
//			System.out.println("yes");  
//		} else {
//			System.out.println("no");
//		}
	}
}
