package com.bednarz.rentalsrestapi;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wololo.geojson.Feature;
import org.wololo.geojson.GeoJSON;
import org.wololo.geojson.Point;
import org.wololo.jts2geojson.GeoJSONWriter;

import java.util.List;
import java.util.Map;

@RestController
public class LocationController {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("locations")
    public GeoJSON getAllLocations() {

        Map<String, Object> properties1 = ImmutableMap.of("NAME", "Apartment z dwoma pokojami", "CITY", "KRAKOW");
        Feature feature1 = new Feature(new Point(new double[]{19.938503, 52.655769}), properties1);

        Map<String, Object> properties2 = ImmutableMap.of("NAME", "Mieszkanie 100m2 na pokoje wynajem", "CITY", "WARSZAWA");
        Feature feature2 = new Feature(new Point(new double[]{19.538503, 51.655769}), properties2);

        Map<String, Object> properties3 = ImmutableMap.of("NAME", "Atrakcyjny pokój jednoosobowy ul.Miechowity", "CITY", "GDANSK");
        Feature feature3 = new Feature(new Point(new double[]{19.738503, 52.455769}), properties3);

        List<Feature> features = ImmutableList.of(feature1, feature2, feature3);

        GeoJSONWriter writer = new GeoJSONWriter();
        GeoJSON geoJson = writer.write(features);
        return geoJson;

    }

}
