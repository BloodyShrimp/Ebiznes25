package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models.Product

@Singleton
class ProductController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  private var products = Seq(
    Product(1, "Laptop", 3499.99),
    Product(2, "Telefon", 1999.50)
  )

  def createProduct: Action[JsValue] = Action(parse.json) { request =>
    request.body.validate[Product].map { product =>
      if (products.exists(_.id == product.id)) {
        Conflict(Json.obj("error" -> "Produkt o takim ID już istnieje"))
      } else {
        products :+= product
        Created(Json.toJson(product))
      }
    }.getOrElse {
      BadRequest(Json.obj("error" -> "Nieprawidłowy format JSON"))
    }
  }

  def getAllProducts: Action[AnyContent] = Action {
    Ok(Json.toJson(products))
  }

  def getProduct(id: Long): Action[AnyContent] = Action {
    products.find(_.id == id) match {
      case Some(p) => Ok(Json.toJson(p))
      case None    => NotFound(Json.obj("error" -> "Nie znaleziono produktu"))
    }
  }

  def updateProduct(id: Long): Action[JsValue] = Action(parse.json) { request =>
    request.body.validate[Product].map { updated =>
      products.indexWhere(_.id == id) match {
        case -1 => NotFound(Json.obj("error" -> "Produkt nie istnieje"))
        case idx =>
          products = products.updated(idx, updated)
          Ok(Json.toJson(updated))
      }
    }.getOrElse {
      BadRequest(Json.obj("error" -> "Nieprawidłowy format JSON"))
    }
  }

  def deleteProduct(id: Long): Action[AnyContent] = Action {
    val beforeSize = products.size
    products = products.filterNot(_.id == id)
    if (products.size < beforeSize) NoContent
    else NotFound(Json.obj("error" -> "Nie znaleziono produktu"))
  }
}
