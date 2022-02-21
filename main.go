package main

import (
	/*	. "ProjectCar/dataBase"*/
	"fmt"
	"github.com/gin-gonic/gin"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	/*	"gorm.io/driver/mysql"
		"gorm.io/gorm"*/
	"net/http"
)

/*func loadTemplates(templatesDir string) multitemplate.Renderer { //Gin框架下渲染模板
	r := multitemplate.NewRenderer()
	layouts, err := filepath.Glob(templatesDir + "/layouts/*.tmpl")
	if err != nil {
		panic(err.Error())
	}
	includes, err := filepath.Glob(templatesDir + "/includes/*.tmpl")
	if err != nil {
		panic(err.Error())
	}
	// 为layouts/和includes/目录生成 templates map
	for _, include := range includes {
		layoutCopy := make([]string, len(layouts))
		copy(layoutCopy, layouts)
		files := append(layoutCopy, include)
		r.AddFromFiles(filepath.Base(include), files...)
	}
	return r
}*/

func indexFunc(c *gin.Context) {
	c.HTML(http.StatusOK, "index.tmpl", nil)
}

func addCarsFunc(c *gin.Context) {
	c.HTML(http.StatusOK, "addCars.html", nil)
}

func addComponentFunc(c *gin.Context) {
	c.HTML(http.StatusOK, "addComponent.html", nil)
}

func checkCarsFunc(c *gin.Context) {
	c.HTML(http.StatusOK, "checkCars.tmpl", nil)
}

func clientHistoryFunc(c *gin.Context) {
	c.HTML(http.StatusOK, "clientHistory.html", nil)
}

func loginFunc(c *gin.Context) {
	c.HTML(http.StatusOK, "login.html", nil)
}

func loginpostFunc(c *gin.Context) {
	// 如果取不到则取默认值
	username := c.DefaultPostForm("username", "somebody")
	password := c.DefaultPostForm("pwd", "******")
	typeofuser := c.DefaultPostForm("type", "notype")

	c.JSON(http.StatusOK, gin.H{
		"Name":     username,
		"Password": password,
		"Type":     typeofuser,
	})
}

func addCarpostFunc(c *gin.Context) {
	// 如果取不到则取默认值
	Code := c.DefaultPostForm("Code", "noCar")
	Model := c.DefaultPostForm("Model", "noModel")
	Brand := c.DefaultPostForm("Brand", "noBrand")
	Area := c.DefaultPostForm("Area", "noArea")
	Date := c.DefaultPostForm("Date", "noDate")

	c.JSON(http.StatusOK, gin.H{
		"Code":  Code,
		"Model": Model,
		"Brand": Brand,
		"Area":  Area,
		"Date":  Date,
	})
}

func main() {
	/*	dsn := "root:111111@tcp(127.0.0.1:3306)/car_db?charset=utf8mb4&parseTime=True&loc=Local"
		db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})
		if err != nil {
			pnc := "failed to connect"
			fmt.Println(pnc)
		}
		ShowRepairman(db)*/
	// 定义一个路由
	r := gin.Default()
	// 引用静态文件
	r.Static("/xxx", "./statics")
	r.LoadHTMLGlob("./templates/**/*")
	/*	r.HTMLRender = loadTemplates("./templates")*/

	r.GET("/index", indexFunc)
	r.GET("/addCars", addCarsFunc)
	r.POST("/addCars", addCarpostFunc)
	r.GET("/addComponent", addComponentFunc)
	r.GET("/clientHistory", clientHistoryFunc)
	r.GET("/checkCars", checkCarsFunc)
	r.GET("/login", loginFunc)
	r.POST("/login", loginpostFunc)

	err := r.Run(":9090")
	if err != nil {
		fmt.Println("Failed to connect.")
	}
}
