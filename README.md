# JavaStreamsInSelenium
How to use java 8 streams concept in Selenium

This project consist of a Maven project using following dependencies:
1. Selenium
2. TestNG
3. ExtentReport
4. WebdriverManager

This project follows Page object model approach.

This project is TestNG Project and to run test cases we need to run it from TestNG.xml file placed in (src<main<java<resources).

All the input data is stored in config.properties file stored in (src<main<java<com<testvagrant<config<config.properties)
1. url=https://rahulshettyacademy.com/seleniumPractise/#/offers
2. browser = chrome
3. veggie=Tomato
4. expectedPrice=37
5. searchVeggie=Rice

Reports are generated in reports folder.

The test file contains 3 test cases:
1. In this test case we try sort the vegetable/fruits appearing in first column and then using java 8 streams we are verifying that the returned values are coming in sorted order.

2. In this test we try to search for a vegetable/fruit and returning its price using java 8 streams.

3. In this test we try filter the value on the basis of searched vegetable/fruit and then checking whether the functionality is working fine using java 8 streams.
