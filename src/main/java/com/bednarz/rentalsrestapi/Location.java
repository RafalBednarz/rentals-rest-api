package com.bednarz.rentalsrestapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

@AutoValue
@JsonDeserialize(builder = AutoValue_Location.Builder.class)
public abstract class Location {

    @JsonProperty("latitudex")
    abstract double latitudex();
    @JsonProperty("longitudey")
    abstract double longitudey();
    @JsonProperty("type")
    abstract AdvertisementType type();
    @JsonProperty("title")
    abstract String title();
    @JsonProperty("city")
    abstract String city();
    @JsonProperty("price")
    abstract int price();

    public enum AdvertisementType {
        FLAT, ROOM
    }

    public static Location create(double latitudex, double longitudey, AdvertisementType type, String title, String city, int price) {
        return builder()
                .latitudex(latitudex)
                .longitudey(longitudey)
                .type(type)
                .title(title)
                .city(city)
                .price(price)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_Location.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        @JsonProperty("latitudex")
        public abstract Builder latitudex(double latitudex);
        @JsonProperty("longitudey")
        public abstract Builder longitudey(double longitudey);
        @JsonProperty("type")
        public abstract Builder type(AdvertisementType type);
        @JsonProperty("title")
        public abstract Builder title(String title);
        @JsonProperty("city")
        public abstract Builder city(String city);
        @JsonProperty("price")
        public abstract Builder price(int price);

        public abstract Location build();
    }
}
