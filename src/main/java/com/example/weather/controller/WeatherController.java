package com.example.weather.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.weather.model.WeatherResponse;

@Controller
public class WeatherController {

	@Value("${api.key}")
	private String apikey;

	@GetMapping("/abc")
	public  String getIndex() {
		return "index";
	}

	@GetMapping("/weather")
	public String getWeather(@RequestParam("city")String city,Model model) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q="+city +"&appid="+apikey +"&units=metric";
		RestTemplate restTemplate = new RestTemplate();
		WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

		if(weatherResponse != null) {
			model.addAttribute("city", weatherResponse.getName());
			model.addAttribute("country", weatherResponse.getSys().getCountry());
			model.addAttribute("waetherDescription", weatherResponse.getWeathers().get(0));
			model.addAttribute("temperature", weatherResponse.getMain().getTemp());
			model.addAttribute("humidity", weatherResponse.getMain().getHumidity());
			model.addAttribute("windSpeed", weatherResponse.getWind().getSpeed());


			String weatherIcon = "wi wi-owm-"+weatherResponse.getWeathers().get(0).getId();
			model.addAttribute("weatherIcon",weatherIcon);
		}
		else {
			model.addAttribute("error", "City not found");
		}

		return "weather";
	}

}
