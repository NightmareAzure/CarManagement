package dataBase

import (
	"fmt"
	"gorm.io/gorm"
)

type Customer struct {
	Customer_id   string
	Customer_name string
	Customer_type string
	Discount      float32
	Linkman       string
	Phone         string
}
type Car struct {
	Car_id      string
	Car_colour  string
	Car_model   string
	Car_type    string
	Customer_id string
}
type Clerk struct {
	Clerk_id   string
	Clerk_name string
}
type Repairman struct {
	Repairman_id   string
	Repairman_name string
	Repairman_type string
}
type Item struct {
	Item_id       string
	Item_name     string
	Item_hour     float32
	Cost_labor    float32
	Cost_material float32
	Repairman_id  string
}

//1.添加新的用户
func addcustomer(db *gorm.DB) {
	customer := Customer{
		Customer_id:   "GS0054",
		Customer_name: "白泽",
		Customer_type: "个人",
		Discount:      0.89,
		Linkman:       "白泽",
		Phone:         "98729862",
	}
	db.Create(&customer)
}

//2.添加新车
func addcar(db *gorm.DB) {
	car := Car{
		Car_id:      "9U341",
		Car_colour:  "绿色",
		Car_model:   "卡罗拉",
		Car_type:    "中型车",
		Customer_id: "GS0054",
	}
	db.Create(&car)
}

//3.选择某一用户所拥有的所有的车
func showcars(db *gorm.DB) {
	var customer Customer
	customer_name := "杨轩"
	db.Where("customer_name=?", customer_name).Find(&customer)
	fmt.Printf("customer.Customer_id: %v\n", customer.Customer_id)
	var cars []Car
	db.Where("Customer_id=?", customer.Customer_id).Find(&cars)
	for _, car := range cars {
		fmt.Printf("car.Car_id: %v\n", car.Car_id)
	}
}

//4.选择业务员
func showclerk(db *gorm.DB) {
	var clerks []Clerk
	db.Find(&clerks)
	for _, clerk := range clerks {
		fmt.Printf("clerk.Clerk_id: %v\n", clerk.Clerk_id)
		fmt.Printf("clerk.Clerk_name: %v\n", clerk.Clerk_name)
		fmt.Println("-------------------------------------")
	}
}

//5.根据维修项目选择维修员
func ShowRepairman(db *gorm.DB) {
	var item Item
	item_name := "汽车美容"
	db.Where("Item_name=?", item_name).Find(&item)
	fmt.Printf("item.Repairman_id: %v\n", item.Repairman_id)

	var repairman Repairman
	db.Where("Repairman_id=?", item.Repairman_id).Find(&repairman)
	fmt.Printf("repairman.Repairman_name: %v\n", repairman.Repairman_name)
	fmt.Printf("repairman.Repairman_type: %v\n", repairman.Repairman_type)
}
