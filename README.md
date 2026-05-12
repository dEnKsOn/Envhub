# 🌍 EnvHub

**EnvHub** est une application web robuste conçue pour centraliser et simplifier la gestion des environnements informatiques, des projets et des équipes techniques. Elle permet de cartographier l'infrastructure technique (serveurs, bases de données, URLs) et d'assurer un suivi précis des affectations et des cycles de vie des développements.

## 🛠️ Stack Technique
* **Backend :** Java EE (Jakarta Servlet 6.0, JSP/JSTL)
* **Base de données :** MySQL (Conteneurisé via Docker Compose)
* **Build & Gestionnaire de dépendances :** Maven
* **Sécurité :** Approche *Secure by Design* (Gestion des variables d'environnement via `dotenv-java`)

## ✨ Fonctionnalités Principales
* **Suivi de Projets :** Gestion du cycle de vie des projets (En cours, Staging, Livré) et du pourcentage d'avancement.
* **Cartographie des Environnements :** Centralisation des données de connexion (Local, Développement, Staging, Production) liées aux serveurs et aux technologies utilisées.
* **Gestion des Rôles :** Attribution d'accès et de profils spécifiques (Administrateur, Développeur, Chef de Projet).
* **Traçabilité & Audit :** Triggers SQL automatisés pour garantir l'intégrité des règles métier (unicité des environnements de prod, journalisation des modifications d'URLs, etc.).
