pipeline{
    agent any
    stages {
        
        stage('compile'){
            steps {
                bat 'mvn clean compile'
            }
        }
        
        stage('unit test'){
            steps {
                bat 'mvn test'
            }
        }
        
        stage('build'){
            steps {
                bat 'mvn -DskipTests package'
            }
        }
        
        stage('image'){
            steps {
                echo 'creating docker image...'
            }
        }

    }

}
