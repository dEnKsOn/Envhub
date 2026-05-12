# **Cahier des Charges**
## EnvHub : Système de Gestion et de Centralisation des Environnements **Kossi Jubilee DENOU** **Présentation Générale**

Le système EnvHub est une application web conçue pour digitaliser et centraliser la
gestion technique des différents projets au sein d’une structure de développement. L’objectif principal est de pallier la dispersion des informations en fournissant un référentiel
unique et fiable. Ce système permet aux équipes techniques de suivre précisément l’état,
l’infrastructure et la configuration logicielle de chaque projet.

## **Gestion des projets et des clients**


Le module de gestion des projets constitue le noyau administratif de l’application,
permettant de structurer l’activité de l’entreprise par entité cliente. Pour enregistrer un
nouveau projet, l’utilisateur accède à un formulaire détaillé via le menu "Nouveau Projet".
Il renseigne les données descriptives suivantes :


  - Le nom complet du projet.


  - L’entité cliente (entreprise ou commanditaire).


  - Une description technique détaillée des objectifs et du domaine métier.


  - Les dates clés : date de lancement et date de livraison estimée.


  - Le statut actuel du projet (En cours, En pause, Livré, Annulé).


Lors de la soumission, le système effectue une vérification (combinaison du nom du
projet et du client) pour bloquer la création de doublons. Une fois le projet validé en base
de données, l’interface permet d’y associer les ressources humaines, notamment le chef de
projet et les développeurs de l’équipe chargés du suivi. La consultation et la modification
de ces fiches restent possibles à tout moment via un moteur de recherche multicritère (par
nom, par client).

## **Gestion des environnements techniques**


La gestion des environnements est la fonctionnalité centrale et la plus critique du
système. Elle permet de lier un projet global à ses différentes instances physiques ou
virtuelles de déploiement. Pour chaque projet, l’utilisateur peut définir plusieurs types
d’environnements qui correspondent au cycle de vie du développement : Environnement
Local, Développement, Staging/Pré-production, et Production.
Pour chaque environnement créé, les informations techniques suivantes sont rigoureusement enregistrées :


  - **Accès** **Web** **:** L’URL front-end pour les tests clients et l’URL back-end/API.


1


  - **Serveur** **:** L’adresse IP publique ou locale du serveur d’hébergement, ainsi que le
système d’exploitation utilisé.


  - **Stack** **Logicielle** **:** Les versions exactes des langages et frameworks utilisés pour le
projet.


  - **Base** **de** **Données** **:** Le type de moteur utilisé, la version, et le nom de la base de
données cible.


Une règle de gestion stricte est appliquée : un projet peut posséder plusieurs environnements de "Développement", mais le système alerte l’utilisateur s’il tente de créer
plus d’un environnement de type "Production" actif simultanément. Un champ de notes
permet d’ajouter des indications sur la configuration matérielle ou des commandes de
lancement spécifiques à chaque instance.

## **Tableau de bord et navigation**


À l’ouverture de l’application, l’utilisateur accède à un tableau de bord (Dashboard)
centralisé offrant une visibilité immédiate et globale sur l’ensemble du parc de projets de
l’agence. Ce tableau, paginé pour des raisons de performances, liste les projets actifs sous
forme de grille de données.
Il affiche, via des indicateurs visuels (badges de couleurs dynamiques), les types d’environnements actuellement configurés et opérationnels pour chaque projet. Des outils de
filtrage avancés (menus déroulants) permettent de trier instantanément les projets par
client, par état d’avancement ou par technologie dominante.
Chaque ligne du tableau comporte des boutons d’action rapide permettant d’accéder
d’un clic à la fiche détaillée d’un projet pour en consulter ou modifier les environnements.
Un module d’administration annexe permet de gérer la liste des utilisateurs du système,
de mettre à jour leurs informations (nom, prénom, email) et de leur attribuer leurs profils
respectifs.

## **Délimitations du projet**


**Éléments** **inclus** **(Périmètre** **fonctionnel)**


Dans le cadre de ce projet, les développements et livrables suivants seront intégralement réalisés :


  - Modélisation conceptuelle et logique des données (MCD/MLD) pour structurer le
référentiel.


  - Conception et implémentation de la base de données relationnelle et de ses scripts
de création.


  - Développement de l’interface utilisateur (Front-end) pour la saisie, la mise à jour et
la consultation fluide des données.


  - Programmation de la logique métier (Back-end) selon le modèle MVC pour la gestion
complète (CRUD) des projets, des clients et des environnements techniques.


  - Mise en place du moteur de recherche multicritère et du tableau de bord de synthèse
dynamique.


2

