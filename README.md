# WhatsApp-UI-clone
# WhatsApp UI Clone (Kotlin · Android · MVVM · Clean Architecture)

## Overview

A WhatsApp UI clone built for Android using Kotlin. The project follows MVVM (Model-View-ViewModel) and Clean Architecture principles, featuring domain, data, and presentation layers for scalable, testable, and maintainable code.  
It replicates WhatsApp’s classic interface with chats, status, and user profile screens, and includes Google Sign-In authentication using JWT ID Tokens.

## Features

- Modern WhatsApp-inspired user interface
- Chat list and individual chat screens (send, receive, display messages)
- Status posting and viewing
- User profile view and info editing
- Google Sign-In authentication (JWT ID Token)
- Light and dark theme support
- Architectural separation (domain, data, presentation)
- Written entirely in Kotlin

## Architecture

### Layers:
- **Domain:** Business logic, entities, repository interfaces, use cases  
- **Data:** Implementation of repositories, remote/local data sources, network models (DTOs), mappers  
- **Presentation:** UI screens, viewmodels, adapters, UI utilities

### Authentication:
- Google Sign-In using JWT ID Token
- Auth-related code structured for separation of concerns:
  - `data/source/remote/GoogleAuthService.kt` – handles Google authentication flow
  - `domain/usecase/SignInWithGoogleUseCase.kt` – business logic for sign-in
  - `presentation/auth/AuthScreen.kt` & `presentation/auth/AuthViewModel.kt` – UI and state management

## Folder Structure

WhatsApp-UI-clone/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── mitchelkenn00/
│   │   │   │           └── whatsappuiclone/
│   │   │   │               ├── authdata/
│   │   │   │               │   ├── AuthRepository.kt
│   │   │   │               │   └── AuthRemoteDataSource.kt
│   │   │   │               ├── domain/
│   │   │   │               │   ├── model/
│   │   │   │               │   │   ├── User.kt
│   │   │   │               │   │   └── Message.kt
│   │   │   │               │   └── usecase/
│   │   │   │               │       ├── LoginUseCase.kt
│   │   │   │               │       └── SendMessageUseCase.kt
│   │   │   │               ├── presentation/
│   │   │   │               │   ├── ui/
│   │   │   │               │   │   ├── screens/
│   │   │   │               │   │   │   ├── ChatScreen.kt
│   │   │   │               │   │   │   ├── HomeScreen.kt
│   │   │   │               │   │   └── components/
│   │   │   │               │   │       ├── ChatBubble.kt
│   │   │   │               │   │       ├── TopBar.kt
│   │   │   │               │   ├── viewmodel/
│   │   │   │               │   │   ├── AuthViewModel.kt
│   │   │   │               │   │   └── ChatViewModel.kt
│   │   │   │               ├── MainActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   ├── values/
│   │   │   │   └── mipmap/
│   │   │   └── AndroidManifest.xml
│   └── build.gradle
├── README.md
└── ...

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/YOUR-USERNAME/whatsapp-ui-clone.git
   ```

2. **Open in [Android Studio](https://developer.android.com/studio).**

3. **Configure your Google Client ID for Google Sign-In in your `google-services.json`.**

4. **Build and launch on emulator or device.**

## Contributing

Contributions, feature requests, and bug reports are welcome!  
Please open an issue or submit a pull request.

## License

[MIT License](LICENSE)

---

**Made with ❤️ in Kotlin**
