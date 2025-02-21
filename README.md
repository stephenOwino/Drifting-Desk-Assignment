Drifting-Desk-Assignment

Spring Boot + Kafka + Docker + Kubernetes Assignment
Project Overview
This project demonstrates a simple message processing system built using Spring Boot, Kafka, Docker, and Kubernetes. It exposes a REST API to send messages, publishes messages to a Kafka topic, consumes messages from the topic, and logs them.

Installation
Prerequisites
Docker
Docker Compose
Kubernetes (Minikube, Docker Desktop, or a cloud provider)
kubectl


## Table of Contents
- [Project Overview](#project-overview)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

### Steps
1. **Clone the Repository**:
   ```sh
   git clone https://github.com/stephenOwino/Drifting-Desk-Assignment.git
   cd Drifting-Desk-Assignment


docker build -t my-app .
docker build -t my-kafka-image -f Dockerfile.kafka .

##Start Kubernetes Cluster: If using Minikube:
minikube start

##Set up Kubernetes resources: You will need to create the necessary Kubernetes resources like pods, deployments, and services. Here's how you can apply the deployment and service files:

kubectl apply -f k8s-deployment.yaml
kubectl apply -f k8s-service.yaml


Set up Ingress (optional, if you want to use Ingress for routing): using an Ingress resource, apply the ingress file:

kubectl apply -f ingress.yaml

##Check Running Pods: To verify that your pods are running correctly:
kubectl get pods
