package com.example.wahtsapp.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import com.example.wahtsapp.presentation.ui.components.ChatItem
import com.example.wahtsapp.presentation.theme.*
import com.example.wahtsapp.presentation.viewModel.ChatListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    chatListViewModel: ChatListViewModel = viewModel(),
    onChatClick: (String) -> Unit = {}
) {
    val chats by chatListViewModel.chats.collectAsState()

    // Pager State for swiping logic (3 pages: Chats, Status, Calls)
    val pagerState = rememberPagerState(pageCount = { 3 })
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("WhatsApp", color = Color.White, fontWeight = FontWeight.Bold) },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.CameraAlt, contentDescription = "Camera", tint = Color.White)
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Color.White)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = WhatsAppGreen)
                )

                // TabRow synced with the HorizontalPager
                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    containerColor = WhatsAppGreen,
                    contentColor = Color.White,
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                            color = Color.White
                        )
                    }
                ) {
                    val tabs = listOf("CHATS", "STATUS", "CALLS")
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = pagerState.currentPage == index,
                            onClick = {
                                scope.launch { pagerState.animateScrollToPage(index) }
                            },
                            text = {
                                Text(
                                    text = title,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (pagerState.currentPage == index) Color.White else Color.White.copy(alpha = 0.7f)
                                )
                            }
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* FAB Action based on pagerState.currentPage */ },
                containerColor = WhatsAppGreen,
                contentColor = Color.White,
                shape = MaterialTheme.shapes.large
            ) {
                when (pagerState.currentPage) {
                    0 -> Icon(Icons.Default.Message, contentDescription = "New Chat")
                    1 -> Icon(Icons.Default.CameraAlt, contentDescription = "Add Status")
                    2 -> Icon(Icons.Default.Call, contentDescription = "New Call")
                }
            }
        }
    ) { innerPadding ->
        // The HorizontalPager handles the actual page content and swiping
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { page ->
            when (page) {
                0 -> ChatsList(chats = chats, onChatClick = onChatClick)
                1 -> PlaceholderScreen(icon = Icons.Default.CircleNotifications, label = "No status updates")
                2 -> PlaceholderScreen(icon = Icons.Default.Call, label = "No recent calls")
            }
        }
    }
}

@Composable
private fun ChatsList(
    chats: List<com.example.wahtsapp.domain.model.Chat>,
    onChatClick: (String) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {
        items(chats) { chat ->
            ChatItem(chat = chat, onChatClick = onChatClick)
        }
    }
}

@Composable
private fun PlaceholderScreen(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String) {
    Box(
        modifier = Modifier.fillMaxSize().background(Neutral15),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(48.dp), tint = Neutral60)
            Spacer(modifier = Modifier.height(8.dp))
            Text(label, color = Neutral60, fontSize = 16.sp)
        }
    }
}