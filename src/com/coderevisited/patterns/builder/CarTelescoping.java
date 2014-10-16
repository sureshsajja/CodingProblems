package com.coderevisited.patterns.builder;

/**
 * Telescoping constructor anti pattern
 */
public class CarTelescoping
{
    private final String variant;
    private final int numberOfSeats;
    private final boolean powerSteering;
    private final boolean enableGPS;
    private final boolean alloyWheels;

    public CarTelescoping(String variant, int numberOfSeats)
    {
        this(variant, numberOfSeats, false);
    }


    public CarTelescoping(String variant, int numberOfSeats, boolean powerSteering)
    {
        this(variant, numberOfSeats, powerSteering, false);
    }

    public CarTelescoping(String variant, int numberOfSeats, boolean powerSteering, boolean enableGPS)
    {
        this(variant, numberOfSeats, powerSteering, enableGPS, false);
    }

    public CarTelescoping(String variant, int numberOfSeats, boolean powerSteering, boolean enableGPS, boolean alloyWheels)
    {
        this.variant = variant;
        this.numberOfSeats = numberOfSeats;
        this.powerSteering = powerSteering;
        this.enableGPS = enableGPS;
        this.alloyWheels = alloyWheels;
    }
}
