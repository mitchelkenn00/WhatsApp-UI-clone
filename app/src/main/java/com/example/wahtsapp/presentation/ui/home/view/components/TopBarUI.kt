package com.example.wahtsapp.presentation.ui.home.view.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wahtsapp.presentation.theme.whatsappHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarUI (
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    titleColor: Color = MaterialTheme.colorScheme.onSurface

){
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                ),
                color = titleColor
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            navigationIconContentColor = contentColor,
            titleContentColor = contentColor,
            actionIconContentColor = contentColor
        ),
        modifier = modifier
    )
}

///////////////////////////////////////////////////////////////////////////
// chats screen
///////////////////////////////////////////////////////////////////////////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppChatsTopBar(
    onCameraClick: () -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopBarUI(
        title = "WhatsApp",
        actions = {
            IconButton(
                onClick = onCameraClick
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Camera"
                )
            }
            IconButton(
                onClick = onMoreClick
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menu"
                )
            }
        },
        modifier = modifier,
        titleColor = MaterialTheme.whatsappHeader
    )
}

///////////////////////////////////////////////////////////////////////////
// updates
///////////////////////////////////////////////////////////////////////////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppUpdatesTopBar(
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopBarUI(
        title = "Updates",
        actions = {
            IconButton(
                onClick = onSearchClick
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Camera"
                )
            }
            IconButton(
                onClick = onMoreClick
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "MoreVert"
                )
            }
        },
        modifier = modifier,
    )
}

///////////////////////////////////////////////////////////////////////////
// communities
///////////////////////////////////////////////////////////////////////////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppCommunitiesTopBar(
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopBarUI(
        title = "Communities",
        actions = {
            IconButton(
                onClick = onSearchClick
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(
                onClick = onMoreClick
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "MoreVert"
                )
            }
        },
        modifier = modifier,
    )
}

///////////////////////////////////////////////////////////////////////////
// calls
///////////////////////////////////////////////////////////////////////////
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppCallsTopBar(
    onSearchClick: () -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopBarUI(
        title = "Calls",
        actions = {
            IconButton(
                onClick = onSearchClick
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(
                onClick = onMoreClick
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "MoreVert"
                )
            }
        },
        modifier = modifier,
    )
}