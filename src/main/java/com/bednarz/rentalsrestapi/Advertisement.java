package com.bednarz.rentalsrestapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
@JsonDeserialize(builder = AutoValue_Advertisement.Builder.class)
public abstract class Advertisement {

    @JsonProperty("id")
    abstract long id();
    @JsonProperty("name")
    abstract String name();
    @JsonProperty("description")
    abstract String description();
    @JsonProperty("images")
    abstract List<String> images();

    public static Advertisement create(long id, String name, String description, List<String> images) {
        return builder()
                .id(id)
                .name(name)
                .description(description)
                .images(images)
                .build();
    }

    public static Advertisement.Builder builder() {
        return new AutoValue_Advertisement.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        @JsonProperty("id")
        public abstract Builder id(long id);
        @JsonProperty("name")
        public abstract Builder name(String name);
        @JsonProperty("description")
        public abstract Builder description(String description);
        @JsonProperty("images")
        public abstract Builder images(List<String> images);

        public abstract Advertisement build();
    }
}
