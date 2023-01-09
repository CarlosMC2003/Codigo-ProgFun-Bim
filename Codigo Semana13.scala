package progFun

import com.github.tototoshi.csv._
import java.io.File

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import com.cibo.evilplot.plot._
import com.cibo.evilplot.plot.aesthetics.DefaultTheme._

import play.api.libs.json._

object Main extends App {

  val reader = CSVReader.open(new File("C:\\Users\\SALA A\\Downloads\\movie_dataset.csv"))
  val data = reader.allWithHeaders()
  reader.close()

  val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
  val releaseDateList = data
    .map(row => row("release_date"))
    .filter(!_.equals(""))
    .map(text => LocalDate.parse(text, dateFormatter))

  val yearReleaseList = releaseDateList
    .map(_.getYear).map(_.toDouble)

  printf("Año menor: %.0f\n", yearReleaseList.min)
  printf("Año mayor: %.0f\n", yearReleaseList.max)

  /*Histogram(yearReleaseList)
    .title("Años de Lanzamiento")
    .xAxis()
    .yAxis()
    .xbounds(1916.0, 2018.0)
    .render().write(new File("C:\\Users\\SALA A\\Desktop\\Grafica.png"))
  */

  val productionCompanies = data
    .flatMap(row => row.get("production_companies"))
    .map(row => Json.parse(row))
    .flatMap(jsonData => jsonData \\ "name")
    .map(jsValue => jsValue.as[String])
    .groupBy(identity)
    .map {case (keyword, lista) => (keyword, lista.size) }
    .toList
    .sortBy(_._2)
    .reverse

  val pCompaniesValues = productionCompanies.take(10).map(_._2).map(_.toDouble)
  val pCompaniesLables = productionCompanies.take(10).map(_._1)

  BarChart(pCompaniesValues)
    .title("Compañias Productoras")
    .xAxis(pCompaniesLables)
    .yAxis()
    .frame()
    .yLabel("Productions")
    .bottomLegend()
    .render().write(new File("C:\\Users\\SALA A\\Desktop\\Grafica2.png"))

  /*implicit val theme = DefaultTheme.copy(
    elements = DefaultElements.copy(categoricalXAxisLabelOrientation = 45)
  )*/
}
