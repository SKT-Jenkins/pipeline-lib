def call(String name) {
  echo "hello & hi ho he hu updated this comes from within shared lib function ${name}. Updated to check push behaviour"
 }
def checkout_code(String branch_name1) {
  echo "SANJAY: Incoming value of branch is ${branch_name1}"
  checkout([$class: 'GitSCM', branches: [[name: '"*/${branch_name1}"']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '0f0682df-26dd-48f2-86d4-40e2b48eabc7', url: 'git@github.com:SKT-Jenkins/mobile-rep.git']]])
  
} 
def createGitBranch(String projectName, String targetBranch, String sourceBranch) {
withCredentials([usernamePassword(
  credentialsId: 'gitlanapitoken',
  passwordVariable: 'GIT_API_TOKEN',
  usernameVriable: 'UNUSED')])
  {
  def createBranchRequest = "${env.GIT_HTTPS}/api/v4/projects/${projectName}/repository/branches " +
    "--data-urlencode \"branch=${targetBranch}\" --data-urlencode \"ref=${sourceBranch}\""
  
  response = sh (
    script: 'curl --noproxy "*" -X POST --header "PRIVATE-TOKEN: ${GIT_API_TOKEN}" ' + createBranchRequest,
    returnStdout: true
    )
  return response
  }
}
  
