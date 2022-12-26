package uk.gov.metoffice.hello.rjr;

import java.time.Clock;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Makes the output from each run
 * with details about instantiation time
 * and SSM parameters
 */
public class MainController {

    private final ZonedDateTime instantiation;
    private final String ssmParamName;
    private final String ssmParamValue;

    public MainController(ZonedDateTime instantiation,
                          String ssmParamName, String ssmParamValue) {
        this.instantiation = instantiation;
        this.ssmParamName = ssmParamName;
        this.ssmParamValue = ssmParamValue;
    }

    public String message() {
        ZonedDateTime timeNow = ZonedDateTime.now(Clock.systemUTC()).withNano(0);

        String instantiationString  = "Instantiated at " + instantiation.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        Duration since = Duration.between(instantiation, timeNow);
        String durationString = humanReadableFormat(since) + " ago";

        String ssmParamString = ".  SSM parameter '" + ssmParamName + "' has value '" +
                ssmParamValue + "'";

        return instantiationString + ", " + durationString + ssmParamString;
    }

    public static String humanReadableFormat(Duration duration) {
        return duration.toHours() + "h " +
                duration.toMinutesPart() + "m " +
                duration.toSecondsPart() + "s";
    }

}
