package com.example.plugins


import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import javax.naming.AuthenticationException

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, status ->
            call.respond(
                message = "404: Page Not Found",
                status = status
            )
        }

        exception<Throwable> { call, cause ->
            if (cause is AuthenticationException) {
                call.respond(message = "403: Forbidden", status = HttpStatusCode.Forbidden)
            } else {
                call.respond(message = "500: Internal server error", status = HttpStatusCode.InternalServerError)
            }
        }

    }
}