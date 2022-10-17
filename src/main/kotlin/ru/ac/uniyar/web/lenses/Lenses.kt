package ru.ac.uniyar.web.lenses

import org.http4k.core.Body
import org.http4k.lens.*

class Lenses {


    companion object {
        val loginFormLens = FormField.string().nonEmptyString().required("login")
        val passwordFormLens = FormField.string().nonEmptyString().required("password")
        val lens = Body.webForm(
            Validator.Feedback,
            loginFormLens,
            passwordFormLens
        ).toLens()
    }
}