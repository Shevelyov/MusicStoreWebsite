# MusicStoreWebsite
The project represent a web application implemented with JAVA for backend functionality and JSP for UI representatios as well as Spring MVC. The applciation uses cloud MySQL clearDB database. The connection to the database may be obtained thru the configuration file in the project sourse files. 

The topic of the project is building a web application and testing its UI via getting information about what buttons user clicks most and so forth. This is implemented via UserStatistics entity which has corresponding DB table. For instance, if user views some product this information is transfered to the database by updating the table with customer and product information. If the user opens the same product again only one column is updated which represents the number of openings. 

Gathered data can be viewed by admin user and represented as a table in the UI. The data is transfered to the JSP from java class.
