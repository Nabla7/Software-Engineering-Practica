# Refractoring

## Core/Clients/Clients.java
Encapsulate field: made m_clients and m_all_clients private. Getters and setters were already put in place.

## Move login function from Core/System.java to Core/Clients/Clients.java
Move Behaviour Close to the Data: It makes more sense to have the Clients class store which clients are logged in.