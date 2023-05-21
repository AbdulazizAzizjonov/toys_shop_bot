package com.company.model;

import com.company.enums.CustomerStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private CustomerStatus status;
    private boolean isAdmin = false;

//    private Location location;
//    private double longitude;
//    private double latitude;

    public Customer(String id) {
        this.id = id;
    }

}

//    }
//
//    public double distanceTo(Location that) {
//        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
//        double lat1 = Math.toRadians(this.latitude);
//        double lon1 = Math.toRadians(this.longitude);
//        double lat2 = Math.toRadians(latitude);
//        double lon2 = Math.toRadians(longitude);
//
//
//        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
//                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
//
//        double nauticalMiles = 60 * Math.toDegrees(angle);
//        double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
//        return statuteMiles;
//    }
//
//    public static void main(String[] args) {
//        Location loc1 = new Location("PRINCETON_NJ", 40.366633, 74.640832);
//        Location loc2 = new Location("ITHACA_NY", 42.443087, 76.488707);
//        double distance = loc1.distanceTo(loc2);
//        System.out.printf("%6.3f miles from\n", distance);
//        System.out.printf(loc1 + " to " + loc2);
//    }
//
//}
