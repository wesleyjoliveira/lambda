pipeline {
  agent any
  stages {
    stage('Testes') {
      parallel {
        stage('Testes') {
          steps {
            echo 'teste'
          }
        }
        stage('Teste IE') {
          steps {
            echo 'Teste no IE'
          }
        }
        stage('Teste Firefox') {
          steps {
            echo 'Teste Firefox'
          }
        }
      }
    }
  }
}