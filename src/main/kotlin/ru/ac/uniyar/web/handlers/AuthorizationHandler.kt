package ru.ac.uniyar.web.handlers

import org.http4k.core.*
import org.http4k.core.cookie.Cookie
import org.http4k.core.cookie.cookie
import org.http4k.lens.Validator
import org.http4k.lens.webForm
import ru.ac.uniyar.domain.operations.FetchWithLoginEmployeeOperation
import ru.ac.uniyar.domain.operations.GenerateTokenOperation
import ru.ac.uniyar.web.lenses.Lenses
import ru.ac.uniyar.web.models.AuthorizationVM
import ru.ac.uniyar.web.templates.ContextAwareViewRender

class AuthorizationHandler(
    private val htmlView: ContextAwareViewRender,
    val eployeeOperation: FetchWithLoginEmployeeOperation,
    val generateTokenOperation: GenerateTokenOperation
) : HttpHandler {
    override fun invoke(request: Request): Response {
        val lens = Lenses.lens
        val webForm=lens(request)
        val employee = eployeeOperation.fetchWithLogin(Lenses.loginFormLens(webForm))
        if (employee != null && employee.password==Lenses.passwordFormLens(webForm)) return Response(Status.FOUND).cookie(Cookie("logged", generateTokenOperation.generateToken(employee.login)))
            .header("location", "/")
        else return Response(Status.BAD_REQUEST).with(htmlView(request) of AuthorizationVM(Lenses.loginFormLens(webForm),Lenses.passwordFormLens(webForm),"wrong login or password"))
    }
}
