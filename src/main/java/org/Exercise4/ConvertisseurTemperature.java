package org.Exercise4;

public class ConvertisseurTemperature {
    public double conversionToFahrenheit(double temperature){
        return (temperature * (9.0/5.0)) + 32;
    }

    public double conversionToCelsius(double temperature){
        return (temperature - 32) * (5.0/9.0);
    }
}
