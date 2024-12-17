package abdellah.project.retrofite_rest.entity
class Chambre {

    private var id: Long? = null
    private var type: String? = null
    private var prix: Double? = null
    private var disponible: Boolean? = null

    // Constructeur principal
    constructor()

    constructor(id: Long?, type: String?, prix: Double?, disponible: Boolean?) {
        this.id = id
        this.type = type
        this.prix = prix
        this.disponible = disponible
    }

    // Getter et Setter pour id
    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    // Getter et Setter pour type
    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    // Getter et Setter pour prix
    fun getPrix(): Double? {
        return prix
    }

    fun setPrix(prix: Double?) {
        this.prix = prix
    }

    // Getter et Setter pour disponible
    fun getDisponible(): Boolean? {
        return disponible
    }

    fun setDisponible(disponible: Boolean?) {
        this.disponible = disponible
    }

    override fun toString(): String {
        return "Chambre(id=$id, type=$type, prix=$prix, disponible=$disponible)"
    }
}
