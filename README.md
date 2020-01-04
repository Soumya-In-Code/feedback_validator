# feedback_validator
This project is a simple API to validate the comment text to prevent customers from posting objectionable content. 
The REST API is expected to take a piece of text as an input and respond with feedback regarding objectionable content.

Work flow and logic:-
------

If the feedback contains any word which are objectionable then the response will not have any value "feedback" attribute and the "publish" attribute will be false.
The attrbute "publish" is a boolean type which tells that a feedback should be published or not.

For the feedback with no objectionable strings the "publish" attribute in response body will be true and the "feedback" attribute will hold the actual feedback entered by the user. 

To know the input string (feedback) contains any objectionable words or not, this application stores objectionable Strings/Words in Ternary Search Tree just after the application starts. (As of now we have stored few words for testing purpose.)

-----------------------------------------------
API Details:
------
URL : http://localhost:9090/feedbackValidationService/v1/validateFeedback/userId/{userId}?feedback={feedback}&productId={productId}
Method : GET
Response format: JSON

-----------------------------------------------
Sample request and response:
------
Request with Good feedback:
-------
URL : http://localhost:9090/feedbackValidationService/v1/validateFeedback/userId/U1?feedback=nice&productId=P1
Method : GET
Response: 
{
    "feedback": "nice",
    "publish": true,
    "userId": "U1",
    "productId": "P1"
}


Request with bad feedback:
------
URL : http://localhost:9090/feedbackValidationService/v1/validateFeedback/userId/U1?feedback=crap&productId=P1
Method : GET
Response:
{
    "feedback": "",
    "publish": false,
    "userId": "U1",
    "productId": "P1"
}
