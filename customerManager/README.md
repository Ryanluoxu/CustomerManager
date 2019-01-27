
# DB
create database customermanager
CREATE USER customermanager WITH PASSWORD 'customermanager';
GRANT ALL PRIVILEGES ON database customermanager TO customermanager;

# Entity
## application.properties
## persistence.xml
## entity class
## JpaUtil.java
run and get DB