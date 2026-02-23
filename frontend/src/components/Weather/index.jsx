import { useState, useEffect } from "react";
import style from "./weather.module.css";

function Weather() {
  const [city, setCity] = useState("");
  const [weatherPresent, setWeatherPresent] = useState({
    locations: "",
    temperature: "",
    weather: "",
  });
  const [weatherFuture, setWeatherFuture] = useState([]);
  useEffect(() => {
    getForecast("Atlanta");
  }, []);

  async function getForecast(cityName) {
    try {
      const response = await fetch(
        "http://localhost:8080/forecast?location=" + cityName,
      );

      // Check for error in response
      if (!response.ok) {
        setCity("");
        alert("Please enter a city from list: Atlanta, Birmingham, Montgomery");
        return;
      }

      // Response is OK. Set useStates.
      const data = await response.json();
      const weather = {
        locations: data.name,
        temperature: data.forecast[0].temperature,
        weather: data.forecast[0].weatherCondition,
      };

      setWeatherPresent(weather);
      setWeatherFuture(data.forecast.filter((item, index) => index !== 0));
    } catch (error) {
      console.error(error);
    }
  }

  function FutureWeather({ forecast }) {
    return (
      <div className={style["weather-future"]}>
        {forecast.map((item, index) => (
          <div key={index} className={style["future-item"]}>
            <h3>{item.dayOfWeek}</h3>
            <p>{item.weatherCondition}</p>
            <p>{item.temperature}</p>
          </div>
        ))}
      </div>
    );
  }

  return (
    <div class={style.container}>
      <div class={style.header}>
        <h2> Weather Explorer </h2>
        <p> Stay updated with the latest weather conditions</p>
      </div>
      <div class={style.search}>
        <input
          type="text"
          value={city}
          name="search-bar"
          placeholder="Enter location"
          onChange={(e) => setCity(e.target.value)}
        />
        <button type="button" onClick={() => getForecast(city)}>
          Search
        </button>
      </div>
      <div class={style["weather-present"]}>
        <h3>{weatherPresent.locations}</h3>
        <p>Temperature: {weatherPresent.temperature}</p>
        <p>{weatherPresent.weather}</p>
      </div>
      <FutureWeather forecast={weatherFuture} />
    </div>
  );
}

export default Weather;
