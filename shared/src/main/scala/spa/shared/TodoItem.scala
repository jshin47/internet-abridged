package spa.shared

import boopickle.Default._

sealed trait TodoPriority

case object TodoLow extends TodoPriority

case object TodoNormal extends TodoPriority

case object TodoHigh extends TodoPriority

case class TodoItem(id: String, timeStamp: Int, content: String, priority: TodoPriority, completed: Boolean)

object TodoPriority {
  implicit val todoPriorityPickler: Pickler[TodoPriority] = generatePickler[TodoPriority]
}


case class LinkObject(id: Option[Long], sourceId: String, title: String, href: String)

object TabId{
  val Reddit = "Reddit"
  val RedditTop = "RedditTop"
  val RedditTil = "RedditTil"
  val AskReddit = "AskReddit"

  val RedditTech = "RedditTech"
  val LifeHacker = "LifeHacker"
  val RedditTechnology = "RedditTechnology"

  val RedditProgramming = "RedditProgramming"
  val HackerNews = "HackerNews"
  val RedditCoding = "RedditCoding"
  val RedditProgrammingHumor = "RedditProgrammingHumor"

  val RedditPics = "RedditPics"
  val RedditComics = "RedditComics"




  /*Maybe
  val Digg = "Digg"
  val GoogleNews = "GoogleNews"
  val GoogleNewsUS = "GoogleNewsUS"
  */
}


object TabFeedSources {
  val Reddit = "https://reddit.com/.rss"
  val RedditTop = "https://reddit.com/top/.rss"
  val RedditTil = "https://www.reddit.com/r/todayilearned/.rss"
  val AskReddit = "https://www.reddit.com/r/AskReddit/.rss"


  val RedditTech = "https://www.reddit.com/r/tech/.rss"
  val LifeHacker = "http://lifehacker.com/rss"
  val RedditTechnology = "https://www.reddit.com/r/technology/.rss"

  val RedditProgramming = "https://www.reddit.com/r/programming/.rss"
  val HackerNews = "https://news.ycombinator.com/rss"
  val RedditCoding = "https://www.reddit.com/r/coding/.rss"
  val RedditProgrammingHumor = "https://www.reddit.com/r/ProgrammerHumor/.rss"

  val RedditPics = "https://www.reddit.com/r/pics/.rss"
  val RedditComics = "https://www.reddit.com/r/comics/.rss"




  /* maybe
  val Digg = "https://digg.com"
  val GoogleNews = "https://news.google.com"
  val GoogleNewsUS = "https://news.google.com/news/section?pz=1&cf=all&topic=n&ict=ln"
  */
}