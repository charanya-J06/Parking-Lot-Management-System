# Parking Lot Management System (Java)

## 📌 Overview
The **Parking Lot Management System** is a console-based Java application that simulates real-world parking lot operations.  
It manages vehicle parking and exit, prevents duplicate vehicle entries, dynamically allocates parking spots, calculates parking fees, and processes payments using clean object-oriented design and well-known design patterns.

This project focuses on **correctness, scalability, and maintainability**, making it suitable for academic evaluation, internships, and entry-level software engineering roles.

---

## 🚀 Features
- Supports multiple vehicle types (Car, Bike)
- Dynamic configuration of parking spots (no hardcoded limits)
- Prevents duplicate vehicle number plate entries
- Ensures occupied parking spots cannot be reused
- Tracks real-time parking status
- Parking fee calculation based on duration
- Multiple payment methods (Cash, Card)
- Menu-driven console interaction
- Graceful handling of invalid user input

---

## 🧠 Design & Architecture

### Object-Oriented Principles
- **Abstraction** – Abstract base classes for `Vehicle` and `ParkingSpot`
- **Inheritance** – Specialized implementations (`Car`, `Bike`, `CarParkingSpot`, `BikeParkingSpot`)
- **Polymorphism** – Unified handling of different vehicle and spot types
- **Encapsulation** – Controlled access to parking state and vehicle data

---

### Design Patterns Used
- **Factory Pattern**  
  Used to create vehicle objects (`VehicleFactory`) without exposing instantiation logic.

- **Strategy Pattern**  
  Used for:
  - Parking fee calculation (`ParkingFeeStrategy`)
  - Payment processing (`PaymentStrategy`)

These patterns improve extensibility and reduce coupling between components.

---

## 📂 Project Structure
```
parkinglot/
├── ParkingLotSystem.java # Main entry point (menu-driven)
├── ParkingLot.java # Core parking logic and tracking
├── ParkingSpot.java # Abstract parking spot
├── CarParkingSpot.java
├── BikeParkingSpot.java
├── Vehicle.java # Abstract vehicle
├── Car.java
├── Bike.java
├── VehicleFactory.java # Factory pattern implementation
├── VehicleType.java # Enum
├── DurationType.java # Enum
├── ParkingFeeStrategy.java # Strategy interface
├── BasicHourlyRate.java
├── PaymentStrategy.java
├── CashPayment.java
├── CardPayment.java

```
---

## ⚙️ How the System Works
1. User configures the number of car and bike parking spots.
2. Vehicles are parked only if a compatible and free spot is available.
3. Duplicate vehicle number plates are rejected.
4. On vehicle exit:
   - Parking duration is captured
   - Fee is calculated using a pricing strategy
   - Payment is processed using the selected method
5. Parking status can be viewed at any time.

---

## ▶️ How to Run the Project

### Compile
```bash
javac parkinglot/*.java
```
### Run
```bash
java parkinglot.ParkingLotSystem
```
---
## 📊 Sample Menu

1. Park Vehicle
2. Exit Vehicle
3. Show Status
4. Exit System

---

## 📈 Metrics & Technical Highlights

- 100% prevention of duplicate vehicle entries
- O(1) vehicle lookup using HashMap-based tracking
- O(N) worst-case parking spot allocation
- Dynamically scales to N parking spots without code changes
- Modular design across 10+ Java classes

---

## ⚠️ Assumptions & Constraints

- Vehicle numbers are alphanumeric (e.g., AP09CA1234)
- One vehicle occupies one parking spot
- Parking is type-specific (Car ↔ Car Spot, Bike ↔ Bike Spot)
- Designed as a single-user console application (no concurrency handling)

---

## 🔮 Possible Enhancements

- Multi-floor parking support
- Premium or dynamic pricing strategies
- Entry/exit time-based billing
- Database integration for persistence
- REST API or web-based interface
- Concurrent access handling

---

## 🎓 Learning Outcomes

- Practical application of Object-Oriented Programming (OOP) principles
- Hands-on experience with Factory and Strategy design patterns
- Understanding real-world system design constraints
- Writing clean, maintainable, and scalable Java code
