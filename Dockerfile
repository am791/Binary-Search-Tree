# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY ./bstproject .

# Compile the Java source file
RUN javac *.java

# Command to run the application
CMD ["java", "TestBinaryTree"]
