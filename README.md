# Checkout Form - Mediator Pattern 🛒

A dynamic desktop application built with **Java and JavaFX** to demonstrate the **Mediator design pattern**. This project was developed as part of a Software Engineering course on Object-Oriented Design.

## Project Overview

This project implements a central **Mediator**. 
Instead of UI elements communicating directly with each other, they notify the Mediator of any state changes. The Mediator then applies the business rules and updates the relevant components accordingly.

## Features & Dynamic Rules

The application simulates a delivery payment form with strict interaction rules managed seamlessly by the Mediator:

* **Dynamic Payment Methods:**
  * Selecting **Credit Card** reveals credit card input fields (Number, Expiry, CVV) and hides Gift Card fields.
  * Selecting **Gift Card** reveals the Gift Card number field and hides Credit Card fields.
  * Selecting **Pay on Delivery** hides all payment-specific fields.
* **Conditional Delivery Options:** * If "Pay on Delivery" is selected, the "Leave at door" delivery option is automatically disabled.
* **Address Synchronization:**
  * Checking the "Use same address for billing and delivery" option disables the billing address text field and forces it to perfectly mirror the delivery address in real-time.

## Architecture: The Mediator Pattern

* **Mediator (The Hub):** Contains the central logic. It listens to the UI components and decides what should be enabled, disabled, hidden, or updated.
* **Colleagues (The UI Components):** The text fields, checkboxes, and radio buttons. They only know about the Mediator. They do not know about each other, ensuring low coupling and high cohesion.

## Getting Started

### Prerequisites
* Java JDK 8 or higher
* JavaFX SDK 

### How to Run
1. Clone this repository:
   ```bash
   git clone [https://github.com/YourUsername/java-mediator-checkout-form.git](https://github.com/YourUsername/java-mediator-checkout-form.git)
