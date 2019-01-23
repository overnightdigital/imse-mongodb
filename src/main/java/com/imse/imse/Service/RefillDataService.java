package com.imse.imse.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;



@Service
public class RefillDataService  {

    public void execute() throws Exception {
	
    	fetchData("http://localhost:8080/api/firma", "firma");
    	fetchData("http://localhost:8080/api/produkt", "produkt");
    	fetchData("http://localhost:8080/api/produkt_des_monats", "produkt_des_monats");
    	fetchData("http://localhost:8080/api/mitarbeiter", "mitarbeiter");
    	fetchData("http://localhost:8080/api/rohstoff", "rohstoff");
    	
    }
    
    private void fetchData(String url, String type) throws Exception {
   
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        	response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response.toString());
        //Read JSON response and print
        JSONArray serverResponse = new JSONArray(response.toString());
        System.out.println("result after Reading JSON Response");
       
        switch(type) {
            case "firma":
            	ArrayList<String> InputQueryParams1 = new ArrayList<>();
            	InputQueryParams1.add("id");
                InputQueryParams1.add("name");
                InputQueryParams1.add("adresse");
                
            	
            	for (int i = 0; i < serverResponse.length(); i++) {
                     JSONObject jsonobject = serverResponse.getJSONObject(i);		            			
                     	ArrayList<String> InputValues1 = new ArrayList<>();
		                InputValues1.add(jsonobject.getString("id"));
		                InputValues1.add(jsonobject.getString("name"));
		                InputValues1.add(jsonobject.getString("adresse"));
		                fillData("http://localhost:8083/api/firma", InputQueryParams1, InputValues1);
            	 	}                
            	break;
            	
            case "produkt":
            	
            	ArrayList<String> InputQueryParams2 = new ArrayList<>();
            	InputQueryParams2.add("id");
                InputQueryParams2.add("name");
                InputQueryParams2.add("preis");
                InputQueryParams2.add("firma_id");
            	for (int i = 0; i < serverResponse.length(); i++) {
                     JSONObject jsonobject = serverResponse.getJSONObject(i);
                     	ArrayList<String> InputValues2 = new ArrayList<>();
		                InputValues2.add(jsonobject.getString("id_Nummer"));
		                InputValues2.add(jsonobject.getString("name"));
		                InputValues2.add(jsonobject.getString("preis"));
		                InputValues2.add(jsonobject.getJSONObject("firma").getInt("id")+"");
		                fillData("http://localhost:8083/api/produkt", InputQueryParams2, InputValues2);
            	 	}                
            	break;
            	
            case "produkt_des_monats":
            	
            	ArrayList<String> InputQueryParams3 = new ArrayList<>();
            	InputQueryParams3.add("produkt_id");
                InputQueryParams3.add("s");
                InputQueryParams3.add("b");
                
            	
            	for (int i = 0; i < serverResponse.length(); i++) {
                     JSONObject jsonobject = serverResponse.getJSONObject(i);	
                     	ArrayList<String> InputValues3 = new ArrayList<>();
		                InputValues3.add(jsonobject.getString("produkt_ID"));
		                InputValues3.add(jsonobject.getString("spezifikation"));
		                InputValues3.add(jsonobject.getString("bewertung"));
		                fillData("http://localhost:8083/api/produkt_des_monats", InputQueryParams3, InputValues3);
            	 	}                
            	break;
            	
            case "mitarbeiter":
            	
            	ArrayList<String> InputQueryParams4 = new ArrayList<>();
                InputQueryParams4.add("name");
                InputQueryParams4.add("nummer");
                InputQueryParams4.add("e_mail");
                InputQueryParams4.add("sv");
                InputQueryParams4.add("firma_id");
                
            	
            	for (int i = 0; i < serverResponse.length(); i++) {
                     JSONObject jsonobject = serverResponse.getJSONObject(i);
                     	ArrayList<String> InputValues4 = new ArrayList<>();
		                InputValues4.add(jsonobject.getString("name"));
		                InputValues4.add(jsonobject.getString("nummer"));
		                InputValues4.add(jsonobject.getString("e_mail"));
		                InputValues4.add(jsonobject.getString("sv_nummer"));
		                InputValues4.add(jsonobject.getJSONObject("firma").getInt("id")+"");
		                fillData("http://localhost:8083/api/mitarbeiter", InputQueryParams4, InputValues4);
            	 	}                
            	break;	
            	
            case "rohstoff":
            	
            	ArrayList<String> InputQueryParams5 = new ArrayList<>();
                InputQueryParams5.add("m");
                InputQueryParams5.add("p");
                InputQueryParams5.add("id");
                InputQueryParams5.add("name");
                InputQueryParams5.add("firma_id");
                
            	
            	for (int i = 0; i < serverResponse.length(); i++) {
                     JSONObject jsonobject = serverResponse.getJSONObject(i);		            			
                     	ArrayList<String> InputValues5 = new ArrayList<>();
		                InputValues5.add(jsonobject.getString("menge"));
		                InputValues5.add(jsonobject.getString("preis"));
		                InputValues5.add(jsonobject.getString("id_Nummer"));
		                InputValues5.add(jsonobject.getString("name"));
		                InputValues5.add(jsonobject.getJSONObject("firma").getInt("id")+"");
		                fillData("http://localhost:8083/api/rohstoff", InputQueryParams5, InputValues5);
            	 	}                
            	break;		
            }
    }

    private void fillData(String inputURL, ArrayList<String> InputQueryParams, ArrayList<String> InputValues) throws Exception {

        URL url = new URL(inputURL);
        Map<String,Object> params = new LinkedHashMap<>();
        for(int queryCounter = 0; queryCounter < InputValues.size(); queryCounter++) {
            params.put(InputQueryParams.get(queryCounter), InputValues.get(queryCounter));
        }

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;)
            System.out.print((char)c);
    }

}
