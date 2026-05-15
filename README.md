# Carrefour Java Kata

Monorepo avec backend en architecture hexagonale (2 microservices: `product-service` et `order-service`) et frontend Angular 18 en architecture feature-based modulaire.

## Stack
- Java 25 (code compatible Java moderne)
- Spring Boot 3.x
- JUnit 5
- Angular 18 (structure modulaire)

## Backend

### product-service
Responsabilités:
- Gérer l'inventaire produits
- Exposer consultation produits
- Réserver/libérer du stock

### order-service
Responsabilités:
- Ajouter/supprimer produits dans panier
- Confirmer commande
- Suivre statut commande
- Annuler commande sous 1h

Le flux de stock est mis à jour via un `ProductGateway` (port sortant) branché ici en mémoire.

## Frontend Angular
Modules fonctionnels:
- `features/products`
- `features/cart`
- `features/orders`

Modules transverses:
- `core` (auth, guards, interceptors, services, models)
- `shared`

Routage lazy-loading entre features.

## Lancement

Exemple backend (depuis chaque microservice):
```bash
./mvnw test
./mvnw spring-boot:run
```

Exemple frontend:
```bash
npm install
ng serve
ng test
```

## Choix fonctionnels
- Un panier est lié à un client (`customerId`).
- L’ajout panier réserve immédiatement le stock.
- La suppression panier libère le stock.
- La confirmation transforme le panier en commande `CONFIRMED`.
- L’annulation est autorisée uniquement dans l’heure suivant la confirmation.
