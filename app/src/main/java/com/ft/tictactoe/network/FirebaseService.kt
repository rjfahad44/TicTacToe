package com.ft.tictactoe.network

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.snapshots
import com.ft.tictactoe.network.model.GameData
import com.ft.tictactoe.ui.model.GameUIModel
import com.google.firebase.database.getValue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FirebaseService @Inject constructor(
    private val reference: DatabaseReference
) {
    companion object {
        private const val PATH = "games"
    }

    fun createGame(gameData: GameData): String {
        val gameReference: DatabaseReference = reference.child(PATH).push()
        val key = gameReference.key
        val newGame = gameData.copy(gameId = key)
        gameReference.setValue(newGame)
        Log.d("TICK_TAC_TOE","createGame : ${gameData}")
        return newGame.gameId.orEmpty()
    }

    fun joinToGame(gameId: String): Flow<GameUIModel?> {
        return reference.database.reference.child("$PATH/$gameId").snapshots.map { dataSnapshot ->
            Log.d("TICK_TAC_TOE","joinToGame : ${dataSnapshot.getValue(GameData::class.java)}")
            dataSnapshot.getValue(GameData::class.java)?.toUIModel()
        }
    }

    fun updateGame(gameData: GameData) {
        if (gameData.gameId != null) {
            Log.d("TICK_TAC_TOE","updateGame : $gameData")
            reference.child(PATH).child(gameData.gameId).setValue(gameData)
        }
    }
}