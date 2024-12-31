package com.ft.tictactoe.ui.model

import androidx.annotation.Keep
import com.ft.tictactoe.network.model.GameData
import com.ft.tictactoe.network.model.PlayerData

@Keep
data class GameUIModel(
    val board: List<PlayerType>,
    val player1: PlayerUIModel,
    val player2: PlayerUIModel?,
    val playerTurn: PlayerUIModel,
    val gameId: String,
    val isGameReady: Boolean = false,
    val isMyTurn: Boolean = false
) {
    fun toDataModel(): GameData {
        return GameData(
            board = board.map { it.id },
            gameId = gameId,
            player1 = player1.toDataModel(),
            player2 = player2?.toDataModel(),
            playerTurn = playerTurn.toDataModel(),
        )
    }
}

@Keep
data class PlayerUIModel(
    val userId: String,
    val playerType: PlayerType
) {
    fun toDataModel(): PlayerData {
        return PlayerData(
            userId = userId,
            playerType = playerType.id
        )
    }
}


@Keep
sealed class PlayerType(
    val id: Int,
    val symbol: String
) {
    data object FirstPlayer : PlayerType(1, "X")
    data object SecondPlayer : PlayerType(2, "O")
    data object Empty : PlayerType(0, "")

    companion object {
        fun getPlayerById(id: Int?): PlayerType {
            return when (id) {
                FirstPlayer.id -> FirstPlayer
                SecondPlayer.id -> SecondPlayer
                else -> Empty
            }
        }
    }
}