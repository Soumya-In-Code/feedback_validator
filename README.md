# feedback_validator
Customers to post comment/feedback on specific products in the product details page. These comments are visible to all other customers.

This project is a simple Springboot application to validate the comment text to prevent customers from posting objectionable content. 
The REST API is expected to take a piece of text as an input and respond with feedback regarding objectionable content.

Work flow and logic:-
------

If the feedback entered by customer contains any word which is/are objectionable then in the response body the "feedback" attribute will be empty and the "publish" attribute will be false.
The attrbute "publish" is a boolean type which tells that a customers feedback should be published or not.

For the feedback with no objectionable strings the "publish" attribute in response body will be true and the "feedback" attribute will hold the actual feedback entered by the user. 

How To know the input string (feedback) contains objectionable word/s ? 
This application stores objectionable Strings/Words in Ternary Search Tree(TST) just after the application starts (As of now we have stored few words for testing purpose), then once the the customer hits submit/publish button with his/her feedback this REST API checks each and every word of the input feedback in the Ternary Search Tree (TST). If we get a matching word in TST that means the input feedback has objectionable content.  

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
