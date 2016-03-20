package one.thing.well.gymtimekeeper.datastore.locationevent;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import one.thing.well.gymtimekeeper.datastore.AbstractFileWriter;
import one.thing.well.gymtimekeeper.datastore.FileWritingConstants;

public class LocationEventFileWriter extends AbstractFileWriter {

    public LocationEventFileWriter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public String buildFileEntry(Double latitude, Double longitude) {
        LocationEventEntry locationEvent = new LocationEventEntry(getFormattedTime(), latitude, longitude);
        return locationEvent.toString();
    }

    private String getFormattedTime() {
        DateFormat dateFormat = new SimpleDateFormat(FileWritingConstants.DATE_FORMAT);
        Date date = new Date();
        return dateFormat.format(date);
    }
}
