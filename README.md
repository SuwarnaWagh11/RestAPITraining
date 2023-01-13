# RestAPITraining

In order to execute this project, you need to attend below training if possible.

https://www.linkedin.com/learning/java-automated-api-testing-with-rest-assured/gain-fast-feedback-with-automated-api-testing?autoplay=true&u=2113185

If it is not possible, follow the below steps:
1. Download & Install MAMP from mamp.info
2. Once downlaoded, click on start button or check it is already started
3. Click on webstart which will open your browser. e.g. http://localhost/mamp/
4. Download the ApiTestingDB.sql from framework(src). click on Import button, click on Browse. select ApiTestingDB.sql file 
5. Download api_testing folder from the framework(src/test/resources) which has some files(.vscode,category,config,object,product)
6. Copy that folder and paste it in C:\MAMP\htdocs.
7. Now we need to create the DB to hold out API data. In order to achieve that, navigate to the http://localhost/mamp/
8. On the webpage, go to the MySQL section
9. Click on phpMyAdmin hypelink
10. Now create new DB
11. Click on New
12. Enter DB Name - ApiTestingDB - click Create.
13. Click on Import button, click on Browse. select ApiTestingDB.sql file 
14. Downlad api_testing folder from the framework which has some files(.vscode,category,config,object,product)
15. Try to check, if you are able to get the json data via below link.
 http://localhost/api_testing/category/read.php
http://localhost/api_testing/product/read.php
http://localhost/api_testing/product/create.php
http://localhost/api_testing/product/update.php
http://localhost/api_testing/product/delete.php
