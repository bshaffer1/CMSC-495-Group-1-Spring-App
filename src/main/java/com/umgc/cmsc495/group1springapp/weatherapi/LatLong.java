package com.umgc.cmsc495.group1springapp.weatherapi;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Author: Brandon Shaffer
 * Date: 11/28/2021
 */
public class LatLong {

	private String latitude;
	private String longitude;

	public LatLong(String zip) {
		try {
			BufferedReader bufferedReader = getFileReader();

			String contentLine = bufferedReader.readLine();
			int row_num = 0;
			while (contentLine != null) {
				String[] row = contentLine.split(",");
				contentLine = bufferedReader.readLine();

				if(row_num == 0){
					row_num++;
					continue;
				}
				String zipValue = row[0];
				String latitude = row[1];
				String longitute = row[2];
				if(zipValue != null && !zipValue.isEmpty()){
					if(zipValue.trim().equals(zip.trim())){
						this.longitude = StringUtils.deleteWhitespace(longitute);
						this.latitude = StringUtils.deleteWhitespace(latitude);
						return;
					}
				}

				row_num++;
			}
		} catch (IOException | URISyntaxException e) {
			latitude = null;
			longitude = null;
			System.out.println(e);
		}
	}

	private BufferedReader getFileReader() throws FileNotFoundException, URISyntaxException {
		InputStream is = getClass().getClassLoader().getResourceAsStream("ZIP_to_Lat_and_Long");
		InputStreamReader inputStreamReader = new InputStreamReader(is);
		return new BufferedReader(inputStreamReader);
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}
}
