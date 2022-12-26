# hello-snapstart-lambda

Hello Snapstart!  

v1: When do you instantiate?  Do we need to fetch our SSM parameters on the fly?
v2: What if republication fails?

* [https://docs.aws.amazon.com/lambda/latest/dg/snapstart.html](https://docs.aws.amazon.com/lambda/latest/dg/snapstart.html)
* [https://aws.amazon.com/about-aws/whats-new/2022/11/aws-lambda-snapstart-java-functions/](https://aws.amazon.com/about-aws/whats-new/2022/11/aws-lambda-snapstart-java-functions/)

## handler
`uk.gov.metoffice.hello.rjr.HelloSnapstartLambdaHandler::handleRequest`

## v1: simple
The code is at tag `original`. 
There's some information about what happened in the docs folder

## v2: init might fail
Now requires env var `SSM_PARAM_NAME` with the value of an SSM parameter in the account. 
If the SSM parameter is not available, initialization will fail.
