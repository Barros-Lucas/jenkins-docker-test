node{
	def app

	stage ('Clone'){
		checkout scm	
	}

	stage('Build image'){
		app = docker.build("dashboard/front-test-jenkins")
	}

	stage('Run image'){
		docker.image('dashboard/front-test-jenkins').withRun('-p 80:80'){c ->
		sh 'docker ps'

		sh 'curl localhost'
	}	
	
	}


}