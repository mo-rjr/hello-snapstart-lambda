package uk.gov.metoffice.hello.rjr;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.time.Clock;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HelloSnapstartLambdaHandler implements RequestHandler<Object, String> {

    private static ZonedDateTime instantiation;

    public HelloSnapstartLambdaHandler() {
        instantiation = ZonedDateTime.now(Clock.systemUTC());
    }

    @Override
    public String handleRequest(Object input, Context context) {

        ZonedDateTime timeNow = ZonedDateTime.now(Clock.systemUTC()).withNano(0);

        String instantiationString  = "Instantiated at " + instantiation.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        Duration since = Duration.between(instantiation, timeNow);
        String durationString = humanReadableFormat(since) + " ago";

        String response = instantiationString + ", " + durationString;

        context.getLogger().log(response);
        return response;

    }

    public static String humanReadableFormat(Duration duration) {
        return duration.toHours() + "h " +
                duration.toMinutesPart() + "m " +
                duration.toSecondsPart() + "s";
    }
}
