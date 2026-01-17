# Team Setup Guide - Android SDK Configuration

## Problem
Team members have Android SDK installed in different locations:
- Some use standard Android Studio installation: `/home/username/Android/Sdk`
- Some use JetBrains Toolbox: `/var/lib/jetbrains/Sdk` or `~/.local/share/JetBrains/Toolbox/apps/AndroidStudio/*/jbr`
- This causes conflicts when `local.properties` is committed to version control

## Solution Implemented

### 1. Added `.gitignore` 
The `local.properties` file is now ignored by git (as it should be per Android best practices).

### 2. Created `local.properties.template`
This template file shows examples for different SDK locations. Team members can reference it.

### 3. Updated README
Added setup instructions for new team members.

## Setup Instructions for Team Members

### First Time Setup:
1. **Clone the repository**
2. **Create your `local.properties` file:**
   ```bash
   cp local.properties.template local.properties
   ```
3. **Edit `local.properties` and set your SDK path:**
   
   **For standard Android Studio (most common):**
   ```properties
   sdk.dir=/home/YOUR_USERNAME/Android/Sdk
   ```
   
   **For JetBrains Toolbox users:**
   - Check where your SDK is installed in Android Studio:
     - Open Android Studio → Settings → Appearance & Behavior → System Settings → Android SDK
     - Copy the "Android SDK Location" path
   - Common locations:
     ```properties
     sdk.dir=/home/YOUR_USERNAME/.local/share/JetBrains/Toolbox/apps/AndroidStudio/ch-0/VERSION/android-sdk
     # or
     sdk.dir=/var/lib/jetbrains/Sdk
     ```
   
   **For Windows users:**
   ```properties
   sdk.dir=C:\\Users\\YOUR_USERNAME\\AppData\\Local\\Android\\Sdk
   ```

4. **Never commit `local.properties`** - it's already in `.gitignore`

### If You Get "SDK location not found" Error:

1. **Open Android Studio**
2. Go to: **File → Settings → Appearance & Behavior → System Settings → Android SDK**
3. Note the path shown in "Android SDK Location"
4. Update your `local.properties` with that exact path

### Alternative: Use ANDROID_HOME Environment Variable

Instead of `local.properties`, you can set the `ANDROID_HOME` environment variable:

**For Linux/Mac (add to `~/.zshrc` or `~/.bashrc`):**
```bash
export ANDROID_HOME=/path/to/your/android/sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

Then restart your terminal or run:
```bash
source ~/.zshrc  # or source ~/.bashrc
```

## Important Notes

- ✅ `local.properties` is specific to YOUR machine
- ✅ Each team member should have their own `local.properties`
- ❌ NEVER commit `local.properties` to git
- ✅ DO commit `local.properties.template` for reference
- ✅ The `.gitignore` file ensures `local.properties` won't be accidentally committed

## Troubleshooting

### Error: "SDK location not found"
1. Verify your SDK path exists: `ls -la /path/to/sdk`
2. Check Android Studio's SDK location in Settings
3. Make sure `local.properties` has the correct path with no typos
4. Ensure the path uses forward slashes (`/`) on Linux/Mac
5. On Windows, escape backslashes: `C:\\Users\\...`

### Error: Permission denied
- JetBrains Toolbox SDK locations may require sudo access
- Consider using the standard Android Studio SDK location instead
- Or adjust permissions on the SDK directory

## Questions?
Contact the team lead or check the project README.md

