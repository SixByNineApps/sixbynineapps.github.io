package res

import res.StringId.*

object FrResources : Resources {
  override fun getString(id: StringId) = when (id) {
    Intro -> "Je travaille comme developpeur pour Google et dans mes passe-temps je crée des " +
        "applications mobile pour Androïd et iOS."
    Home -> "Acceuil"
    Apps -> "Applis"
  }
}