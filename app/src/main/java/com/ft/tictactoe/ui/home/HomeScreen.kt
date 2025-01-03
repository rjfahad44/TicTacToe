package com.ft.tictactoe.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ft.tictactoe.R
import com.ft.tictactoe.ui.core.components.TicTacPrimaryButton
import com.ft.tictactoe.ui.theme.Background
import com.ft.tictactoe.ui.theme.LightGrey
import com.ft.tictactoe.ui.theme.PrimaryBlack
import com.ft.tictactoe.ui.theme.PrimaryGrey
import com.ft.tictactoe.ui.theme.SecondaryGrey

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateToGame: (String, String, Boolean) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        Spacer(modifier = Modifier.weight(0.2f))
        Header()
        Spacer(modifier = Modifier.weight(0.2f))
        Body(
            onCreateGame = { homeViewModel.onCreateGame(navigateToGame) },
            onJoinGame = { gameId -> homeViewModel.onJoinGame(gameId, navigateToGame) }
        )
        Spacer(modifier = Modifier.weight(0.6f))
    }
}

@Composable
fun Header() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Box(
            modifier = Modifier
                .size(200.dp)
                .padding(12.dp)
                .clip(RoundedCornerShape(24.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.logo_content_description),
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 32.sp,
            color = PrimaryBlack,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun Body(
    onCreateGame: () -> Unit,
    onJoinGame: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var createGame by remember { mutableStateOf(true) }
        Switch(
            checked = createGame,
            onCheckedChange = { createGame = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = SecondaryGrey,
                checkedTrackColor = PrimaryGrey,
                uncheckedThumbColor = SecondaryGrey,
                uncheckedTrackColor = PrimaryGrey,
                uncheckedBorderColor = Color.Transparent
            ),
        )
        Spacer(modifier = Modifier.height(24.dp))
        AnimatedContent(targetState = createGame, label = "") {
            when (it) {
                true -> CreateGame(onCreateGame)
                false -> JoinGame(onJoinGame)
            }
        }
    }
}

@Composable
fun CreateGame(
    onCreateGame: () -> Unit,
) {
    TicTacPrimaryButton(
        onClick = { onCreateGame() },
        text = stringResource(id = R.string.start_game)
    )
}


@Composable
fun JoinGame(
    onJoinGame: (String) -> Unit,
) {
    var text by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            colors = TextFieldDefaults.colors(
                focusedTextColor = PrimaryBlack,
                unfocusedTextColor = PrimaryGrey,
                cursorColor = PrimaryBlack,
                focusedIndicatorColor = SecondaryGrey,
                unfocusedIndicatorColor = PrimaryGrey,
                focusedContainerColor = LightGrey,
                unfocusedContainerColor = LightGrey.copy(alpha = 0.5f)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        TicTacPrimaryButton(
            onClick = { onJoinGame(text) },
            text = stringResource(id = R.string.join_game),
            enabled = text.isNotEmpty(),
            textColor = if (text.isNotEmpty()) PrimaryBlack else LightGrey,
        )
    }
}