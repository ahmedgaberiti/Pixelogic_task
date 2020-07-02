# Pixelogic_task


"Automated Script for valid user registration for PHP travels website:https://www.phptravels.net/register using POM model and page factory design"

.the script works on chrome version 83 on the last update 

.the framework is divided into classes with page object model and page factory design
.we have 3 main packages 

.the first is the pom packages which contains :
the page base class has the driver and some common methods
the registration class extends the page base which represents the site registration page and has it element locators and a method to fill them 

the second package is tests which contains:
the test base clase which represents some setups to initiate the driver and some methods to the http interceptor and the screenshot on failure 
the registrationtest class has the main script to make the registration

the third package is utilities which contains :
class for contstant paths
class for reading from external file.properties
the external file.properties which have the data for the test 
helper class to take the screenshot method 
the listener class which makes some logs during the test and make a report with allure reporting 

.. there is a method called Http_interceptor which used to save the reponse but the script when try to make registartion the server responds with 
500 ! which is a server error and i handled it in the test but on reality i cannot make a real account so i didnot complete the script to make the user 
login again with the right creditials 

