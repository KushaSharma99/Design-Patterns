# Design-Patterns
This project is designed to manage characters in a game environment, focusing on operations like attacking, using skills, healing, and leveling up. It includes a set of classes and tests to ensure the system behaves as expected. The project employs the Decorator and Factory design patterns to enhance object functionality and manage object creation, respectively, providing a flexible and scalable approach to character management.

## Features
Character Operations: Supports basic character operations such as attack, use skills, heal, and take damage.
Leveling System: Characters can level up, which affects their health, mana, and other attributes.
Item Management: Characters can interact with items (e.g., swords) that influence the game's dynamics, like dealing damage or healing.
Character Decorator: Enhances character functionality dynamically by adding new behaviors without altering the existing character classes directly.
Test Suite: Includes unit tests to verify the functionality of characters and items, ensuring that operations like healing and leveling up work as intended.

## Design Pattern

The RPG simulation uses several design patterns to enhance the functionality and maintain modularity:

- Decorator Pattern: It is utilized in the CharacterDecorator class, allowing for the dynamic extension of character functionalities. This pattern enables adding responsibilities to objects at runtime without modifying their structure.
  
- Factory Pattern: Employed to create a new character or trainer in the game. Also, managing item creation, particularly if multiple item types have different effects. The Factory Pattern would simplify object creation, allowing the game to instantiate items based on type or characteristics without coupling the creation logic directly to the game's main flow.

## Getting Started

1. Clone the repo to the local machine.
2. Install the required dependencies listed.
3. Build and compile the application.
4. Run the file by gradle run command in the terminal.

## Acknowledgement

This project is given to us by our Professor in class SER316 Spring A 2024 at ASU.
