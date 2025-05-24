package controllers

import (
	"zadanie-4/models"
	"net/http"
	"strconv"

	"github.com/labstack/echo/v4"
	"gorm.io/gorm"
)

type ProductController struct {
	DB *gorm.DB
}

func NewProductController(db *gorm.DB) *ProductController {
	return &ProductController{DB: db}
}

// POST /products
func (pc *ProductController) CreateProduct(c echo.Context) error {
	p := new(models.Product)
	if err := c.Bind(p); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}
	pc.DB.Create(&p)
	return c.JSON(http.StatusCreated, p)
}

// GET /products
func (pc *ProductController) GetProducts(c echo.Context) error {
	var products []models.Product
	pc.DB.Find(&products)
	return c.JSON(http.StatusOK, products)
}

// GET /products/:id
func (pc *ProductController) GetProduct(c echo.Context) error {
	id, _ := strconv.Atoi(c.Param("id"))
	var product models.Product
	result := pc.DB.First(&product, id)
	if result.Error != nil {
		return c.JSON(http.StatusNotFound, echo.Map{"error": "Product not found"})
	}
	return c.JSON(http.StatusOK, product)
}

// PUT /products/:id
func (pc *ProductController) UpdateProduct(c echo.Context) error {
	id, _ := strconv.Atoi(c.Param("id"))
	var product models.Product
	if pc.DB.First(&product, id).Error != nil {
		return c.JSON(http.StatusNotFound, echo.Map{"error": "Product not found"})
	}
	if err := c.Bind(&product); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}
	pc.DB.Save(&product)
	return c.JSON(http.StatusOK, product)
}

// DELETE /products/:id
func (pc *ProductController) DeleteProduct(c echo.Context) error {
	id, _ := strconv.Atoi(c.Param("id"))
	if err := pc.DB.Delete(&models.Product{}, id).Error; err != nil {
		return c.JSON(http.StatusInternalServerError, echo.Map{"error": "Failed to delete product"})
	}
	return c.NoContent(http.StatusNoContent)
}
