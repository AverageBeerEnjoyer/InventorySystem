package ru.ac.uniyar.web.models

import org.http4k.lens.WebForm
import org.http4k.template.ViewModel

class AuthorizationVM(val login: String="", val password: String="", val error: String="") : ViewModel {
}