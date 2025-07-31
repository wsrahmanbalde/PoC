# 💬 PoC - Chat Temps Réel (Angular 19 + Spring Boot + PostgreSQL)

Ce projet est un **Proof of Concept (PoC)** pour un système de **chat en temps réel** entre un **Client** et un **Agent**, utilisant :

- 🧠 **Angular 19** (Frontend standalone)
- ⚙️ **Spring Boot 3+** (Backend WebSocket avec STOMP & SockJS)
- 🛢️ **PostgreSQL** (Base de données pour persister les messages)

---

## 🧪 Objectif

Valider la **faisabilité technique** d’un système de messagerie instantanée, avec synchronisation des messages en temps réel, sans rechargement de page. Le PoC permet de simuler une conversation instantanée entre deux utilisateurs (client et agent) via deux fenêtres ou navigateurs différents.

---

## 📦 Technologies utilisées

| Couche          | Technologie               |
|-----------------|---------------------------|
| Frontend        | Angular 19 (standalone)   |
| Backend         | Spring Boot 3             |
| Communication   | WebSocket (STOMP + SockJS)|
| Base de données | PostgreSQL                |
| Transport       | REST + WebSocket          |

---

## 🛠️ Prérequis

Avant de commencer, assurez-vous d’avoir :

- ✅ Node.js ≥ 18
- ✅ npm ≥ 9
- ✅ Angular CLI ≥ 16
- ✅ Java ≥ 17
- ✅ PostgreSQL (avec un schéma configuré)
- ✅ Backend configuré avec STOMP + SockJS

---

## ⚙️ Installation

### 🔁 Cloner le projet

```bash
git clone https://github.com/wsrahmanbalde/scriptSQL.git
cd PoC

### 📦 Installer les dépendances
🛠️ Installation et lancement

### 📦 Backend - Spring Boot
	1.	Se rendre dans le dossier backend :
```bash
cd chat-backend

	2.	S’assurer que votre base de données PostgreSQL est accessible et que les informations sont bien configurées dans application.properties ou application.yml.
	3.	Démarrer le backend : ./mvnw spring-boot:run

Cela démarre l’API REST + WebSocket à l’adresse : http://localhost:8080
Le WebSocket est accessible à : ws://localhost:8080/ws

### 💻 Frontend - Angular 19
	1.	Aller dans le dossier chat-frontend : ```bash cd chat-frontend
	2.	Installer les dépendances : npm install
	3.	Lancer l’application Angular : npm start
L’interface est disponible à : http://localhost:4200

🧪 Tester le PoC
	1.	Ouvrir deux fenêtres de navigateur (ou deux navigateurs différents).
	2.	Dans chaque fenêtre, entrez un nom d’utilisateur unique (ex : ClientUser et AgentUser) lorsqu’on vous le demande.
	3.	Écrivez un message dans une fenêtre, cliquez sur “Envoyer”.
	4.	Le message s’affiche en temps réel dans les deux interfaces, sans rechargement.

Ainsi, vous pouvez simuler une conversation entre deux utilisateurs (Client et Agent).




