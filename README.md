#📚 Study Tracker (Java Swing Application)

  - A Java Swing-based desktop application designed to help students track study progress, manage tasks, and maintain productivity.
  - Enables users to record, organize, and analyze daily study activities through an interactive graphical interface.
  - Allows structured logging of study sessions with subject, duration, and description for effective tracking and review.
  - Provides summarized insights by analyzing study time across different subjects and dates.
  - Demonstrates practical implementation of object-oriented programming, event-driven design, and data handling concepts.
  - Built as a simple and efficient productivity tool to improve consistency and monitor study patterns over time.

## Overview
The system allows users to input study details such as subject, duration, and description, which are automatically tagged with the current date. All records are displayed in a tabular format, making it easy to track and review study activities. Additionally, the application processes stored data to generate summaries that help users understand their study distribution across different subjects and dates.

## Key Features
- Add study logs with subject, duration, and description
- Automatically captures the current date for each entry
- Displays all records in a structured tabular format
- Generates summaries:
  - Total study hours grouped by date
  - Total study hours grouped by subject
- Export all study records to a CSV file
- Clean and responsive GUI built using Java Swing components

## 🛠 Technologies Used
- **Java**
- **Java Swing**
- **File Handling** for data persistence

## Project Structure

├── StudyLog.java              Handles data representation of each study entry  
├── StudyTrackerGUI.java      Implements GUI and core functionality  
├── StudyTrackerGUImain.java  Application entry point  

## Working Principle
The application stores study logs in an ArrayList, allowing dynamic addition of records during runtime. Data is processed using TreeMap to generate sorted summaries based on date and subject. The GUI interacts with the underlying data structures to display and update information in real time.

## Compilation and Execution

Compile using wildcard:
javac *.java

OR compile by specifying all files:
javac StudyLog.java StudyTrackerGUI.java StudyTrackerGUImain.java

Run the application:
java StudyTrackerGUImain

## Concepts and Technologies Used
- Java Programming Language
- Object-Oriented Programming (Encapsulation, Class Design)
- Java Swing for GUI development
- Event Handling (ActionListeners)
- Java Collections Framework (ArrayList, TreeMap)
- File Handling (CSV export using FileWriter)

## Use Cases
- Tracking daily study sessions and productivity
- Analyzing time distribution across different subjects
- Maintaining a structured academic log
- Useful for students, learners, and self-study planning

## Future Enhancements
- Add database support for permanent storage
- Implement login and user profiles
- Add graphical analytics (charts for study trends)
- Enable editing and deleting of existing records

## Author
Varad Muley  
