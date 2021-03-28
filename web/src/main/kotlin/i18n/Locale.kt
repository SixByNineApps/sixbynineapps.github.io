package i18n

import res.EnResources
import res.FrResources
import res.Resources

enum class Locale(val language: String, val resources: Resources) {
  ENGLISH("en", EnResources),
  FRENCH("fr", FrResources)
}