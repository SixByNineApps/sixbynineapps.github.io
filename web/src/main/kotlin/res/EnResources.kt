package res

import res.StringId.*

object EnResources: Resources {
  override fun getString(id: StringId) = when (id) {
    Intro -> "I am a software engineer at Google and in my spare time I develop mobile apps for " +
        "Android and iOS."
    Home -> "Home"
    Apps -> "Apps"
  }
}