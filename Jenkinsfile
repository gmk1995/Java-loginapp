pipeline {
    agent {
        label 'Slave-1'
    }

    tools {
        maven 'maven3.8.7'
        git 'Default'
    }

    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')
        timestamps()
    }

    parameters {
        choice choices: ['main', 'dev', 'qa', 'prod'], name: 'BranchName'
        string defaultValue: 'Mohan Kumar', name: 'ExecutorName'
    }

    stages {
        stage('GitCheckOut') {
            steps {
                git branch: "${params.BranchName}", credentialsId: '026f781b-368d-4626-ab66-08d71d1d7d82', url: 'https://github.com/gmk1995/Java-loginapp.git'
                            
            }
        }

        stage('RunningGlobalVariables') {
            steps{

                echo "Job Running on ${env.BRANCH_NAME}"
                echo "Job Build Number  ${env.BUILD_NUMBER}"
                echo "Job Build ID ${env.BUILD_ID}"
                echo "Click on the link to redirect to job ${env.JOB_DISPLAY_URL}"
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