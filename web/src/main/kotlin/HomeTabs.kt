import HomeDestination.Home
import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.MTabVariant.*
import kotlinx.browser.window
import react.*
import res.Resources

class HomeTabs: RComponent<BaseProps, RState>() {

  private var selectedTab: Any = Home

  private val resources: Resources
    get() = props.context.resources

  override fun RBuilder.render() {
    /*themeContext.Consumer { theme ->
      styledDiv {
        css { flexGrow = 1.0; backgroundColor = Color(theme.palette.background.paper) }*/
          mTabs(
            selectedTab,
            onChange = { _, value -> setState { selectedTab = value } },
            variant = if (isLargeWidth) standard else fullWidth,
            centered = isLargeWidth
          ) {
            HomeDestination.values().forEach {
              mTab(resources.getString(it.label), it)
            }
          }
      //}
    //}
  }
}

val isLargeWidth: Boolean
  get() = window.innerWidth >= 600

fun RBuilder.homeTabs(context: Context) = child(HomeTabs::class) {
  attrs.context = context
}