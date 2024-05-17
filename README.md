Enviro365 Waste Sorting Mobile Application
Introduction
Enviro365, a leading environmental solutions company, is developing a waste sorting mobile application aimed at promoting sustainable waste management practices.
The application serves as an educational tool for individuals and communities, providing guidance on proper waste disposal techniques and encouraging recycling habits.

As a recent graduate developer at Enviro365, I've been tasked with implementing REST endpoints to enable communication between the frontend and backend systems of the application.

Project Overview
Objective
The objective of this project is to design and implement REST endpoints using Spring Boot that facilitate data exchange between the frontend mobile application and the backend server.

Features
Waste Category Lookup: Retrieve information about different waste categories.
Disposal Guidelines Retrieval: Retrieve disposal guidelines for different waste categories.
Recycling Tips Display: Display recycling tips to promote environmentally conscious decisions.

Technologies Used
Spring Boot
RESTful APIs
JSON formatting

API Endpoints

Waste Categories
GET /api/waste-categories: Retrieve a list of waste categories.
POST /api/waste-categories: Create a new waste category.
GET /api/waste-categories/{id}: Retrieve details of a specific waste category.
PUT /api/waste-categories/{id}: Update details of a specific waste category.
DELETE /api/waste-categories/{id}: Delete a waste category.

Disposal Guidelines
GET /api/disposal-guidelines: Retrieve disposal guidelines for all waste categories.
POST /api/disposal-guidelines: Create a new guideline.
GET /api/disposal-guidelines/{id}: Retrieve details of a specific guideline.
PUT /api/disposal-guidelines/{id}: Update details of a specific guideline.
DELETE /api/disposal-guidelines/{id}: Delete a guideliney.

Recycling Tips
GET /api/recycling-tips: Retrieve recycling tips.
POST /api/recycling-tips: Create a new recycling tip.
GET /api/recycling-tips/{id}: Retrieve details of a specific recycling tip.
PUT /api/recycling-tips/{id}: Update details of a specific recycling tip.
DELETE /api/recycling-tips/{id}: Delete a recycling tip.

Error Handling
Error handling mechanisms are in place to provide meaningful error messages and appropriate HTTP status codes in response to invalid requests or server errors.

Contributors
Siyanda Cele

