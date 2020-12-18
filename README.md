------------------------------------------------------------------------------------------------------Obecjtif du Site----------------------------------------------------------------------------------------------------------------

Partage d'information sur des sites d'escalade et échange de topos entre grimpeur

Nom du site: "Les amis de l'escalade"

----------------------------------------------------------------------------------------------------------Pré-requis------------------------------------------------------------------------------------------------------------------
Java : JDK 1.8 
Serveur d'application: Apache TOMCAT 7.0
DAO: Hibernate
BDD: MySQL 
Projet: Maven
Site responsive : Bootstap 
Lanceur base de donnée : WAMPSERVER (uniquement pour le déploiement local)

-------------------------------------------------------------------------------------------------Générer le fichier WAR--------------------------------------------------------------------------------------------------------------- 

1) Rendez-vous dans le dossier config de Tomcat et ouvrez le fichier User.xml

Ajout les lignes de commande suivante:

	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<user username="admin" password="password" roles="manager-gui,manager-script"/>

2) Modifier le fichier setting.xml de Maven

Ajouter les lignes suivantes:
<servers>
  
    <server>
      <id>TomcatServer</id>
      <username>admin</username>
      <password>password</password>

    </server>
    
  </servers>
 <pluginGroups>
    
    <pluginGroup>org.apache.tomcat.maven</pluginGroup>

  </pluginGroups>
    
</settings>

3) Modifier le fichier POM.xml pour ajouter le plugin de Maven

	<plugin>
			<groupId>org.apache.tomcat.maven</groupId>
			<artifactId>tomcat7-maven-plugin</artifactId>
			<version>2.2</version>
			<configuration>
				<url>http://localhost:8080/manager/text</url>
				<server>TomcatServer</server>
				<path>/mkyongWebApp</path>
			</configuration>
    </plugin>

4) Ouvrir l'invite de commande cmd

5) Taper la ligne de commande mvn tomcat7:deploy

5)Votre fichier WAR est prêt 

------------------------------------------------------------------------------------------------Déployer le site---------------------------------------------------------------------------------------------------------------------- 

1) Lancer le serveur base de donnée

2)Place le dans le dossier webapps de Tomcat

3)Aller dans le dossier bin de Tomcat et lancer startup.bat

4)Ouvrez votre navigateur internet et taper l'url du site.

---------------------------------------------------------------------------------------------Fonctionnement du site-------------------------------------------------------------------------------------------------------------------

Le site permet de consulter les sites, dès que l'on souhaite naviguer plus en détail il faut créer un compte ou s'identifier.

Il y a des fonctions qui ne sont proposé que lorsqu'on est administrateur et que l'utilisateur ne voit pas.

Tous le monde peut créer un site, faire des réservations de topos, faire des commentaires.

Dès qu'il s'agit d'apporter des modifications ou de supprimer il nous faut les droits administrateurs.

 escalade
