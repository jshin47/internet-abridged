package spa.client.modules

import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import spa.client.SPAMain._
import spa.client.components.Bootstrap.CommonStyle
import spa.client.components.Icon._
import spa.client.components._
import spa.client.services._
import spa.shared.TabId._

import scalacss.ScalaCssReact._

object MainMenu {
  // shorthand for styles
  @inline private def bss = GlobalStyles.bootstrapStyles

  case class Props(router: RouterCtl[Loc], currentLoc: Loc = HomeLoc)//, proxy: ModelProxy[Option[Int]])

  private case class MenuItem(idx: Int, label: (Props) => ReactNode, icon: Icon, location: Loc)

  // build the Todo menu item, showing the number of open todos
  /*private def buildTodoMenu(props: Props): ReactElement = {
    val todoCount = props.proxy().getOrElse(0)
    <.span(
      <.span("Todo "),
      todoCount > 0 ?= <.span(bss.labelOpt(CommonStyle.danger), bss.labelAsBadge, todoCount)
    )
  }*/

  private val menuItems = Seq(
    MenuItem(1, _ => "Home", Icon.home, HomeLoc),//rss? code fork?
    MenuItem(2, _ => "About", Icon.info, AboutLoc)
    //MenuItem(3, _ => "Todos", Icon.check, TodoLoc),//link for external page?

  )

  private class Backend($: BackendScope[Props, Unit]) {
    /*def mounted(props: Props) =
      // dispatch a message to refresh the todos
      Callback.ifTrue(props.proxy.value.isEmpty, props.proxy.dispatch(RefreshTodos))*/

    def render(props: Props) = {
      <.ul(bss.navbar)(
        // build a list of menu items
        for (item <- menuItems) yield {
          <.li(^.key := item.idx, (props.currentLoc == item.location) ?= (^.className := "active"),
            props.router.link(item.location)(item.icon, " ", item.label(props))
          )
        }
      )
    }
  }

  private val component = ReactComponentB[Props]("MainMenu")
    .renderBackend[Backend]
    //.componentDidMount(scope => {scope.backend.mounted(scope.props)})
    .build

  def apply(ctl: RouterCtl[Loc], currentLoc: Loc/*, proxy: ModelProxy[Option[Int]]*/): ReactElement =
    component(Props(ctl, currentLoc/*, proxy*/))
}
