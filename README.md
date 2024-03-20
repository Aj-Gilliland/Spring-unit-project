# Spring-unit-project

## Talkify Api

### **DESCRIPTION**
The purpose of Talkify Api is to provide a secure, cloud-based solution for message storage, offering enhanced security over local services.

### **KEY FEATURES**

#### Set up dependent:
- Store User History
- View Messages
- View all Chat Rooms
- Delete Messages
- Delete Chat Rooms
- Make Chat Rooms

#### User:
- Make Messages
- Reply Messages
- Delete User
- Make User

#### Admin:
- view all users

### **Inspiration**
Inspired by Slack and the need for secure easy to use, plug and play, organizational chat systems.

### **Quick start (for Intellij)**
Running the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### **Structure**
Developers first need to choose a structure on how they plan on setting up the messageing system. You can choose to make the admin manage everything from user creation to chat room assignment like slack, or have  a more relaxed method of allowing users to set up who they would like to chat with. From there you'll be able to decide how users, messages, and chatrooms are made/viewed/deleted and assigned with their respective endpoints. We reccomend when setting up to run a check and loop through people who are in the chat room for display and security.

### **ENDPOINT EXAMPLES**

VIEW ALL MESSSAGES
```GET http://localhost:8080/messages/getAll```

MAKE MESSAGE
```
POST http://localhost:8080/messages
Content-Type: application/json

{
  "content": "Hello, World!",
  "postDate": "2024-03-16"
}
```

ADD MESSAGE TO USER'S MESSAGE HISTORY
| PATH VARS {{messageId}}/{{userId}}
```PUT http://localhost:8080/messages/addMessageToUser/1/1```

ADD A REPLY TO A MESSAGE
| PATH VARS {{messageId}}/{{replyId}}
```PUT http://localhost:8080/messages/addReply/1/2```

VIEW ALL USERS
```GET http://localhost:8080/user/getAll```

MAKE USER
```
POST http://localhost:8080/user
Content-Type: application/json

{
  "fName": "Jane",
  "lName": "Doe",
  "email": "janedoe@example.com",
  "admin": false
}
```

ADD USER TO CHAT ROOM AND A CHATROOM TO USER
| PATH VARS {{userId}}/{{chatroomId}}
```PUT http://localhost:8080/user/addUserToChatroom/1/1```

VIEW ALL CHATROOMS
```GET http://localhost:8080/chatrooms/getAll```

MAKE A CHATROOM
```
POST http://localhost:8080/chatrooms
Content-Type: application/json

{
  "name": "General Discussion"
}
```

ADD A MESSAGE TO A CHATROOM (conversation)
| PATH VARS {{chatroomId}}/{{messageId}}
```PUT http://localhost:8080/chatrooms/addConversation/1/1```



### **LICENSE**
&copy; copyleft
