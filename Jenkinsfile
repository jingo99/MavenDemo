pipeline {
    agent {
        docker { image 'node:7-alpine' }
    }
    stages {
        stage('Test2') {
            steps {
                sh 'node --version'
            }
        }
    }
}
