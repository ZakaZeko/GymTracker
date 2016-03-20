package one.thing.well.gymtimekeeper.persist.locationevent;

import one.thing.well.gymtimekeeper.persist.FileWritingConstants;

public class InTheGymLocationEventEntry {

    private String time;

    private Double latitude;

    private Double longitude;

    public InTheGymLocationEventEntry(String time, Double latitude, Double longitude) {
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public InTheGymLocationEventEntry(String locationEventString) {
        parseString(locationEventString);
    }

    public void parseString(String locationEventString) {
        String[] fields = locationEventString.split(FileWritingConstants.SPLITTER);
        time = fields[0];
        latitude = Double.valueOf(fields[1]);
        longitude = Double.valueOf(fields[2]);
    }

    public String getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return  time + FileWritingConstants.SPLITTER + latitude + FileWritingConstants.SPLITTER + longitude;
    }
}