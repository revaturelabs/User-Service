pipeline {
  agent any
  stages {
       stage('Test') {
         steps {
           sh 'mvn -f pom.xml test'
        }
       }

       stage('Build') {
         steps {
            sh 'mvn -f pom.xml clean install'
            sh 'mvn -f pom.xml clean package -DskipTests'
         }
       }

        stage('Docker Hub') {
          steps {
            script {
            sh "docker build -t javasre2022/userservice ."
            }
          }
        }
        
        stage('Docker Deliver') {
        steps {
            script {
              sh "echo $currentBuild.number " 
              sh "docker login -u javasre2022 -p 7ce357ae-b369-4a7d-876c-10d27cf1171e"
              sh "docker push javasre2022/userservice:latest"
              sh "docker tag javasre2022/userservice:latest javasre2022/userservice:$currentBuild.number"
              sh "docker push javasre2022/userservice:$currentBuild.number"
            }
        }
    }
        

         stage('Checkout') {
          steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'ghp', url: 'https://github.com/revaturelabs/User-Service']]])
          }
        }

        stage('Quality Gate') {
          steps {    
                 script {
                    sh 'mvn clean verify sonar:sonar \
                      -Dsonar.projectKey=User-service \
                      -Dsonar.host.url=http://35.222.177.228:9000 \
                      -Dsonar.login=61072435882689d3d022fed333f1fe524f275ad0'
                 } 
           } 
        }
        stage('Wait for approval') {
        when {
            branch 'master'
        }
        steps {
            script {
                try {
                    timeout(time: 5, unit: 'MINUTES') {
                        approved = input message: 'Deploy to production?', ok: 'Continue',
                                           parameters: [choice(name: 'approved', choices: 'Yes\nNo', description: 'Deploy build to production')]
                        if(approved != 'Yes') {
                            error('Build did not pass approval')
                        }
                    }
                } catch(error) {
                    error('Build failed because timeout was exceeded')
                }
            }
        }
    }
        stage('DeployToCluster') {
          steps {
            withKubeConfig(credentialsId: '39a085b6-0856-43e2-94c5-7c1e4b583506', serverUrl: 'https://35.232.148.254') {
              sh 'curl -LO "https://storage.googleapis.com/kubernetes-release/release/v1.20.5/bin/linux/amd64/kubectl"'
              sh 'chmod u+x ./kubectl'
              sh './kubectl apply -f Kubernetes/deployment.yml'

            }

          }
        }
  }
}
