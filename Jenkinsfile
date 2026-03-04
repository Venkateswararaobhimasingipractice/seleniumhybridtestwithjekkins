pipeline {
    agent any
    
    environment {
        JIRA_EMAIL = credentials('jira-email')
        JIRA_TOKEN = credentials('jira-api-token')
    }


    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', 
                    url: 'https://github.com/Venkateswararaobhimasingipractice/seleniumhybridtestwithjekkins.git'
            }
        }

        stage('Read TestRail and Jira Data') {
            steps {
                script {
                    // Update this path to where your Python script saves the file
                    def filePath = "C:\\Users\\B.VENKATESWARA RAO\\Documents\\veeva\\java_selenium_grid_jar\\pythonfiles\\testrail\\testrail_run_id.txt"
                    
                    def fileContent = readFile(file: filePath).trim()
                    def props = [:]

                    // Split by lines and then by the '=' sign
                    fileContent.split("\n").each { line ->
                        def parts = line.split("=")
                        if (parts.length == 2) {
                            props[parts[0].trim()] = parts[1].trim()
                        }
                    }

                    // Set Environment Variables for the next stages
                    env.TESTRAIL_RUN_ID = props['RUN_ID']
                    env.ISSUE_KEY = props['ISSUE_KEY']

                    echo "Successfully loaded RUN_ID: ${env.TESTRAIL_RUN_ID}"
                    echo "Successfully loaded ISSUE_KEY: ${env.ISSUE_KEY}"
                }
            }
        }

        steps {
                bat """
                mvn clean test ^
                -DrunId=%TESTRAIL_RUN_ID% ^
                -DissueKey=%ISSUE_KEY% ^
                -DjiraEmail=%JIRA_EMAIL% ^
                -DjiraToken=%JIRA_TOKEN%
                """
            }
        }
    }
}