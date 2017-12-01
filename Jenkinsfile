pipeline {
  agent any
  stages {
    stage('ds') {
      parallel {
        stage('ds') {
          steps {
            mail(subject: 'asa', body: 'sasas')
          }
        }
        stage('asa') {
          steps {
            sleep 1
          }
        }
      }
    }
    stage('sasas') {
      agent any
      steps {
        sleep 1
      }
    }
  }
}