# Problem Statement
HashMap as a Service
 Write a service broker for cloud foundry that provides a custom HashMap to be used by CF applications.

# Approach:
  Service Broker is solved with the implementation of custom hashmap which performs all the functionalities of java.util.HashMap.
  TDD approach is followed in all the places.JUnit is used for writing unit test cases.
  
# Steps to Run:
  1) Import the project ClientServiceBroker as Maven project and do a maven install to build the project succesffully.
  2) Run the RequestExecutorTests.java which will invoke the service broker running in http://hashmap-service-broker.cfapps.io/


