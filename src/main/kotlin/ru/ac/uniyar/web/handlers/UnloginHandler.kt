package ru.ac.uniyar.web.handlers

import org.http4k.core.*
import org.http4k.core.cookie.invalidateCookie

class UnloginHandler : HttpHandler {
    override fun invoke(request: Request): Response {
        return Response(Status.FOUND).invalidateCookie("logged").header("location","/")
    }
}