package main

import (
	"zadanie-4/controllers"
	"zadanie-4/models"
	"zadanie-4/routes"

	"github.com/labstack/echo/v4"
	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
)

func initDB() *gorm.DB {
	db, err := gorm.Open(sqlite.Open("products.db"), &gorm.Config{})
	if err != nil {
		panic("failed to connect database")
	}
	db.AutoMigrate(&models.Product{})
	return db
}

func main() {
	db := initDB()
	e := echo.New()

	productController := controllers.NewProductController(db)

	routes.RegisterProductRoutes(e, productController)

	e.Logger.Fatal(e.Start(":8080"))
}
