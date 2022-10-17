package ru.ac.uniyar.domain.operations

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

fun interface GenerateTokenOperation{
    fun generateToken(login: String): String
}
class GenerateTokenOperationImplementation : GenerateTokenOperation{
    override fun generateToken(login: String): String {
        return JWT
            .create()
            .withSubject(login)
            .withExpiresAt(Date(System.currentTimeMillis()+5*60*1000)).sign(JWTUtils.algorithm)
    }
}