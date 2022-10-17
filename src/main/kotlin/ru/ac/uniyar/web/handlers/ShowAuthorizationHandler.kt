package ru.ac.uniyar.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.with
import org.http4k.routing.path
import ru.ac.uniyar.domain.operations.FetchEmployeeOperation
import ru.ac.uniyar.web.models.AuthorizationVM
import ru.ac.uniyar.web.models.ShowEmployeeVM
import ru.ac.uniyar.web.templates.ContextAwareViewRender
import java.util.UUID

class ShowAuthorizationHandler(
    private val htmlView: ContextAwareViewRender,
) : HttpHandler {
    override fun invoke(request: Request): Response {
        return Response(Status.OK).with(
            htmlView(request) of AuthorizationVM()
        )
    }
}
