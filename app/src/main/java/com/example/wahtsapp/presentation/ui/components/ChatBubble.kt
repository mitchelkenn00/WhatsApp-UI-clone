package com.example.wahtsapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wahtsapp.domain.model.Message
import com.example.wahtsapp.presentation.theme.*

@Composable
fun ChatBubble(
    message: Message,
    modifier: Modifier = Modifier
) {
    val isOutgoing = message.isOutgoing
    val bubbleColor = if (isOutgoing) OutgoingMessageLight else IncomingMessageLight
    val textColor = if (isOutgoing) Neutral80 else Neutral80
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalAlignment = if (isOutgoing) Alignment.End else Alignment.Start
    ) {
        if (!isOutgoing && message.senderName != null) {
            Text(
                text = message.senderName,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Neutral60,
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 2.dp)
            )
        }
        
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = if (isOutgoing) 20.dp else 4.dp,
                        bottomEnd = if (isOutgoing) 4.dp else 20.dp
                    )
                )
                .background(bubbleColor)
                .padding(12.dp)
        ) {
            Text(
                text = message.text,
                color = textColor,
                fontSize = 16.sp,
                modifier = Modifier.widthIn(max = 280.dp)
            )
        }
        
        Text(
            text = formatTimestamp(message.timestamp),
            fontSize = 11.sp,
            color = Neutral60,
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 2.dp)
        )
    }
}

private fun formatTimestamp(timestamp: Long): String {
    val now = System.currentTimeMillis()
    val diff = now - timestamp
    
    return when {
        diff < 60000 -> "now"
        diff < 3600000 -> "${diff / 60000}m ago"
        diff < 86400000 -> "${diff / 3600000}h ago"
        diff < 604800000 -> "${diff / 86400000}d ago"
        else -> "Long ago"
    }
}
