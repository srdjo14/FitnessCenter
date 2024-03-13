# Fitness Center
Fitness Center Management System
## Table of Contents

1. [Introduction](#i-introduction)
2. [Project Overview](#ii-project-overview)
3. [Features](#iii-features)
4. [Functionalities](#iv-functionalities)
5. [Implementation](#v-implementation)
6. [How To Use](#vi-how-to-use)

## 1. Introduction
This project is a web-based fitness center management system that provides a platform for fitness center administrators, trainers, and members to streamline various aspects of fitness center operations.

## 2. Project Overview
The system includes features for user authentication, member and trainer management, class scheduling, and more. It leverages a robust data model to capture essential information about members, trainers, fitness centers, classes, and facilities.

## 3. Features
User Authentication:

Different roles: Administrator, Trainer, Fitness Center Member.
User registration and login with role-based access.
Member Management:

Track member profiles, attendance, and ratings.
Member sign-ups for classes and class attendance tracking.
Trainer Management:

Trainer profiles with average ratings.
Class scheduling and management by trainers.
Fitness Center Management:

Add, edit, and delete fitness centers.
Manage fitness center facilities and class schedules.
Class Scheduling:

Create, modify, and delete fitness classes.
Schedule classes with dates, times, and pricing.
Data Model:

Entities include Users, Members, Trainers, Fitness Centers, Classes, and more.

## 4. Functionalities
The system provides various functionalities based on user roles:

All Users:

Registration, login, and viewing available classes.
Advanced search and sorting options for classes.
Fitness Center Members:

Sign up for classes, view, and cancel class registrations.
View personal profile, completed classes, and ratings.
Trainers:

Create and edit class schedules.
View average ratings and manage classes.
Administrators:

Manage fitness centers, including adding/deleting.
Approve trainer registrations and manage trainers.

## 5. Implementation
The application is implemented as a client-server application. The server side is developed using the Java programming language and the SpringBoot framework.

## 6. Setup Instructions
To set up and run the application locally, follow these instructions:

Clone the repository: git clone git@github.com:srdjop/FitnessCenter.git
Navigate to the project directory: cd FitnessCenter
