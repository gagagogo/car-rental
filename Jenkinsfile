pipeline {
    agent none
    stages {
        stage('Build') { 
			agent {
		        docker {
		            image 'maven:3-alpine' 
		            args '-v /root/.m2:/root/.m2' 
		        }
		    }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
       stage('Build docker contaners'){
            agent any
            steps {
                sh 'docker image build -t car-rental-web-ui:base ./car-rental-web-ui'
                sh 'docker image build -t car-rental-tracking:base ./test-task-vehicle-tracker'
            }
       }         
       stage('Deploy contaners'){
            agent any
            steps {
                sh 'docker service update --image car-rental-web-ui:base --force car-rental_car-rental-web-ui'
                sh 'docker service update --image car-rental-tracking:base --force car-rental_car-rental-tracking'
            }
       }         
    }
}