
# Expense-Tracker_API
> This is an Expense Tracker API project developed using Java Spring Boot MVC. The API allows users to track their expenses, manage products, generate reports, and perform various operations related to expense management.
---
## Frameworks and Languages
The Instagram backend project is developed using the following frameworks and languages:

* **Spring Boot:** A Java-based framework for building web applications.
* **Spring MVC:** A module of the Spring Framework that supports building web applications.
* **Java:** The programming language used for backend development.
* **Hibernate:** An Object-Relational Mapping (ORM) framework used for database interactions.
* **MySQL:** The chosen database management system.
---
## Data flow
The project follows a standard Spring Boot MVC structure and consists of the following components:

* **Controller:** Contains the API endpoints and request mappings.
* **Service:** Implements business logic and interacts with the repository.
* **Repository:** Handles data access to the MySQL database.
* **DTO (Data Transfer Object):** Represents the data structure exchanged between the API and the client.
* **Model:** Represents the data model(entity) mapped to the MySQL database.
---
### Validation
The API uses annotation-based validation to ensure data integrity and proper formatting.

---
## Project Structure
* **User authentication:** Users must register and sign in to use the API.
* **Expense Management:** Users can create, read, update, and delete expenses.
* **Product Details:**
    * Title
    * Description
    * Price
    * Date
    * Time
    * User ID (related to the user who created the expense(foreign key))
* API to fetch products for a particular date and time.
* API to generate the total expenditure for a given month.
* **Data Storage:** MySQL database is used to store expense records.
* **Static Deployment:** The API is deployed with a static IP address.
---
## Deployment
* The application is deployed with a static IP address.
* MySQL database is used to store expense records, and the connection details are configured in the application properties.
---
## Project Summary
The Expense Tracker API project developed using Java Spring Boot MVC is a powerful tool that allows users to efficiently track their expenses. The API provides various features such as user authentication, expense management (create, read, update, delete), product details, fetching products for a specific date and time, and generating expenditure reports for a given month. The project follows best practices by using annotation-based validation, separating concerns into controller, service, and repository layers, and storing data in a MySQL database.

---
## Conclusion
> The Expense Tracker API can serve as a solid foundation for building an expense-tracking application and can be extended with more advanced features based on specific business requirements. By leveraging the capabilities of Spring Boot and the flexibility of Java, developers can create a reliable and user-friendly platform for managing expenses efficiently.
---
