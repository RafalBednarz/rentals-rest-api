package com.bednarz.rentalsrestapi;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;
import org.wololo.geojson.Feature;
import org.wololo.geojson.GeoJSON;
import org.wololo.geojson.Point;
import org.wololo.jts2geojson.GeoJSONWriter;

import java.util.List;
import java.util.Map;

@Repository
public class MockLocationRepository {

    private List<Feature> features;

    MockLocationRepository() {
        createInitialData();
    }

    public GeoJSON getAllLocations() {
        GeoJSONWriter writer = new GeoJSONWriter();
        return writer.write(features);
    }

    public Location createAdvertisement(Location location) {
        Map<String, Object> properties1 = ImmutableMap.of(
                "NAME", location.getTitle(),
                "CITY", location.getCity(),
                "PRICE", location.getPrice());
        Feature feature = new Feature(new Point(new double[]{location.getLongitudey(), location.getLatitudex()}), properties1);
        features = new ImmutableList.Builder<Feature>().addAll(features).add(feature).build();
        return location;
    }

    private void createInitialData() {
        Map<String, Object> properties1 = ImmutableMap.of(
                "NAME", "Apartment z dwoma pokojami",
                "CITY", "KRAKOW",
                "PRICE", 100);
        Feature feature1 = new Feature(new Point(new double[]{19.938503, 52.655769}), properties1);

        Map<String, Object> properties2 = ImmutableMap.of(
                "NAME", "Mieszkanie 100m2 na pokoje wynajem",
                "CITY", "WARSZAWA",
                "PRICE", 200);
        Feature feature2 = new Feature(new Point(new double[]{19.538503, 51.655769}), properties2);

        Map<String, Object> properties3 = ImmutableMap.of(
                "NAME", "Atrakcyjny pokój jednoosobowy ul.Miechowity",
                "CITY", "GDANSK",
                "PRICE", 300);
        Feature feature3 = new Feature(new Point(new double[]{19.738503, 52.455769}), properties3);

        features = ImmutableList.of(feature1, feature2, feature3);

    }
}
