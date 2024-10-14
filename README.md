# Gestion des Produits avec Hibernate (Exercice 1)

Ce projet est une application Java de gestion des produits utilisant Hibernate pour la persistance des données et MySQL comme base de données.

## Table des matières

1. [Description du projet](#description-du-projet)
2. [Prérequis](#prérequis)
3. [Structure du projet](#structure-du-projet)
4. [Configuration](#configuration)
5. [Fonctionnalités](#fonctionnalités)
6. [Installation et exécution](#installation-et-exécution)
7. [Tests](#tests)

## Description du projet

Ce projet vise à créer une application de gestion des produits en utilisant Hibernate comme framework de persistance et MySQL comme système de gestion de base de données. L'application permet de réaliser des opérations CRUD (Create, Read, Update, Delete) sur les produits.

## Prérequis

- JDK 8 ou supérieur
- NetBeans IDE
- MySQL Server
- Hibernate ORM
- MySQL Connector/J

## Structure du projet

Le projet est organisé en plusieurs packages :

- `ma.projet.entity` : Contient la classe entité `Produit`
- `ma.projet.config` : Contient le fichier de configuration Hibernate
- `ma.projet.util` : Contient la classe utilitaire `HibernateUtil`
- `ma.projet.dao` : Contient l'interface `IDao`
- `ma.projet.service` : Contient la classe service `ProduitService`

## Configuration

1. Créez une base de données nommée "H1" dans MySQL.
2. Configurez le fichier `hibernate.cfg.xml` dans le package `ma.projet.config` avec les informations de connexion à votre base de données.

## Fonctionnalités

- Création de produits
- Affichage de la liste des produits
- Affichage des informations d'un produit spécifique
- Suppression d'un produit
- Modification des informations d'un produit
- Affichage des produits dont le prix est supérieur à un seuil
- Affichage des produits commandés entre deux dates

## Installation et exécution

1. Clonez ce dépôt Git.
2. Ouvrez le projet dans NetBeans.
3. Assurez-vous que toutes les dépendances (Hibernate et MySQL Connector) sont correctement configurées.
4. Exécutez le fichier de test principal pour tester les fonctionnalités.

## Tests

Dans la classe de test, vous pouvez :

1. Créer cinq produits
2. Afficher la liste des produits
3. Afficher les informations du produit avec id = 2
4. Supprimer le produit avec id = 3
5. Modifier les informations du produit avec id = 1
6. Afficher la liste des produits dont le prix est supérieur à 100 DH
7. Afficher la liste des produits commandés entre deux dates (saisies au clavier)
