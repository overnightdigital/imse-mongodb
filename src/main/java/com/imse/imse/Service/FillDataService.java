package com.imse.imse.Service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.*;
import java.util.*;

@Service
public class FillDataService  {

    public void execute() throws Exception {
        System.out.println("Filling Data...");

        // Firma
        ArrayList<String> InputQueryParams1 = new ArrayList<>();
        InputQueryParams1.add("id");
        InputQueryParams1.add("name");
        InputQueryParams1.add("adresse");

        ArrayList<String> InputValues1 = new ArrayList<>();
        InputValues1.add("101");
        InputValues1.add("The Big Oil Company");
        InputValues1.add("California West street 25/7 10001 LA");

        fillData("http://localhost:8080/api/firma", InputQueryParams1, InputValues1);
        // Firma

        // Produkt
        ArrayList<String> InputQueryParams2 = new ArrayList<>();
        InputQueryParams2.add("id");
        InputQueryParams2.add("name");
        InputQueryParams2.add("preis");
        InputQueryParams2.add("firma_id");

        Random rand = new Random();
        ArrayList<String> randomOilProducts = new ArrayList<>();
        randomOilProducts.add("Abu Bukhoosh");
        randomOilProducts.add("Agbami");
        randomOilProducts.add("Aktobe");
        randomOilProducts.add("Al-Jurf");
        randomOilProducts.add("Arab Extra Light");
        randomOilProducts.add("Attaka");
        randomOilProducts.add("Arab Light");
        randomOilProducts.add("Belanak");
        randomOilProducts.add("Kirkuk (Netback Price at U.S. Gulf)");
        randomOilProducts.add("Kikeh");
        randomOilProducts.add("Furrial");
        randomOilProducts.add("El Sharara");
        randomOilProducts.add("Cabinda");
        randomOilProducts.add("Cepu");
        randomOilProducts.add("CPC Blend");
        randomOilProducts.add("Beryl");
        for(int i = 0; i < 100; i++) {
            ArrayList<String> InputValues2 = new ArrayList<>();
            InputValues2.add(50000 + i + "");
            InputValues2.add(randomOilProducts.get(rand.nextInt(randomOilProducts.size()-1)));
            InputValues2.add(rand.nextInt(1000) + "");
            InputValues2.add("101");
            fillData("http://localhost:8080/api/produkt", InputQueryParams2, InputValues2);
        }
        // Produkt

        // Produkt Des Monats
        ArrayList<String> InputQueryParams3 = new ArrayList<>();
        InputQueryParams3.add("produkt_id");
        InputQueryParams3.add("s");
        InputQueryParams3.add("b");

        ArrayList<String> b = new ArrayList<>();
        b.add("Gut");
        b.add("Sehr Gut");
        b.add("Ausgezeichnet");
        b.add("Fast Perfekt");
        b.add("Geht So");
        b.add("Neutral");

        ArrayList<String> s = new ArrayList<>();
        s.add("Hat sich sehr gut bei Diesel Motoren bewertet");
        s.add("uberall sehr gut");
        s.add("excellente bewertungen");
        s.add("ist uberall einsetzbar");
        s.add("extrem gleitend");
        s.add("gute qualitet");
        s.add("testsieger");
        s.add("wurde ich weiterepmfehlen");
        s.add("funktioniert einwandfrei");
        s.add("sehr gut in jeder hinsicht");

        for(int i = 0; i < 25; i++) {
            ArrayList<String> InputValues3 = new ArrayList<>();
            InputValues3.add(50000 + i + "");
            InputValues3.add(s.get(rand.nextInt(s.size()-1)));
            InputValues3.add(b.get(rand.nextInt(b.size()-1)));
            fillData("http://localhost:8080/api/produkt_des_monats", InputQueryParams3, InputValues3);
        }
        // Produkt Des Monats

        // Mitarbeiter
        ArrayList<String> InputQueryParams4 = new ArrayList<>();
        InputQueryParams4.add("name");
        InputQueryParams4.add("nummer");
        InputQueryParams4.add("e_mail");
        InputQueryParams4.add("sv");
        InputQueryParams4.add("firma_id");

        ArrayList<String> name = new ArrayList<>();
        name.add("CHRIS PATRIC");
        name.add("Martin Garix");
        name.add("David Guetha");
        name.add("Nikola Pastilovski");
        name.add("Wolfgang Bu");
        name.add("PS SM");
        name.add("Markus von Anhalt");
        name.add("brad Pit");
        name.add("Nikolaj Patric");
        name.add("Rocki Balboa");

        ArrayList<String> email = new ArrayList<>();
        email.add("rocko@example.com");
        email.add("coolio@example.com");
        email.add("workerio@example.com");
        email.add("sales@example.com");
        email.add("marketing@example.com");
        email.add("oil@example.com");
        email.add("manager@example.com");
        email.add("officedep@example.com");
        email.add("reqeng@example.com");
        email.add("rescue@example.com");

        for(int i = 0; i < 10; i++) {
            ArrayList<String> InputValues4 = new ArrayList<>();
            InputValues4.add(name.get(rand.nextInt(name.size()-1)));
            InputValues4.add(69 + rand.nextInt(1000) + "");
            InputValues4.add(email.get(rand.nextInt(email.size()-1)));
            InputValues4.add(100 + i + "");
            InputValues4.add("101");
            fillData("http://localhost:8080/api/mitarbeiter", InputQueryParams4, InputValues4);
        }
        // Mitarbeiter


        // Rohstoff
        ArrayList<String> InputQueryParams5 = new ArrayList<>();
        InputQueryParams5.add("m");
        InputQueryParams5.add("p");
        InputQueryParams5.add("id");
        InputQueryParams5.add("name");
        InputQueryParams5.add("firma_id");

        ArrayList<String> rohstoff = new ArrayList<>();
        rohstoff.add("crude oil");
        rohstoff.add("refine sand");
        rohstoff.add("water");
        rohstoff.add("sand");
        rohstoff.add("pasta");

        for(int i = 0; i < 10; i++) {
            ArrayList<String> InputValues5 = new ArrayList<>();
            InputValues5.add(rand.nextInt(100) + "");
            InputValues5.add(rand.nextInt(50) + "");
            InputValues5.add(10 + i + "");
            InputValues5.add(rohstoff.get(rohstoff.size()-1));
            InputValues5.add("101");
            fillData("http://localhost:8080/api/rohstoff", InputQueryParams5, InputValues5);
        }
        // Rohstoff

        System.out.println("Done!");
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
