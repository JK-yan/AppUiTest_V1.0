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
    stage('docker') {
      agent any
      steps {
        tool(name: 'docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool')
      }
    }
    stage('ss') {
      steps {
        sh 'docker build'
      }
    }
  }
}