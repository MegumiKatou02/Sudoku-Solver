pipeline {
    agent any
    tools {
        maven 'MAVEN' 
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/MegumiKatou02/Group1Demo.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package -DskipTests=true'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh "mvn test"
                }
            }
        }
        stage('Archive') {
            steps {
                echo 'Archiving JAR file...'
                archiveArtifacts allowEmptyArchive: false, artifacts: '**/target/*.jar', onlyIfSuccessful: true
            }
        }
    } 
    post {
        success {
            echo 'Thuc hien pineline thanh cong'  
        }
        failure {
            echo 'Build that bai.' 
        }
    }
}