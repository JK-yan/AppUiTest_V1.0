pipeline {
  agent any
  stages {
    stage('checkout') {
      parallel {
        stage('checkout') {
          steps {
            git(url: 'https://github.com/jackiezero/AppUiTest_V1.0.git', branch: 'master')
          }
        }
        stage('sleep') {
          steps {
            sleep 1
          }
        }
      }
    }
  }
}