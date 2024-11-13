# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

RUN apt-get update && apt-get install -y \
    xvfb \
    && rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . .

# Compile the Java source file
RUN javac bstproject/*.java

# Command to run the application
CMD ["java", "bstproject.TestBinaryTree"]
