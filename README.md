PRESENTATION SLIDESHOW LINK: https://docs.google.com/presentation/d/1XN3rOhqg0ClOlGjq0Nb9WZg8lnwxaB2-0TjlpN8tNbk/edit?usp=sharing

MILESTONE 4/5 PULL REQUEST EXPLANATIONS 

ISABEL
1. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/26
Created and added new tests for the User class. Tested if the methods called the appropriate variables and returned the proper objects.

2. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/22
This is a more recent pull request, however, I believe my review was significant as I ensured that our group's code is staying consistent throughout 
everyone's parts. This is in terms of method/function names. As well, I asked for reviews on code written based on what the group had previously 
discussed. This is to ensure we are all on the same page with the design of the application and that our logic is clear so there is no confusion. 

NIVEDHA

1. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/20
- most recent pull request with the most complete version of the Chatroom entity class. 
- Included code that allows every created Chatroom to be stored in Storage 
- Included a method to allow every new message sent to also be stored in the Chatroom's message storage and updates the Chatroom data in Storage

2. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/8
- first push to Chatroom class
- defined the integral structure of the Chatroom entity that would early on act as the basis for other entities and interfaces to be implemented

https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/22
- comment and approval under files changed related to UI implementing a way for a Chatroom to be hidden once number of users becomes 0 and clarifications 
regarding the structure of the Chatroom class

JEFF
1. 
2.

SAM
1. I have made the pull request https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/29. I was mainly responsible for implementing the Login System which includes the registration page and the login page. I was also responsible for implementing the private and public profile pages. The user interfaces for the login system and the profile pages all work. All of the UI's have their own controller and use case classes that help with processing numerous actions such a button press or creating an account. These classes mainly worked with the User entity class to modify/update user data (used in the private and public profiles) and the storage class to save user login info when creating an account, checking whether the information matches when logging in, and saving user data when updating the user profile. 

I have also created the tests for each of the pages. However, when it came to testing the user interfaces directly, I had some challenges and instead I decided to test the main functionalities such testing whether the new account is saved in storage when a user registers an account. Testing other functionalities include checking whether the username and password match by comparing it with the data saved in storage. Checking whether the updates have been stored when modifying the public/private profile pages. Checking whether the user data is retained when a user signs out and tries to sign back in. 

EVAN
I have made a pull request https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/22 
(2 user intefaces #22), even though it hasn't gone through, but I have the changes in file UIinsdeChatroom
and UIoutsideChatroom in 2-user-interfaces and both are pretty much complete and runnable.(since being able to see the output
are quite important for designing the User interfaces. You can pull the files from branches 2-user-interfaces and run!, not from main). 
I have set it up and made it runnable in UIoutsideChatroom's main, so that clicking button named tut119 will run UIinsideChatroom
and both should pop-up a frame with buttons and chat_window. for now only and create chatroom and enter chatroom button is clickable
and send message button inside chatroom.

The pull request I made some review would be the same pull request as above, where I have discussed the problem with Jeff 
of having data interfering the terminal or UI in Sam's work, which allowed me to actually realize the problem in the code.
Sam actually have the data reading and outputting in terminal which go against of our design of the project. While now it is fixed,
it made us clear of how we actually want our UI designed. 

TC
1. 
2. 
