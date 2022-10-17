package ru.ac.uniyar.domain.operations

import com.auth0.jwt.algorithms.Algorithm
import java.util.*

class JWTUtils {
    companion object{
        val secret = "zachet plz"
        val algorithm = Algorithm.HMAC512(secret)
    }
}