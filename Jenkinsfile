pipeline {
    agent any
    stages {
        stage ('PULL'){
            steps {
                git branch: 'main', url: 'https://github.com/SauravChamate/Jenkins.git'
            }
        }
        stage ('BUILD'){
            steps {
                echo 'BUILD SUCCESS'
            }
        }
        
        stage ('TEST') {
            steps {
                echo 'TEST SUCCESS'
                }
        }
        

        stage ('DEPLOY'){
            steps {
                echo 'DEPLOY SUCCESS'
            }
        }
        
    }
}
