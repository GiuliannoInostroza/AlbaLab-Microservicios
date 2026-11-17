cd api-gateway
call .\mvnw clean -s ..\configuracion-maven\settings.xml

cd ../auth-service
call .\mvnw clean -s ..\configuracion-maven\settings.xml

cd ../contenidos-service
call .\mvnw clean -s ..\configuracion-maven\settings.xml

cd ../vinculacion-service
call .\mvnw clean -s ..\configuracion-maven\settings.xml