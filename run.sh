mvn -f ./app/pom.xml clean package -Dmaven.test.skip=true
mvn -f ./test-task-vehicle-tracker/pom.xml clean package -Dmaven.test.skip=true 
docker image build -t car-rental-web-ui:base ./app
docker image build -t car-rental-tracking:base ./test-task-vehicle-tracker
docker image build -t car-rental-nginx:base ./nginx
docker-compose up