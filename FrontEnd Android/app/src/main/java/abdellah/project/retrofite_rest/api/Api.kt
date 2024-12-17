package abdellah.project.retrofite_rest.api


import abdellah.project.retrofite_rest.entity.Reservation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface Api {
  @GET("reservations/{id}")
  fun getReservationById(@Path("id") id: Long): Call<Reservation>
  @POST("reservations")
  fun createReservation(@Body reservation: Reservation): Call<Reservation>
  @PUT("reservations/{id}")
  fun updateReservation(@Path("id") id: Long, @Body reservation: Reservation): Call<Reservation>
  @DELETE("reservations/{id}")
  fun deleteReservation(@Path("id") id: Long): Call<Void>
}