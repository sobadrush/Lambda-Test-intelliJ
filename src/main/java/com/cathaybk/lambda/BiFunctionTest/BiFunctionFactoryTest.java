package com.cathaybk.lambda.BiFunctionTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.function.BiFunction;

/**
 * @author RogerLo
 * @date 2022/6/27
 */
public class BiFunctionFactoryTest {

    public static void main(String[] args) {
        GPS gpsObjByFactory = BiFunctionFactoryTest.GpsFactory("40.741895", "-73.989308",
                (inputLat, inputLng) -> new GPS(inputLat, inputLng));

        System.err.println("gpsObjByFactory = " + gpsObjByFactory);
    }

    public static <R extends GPS> R GpsFactory(String lat, String lng, BiFunction<String, String, R> biFunction) {
        if (StringUtils.isBlank(lat) || StringUtils.isBlank(lng)) {
            return (R) GPS.builder().latitude("0.0").longitude("0.0").build();
        }
        return biFunction.apply(lat, lng);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class GPS {
        private String latitude;
        private String longitude;
    }

}
