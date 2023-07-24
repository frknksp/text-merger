
# Text Merger Project

This project includes an algorithm developed for merging texts and an application that merges texts and stores the results in a database. The backend is developed in Java, and it interacts with the MongoDB database using HTTP client-side. Additionally, there is a simple web interface where users can enter texts and view the merged results.

## Features

- Users can merge texts by entering them into the system.
- Merged texts along with performance features (elapsed time) are saved and can be viewed later.
- Users can list the merged texts stored in the database.

## Technologies Used

- Java: Used for backend operations and the text merging algorithm.
- Spring Boot: Utilized to develop the Java-based application quickly and easily.
- MongoDB: Data is stored in the NoSQL MongoDB database.
- HTML/CSS/JavaScript: Used for the basic web interface.
- Axios: HTTP client library for communicating with the backend.

## Project Structure

- `com.example.TextService`: Package containing Java backend code.
  - `TextMerger`: Class containing the text merging algorithm.
  - `TextService`: Service class for saving and listing texts in the database.
  - `TextController`: Controller class for interacting with the HTTP client.
  - `model`: Data model classes.
  - `repository`: Repository class for MongoDB database operations.
- `style.css`: CSS file for the web interface.
- `index.html`: Main page of the web interface.
- `script.js`: JavaScript code used in the web interface.

## Installation and Usage

1. Clone this project from GitHub or download it as a ZIP file.
2. Open the project in a Java IDE (e.g., IntelliJ IDEA or Eclipse).
3. Set up your MongoDB database and configure connection settings in `application.properties`.
4. Run the backend and view the application at `http://localhost:8080`.
5. Enter texts, merge them, and save if desired.

## Screenshots

![Interface]([screenshot.png](https://github.com/frknksp/text-merger/blob/main/sstextmerger.png?raw=true)https://github.com/frknksp/text-merger/blob/main/sstextmerger.png?raw=true)
![alt text](https://github.com/frknksp/text-merger/blob/main/sstextmerger.png?raw=true)

