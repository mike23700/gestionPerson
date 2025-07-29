# Person Management Web Application (Java EE)

This is a basic Java EE web application designed to manage a list of people (`Personne`). The application allows users to **add**, **display**, **search**, and **delete** individuals from a MySQL database.

> ⚠️ This project is currently in its initial stage and mainly serves educational or test purposes.

## 🛠️ Technologies Used

- **Java EE (Servlets)**
- **JSP**
- **JDBC (Java Database Connectivity)**
- **Apache Tomcat (or compatible application server)**
- **MySQL**
- **Maven**

## 🧾 Features

- Add a new person with `nom` and `prenom`.
- Display all registered persons.
- Search for a person by `nom`.
- Delete a person by `nom`.

## 🗄️ Database Requirements

Ensure that **MySQL Server** is installed and running on your machine.

### Database Setup

Create the database and the required table using the following SQL commands:

```sql
CREATE DATABASE IF NOT EXISTS personne;

USE personne;

CREATE TABLE IF NOT EXISTS person (
    nom VARCHAR(100) PRIMARY KEY UNIQUE,
    prenom VARCHAR(100) NOT NULL
);
```

> Make sure your MySQL credentials and JDBC connection string are correctly configured in your Java code (typically in `AccessDB.java` or similar class).

```

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/mike23700/personne-management.git
   ```

2. Import the project into your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

3. Configure your MySQL connection settings.

4. Deploy the application on Tomcat or any Java EE compatible server.

5. Access the application via:
   ```
   http://localhost:8080/tp1/person
   http://localhost:8080/tp1/gestion
   ```

## 📌 Notes

- The project currently assumes a local MySQL setup with default port `3306`.
- `nom` is used as both the **primary key** and a **unique identifier** for each person.
- More features can be added in the future such as pagination, editing, authentication, etc.

## 📄 License

This project is open-source and free to use for educational purposes.

---

Feel free to adapt and extend this project to fit your needs!
