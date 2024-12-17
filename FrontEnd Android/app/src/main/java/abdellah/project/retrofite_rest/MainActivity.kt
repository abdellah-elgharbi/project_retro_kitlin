

package abdellah.project.retrofite_rest
import abdellah.project.retrofite_rest.R
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import abdellah.project.retrofite_rest.api.Api
import abdellah.project.retrofite_rest.entity.Reservation
import abdellah.project.retrofite_rest.retroClinet.RetrofitClient


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        testGetReservationById(1)

        testCreateReservation()
    }

    // Test d'appel API GET pour récupérer une réservation par ID
    private fun testGetReservationById(id: Long) {
        val startTime = System.nanoTime()

        val call: Call<Reservation> = RetrofitClient.api.getReservationById(id)
        call.enqueue(object : Callback<Reservation> {
            override fun onResponse(call: Call<Reservation>, response: Response<Reservation>) {
                val endTime = System.nanoTime()
                val duration = (endTime - startTime) / 1_000_000.0 // Temps en millisecondes
                Log.d("GET Reservation", "Réponse : ${response.body()}")
                Log.d("Performance", "Temps de réponse (GET) : $duration ms")
                Log.d("Performance", "Taille des données : ${response.raw().networkResponse?.body?.contentLength()} octets")
            }

            override fun onFailure(call: Call<Reservation>, t: Throwable) {
                Log.e("GET Reservation", "Erreur : ${t.message}")
            }
        })
    }

    // Test d'appel API POST pour créer une réservation
    private fun testCreateReservation(reservation: Reservation) {
        val startTime = System.nanoTime()

        val call: Call<Reservation> = RetrofitClient.api.createReservation(reservation)
        call.enqueue(object : Callback<Reservation> {
            override fun onResponse(call: Call<Reservation>, response: Response<Reservation>) {
                val endTime = System.nanoTime()
                val duration = (endTime - startTime) / 1_000_000.0 // Temps en millisecondes
                Log.d("POST Reservation", "Réponse : ${response.body()}")
                Log.d("Performance", "Temps de réponse (POST) : $duration ms")
                Log.d("Performance", "Taille des données envoyées : ${response.raw().request.body?.contentLength()} octets")
            }

            override fun onFailure(call: Call<Reservation>, t: Throwable) {
                Log.e("POST Reservation", "Erreur : ${t.message}")
            }
        })
    }
}
