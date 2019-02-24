package com.bednarz.rentalsrestapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
@JsonDeserialize(builder = AutoValue_Location.Builder.class)
public abstract class Location {

    @JsonProperty("latitudex")
    public abstract double latitudex();
    @JsonProperty("longitudey")
    public abstract double longitudey();
    @JsonProperty("type")
    public abstract AdvertisementType type();
    @JsonProperty("title")
    public abstract String title();
    @JsonProperty("city")
    public abstract String city();
    @JsonProperty("price")
    public abstract int price();
    @JsonProperty("photos")
    public abstract List<String> photos();

    public enum AdvertisementType {
        FLAT, ROOM
    }

    public static Location create(double latitudex, double longitudey, AdvertisementType type, String title, String city, int price, List<String> photos) {
        return builder()
                .latitudex(latitudex)
                .longitudey(longitudey)
                .type(type)
                .title(title)
                .city(city)
                .price(price)
                .photos(photos)
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
        @JsonProperty("photos")
        public abstract Builder photos(List<String> photos);

        public abstract Location build();
    }
}
