package weatherstation.main;

import weatherstation.model.WeatherData;
import weatherstation.displays.*;

/**
 * Clase principal para probar el sistema de estación meteorológica
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        
        // Crear los displays y registrarlos como observadores
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        
        // Nuevos displays agregados según el reto
        PressureDisplay pressureDisplay = new PressureDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        
        System.out.println("=== Estación Meteorológica Iniciada ===\n");
        
        // Simular cambios en las mediciones
        System.out.println("--- Primera medición ---");
        weatherData.setMeasurements(27.0f, 65.0f, 1013.25f);
        
        System.out.println("\n--- Segunda medición ---");
        weatherData.setMeasurements(30.0f, 75.0f, 1009.50f);
        
        System.out.println("\n--- Tercera medición ---");
        weatherData.setMeasurements(25.5f, 80.0f, 1015.80f);
        
        // Demostrar que se puede desregistrar un observador
        System.out.println("\n--- Desregistrando el display de pronóstico ---");
        weatherData.removeObserver(forecastDisplay);
        
        System.out.println("\n--- Cuarta medición (sin pronóstico) ---");
        weatherData.setMeasurements(28.0f, 70.0f, 1012.00f);
    }
}