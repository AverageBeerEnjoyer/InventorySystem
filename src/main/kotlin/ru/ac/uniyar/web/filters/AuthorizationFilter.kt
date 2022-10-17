package ru.ac.uniyar.web.filters

import org.http4k.core.*
import org.http4k.core.cookie.Cookie
import org.http4k.core.cookie.cookie
import ru.ac.uniyar.domain.operations.DecodeTokenOperation
import ru.ac.uniyar.domain.operations.FetchEmployeeOperation
import ru.ac.uniyar.domain.operations.FetchWithLoginEmployeeOperation
import ru.ac.uniyar.domain.storage.Role
import ru.ac.uniyar.web.models.NotFoundVM
import ru.ac.uniyar.web.templates.ContextAwareViewRender

class AuthorizationFilter(
    private val htmlView: ContextAwareViewRender,
    val decodeTokenOperation: DecodeTokenOperation,
    val fetchWithLoginEmployeeOperation: FetchWithLoginEmployeeOperation
) : Filter {
    override fun invoke(next: HttpHandler): HttpHandler = { request ->
        val response=next(request)
        val cookie = request.cookie("logged")
        val role=getRoleFromCookie(cookie)
        val route=request.uri.path
        if(role.forbiddenRoutes.firstOrNull{
            route.startsWith(it)
        }==null) response
        else Response(Status.BAD_REQUEST)
    }

    private fun getRoleFromCookie(cookie: Cookie?): Role {
        if (cookie == null) return Role.GUEST
        val login = decodeTokenOperation.decodeToken(cookie.value) ?: return Role.GUEST
        val employee = fetchWithLoginEmployeeOperation.fetchWithLogin(login)
        return employee?.role ?:Role.GUEST
    }
}
