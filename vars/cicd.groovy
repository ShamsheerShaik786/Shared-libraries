def Download(repo)
{
  git "https://github.com/ShamsheerShaik786/${repo}.git"
}
def Build()
{
  sh 'mvn package'
}
def Deploy(jobname,IP,Contextpath)
{
  sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${IP}:/var/lib/tomcat10/webapps/${Contextpath}.war"
}
def RunTestcases(repo)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
