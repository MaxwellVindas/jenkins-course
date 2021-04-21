job('NodeJS example') {
    scm {
        git('git:github.com/MaxwellVindas/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('MaxwellVindas')
            node / gitConfigEmail('maxwell.vindas@ucr.ac.cr')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
