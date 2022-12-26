package uk.gov.metoffice.hello.rjr;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import uk.gov.metoffice.hello.rjr.aws.SnapstartLambdaInitialization;

public class HelloSnapstartLambdaHandler implements RequestHandler<Object, String> {

    private final MainController mainController;

    public HelloSnapstartLambdaHandler() {
        mainController = new SnapstartLambdaInitialization().get();
    }

    @Override
    public String handleRequest(Object input, Context context) {
        String response = mainController.message();

        context.getLogger().log(response);
        return response;
    }

}
