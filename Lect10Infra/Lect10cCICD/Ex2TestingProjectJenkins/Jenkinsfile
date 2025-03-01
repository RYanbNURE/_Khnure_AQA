pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Проверка исходного кода из репозитория
                checkout scm
            }
        }

        stage('Setup JDK') {
            steps {
                // Установка JDK 17
                script {
                    env.JAVA_HOME = tool name: 'JDK 17', type: 'jdk'
                    env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
                }
            }
        }

        stage('Build') {
            steps {
                // Сборка проекта с Gradle
                sh './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                // Запуск тестов
                sh './gradlew test'
            }
        }
    }

    post {
        always {
            // Сохранение артефактов сборки (например, jar-файл)
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true

            // Публикация результатов тестов
            junit 'build/test-results/test/*.xml'
        }
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed. Check the logs.'
        }
    }
}