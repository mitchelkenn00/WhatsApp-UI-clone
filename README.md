# WhatsApp UI Clone (Kotlin · Android · MVVM · Clean Architecture)

A sleek messaging app for Android built in Kotlin, focused on clean code, modern design patterns, and robust architecture.

## Overview

This project replicates the look & feel of WhatsApp, including chats, status updates, and user profiles. Built with MVVM and Clean Architecture, it features clear separation between domain, data, and presentation layers. Authentication is handled with Google Sign-In (JWT ID Token), and the app is designed for easy extension and testing.

---

## Features

- Modern WhatsApp-inspired UI
- View chat list, open/switch chats, send & receive messages
- Post/view statuses
- Edit/view user profile info
- Google Sign-In authentication (JWT ID Token)
- Light/Dark theme toggle
- Modular, maintainable codebase (MVVM/Clean Architecture)
- 100% Kotlin, using Jetpack Compose for UI

---

## Architecture

**Layers:**
- **Domain:** Business logic, models, repo interfaces, use cases  
- **Data:** Repo implementations, remote/local data sources, DTOs, mappers  
- **Presentation:** UI screens, components, viewmodels

**Authentication Flow:**
- **GoogleAuthService.kt:** Handles auth with Google and JWT acquisition
- **SignInWithGoogleUseCase.kt:** Encapsulates business logic for sign-in
- **AuthScreen.kt & AuthViewModel.kt:** UI and state management for authentication

---

## Folder Structure

```
WhatsApp-UI-clone/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── mitchelkenn00/
│   │   │   │           └── whatsappuiclone/
│   │   │   │               ├── data/
│   │   │   │               │   ├── repository/
│   │   │   │               │   │   └── AuthRepositoryImpl.kt
│   │   │   │               │   └── source/
│   │   │   │               │       ├── remote/
│   │   │   │               │       │   ├── GoogleAuthService.kt
│   │   │   │               │       │   └── ChatRemoteDataSource.kt
│   │   │   │               │       └── local/
│   │   │   │               │           ├── ChatLocalDataSource.kt
│   │   │   │               ├── domain/
│   │   │   │               │   ├── model/
│   │   │   │               │   │   ├── User.kt
│   │   │   │               │   │   ├── Message.kt
│   │   │   │               │   │   └── Status.kt
│   │   │   │               │   ├── repository/
│   │   │   │               │   │   └── AuthRepository.kt
│   │   │   │               │   └── usecase/
│   │   │   │               │       ├── SignInWithGoogleUseCase.kt
│   │   │   │               │       ├── SendMessageUseCase.kt
│   │   │   │               │       └── PostStatusUseCase.kt
│   │   │   │               └── presentation/
│   │   │   │                   ├── ui/
│   │   │   │                   │   ├── screens/
│   │   │   │                   │   │   ├── AuthScreen.kt
│   │   │   │                   │   │   ├── ChatScreen.kt
│   │   │   │                   │   │   ├── HomeScreen.kt
│   │   │   │                   │   │   ├── StatusScreen.kt
│   │   │   │                   │   │   └── ProfileScreen.kt
│   │   │   │                   │   ├── components/
│   │   │   │                   │   │   ├── ChatBubble.kt
│   │   │   │                   │   │   ├── TopBar.kt
│   │   │   │                   │   │   └── StatusTile.kt
│   │   │   │                   ├── viewmodel/
│   │   │   │                   │   ├── AuthViewModel.kt
│   │   │   │                   │   ├── ChatViewModel.kt
│   │   │   │                   │   ├── StatusViewModel.kt
│   │   │   │                   │   └── ProfileViewModel.kt
│   │   │   │                   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   ├── values/
│   │   │   │   └── mipmap/
│   │   │   └── AndroidManifest.xml
│   └── build.gradle
├── google-services.json         # Google Auth config -- add your own
├── README.md
├── LICENSE
└── ...
# Brief Overview of the project structure

app/src/main/java/com/mitchelkenn00/mitchyken/
├── data/
│   ├── local/
│   │   ├── dao/              # Room DAOs
│   │   ├── entity/           # Room Entities
│   │   ├── mapper/           # Entity-Domain mappers
│   │   └── AppDatabase.kt    # Room Database
│   ├── repository/           # Repository implementations
│   └── source/
│       ├── local/            # Local data source
│       └── remote/           # Firebase auth service
├── domain/
│   ├── model/                # Domain models
│   ├── repository/           # Repository interfaces
│   └── usecase/              # Business logic use cases
└── presentation/
    ├── ui/
    │   ├── components/       # Reusable UI components
    │   ├── screens/          # App screens
    │   └── theme/            # Material 3 theme
    ├── viewmodel/            # ViewModels
    └── MainActivity.kt       # Entry point
```

---

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/mitchelkenn00/WhatsApp-UI-clone.git
   ```

2. **Open in [Android Studio](https://developer.android.com/studio)**

3. **Configure Android SDK location:**
   - Copy `local.properties.template` to `local.properties`
   - Update `sdk.dir` in `local.properties` with your Android SDK path:
     - Standard Android Studio (Linux/Mac): `/home/YOUR_USERNAME/Android/Sdk`
     - JetBrains Toolbox (Linux): `/var/lib/jetbrains/Sdk`
     - Windows: `C:\\Users\\YOUR_USERNAME\\AppData\\Local\\Android\\Sdk`
   - **Note:** `local.properties` is gitignored and should never be committed

4. **Add your Google Client ID/credentials to `google-services.json` (for Sign-In)**  
   - [How to generate google-services.json?](https://developers.google.com/identity/sign-in/android/start)

5. **Build and run on emulator/device (Android 5.0+)**

---

## Contributing

- Ideas, bug reports, and pull requests are welcome!
- Please open an [issue](https://github.com/mitchelkenn00/WhatsApp-UI-clone/issues) or draft a PR

---

## License

[MIT License](LICENSE)

---

**Made with ❤️ in Kotlin & Jetpack Compose**
