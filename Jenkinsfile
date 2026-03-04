pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master', 
                    url: 'https://github.com/Venkateswararaobhimasingipractice/seleniumhybridtestwithjekkins.git'
            }
        }

        stage('Read Run ID From Local Path') {
            steps {
                script {
                    def filePath = "C:\\Users\\B.VENKATESWARA RAO\\Documents\\veeva\\java_selenium_grid_jar\\pythonfiles\\testrail\\testrail_run_id.txt"

                    def content = readFile(file: filePath).trim()
                    env.TESTRAIL_RUN_ID = content.split("=")[1]

                    echo "Using TestRail Run ID: ${env.TESTRAIL_RUN_ID}"
                }
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat """
                mvn clean test -DrunId=%TESTRAIL_RUN_ID%
                """
            }
        }
    }
}