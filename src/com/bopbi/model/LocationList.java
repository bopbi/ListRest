/**
 * handle
 * 
 * {"locations":[{"name":"xc","description":"xc"},{"name":"a","description":"as"},{"name":"asa","description":"as"}]}
 * 
 */

package com.bopbi.model;

import java.util.List;

public class LocationList {
    private List<LocationModel> locations;
    
    public List<LocationModel> getLocations() {
        return locations;
    }
    public void setLocationList(List<LocationModel> locations) {
        this.locations = locations;
    }
}
