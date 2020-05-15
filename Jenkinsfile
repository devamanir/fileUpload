node{
      stage('Git checkout') {
      	git 'https://github.com/devamanir/fileUpload.git'
         }
      stage('Package and Build') {
            def mvnHome = tool name: '', type: 'maven'
            sh "${mvnHome}/bin/mvn package"
         }
      }
