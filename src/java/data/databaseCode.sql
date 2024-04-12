/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Aaref, Luke, Tony
 * Created: Apr 12, 2024
 */
DROP DATABASE IF EXISTS FWRP;

CREATE DATABASE FWRP;
USE FWRP;

CREATE TABLE User (
    UserID INT AUTO_INCREMENT,
    UserType VARCHAR(255),
    Email VARCHAR(255),
    Username VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    PhoneNumber VARCHAR(15),
    IsSubed BOOLEAN,
    Balance DECIMAL(10, 2),
    LastLogin TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(UserID)
);

CREATE TABLE RetailerInventory (
    InventoryID INT AUTO_INCREMENT,
    UserID INT,
    FoodAmount INT,
    FoodName VARCHAR(255),
    Price DECIMAL(10, 2), 
    ExpirationDate DATE, 
    SurplusType VARCHAR(255),
    ItemAdded TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(InventoryID),
    FOREIGN KEY(UserID) REFERENCES User(UserID)
);

CREATE TABLE CharityInventory (
    InventoryID INT AUTO_INCREMENT,
    CharityID INT,
    Quantity INT,
    FoodName VARCHAR(255),
    ExpirationDate DATE, 
    ItemAdded TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(InventoryID),
    FOREIGN KEY(CharityID) REFERENCES User(UserID)
);

CREATE TABLE FavoriteInventory (
    FavoriteID INT AUTO_INCREMENT,
    UserID INT,
    InventoryID INT,
    FoodName VARCHAR(255),
    RetailerName VARCHAR(255),
    PRIMARY KEY(FavoriteID),
    FOREIGN KEY(UserID) REFERENCES User(UserID)
);
