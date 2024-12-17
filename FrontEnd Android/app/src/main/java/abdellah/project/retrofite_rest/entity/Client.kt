package abdellah.project.retrofite_rest.entity
class Client {

    private var id: Long? = null
    private var nom: String? = null
    private var prenom: String? = null
    private var email: String? = null
    private var telephone: String? = null

    // Constructeur principal
    constructor()

    constructor(id: Long?, nom: String?, prenom: String?, email: String?, telephone: String?) {
        this.id = id
        this.nom = nom
        this.prenom = prenom
        this.email = email
        this.telephone = telephone
    }

    // Getter et Setter pour id
    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    // Getter et Setter pour nom
    fun getNom(): String? {
        return nom
    }

    fun setNom(nom: String?) {
        this.nom = nom
    }

    // Getter et Setter pour prenom
    fun getPrenom(): String? {
        return prenom
    }

    fun setPrenom(prenom: String?) {
        this.prenom = prenom
    }

    // Getter et Setter pour email
    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    // Getter et Setter pour telephone
    fun getTelephone(): String? {
        return telephone
    }

    fun setTelephone(telephone: String?) {
        this.telephone = telephone
    }

    override fun toString(): String {
        return "Client(id=$id, nom=$nom, prenom=$prenom, email=$email, telephone=$telephone)"
    }
}
