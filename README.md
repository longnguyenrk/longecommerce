
# Agricultural Products Ecommerce

Agricultural Products Ecommerce Application Web using Spring MVC


## Main Dependencies

- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL - connector
- Spring Mail
- JSTL
- Bootstrap

## Role
-   User
-   Admin
## Functions
- Users: 
    - Register/ Login validate
    - Password Encoder Bcrypt
    - Views Profile, update info, change Password
    - Views User's Orders Details
    - Email after Register
    - Product search, filter, sorting
    - Product show All Products, show Product by Category, Featured Product, New Products
    - Shopping Cart: Add product to Cart, change quantity of products, remove items, remove all items 
    - Views Quantity and Total Price of Shopping Cart in header
    - Product Details, Related Products
    - Create Order
    - Checkout with COD or Payment Credit Card
    - Show Order Details
    - Email after Check out Success
- Admin:
    - Category: Add, update, show all Category
    - Product: Add, update, hide or display, search, show all products, show products by Category, filter, sorting
    - Account: Add, update, change status account, search, show all account
    - Order: View Order Total, Order Details, change Order's status ( Success or Pending)
## Link
- Admin Page Link:
    - /admin/list-account - Account Management Page
    - /admin/updateAccount(?id=) - Update Account Page
    - /admin/trang-chu - Admin Home Page
    - /admin/list-category - Category Management Page
    - /admin/addCategory - Add Category Page
    - /admin/updateCategory(?idCategory=) - Update Category Page
    - /admin/list-product - Product Management Page
    - /admin/addProduct - Add Product Page
    - /admin/updateProduct(?idProduct=) - Update Product Page
    - /admin/listOrder - Order Management Page
    - /admin/detailsOrder(?idOrder=) - Order Details Page
- User Page Link:
    -  /trang-chu - Home Page
    -  /authen/register - Register Page
    -  /authen/login - Login Page
    -  /shop-gird - Shop Gird All Products
    -  /shopGridByCategory(?idCategory=) - Shop Gird Show Products by Category
    -  /product-detail(?idProduct=) - Product Detail Page
    -  /shopingcart - Shopping Cart Page
    -  /checkOut(?idAccount=) - Check Out Page
    -  /paymentCard - Payment Credit Card Page
    