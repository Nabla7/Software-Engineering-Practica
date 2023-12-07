### 1. Extract Method

- **What It Does & Goal**: 
  - The Extract Method involves identifying a code fragment that can be grouped together, moving it to a new method, and replacing the old code with a call to this method. The goal is to enhance readability and organization of the code.

- **When to Use & Symptoms in the Code**: 
  - Use when a method is too long or when a code fragment can stand on its own. Symptoms include long methods or code blocks doing more than one thing.

- **Benefits**: 
  - Increases readability, reduces code duplication, and isolates independent parts of code, reducing error likelihood.

- **How to Apply**: 
  - Create a new method named for its purpose. Move the relevant code fragment to this method. Adjust variables and replace the old code with a call to the new method.

### 2. Move Behaviour Close to the Data

- **What It Does & Goal**: 
  - This technique involves moving a method to a class where most of the data used by the method is located. The goal is to enhance class coherence and encapsulation.

- **When to Use & Symptoms in the Code**: 
  - Applied when a method relates more to data in another class than in its own. Symptoms include methods heavily interacting with data from another class.

- **Benefits**: 
  - Increases internal class coherence, reduces dependencies between classes, and improves encapsulation.

- **How to Apply**: 
  - Identify features used by the method in its class and consider moving them. Ensure no conflicts with superclasses or subclasses. Create the method in the recipient class, adjust references, and possibly delete the old method.

### 3. Encapsulate Field

- **What It Does & Goal**: 
  - Encapsulate Field involves changing a public field to private and providing access methods (getters/setters). The goal is to protect object data and adhere to encapsulation principles in object-oriented programming.

- **When to Use & Symptoms in the Code**: 
  - Use when you have a public field that should be restricted for direct access. Symptom is the presence of public fields which can be manipulated without control.

- **Benefits**: 
  - Improves maintenance and development, allows complex operations related to field access, and strengthens encapsulation.

- **How to Apply**: 
  - Create getter and setter methods for the field. Replace direct field access with these methods, then make the field private.

### 4. Replace Conditional with Polymorphism

- **What It Does & Goal**: 
  - This technique involves replacing conditionals that depend on an object's type or properties with polymorphism. The goal is to streamline code by using object-oriented principles.

- **When to Use & Symptoms in the Code**: 
  - Applicable when conditionals perform actions based on object types or properties. Symptoms include complex conditionals checking the class or properties of objects.

- **Benefits**: 
  - Adheres to the Tell-Don’t-Ask principle, removes duplicate code, and facilitates adding new variants without modifying existing code (Open/Closed Principle).

- **How to Apply**: 
  - Create a class hierarchy if needed. For each subclass, redefine the method containing the conditional with the relevant branch code. Replace the conditional with a call to this method and declare the method abstract.

