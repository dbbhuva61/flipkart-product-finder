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
public class MesshoController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/meshoo")
	public Boolean getproductlist() {

		String url = "https://meesho.com/api/v1/products/search";

		MultiValueMap<String, String> headers = new HttpHeaders();

		headers.add("content-type", "application/json");

		int a = 1;
		int off = 0;
	while (true) {

		Map<String, Object> b1 = new HashMap();
		b1.put("query", "saree");
		b1.put("type", "text_search");
		b1.put("page", a);
		b1.put("offset", off);
		b1.put("limit", "20");

		HttpEntity<Object> request = new HttpEntity<Object>(b1, headers);

		try {
			ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
			Map<String, Object> b = response.getBody();


			List<Object> brr = (List<Object>) b.get("catalogs");
		
			
			for (int i = 0; i < brr.size(); i++) {
				Map<String, Object> z = (Map<String, Object>) brr.get(i);
			
			
				List<Object> pro = (List<Object>) z.get("products");
				
				for(int j=0;j<pro.size();j++) {
					Map<String, Object> z2 = (Map<String, Object>)  pro.get(j);
					
					
					Object product = z2.get("name");
					
					String name = "Lahariya";

					if(product.equals(name)){

						System.out.println("found : "+name);
						System.out.println("Page No: "+a);
						return true;
					}	
				}
			}
			
			a++;
			off+=20;
			System.out.println("Current page no: "+a);
		}
		catch (Exception e) { }	
	}
}

}
