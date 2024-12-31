package com.ft.tictactoe.network.model

import androidx.annotation.Keep
import com.ft.tictactoe.ui.model.GameUIModel
import com.ft.tictactoe.ui.model.PlayerType
import com.ft.tictactoe.ui.model.PlayerUIModel
import java.util.Calendar

@Keep
data class GameData(
    val board: List<Int?>? = null,
    val gameId: String? = null,
    val player1: PlayerData? = null,
    val player2: PlayerData? = null,
    val playerTurn: PlayerData? = null,
) {
    fun toUIModel(): GameUIModel {
        return GameUIModel(
            board = board?.map { PlayerType.getPlayerById(it) } ?: mutableListOf(),
            gameId = gameId.orEmpty(),
            player1 = player1!!.toUIModel(),
            player2 = player2?.toUIModel(),
            playerTurn = playerTurn!!.toUIModel(),
        )
    }
}


@Keep
data class PlayerData(
    val userId: String? = Calendar.getInstance().timeInMillis.hashCode().toString(),
    val playerType: Int? = null,
) {
    fun toUIModel(): PlayerUIModel {
        return PlayerUIModel(
            userId = userId.orEmpty(),
            playerType = PlayerType.getPlayerById(playerType),
        )
    }
}