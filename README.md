# Hotel Booking Simulation in Java

## Overview

This Java application simulates the operation of a hotel, allowing you to manage hotel floors, rooms, and client bookings. It's designed to demonstrate a simple hotel management system with the following features:

- Creating a hotel with multiple floors and rooms.
- Booking rooms for clients.
- Checking clients in and out of rooms.
- Managing room availability.
- Simulating hotel operations over several days.

## Table of Contents

- [Getting Started](#getting-started)
- [How to Use](#how-to-use)
- [Code Structure](#code-structure)

## Getting Started

### Prerequisites

Before running the simulation, make sure you have the following installed:

- Java Development Kit (JDK)
- An Integrated Development Environment (IDE) like Eclipse or IntelliJ (optional but recommended)

### Installation

1. Clone or download this repository to your local machine.

2. Open the project in your preferred Java IDE (Eclipse, IntelliJ, etc.).

3. Build and run the `HotelSimulation` class to start the simulation.

## How to Use

1. The simulation will start, and you'll see the hotel's daily operations displayed in the console.

2. Clients will check in and out of rooms, and the program will manage room availability.

3. The simulation will run for a predefined number of days (as set in the `main` method).

4. Review the console output to see the progress of the simulation.

## Code Structure

- **`HotelSimulation`**: The main class containing the `main` method to run the simulation.

- **`Client`**: Represents a hotel client. Generates random client information and decides booking details.

- **`Floor`**: Represents a hotel floor with multiple rooms. Handles room setup, availability, and operations.

- **`Hotel`**: Represents the hotel and its floors. Manages room booking and occupancy.

- **`Room`**: Represents a hotel room. Handles room booking, check-in, and check-out.
