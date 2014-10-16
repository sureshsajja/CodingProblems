package com.coderevisited.patterns.builder;

public class CarJavaBeansPattern
{
    private String variant = "sports";
    private int numberOfSeats = 4;
    private boolean powerSteering = false;
    private boolean enableGPS = false;
    private boolean alloyWheels = false;

    public CarJavaBeansPattern()
    {

    }


    public void setVariant(String variant)
    {
        this.variant = variant;
    }

    public void setNumberOfSeats(int numberOfSeats)
    {
        this.numberOfSeats = numberOfSeats;
    }

    public void setPowerSteering(boolean powerSteering)
    {
        this.powerSteering = powerSteering;
    }

    public void setEnableGPS(boolean enableGPS)
    {
        this.enableGPS = enableGPS;
    }

    public void setAlloyWheels(boolean alloyWheels)
    {
        this.alloyWheels = alloyWheels;
    }
}
