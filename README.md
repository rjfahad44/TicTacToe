<h1 align="center">👾 Tic Tac Toe using Firebase Realtime Database</h1></br>
<p align="center">  
A Tic Tac Toe game Android app for playing in real time with two devices. Using Firebase, Compose and Hilt based on modern Android tech-stack and MVVM architecture.
</p>
</br>

<h3 align="center">🚧 IN PROGRESS 🚧</h2>

## Screenshots
![](./tictactoe-demo.gif)

## Tech stack
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Hilt for dependency injection.
- Firebase: Realtime database.
- JetPack
  - Compose - A modern toolkit for building native Android UI.
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
- Architecture
  - Clean Architecture.
  - MVVM Architecture (Declarative View - ViewModel - Model)
- Material Design & Animations.

## Features
- Create game and copy the game ID to share it.
- Join a game with the game ID.
- Play the game.

## Future Features (Contributions are welcome!)
- Game history.
  
## How to - Build guide
For security reasons, I have not added the `google-services.json` file. This file is responsible for establishing the connection to the Firebase database. Here, I will explain how you can set up own Firebase Realtime database for FREE, download `google-services.json` and how to use it. This is necessary if you want to download and build this Android project.

1. Login to [firebase console](https://console.firebase.google.com/) and add a new project.
   
   ![](./how-to-firebase/step1.png)

2. Give a name to the Firebase project.

   ![](./how-to-firebase/step2.png)

3. If you want you can enable Google Analytics. Click `Continue`.

   ![](./how-to-firebase/step3.png)

4. If you enabled Google Analytics select your preferred Google Analytics account and click `Create project`.

   ![](./how-to-firebase/step4.png)

5. Wait until your project is ready and click `Continue`.

   ![](./how-to-firebase/step5.png)

6. On your new Firebase project main screen click the Android icon to add Firebase to your Android app.

   ![](./how-to-firebase/step6.png)

7. Register the app:
     - ⚠️ Make sure to specify `com.ft.tictactoe` as the package name. ⚠️
     - Optionally enter the nickname for the app.
     - Click `Register app`.
   
   ![](./how-to-firebase/step7.png)

8. ⚠️ DO NOT DOWNLOAD THE JSON FILE YET. ⚠️ Just click continue, it will be downloaded later when all the config is set up.

   ![](./how-to-firebase/step8.png)

9. The Firebase SDK is already added in this project. You can check if everything is fine just in case. Click `Next`.

    ![](./how-to-firebase/step9-1.png)
    ![](./how-to-firebase/step9-2.png)

10. Click `Continue to the console`.
    
    ![](./how-to-firebase/step10.png)

11. On the main page of the Firebase project go to `Build > Realtime Database`.

    ![](./how-to-firebase/step11.png)

12. On Realtime Database page click `Create Database`.

    ![](./how-to-firebase/step12.png)

13. Choose your prefrerred location for the database and click `Next`.

    ![](./how-to-firebase/step13.png)

14. Choose any option for the security rules and click `Enable`, we will edit this rules later.

    ![](./how-to-firebase/step14.png)

15. Go to Rules tab and edit them specifying the following rules: Then click on `Publish`.
    ```
    {
      "rules": {
        ".read": true,
        ".write": true
      }
    }
    ```
    ![](./how-to-firebase/step15.png)

16. Finally, go to `Project settings` and download the `google-services.json` file.

    ![](./how-to-firebase/step17.png)
    ![](./how-to-firebase/step18.png)

17. Last step: Add the downloaded file to your Android project under `TicTacToe > app > src` and build the project.

    ![](./how-to-firebase/step19.png)

    
   

[//]: # (## Find this repository useful? :heart:)

[//]: # (Support it by joining __[stargazers]&#40;https://github.com/waleska404/tic-tac-toe/stargazers&#41;__ for this repository. :star: <br>)

[//]: # (And __[follow]&#40;https://github.com/waleska404&#41;__ me for my next creations! 🤓)
