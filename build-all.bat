rem $env:DOCKER_BUILDKIT=0
rem docker rm -f $(docker ps -aq)
FOR /f %%i IN ('docker ps -aq') DO docker rm -f %%i
FOR /f %%i IN ('docker images -aq') DO docker rmi -f %%i
cd api-gateway
call .\mvnw clean package -DskipTests -s ..\configuracion-maven\settings.xml

cd ../auth-service
call .\mvnw clean package -DskipTests -s ..\configuracion-maven\settings.xml

cd ../contenidos-service
call .\mvnw clean package -DskipTests -s ..\configuracion-maven\settings.xml

cd ../vinculacion-service
call .\mvnw clean package -DskipTests -s ..\configuracion-maven\settings.xml