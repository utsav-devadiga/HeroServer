package com.example

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.http.*
import com.example.plugins.*
import io.ktor.server.application.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            Application::module
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hey, Welcome to the server", bodyAsText())
        }
    }
}
