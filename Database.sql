
use vshop
-- add account -- 
INSERT INTO `role` VALUES (1,'ADMIN','Quản trị'),(2,'acc','Người dùng');
INSERT INTO `vshop`.`account` (`address`, `email`, `fullName`, `password`, `phone`, `status`, `totalPrice`, `userName`, `idRole`) VALUES ('asd', 'a@a.a', 'a', '$2a$10$DBlJeD5o3MJrYGxNlUF2K.6fojpOhGlaXIzkpcLQ2t0.AYKYVBr/6', '12312', '1', '0', 'a', '1');
INSERT INTO `vshop`.`account` (`address`, `email`, `fullName`, `password`, `phone`, `status`, `totalPrice`, `userName`, `idRole`) VALUES ('asd1', 'a@a1.a', 'a1', '$2a$10$DBlJeD5o3MJrYGxNlUF2K.6fojpOhGlaXIzkpcLQ2t0.AYKYVBr/6', '12312', '1', '0', 'b', '2');

-- add category
INSERT INTO `vshop`.`category` ( `Category`, `descriptions`, `imgUrl`) VALUES ( 'Trái cây', 'Trái cây thu hoạch tại vườn ', '/resources/images/cat-1.jpg');
INSERT INTO `vshop`.`category` ( `Category`, `descriptions`, `imgUrl`) VALUES ( 'Rau củ quả', 'Rau trồng Oganic', '/resources/images/cat-3.jpg');
INSERT INTO `vshop`.`category` ( `Category`, `descriptions`, `imgUrl`) VALUES ( 'Thịt tươi', 'Thịt tươi áđá', '/resources/images/cat-5.jpg');



-- add sp
INSERT INTO `vshop`.`product` ( `Cost`, `Product`, `descriptions`, `imgUrl`, `quantity`, `shortdescription`, `soldQuantity`, `unit`, `weight`, `idCategory`) VALUES ('100000', 'Cam', 'Cam thu hoạch tại vườn', '/resources/images/cat-1.jpg', '50', 'Cam tươi', '0', 'kg', '1', '1');
INSERT INTO `vshop`.`product` (`Cost`, `Product`, `descriptions`, `imgUrl`, `quantity`, `shortdescription`, `soldQuantity`, `unit`, `weight`, `idCategory`) VALUES ( '30000', 'Xà lách', 'Xà lách ăn mì tôm', '/resources/images/thumb-2.jpg', '50', 'Xà lách tươi ngon', '0', 'g', '500', '2');
INSERT INTO `vshop`.`product` ( `Cost`, `Product`, `descriptions`, `imgUrl`, `quantity`, `shortdescription`, `soldQuantity`, `unit`, `weight`, `idCategory`) VALUES ('1000000', 'Thịt bò', 'Thịt bò ăn mì tôm', '/resources/images/product-1.jpg', '50', 'Thị bò kobe', '0', 'kg', '1', '3');