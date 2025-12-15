package com.example.wahtsapp.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// ========== WHATSAPP LIGHT COLOR SCHEME ==========
private val WhatsAppLightColorScheme = lightColorScheme(
    // Primary colors - WhatsApp Teal/Green
    primary = WhatsAppDarkGreen,           // Header bar color (#075E54)
    onPrimary = Neutral10,
    primaryContainer = OutgoingMessageLight, // Light green bubble
    onPrimaryContainer = Neutral70,

    // Secondary - Main WhatsApp Green for FAB and accents
    secondary = WhatsAppGreen,              // Bright green (#25D366)
    onSecondary = Neutral10,
    secondaryContainer = Color(0xFFD1F4DD), // Lighter container
    onSecondaryContainer = Color(0xFF00663B),

    // Tertiary - Blue for links and media icons
    tertiary = IconBlue,
    onTertiary = Neutral10,
    tertiaryContainer = Color(0xFFE3F2FD),
    onTertiaryContainer = Color(0xFF01579B),

    // Background & Surface
    background = Neutral10,                 // White background
    onBackground = Neutral80,
    surface = Neutral10,                    // White cards/surfaces
    onSurface = Neutral80,
    surfaceVariant = SearchBarLight,        // Search bar background
    onSurfaceVariant = Neutral60,

    // Chat specific surfaces
    inverseSurface = ChatBackgroundLight,   // Chat wallpaper background
    inverseOnSurface = Neutral80,
    inversePrimary = WhatsAppGreen,         // Accent for dark surfaces

    // Outline & Borders
    outline = DividerLight,                 // Dividers
    outlineVariant = Neutral25,

    // Error colors
    error = IconRed,
    onError = Neutral10,
    errorContainer = Color(0xFFFFEBEE),
    onErrorContainer = Color(0xFFC62828),

    // Scrim for overlays
    scrim = Color(0x99000000)
)

// ========== WHATSAPP DARK COLOR SCHEME ==========
private val WhatsAppDarkColorScheme = darkColorScheme(
    // Primary - Teal accent for dark mode
    primary = WhatsAppGreenAccent,          // Teal (#00A884)
    onPrimary = Neutral10,
    primaryContainer = OutgoingMessageDark, // Dark green bubble
    onPrimaryContainer = Color(0xFF6DDABE),

    // Secondary - Bright green for accents
    secondary = WhatsAppGreen,
    onSecondary = Neutral100,
    secondaryContainer = Color(0xFF005C4B), // Darker container
    onSecondaryContainer = Color(0xFF6DDABE),

    // Tertiary - Blue for links
    tertiary = IconBlue,
    onTertiary = Neutral100,
    tertiaryContainer = Color(0xFF0D47A1),
    onTertiaryContainer = Color(0xFF90CAF9),

    // Background & Surface
    background = Neutral100,                // Dark background (#0B141A)
    onBackground = Neutral10,
    surface = Neutral90,                    // Dark cards (#202C33)
    onSurface = Color(0xFFE9EDEF),         // Light text
    surfaceVariant = SearchBarDark,         // Dark search bar
    onSurfaceVariant = Color(0xFF8696A0),  // Muted text

    // Chat specific surfaces
    inverseSurface = ChatBackgroundDark,    // Dark chat background
    inverseOnSurface = Neutral10,
    inversePrimary = WhatsAppGreenAccent,

    // Outline & Borders
    outline = DividerDark,                  // Dark dividers
    outlineVariant = Neutral85,

    // Error colors
    error = Color(0xFFFF6B6B),             // Brighter red for dark mode
    onError = Neutral10,
    errorContainer = Color(0xFF5C1C1C),
    onErrorContainer = Color(0xFFFFA8A8),

    // Scrim
    scrim = Color(0xCC000000)
)

// ========== WHATSAPP THEME ==========
@Composable
fun WahtsappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> WhatsAppDarkColorScheme
        else -> WhatsAppLightColorScheme
    }

    // Uncomment to set status bar color
    // val view = LocalView.current
    // if (!view.isInEditMode) {
    //     SideEffect {
    //         val window = (view.context as Activity).window
    //         window.statusBarColor = colorScheme.primary.toArgb()
    //         WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    //     }
    // }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// ========== WHATSAPP SPECIFIC COLOR EXTENSIONS ==========
data class WhatsAppColors(
    val messageBubbleOutgoing: Color,
    val messageBubbleIncoming: Color,
    val chatBackground: Color,
    val statusOnline: Color,
    val statusOffline: Color,
    val iconBlue: Color,
    val iconRed: Color,
    val iconGray: Color,
    val searchBar: Color,
    val unreadBadge: Color,
    val divider: Color,
    val ripple: Color
)

val MaterialTheme.whatsAppColors: WhatsAppColors
    @Composable
    get() {
        val isDark = isSystemInDarkTheme()
        return WhatsAppColors(
            messageBubbleOutgoing = if (isDark) OutgoingMessageDark else OutgoingMessageLight,
            messageBubbleIncoming = if (isDark) IncomingMessageDark else IncomingMessageLight,
            chatBackground = if (isDark) ChatBackgroundDark else ChatBackgroundLight,
            statusOnline = StatusOnline,
            statusOffline = StatusOffline,
            iconBlue = IconBlue,
            iconRed = IconRed,
            iconGray = IconGray,
            searchBar = if (isDark) SearchBarDark else SearchBarLight,
            unreadBadge = UnreadBadge,
            divider = if (isDark) DividerDark else DividerLight,
            ripple = if (isDark) RippleDark else RippleLight
        )
    }

// Quick access to chat colors
val MaterialTheme.chatBubbleOutgoing: Color
    @Composable
    get() = if (isSystemInDarkTheme()) OutgoingMessageDark else OutgoingMessageLight

val MaterialTheme.chatBubbleIncoming: Color
    @Composable
    get() = if (isSystemInDarkTheme()) IncomingMessageDark else IncomingMessageLight

val MaterialTheme.whatsAppChatBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) ChatBackgroundDark else ChatBackgroundLight

// Additional utility extensions
val MaterialTheme.chatDivider: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DividerDark else DividerLight

val MaterialTheme.headerBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Neutral90 else WhatsAppDarkGreen

val MaterialTheme.whatsappHeader: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Neutral10 else WhatsAppGreen