package uk.gov.metoffice.hello.rjr.aws;

import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.services.ssm.SsmClient;
import uk.gov.metoffice.hello.rjr.MainController;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.function.Supplier;

/**
 * Reponsible for the code that runs at initialization time,
 * instantiating classes and fetching ssm params etc
 */
public class SnapstartLambdaInitialization implements Supplier<MainController> {

    private static final String SSM_PARAM_NAME_ENV_VAR = "SSM_PARAM_NAME";

    private static MainController mainController;

    public SnapstartLambdaInitialization() {
        System.out.println("Starting initialization");
        mainController = setUp();
        System.out.println("Initialization successful");
    }

    public MainController setUp() {

        System.out.println("Getting environment variable '" + SSM_PARAM_NAME_ENV_VAR + "'");
        String ssmParamName = System.getenv(SSM_PARAM_NAME_ENV_VAR);

        System.out.println("Creating SSM client");
        SsmClient ssmClient = SsmClient.builder()
                .httpClient(UrlConnectionHttpClient.builder().build())
                .build();

        System.out.println("Getting SSM param with name '" + ssmParamName + "'");
        String ssmParamValue = ssmClient.getParameter(bob -> bob.name(ssmParamName))
                .parameter().value();
        System.out.println("SSM param '" + ssmParamName + "' has value '" + ssmParamValue +
                "'");

        return new MainController(ZonedDateTime.now(Clock.systemUTC()).withNano(0),
                ssmParamName, ssmParamValue);
    }

    @Override
    public MainController get() {
        return mainController;
    }
}
