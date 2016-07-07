# FoVDemo
Clustering countries based on data from various streams.


ALL THE STEPS MUST BE FOLLOWED IN ORDER!!!


Pre-requisites before executing programs:

1.Check if datasets has names as health, education, public-cash and public-tax for their respective dataset.
2.Create four databases health, education, public-cash and public-tax. With all the databases to have three tables named country_code ,country_gdp and country_class.
3.country_code has two columns country(varchar) and code(varchar) with country as primary key.
4.country_gdp with country(varchar),year(varchar) and val(FLOAT) as columns.{country,year} acts as a primary key.country is the foreign key which references to the country of country_code table.
5.country_class with country(varchar) and class(INT) as columns.country is the primary key.country is the foreign key which references to the country of country_code table.
6.Repeat the steps 3,4,5 for all the above mentioned databases.
7.Now create a new database called vector. Create two tables country_vector and country_cluster.
8.country_vector has five columns country(varchar),health(INT),education(INT),public-cash(INT) and public-tax(INT).
9.country_cluster has two columns country(varchar) and cluster(INT). This holds the cluster number of each countries.
10. Make sure that you have set up your class path and established JRE setup properly in your environment.


Steps to execute programs

1.First open Executables.

2.Then open 1.Parsing under it.

3.Compile the java file as javac Ogdp.java

4. Run the java file as java cp . Ogdp health.

5. Run the java file as java cp . Ogdp education.

6. Run the java file as java cp . Ogdp public-cash.

7. Run the java file as java cp . Ogdp public-tax.

8. Now the data has been parsed and stored in two tables country_code and country_gdp in all four databases health, education, public-cash and public-tax(Check the DB to make sure).

9. Now come out of the folder 1.parsing and open 2.classification.

10.Compile the java file as javac Classification.java 

11. Run the java file as java cp . Classification health.

12. Run the java file as java cp . Classification education.

13. Run the java file as java cp . Classification public-cash.

14. Run the java file as java cp . Classification public-tax.

15. Now the country has been classified and entered into country_class under each respective databases health, education, public-cash and public-tax.

16. Now come out of folder 2.classification and enter 3.vector and clustering.

17. Compile the java file as javac Vector.java

18.Run the java file as java cp . Classification health education public-cash public-demo vector

19. Now you have vector of each countries in vector database under country_vector table.

20. This also generates a csv file for the same under the name test.csv in the same folder.

21. Now run the python cluster.py.

22. This does the clustering and stores it in a test_results.csv file.

23. Now compile the java file as javac Cluster1.java.

24. Now this stores the clustered countries back into the database vector in the table country_cluster.

25. Now this table can be queried for countries under same cluster.
