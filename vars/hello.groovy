def call(String name) {
  echo "hello & hi ho he hu updated this comes from within shared lib function ${name}. Updated to check push behaviour"
 }
// def checkout_code(String branch_name) {
 //  checkout([$class: 'GitSCM', branches: [[name: '*/${branch_name}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '0f0682df-26dd-48f2-86d4-40e2b48eabc7', url: 'git@github.com:SKT-Jenkins/mobile-rep.git']]])
// } 
