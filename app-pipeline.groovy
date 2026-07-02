pipeline{
    agent any
    stages{
        stage('PULL'){
            steps{
            git branch: 'test', url: 'https://github.com/SauravChamate/CDEC-studentapp.git'
            }
        }
    }

        stage('DOCKER-FRONTEND-BUILD'){
            steps{
                sh '''cd frontend
                docker build -t sauravdoc99/frontend:v1'''
        }
    }

        stage('DOCKER-BACKEND-BUILD'){
            steps{
                sh '''cd backend
                docker build -t sauravdoc99/backend:v1'''
        }
    }

        stage('DOCKER-LOGIN'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'Docker-cred', passwordVariable: 'password_var', usernameVariable: 'username_var')]) 
                sh 'echo $password_var | docker login -u $username_var --password-stdin'
            }
        }
    
        stage ('DOCKER-PUSH') {
                steps {
                sh '''docker push sauravdoc99/frontend:v1 
                        docker push sauravdoc99/backend:v1 '''
                }
            }
        stage ('RM-IMAGE') {
            steps {
                sh 'docker rmi -f $(docker images -aq)'
        }    
    }

        stage('EKS-ACCESS') {
    steps {
        sh '''
        aws eks update-kubeconfig --region us-east-1 --name my-cluster
        '''
        }
    }
        stage ('KUBECTL-APPLY') {
            steps{
                sh 'kubectl apply -f simple-deploy/'
        }
    }
}
