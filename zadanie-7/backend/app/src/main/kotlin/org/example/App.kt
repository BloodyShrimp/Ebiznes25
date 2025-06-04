package org.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.serialization.jackson.*
import io.ktor.server.routing.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.example.models.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        jackson()
    }

    install(CORS) {
        anyHost()
        allowMethod(io.ktor.http.HttpMethod.Get)
        allowMethod(io.ktor.http.HttpMethod.Post)
        allowHeader(io.ktor.http.HttpHeaders.ContentType)
    }

    routing {
        get("/produkty") {
            val produkty = listOf(
                Produkt(1, "Gruszka", 10.0),
                Produkt(2, "Pietruszka", 20.0),
                Produkt(3, "Marchewka", 30.0),
                Produkt(4, "Jabłko", 40.0),
                Produkt(5, "Kaktus", 50.0)
            )
            call.respond(produkty)
        }

        post("/platnosci") {
            val platnosc = call.receive<Platnosc>()
            println("Otrzymano płatność: $platnosc")
            call.respond(mapOf("status" to "ok"))
        }
    }
}
