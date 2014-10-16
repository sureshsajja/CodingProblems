package com.coderevisited.patterns.builder;

public class CarBuilder
{
    private final String variant;
    private final int numberOfSeats;
    private final boolean powerSteering;
    private final boolean enableGPS;
    private final boolean alloyWheels;

    public CarBuilder(Builder builder)
    {
        this.variant = builder.variant;
        this.numberOfSeats = builder.numberOfSeats;
        this.powerSteering = builder.powerSteering;
        this.enableGPS = builder.enableGPS;
        this.alloyWheels = builder.alloyWheels;
    }

    public static class Builder
    {

        private final String variant;
        private final int numberOfSeats;
        private boolean powerSteering;
        private boolean enableGPS;
        private boolean alloyWheels;

        public Builder(String variant, int numberOfSeats)
        {
            this.variant = variant;
            this.numberOfSeats = numberOfSeats;
        }


        public Builder setPowerSteering(boolean powerSteering)
        {
            this.powerSteering = powerSteering;
            return this;
        }

        public Builder setEnableGPS(boolean enableGPS)
        {
            this.enableGPS = enableGPS;
            return this;

        }

        public Builder setAlloyWheels(boolean alloyWheels)
        {
            this.alloyWheels = alloyWheels;
            return this;
        }

        public CarBuilder build()
        {
            return new CarBuilder(this);
        }
    }

}
