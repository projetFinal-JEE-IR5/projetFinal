# App

User Stories :

* En tant que directeur des études, je veux pouvoir informer les étudiants qui me sont rattachés
* En tant qu'étudiant, je veux pouvoir consulter les informations qui me concernent
* En tant que directeur d'établissement, je veux pouvoir informer tous les étudiants
* En tant que directeurs des études et d'établissement, je veux pouvoir supprimer les anciennes notifications (informations)
* En tant qu'étudiant, je veux pouvoir remonter un problème (à définir) avec mes coordonnées (nom, prénom)
* En tant que directeurs des études et d'établissement, je veux pouvoir consulter les problèmes
* En tant qu'étudiant, je veux pouvoir consulter les problèmes et voter (une seule fois par problème) pour accélérer leur résolution (+1)
* En tant que directeurs des études et d'établissement, je veux pouvoir supprimer les problèmes résolus
* En tant que directeurs des études et d'établissement, je veux pouvoir limiter le nombre de problèmes remontés par étudiant et par jour
* En tant qu'établissement partenaire, je veux pouvoir accéder aux notifications sous forme de web services JSON (REST)

Mes attentes :

* je veux un projet Maven
* je veux la mise en place de Spring et JPA côté serveur
* je veux voir dans le code les différentes couches
* je veux des pages côté serveur (Thymeleaf)
* je veux une gestion de la BDD avec Flyway

J'attends une page d'explication, de type journalistique avec :

* ce que fait le programme (copie d'écrans) ;
* la structure modèles objets + services.

Tips :

* Faire simple, ne pas tenter d’optimiser dans un 1er temps
* Traverser toutes les couches avant de peaufiner chacune d’entre elles

== Aide à la relecture des slides

* Formation_Maven_20151214.pdf
** Passer les parties "multi modules projects" et "optimizing poms"

* Formation_Spring_01-Core_20151128.pdf
** Passer la partie "advanced wiring"

* Formation_Spring_04-Boot_20161130.pdf
** Tout est à regarder :)

* Formation_Spring_02-OnTheWeb_20151128.pdf
** Passer la partie configuration (prise en charge par Spring Boot !)

* Formation_Spring_03-InTheBackend_20151128.pdf
** Uniquement la slide "Writing a JPA-based repository" et la partie sur les transactions

* Formation_Spring_05-WebService_20160424.pdf
** Uniquement la 1ere partie sur les web services REST