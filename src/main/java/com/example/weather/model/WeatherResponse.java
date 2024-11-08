package com.example.weather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

	@JsonProperty("name")
	private String name;

	@JsonProperty("sys")
	private Sys sys;

	@JsonProperty("weather")
	private List<Weather> weathers;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("wind")
	private Wind wind;


	public String getName() {
		return name;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}




	public static class Sys{

		private String country;

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

	}

	public static class Weather{

		private int id;
		private String description;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

	public static class Main{

		private Double temp;
		private Double humidity;
		public Double getTemp() {
			return temp;
		}
		public void setTemp(Double temp) {
			this.temp = temp;
		}
		public Double getHumidity() {
			return humidity;
		}
		public void setHumidity(Double humidity) {
			this.humidity = humidity;
		}

	}

	public static class Wind{

		private Double speed;

		public Double getSpeed() {
			return speed;
		}

		public void setSpeed(Double speed) {
			this.speed = speed;
		}


	}
}
