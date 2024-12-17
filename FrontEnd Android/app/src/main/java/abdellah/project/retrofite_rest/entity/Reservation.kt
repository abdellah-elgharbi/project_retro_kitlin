package abdellah.project.retrofite_rest.entity
class Reservation {

    private var id: Long? = null
    private var client: Client? = null
    private var chambre: Chambre? = null
    private var dateDebut: String? = null
    private var dateFin: String? = null
    private var preferences: String? = null

    // Constructeur principal
    constructor()

    constructor(id: Long?, client: Client?, chambre: Chambre?, dateDebut: String?, dateFin: String?, preferences: String?) {
        this.id = id
        this.client = client
        this.chambre = chambre
        this.dateDebut = dateDebut
        this.dateFin = dateFin
        this.preferences = preferences
    }

    // Getter et Setter pour id
    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    // Getter et Setter pour client
    fun getClient(): Client? {
        return client
    }

    fun setClient(client: Client?) {
        this.client = client
    }

    // Getter et Setter pour chambre
    fun getChambre(): Chambre? {
        return chambre
    }

    fun setChambre(chambre: Chambre?) {
        this.chambre = chambre
    }

    // Getter et Setter pour dateDebut
    fun getDateDebut(): String? {
        return dateDebut
    }

    fun setDateDebut(dateDebut: String?) {
        this.dateDebut = dateDebut
    }

    // Getter et Setter pour dateFin
    fun getDateFin(): String? {
        return dateFin
    }

    fun setDateFin(dateFin: String?) {
        this.dateFin = dateFin
    }

    // Getter et Setter pour preferences
    fun getPreferences(): String? {
        return preferences
    }

    fun setPreferences(preferences: String?) {
        this.preferences = preferences
    }

    override fun toString(): String {
        return "Reservation(id=$id, client=$client, chambre=$chambre, dateDebut=$dateDebut, dateFin=$dateFin, preferences=$preferences)"
    }
}
