# The application is built using mvn and can be packaged as a jar using mvn clean package, which would generate a PayslipGenerator.jar
# To execute the application: java -jar PayslipGenerator.jar
# Assumptions:
## The input and output file paths are hard coded instead if being passed as args to the main for simplicity.
## Names and pay dates are not validated, assuming that the data is valid
## It is assumed that super is given in the format 10% or 9% etc. 
## It is assumed that all values passed are whole numbers, though the CSV handler automatically rounds off the values.
## It is assumed that the inputs are valid, i.e. all the fields are passed
