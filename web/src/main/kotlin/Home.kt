import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.styles.*
import i18n.Locale
import kotlinx.browser.window
import kotlinx.css.*
import react.*
import res.Resources
import res.strings
import styled.*

class Home : RComponent<HomeProps, RState>() {

  var locale = getDefaultLocale()

  val resources: Resources
    get() = locale.resources

  override fun RBuilder.render() {
    mCssBaseline()

    @Suppress("UnsafeCastFromDynamic")
    val themeOptions: ThemeOptions =
      js("({palette: { type: 'placeholder', primary: {main: 'placeholder'}}})")
    themeOptions.palette?.type = "light"
    themeOptions.palette?.primary.main = Colors.DeepPurple.shade500.value

    mThemeProvider(createMuiTheme(themeOptions)) {
      styledDiv {
        css {
          padding(16.px)
        }

        mAppBar {
          mToolbar {
            mToolbarTitle("Six by Nine Apps")
          }
          homeTabs(createContext())
        }

        mPaper {
          css {
            display = Display.flex
            padding(16.px)
            marginTop = 112.px
          }
          mTypography(resources.getString(strings.Intro))
        }
      }
    }
  }
}

private fun getDefaultLocale(): Locale {
  for (language in window.navigator.languages) {
    val code = if ('-' in language) {
      language.substring(0, language.indexOf('-'))
    } else {
      language
    }
    Locale.values().firstOrNull { it.language == code }?.let { return it }
  }
  return Locale.ENGLISH
}

private fun createContext() = object: Context {
  override val resources: Resources
    get() = getDefaultLocale().resources
}

fun RBuilder.home(): ReactElement {
  return child(Home::class) {}
}

external interface HomeProps : RProps {
  var defaultLocale: Locale
}
