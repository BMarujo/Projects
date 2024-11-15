## TastyBite

### Introduction:

In today's fast-paced world, convenience and efficiency are paramount, especially when it comes to ordering food. Recognizing this need, we developed TastyBite, a user-friendly mobile application designed to simplify the food ordering experience. 

TastyBite provides users with a seamless platform to order food, track deliveries with a dynamic order status update, make payments, and talk with the drivers, all within a single interface. 

Our primary goal with TastyBite was to enhance the overall user experience, making it easier and more enjoyable for customers to order food from our food chain, and set ourselves apart from other food delivery applications.


### Features implemented:

- **Authentication (Login, Sign Up):** 
  - Users can create an account or log in using their email and password. 
  - Passwords are securely stored in Firebase Authentication, ensuring the confidentiality of user data by providing a seamless and reliable method for users to access the app's functionalities while maintaining the highest standards of security and privacy.

- **Live Messaging Service:**
    - Users can communicate with the driver in real-time through a chat interface.
    - Firestore Database is employed to store and manage message data, ensuring seamless communication.
    - Upon initiating a conversation with a driver, users can send and receive messages instantly, fostering efficient communication. The app dynamically updates the chat interface as new messages are sent or received, enabling users to stay informed and engaged throughout their interaction with the driver. Messages are displayed in a chat bubble format, providing a user-friendly interface for viewing conversations.

- **Camera and File System Access to change profile picture:**
    - Users can take a picture using the device's camera or upload an image from their device to set as their profile picture which enhances user engagement and personalization.
    - Images are stored in Firebase Storage. The profile picture URL is stored in Firestore associated with the user's document.

- **Push Notifications:**
    - Users receive notifications when their order begins processing. 

- **Tracking Page with Dynamic Order Status Update:**
    - Users can track the status of their order in real-time.
    - The status is updated dynamically using a timer-based mechanism.

- **GPS and Geocoding:**
    - The application uses GPS to determine the user's location.
    - Geocoding is used to convert the user's location into an address.

### Firebase Features:

- **Firestore Database:**
    - Stores user information, orders, and messages.
    - Provides real-time updates to the application.

- **Firebase Authentication:**
    - Provides secure authentication using email and password.
    - Passwords are securely stored and encrypted within Firebase Authentication.

- **Firebase Storage:**
    - Stores profile pictures uploaded by users.
    - Provides a secure and scalable solution for storing images.

### Git Repository: 
[GitHub](https://github.com/BMarujo/TastyBite)

### Contributions:

- **Bernardo Marujo 107322:** 50%
- **Henrique Coelho 108342:** 50%