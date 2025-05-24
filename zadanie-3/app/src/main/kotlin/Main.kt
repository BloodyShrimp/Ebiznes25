import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.coroutines.runBlocking

@Serializable
data class DiscordMessage(val content: String)

fun main() {
    val webhookUrl = "https://discord.com/api/webhooks/1375900465731993772/-tJxy8TILG5GlUwTkBgRZiXijRIgCBeBnzAbxFCesHbyOUP72wv7w5PZQq0Bu0GzskKH"

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    runBlocking {
        try {
            val response = client.post(webhookUrl) {
                contentType(ContentType.Application.Json)
                setBody(DiscordMessage("Ebiznes zadanie test"))
            }

            println("Odpowiedź: ${response.status}")
        } catch (e: Exception) {
            println("Błąd przy wysyłaniu wiadomości: ${e.message}")
        } finally {
            client.close()
        }
    }
}
