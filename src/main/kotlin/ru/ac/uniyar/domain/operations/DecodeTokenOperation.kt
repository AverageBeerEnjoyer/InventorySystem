package ru.ac.uniyar.domain.operations

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import java.util.*

fun interface DecodeTokenOperation {
    fun decodeToken(token: String): String?
}

class DecodeTokenOperationImplementation : DecodeTokenOperation {
    override fun decodeToken(token: String): String? {
        val verifier = JWT.require(JWTUtils.algorithm).acceptExpiresAt(5 * 60).build()
        try {
            return verifier.verify(token).subject
        } catch (ignored: JWTVerificationException) {
            return null
        }
    }
}