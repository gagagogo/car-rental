pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package'
                sh 'docker image build -t car-rental-web-ui:base ./car-rental-web-ui'
                sh 'docker image build -t car-rental-tracking:base ./test-task-vehicle-tracker'
            }
        }        
    }
}