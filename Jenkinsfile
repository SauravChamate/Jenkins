pipeline {
    agent any
    stages {
        stage ('PULL'){
            steps {
                git branch: 'devops', url: 'https://github.com/jambhulkarcloudblitz-alt/CDEC-studentapp.git'
            }
        }

        stage ('BUILD'){
            steps {
                sh '''cd backend
                mvn clean package -DskipTests'''  
            }
        }
        
        stage ('TEST') {
            steps {
                sh '''cd backend
                mvn sonar:sonar \\
                -Dsonar.projectKey=student-app \\
                -Dsonar.projectName=\'student-app\' \\
                -Dsonar.host.url=http://35.171.184.89:9000 \\
                -Dsonar.token=sqp_1787929eb51358baa849839cc146b2e295554597'''
            }
        }
        
        stage ('DEPLOY'){
            steps {
                echo 'DEPLOY SUCCESS'
            }
        }
        
    }
}

