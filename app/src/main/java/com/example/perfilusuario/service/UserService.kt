package com.example.perfilusuario.service

import android.util.Log
import com.example.perfilusuario.model.Usuario
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class UserService {
    private val db = FirebaseFirestore.getInstance()

    suspend fun salvarUsuario(uid: String, nome: String, email: String): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val usuario = Usuario(uid = uid, nome = nome, email = email)
            db.collection("usuarios")
                .document(uid)
                .set(usuario)
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e("UserService", "Erro ao salvar usuário no Firestore", e)
            Result.failure(e)
        }
    }
}
