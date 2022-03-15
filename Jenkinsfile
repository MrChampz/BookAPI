pipeline {
  agent any
  stages {
    stage('Print Hello World') {
      parallel {
        stage('Print Hello World') {
          steps {
            echo 'Hello World'
            sleep 20
          }
        }

        stage('Ping over google.com') {
          environment {
            TEST_ENV = 'test'
          }
          steps {
            sh 'ping www.google.com'
          }
        }

      }
    }

  }
}