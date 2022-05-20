package com.example.javacrud;

import java.util.HashMap;
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
public class MesshoController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/productsmeshoo")
	public Boolean getproductlist() {
		
		String url = "https://meesho.com/api/v1/products/search";
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		
		headers.add("Content-Length","<calculated when request is sent>");
		headers.add("Host","<calculated when request is sent>");
		headers.add("content-type","application/json");
		
		int a = 1;
		int off = 0;
		while (true) {
			Map<String, Object> b1 = new HashMap();
			b1.put("query","saree");
			b1.put("type","text_search");
			b1.put("page",a);
			b1.put("offset",off);
			b1.put("limit","20");
			
			HttpEntity<Object> request = new HttpEntity<Object>(b1, headers);
			
			try {
				ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
				String b = response.getBody();
				String c = b;
				System.out.println(b);
				 
				final Pattern pattern = Pattern.compile("\"name\":\"Kashvi Voguish Sarees\r\n"
						+ "\r\n"
						+ " \"", Pattern.CASE_INSENSITIVE);
				
				final Matcher matcher = pattern.matcher(c);

				if (matcher.find()) {
					System.out.println(b);
					System.out.println("Found: ");
					System.out.println("Page No: " + a);

					break;

				} else {
					a++;
					off+=20;
					System.out.println("Page No: " + a);
				}	
			}catch (Exception e){
				
			}
		
			
		}		

		return true;	
	}
	
	public static void main(String[] args) {
				//System.out.println(response.getBody());
				String test = " {\r\n"
						+ "            \"id\": 1600430,\r\n"
						+ "            \"name\": \"Kashvi Voguish Sarees\",\r\n"
						+ "            \"category_id\": 1004,\r\n"
						+ "            \"sub_sub_category_name\": \"Sarees\",\r\n"
						+ "            \"min_catalog_price\": 488,\r\n"
						+ "            \"min_product_price\": 488,\r\n"
						+ "            \"transient_price\": 438,\r\n"
						+ "            \"max_product_discount\": 10,\r\n"
						+ "            \"original_price\": 488,\r\n ";

				String p = "\"name\":\"Kashvi Voguish Sarees\"";
				
		
				 test = test.toLowerCase();
				if (test.matches("name...Kashvi Voguish Sarees")) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
		
		
}
}
