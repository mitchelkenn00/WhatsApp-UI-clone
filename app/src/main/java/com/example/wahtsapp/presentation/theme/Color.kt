package com.example.wahtsapp.presentation.theme

import androidx.compose.ui.graphics.Color

// ========== WHATSAPP BRAND COLORS ==========
// Primary brand colors - Adjusted to match actual WhatsApp
val WhatsAppGreen = Color(0xFF25D366)        // Main WhatsApp green (correct)
val WhatsAppDarkGreen = Color(0xFF075E54)    // Header bar green (correct)
val WhatsAppGreenAccent = Color(0xFF00A884)  // Dark mode teal accent

// Secondary/Container colors
val WhatsAppGreenLight = Color(0xFFDCF8C6)   // Outgoing message bubble light mode (correct)
val WhatsAppGreenDark = Color(0xFF128C7E)    // Teal variant
val WhatsAppDarkGreenLight = Color(0xFF056162) // Outgoing message dark mode (updated)

// ========== NEUTRAL PALETTE ==========
// Light mode neutrals - Refined
val Neutral10 = Color(0xFFFFFFFF)      // White background
val Neutral15 = Color(0xFFF7F8FA)      // Very light gray (adjusted)
val Neutral20 = Color(0xFFF0F2F5)      // Light surface (updated)
val Neutral25 = Color(0xFFE9EDEF)      // Lighter gray (updated)
val Neutral30 = Color(0xFFE1E3E6)      // Divider light (adjusted)
val Neutral40 = Color(0xFFD1D7DB)      // Light border (adjusted)
val Neutral50 = Color(0xFF8696A0)      // Disabled light (updated to WhatsApp gray)
val Neutral60 = Color(0xFF667781)      // Secondary text light (updated)
val Neutral70 = Color(0xFF54656F)      // Hint text light (updated)
val Neutral80 = Color(0xFF3B4A54)      // Primary text light (updated)

// Dark mode neutrals - Refined to match WhatsApp dark theme
val Neutral85 = Color(0xFF2A3942)      // Dark divider (updated)
val Neutral90 = Color(0xFF202C33)      // Dark surface (updated to WhatsApp dark)
val Neutral95 = Color(0xFF111B21)      // Darker background (updated)
val Neutral100 = Color(0xFF0B141A)     // Dark background (updated)
val Neutral110 = Color(0xFF0B141A)     // WhatsApp dark chat background (same as 100)

// ========== CHAT SPECIFIC COLORS ==========
// Message bubbles - Refined
val OutgoingMessageLight = Color(0xFFD9FDD3)  // Slightly adjusted green tint
val IncomingMessageLight = Color(0xFFFFFFFF)  // Pure white
val OutgoingMessageDark = Color(0xFF005C4B)   // Updated to match WhatsApp exactly
val IncomingMessageDark = Color(0xFF202C33)   // Updated to match dark theme

// Chat backgrounds - Refined
val ChatBackgroundLight = Color(0xFFEFEAE2)   // Warmer beige tone (updated)
val ChatBackgroundDark = Color(0xFF0B141A)    // Updated to match exact dark background

// ========== STATUS COLORS ==========
val StatusOnline = Color(0xFF25D366)      // WhatsApp green for online (updated)
val StatusOffline = Color(0xFF8696A0)     // Gray for offline (updated)
val StatusTyping = Color(0xFF06CF9C)      // Teal for typing indicator (updated)
val StatusRead = Color(0xFF53BDEB)        // Blue tick color (updated)

// ========== ICON/ACCENT COLORS ==========
val IconBlue = Color(0xFF53BDEB)         // Updated to WhatsApp blue
val IconGreen = WhatsAppGreen
val IconGray = Color(0xFF8696A0)         // Updated to match WhatsApp gray
val IconRed = Color(0xFFF15C6D)          // Updated to WhatsApp red
val IconYellow = Color(0xFFFFC107)       // Starred messages (adjusted)

// ========== UI SPECIFIC COLORS ==========
// Tab colors
val StatusTabLight = Color(0xFFF0F2F5)       // Updated
val StatusTabDark = Color(0xFF202C33)        // Updated
val CameraTabLight = Color(0xFF008069)       // WhatsApp teal (updated)
val CameraTabDark = Color(0xFF233138)        // Darker teal (updated)

// Badge/Indicator colors
val UnreadBadge = Color(0xFF25D366)          // WhatsApp green
val PinnedChatColor = Color(0xFF8696A0)      // Updated to subtle gray
val MutedChatColor = Color(0xFF8696A0)       // Consistent gray

// Call colors
val CallIncoming = Color(0xFF00A884)         // Teal for incoming (updated)
val CallOutgoing = Color(0xFF00A884)         // Same teal (updated)
val CallMissed = Color(0xFFF15C6D)           // Red for missed (updated)

// Status screen colors
val StatusSeenBorder = Color(0xFF8696A0)     // Gray for seen (updated)
val StatusUnseenBorder = Color(0xFF00A884)   // Teal for unseen (updated)
val StatusGradientStart = Color(0xFF09D261)  // WhatsApp green gradient
val StatusGradientEnd = Color(0xFF03A65A)    // Darker green gradient

// Search/Input colors
val SearchBarLight = Color(0xFFF0F2F5)       // Light search (updated)
val SearchBarDark = Color(0xFF202C33)        // Dark search (updated)

// Additional utility colors
val DividerLight = Color(0xFFE9EDEF)
val DividerDark = Color(0xFF2A3942)
val RippleLight = Color(0x1F000000)          // 12% black
val RippleDark = Color(0x1FFFFFFF)           // 12% white