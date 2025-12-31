package com.example.wahtsapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wahtsapp.presentation.theme.*

@Composable
fun ChatInputBar(
    messageText: String,
    onMessageTextChanged: (String) -> Unit,
    onSendMessage: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Neutral10)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = messageText,
            onValueChange = onMessageTextChanged,
            modifier = Modifier.weight(1f),
            placeholder = { Text("Type a message...", color = Neutral60) },
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Neutral30,
                focusedBorderColor = WhatsAppGreen,
                cursorColor = WhatsAppGreen
            )
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        IconButton(
            onClick = onSendMessage,
            enabled = messageText.isNotBlank()
        ) {
            Icon(
                Icons.Default.Send,
                contentDescription = "Send",
                tint = if (messageText.isNotBlank()) WhatsAppGreen else Neutral60
            )
        }
    }
}
