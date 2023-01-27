pipeline {
    agent any

    stages {
        stage('GitCheckOut') {
            steps {

            }
        }

        stage('MavenBuild') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('SonarQubeReport') {
            steps {
                sh "mvn sonar:sonar"
            }
        }

        stage('UploadToArtifacts') {
            steps{
                sh "mvn clean deploy"
            }
        }
    }
}