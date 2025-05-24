package routes

import (
	"zadanie-4/controllers"

	"github.com/labstack/echo/v4"
)

func RegisterProductRoutes(e *echo.Echo, productController *controllers.ProductController) {
	e.POST("/products", productController.CreateProduct)
	e.GET("/products", productController.GetProducts)
	e.GET("/products/:id", productController.GetProduct)
	e.PUT("/products/:id", productController.UpdateProduct)
	e.DELETE("/products/:id", productController.DeleteProduct)
}
