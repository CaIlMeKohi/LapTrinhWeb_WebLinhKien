Bạn là Senior Java Full Stack Architect và Software Engineer.

Tôi cần bạn tạo một project website thương mại điện tử bán linh kiện điện tử theo đúng file design/specification của tôi. Project phải chạy được trong Eclipse IDE bằng Maven và Apache Tomcat.

Tên project:

```text
electronic-store
```

## 1. Công nghệ bắt buộc

Backend bắt buộc dùng:

* Java 17
* Spring MVC truyền thống
* Không dùng Spring Boot
* Hibernate ORM
* PostgreSQL
* Maven
* JSP
* JSTL
* Jakarta Servlet
* Jakarta Validation
* Jakarta Mail

Frontend bắt buộc dùng:

* HTML5
* CSS3
* TailwindCSS
* Vanilla JavaScript
* Chart.js cho dashboard admin

## 2. Các công nghệ bị cấm tuyệt đối

Không được dùng:

* Spring Boot
* React
* Vue
* Angular
* NextJS
* NuxtJS
* REST API
* Fetch API
* Axios
* JWT
* Local Storage Authentication
* Firebase

Tất cả chức năng phải dùng form submit truyền thống:

```html
<form action="" method="">
```

Controller chỉ dùng:

```java
@Controller
@RequestMapping
@GetMapping
@PostMapping
```

Không tạo REST Controller.

Không dùng `@RestController`.

Không dùng JSON API.

## 3. Mục tiêu dự án

Hãy tạo một website e-commerce bán linh kiện điện tử hoàn chỉnh, có:

* Trang chủ giống trải nghiệm và bố cục của Hshop.vn nhưng không copy source code.
* Đăng ký, đăng nhập, xác thực OTP qua email.
* Quên mật khẩu bằng OTP email.
* Trang cá nhân.
* Danh mục sản phẩm.
* Danh sách sản phẩm.
* Chi tiết sản phẩm.
* Giỏ hàng.
* Checkout.
* Đơn hàng của khách hàng.
* Blog.
* Admin dashboard.
* Admin CRUD sản phẩm.
* Admin CRUD danh mục.
* Admin quản lý khách hàng.
* Admin quản lý đơn hàng.
* Admin quản lý blog.
* Admin xem doanh thu/thống kê.
* Trang lỗi 404, 403, 500.

Project phải có kiến trúc sạch, compile được bằng:

```bash
mvn clean install
```

và chạy được trên Eclipse + Tomcat + PostgreSQL.

## 4. Yêu cầu quan trọng về cách làm

Trước khi tạo code, hãy kiểm tra project hiện tại.

Nếu project đã có sẵn file/folder thì hãy bám theo cấu trúc hiện có nhưng vẫn phải chỉnh về đúng cấu trúc yêu cầu.

Nếu project còn trống, hãy tạo đúng cấu trúc sau:

```text
electronic-store

├── pom.xml
│
├── database
│   └── schema.sql
│
├── src/main/java
│
│   ├── config
│   │   ├── AppConfig.java
│   │   ├── HibernateConfig.java
│   │   ├── SecurityConfig.java
│   │   └── WebMvcConfig.java
│   │
│   ├── controller
│   │
│   ├── dao
│   │
│   ├── dto
│   │
│   ├── entity
│   │
│   ├── repository
│   │
│   ├── service
│   │
│   ├── service/impl
│   │
│   ├── validator
│   │
│   └── util
│
└── src/main/webapp
    │
    ├── assets
    │   ├── css
    │   ├── js
    │   ├── images
    │   └── icons
    │
    ├── WEB-INF
    │   └── views
    │       ├── layouts
    │       │   ├── header.jsp
    │       │   ├── navbar.jsp
    │       │   ├── sidebar.jsp
    │       │   ├── footer.jsp
    │       │   └── admin-sidebar.jsp
    │       │
    │       └── pages
    │           ├── home
    │           ├── auth
    │           ├── profile
    │           ├── product
    │           ├── category
    │           ├── cart
    │           ├── order
    │           ├── blog
    │           ├── admin
    │           └── error
    │
    └── index.jsp
```

Không được tạo lung tung package ngoài cấu trúc này nếu không cần thiết.

## 5. Quy tắc JSP layout

Tất cả JSP page phải dùng include layout, không được lặp lại header/navbar/footer.

Mỗi page nên include:

```jsp
<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
<jsp:include page="/WEB-INF/views/layouts/navbar.jsp"/>
<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>
```

Trang admin phải dùng thêm:

```jsp
<jsp:include page="/WEB-INF/views/layouts/admin-sidebar.jsp"/>
```

Không viết CSS inline lặp lại ở từng JSP.

CSS chính đặt tại:

```text
src/main/webapp/assets/css/style.css
src/main/webapp/assets/css/admin.css
```

JavaScript đặt tại:

```text
src/main/webapp/assets/js/main.js
src/main/webapp/assets/js/admin.js
```

## 6. Database PostgreSQL

Tạo file:

```text
database/schema.sql
```

Schema phải đầy đủ các bảng chính sau:

### users

Fields:

```text
id
fullname
email
password
phone
address
avatar
role
status
email_verified
otp_code
otp_expired_at
last_login
created_at
updated_at
```

Role:

```text
ADMIN
CUSTOMER
```

Status:

```text
PENDING
VERIFIED
ACTIVE
INACTIVE
```

### categories

Fields:

```text
id
name
slug
description
image
status
created_at
```

### products

Fields:

```text
id
name
slug
sku
price
quantity
description
specification
image
status
category_id
created_at
updated_at
```

### carts

Fields:

```text
id
user_id
created_at
```

### cart_items

Fields:

```text
id
cart_id
product_id
quantity
price
```

### orders

Fields:

```text
id
user_id
total_amount
shipping_address
phone
note
status
created_at
```

### order_items

Fields:

```text
id
order_id
product_id
quantity
price
```

### blogs

Fields:

```text
id
title
slug
thumbnail
content
created_at
```

Ngoài các bảng bắt buộc trên, có thể thêm bảng sau nếu cần cho hệ thống chạy tốt hơn:

```text
password_reset_otps
email_logs
settings
```

Nhưng không làm phức tạp quá mức.

## 7. Entity Hibernate

Tạo entity tương ứng:

* User
* Category
* Product
* Cart
* CartItem
* Order
* OrderItem
* Blog

Có enum:

* UserRole
* UserStatus
* ProductStatus
* CategoryStatus
* OrderStatus

Dùng:

* `Long` cho id
* `BigDecimal` cho tiền
* `Integer` cho quantity
* `LocalDateTime` cho thời gian
* `Boolean` cho emailVerified

Không lưu password plain text.

## 8. Cấu hình Spring MVC

Tạo đầy đủ config:

### AppConfig.java

Cấu hình component scan.

### WebMvcConfig.java

Cấu hình:

* ViewResolver cho JSP
* Static resources cho `/assets/**`
* Multipart resolver nếu cần upload ảnh

### HibernateConfig.java

Cấu hình Hibernate + PostgreSQL:

* DataSource
* SessionFactory hoặc EntityManagerFactory
* TransactionManager
* Hibernate properties
* PostgreSQL dialect

Thông tin database để trong config dễ sửa:

```text
database name: electronic_store
username: postgres
password: postgres
host: localhost
port: 5432
```

Nếu cần, hãy để comment rõ chỗ đổi username/password.

### SecurityConfig.java

Không dùng Spring Security phức tạp nếu chưa cần.

Dùng session-based auth bằng interceptor/filter.

## 9. Authentication bằng Session

Khi login thành công:

```java
session.setAttribute("user", user);
```

Khi logout:

```java
session.invalidate();
```

Không dùng JWT.

Không dùng localStorage.

Không dùng token authentication.

Tạo filter hoặc interceptor:

* Chặn `/admin/**` nếu chưa đăng nhập.
* Chặn `/admin/**` nếu user không phải ADMIN.
* Chặn `/profile/**`, `/cart/**`, `/checkout/**`, `/orders/**` nếu chưa đăng nhập.
* Nếu không đủ quyền thì redirect `/error/403`.

## 10. Register system

Route:

```text
GET  /auth/register
POST /auth/register
```

Form phải có:

```text
Full Name
Email
Password
Confirm Password
```

Flow:

1. Validate thông tin.
2. Kiểm tra email trùng.
3. Hash password.
4. Generate OTP 6 chữ số.
5. OTP hết hạn sau 5 phút.
6. Lưu user với status `PENDING`, `email_verified = false`.
7. Gửi OTP qua Jakarta Mail.
8. Redirect sang trang verify OTP.

Form action:

```html
<form action="/auth/register" method="post">
```

## 11. Email OTP verification

Route:

```text
GET  /auth/verify-otp
POST /auth/verify-otp
```

Form action:

```html
<form action="/auth/verify-otp" method="post">
```

Logic:

* User nhập email + OTP.
* Kiểm tra OTP đúng.
* Kiểm tra OTP chưa hết hạn.
* Nếu đúng:

  * `email_verified = true`
  * `status = VERIFIED`
  * Xóa hoặc làm rỗng OTP.
  * Gửi welcome email.
  * Redirect login.
* Nếu sai:

  * Hiển thị lỗi rõ ràng.

## 12. Jakarta Mail EmailService

Tạo:

```java
EmailService
EmailServiceImpl
```

Methods:

```java
sendOtp(String toEmail, String otp)
sendWelcomeEmail(String toEmail, String fullname)
sendForgotPasswordOtp(String toEmail, String otp)
```

Nếu chưa cấu hình SMTP thật, hãy để thông số trong class config hoặc properties dễ sửa.

Không làm app crash khi gửi mail lỗi. Hãy log lỗi và hiển thị thông báo phù hợp.

## 13. Login system

Route:

```text
GET  /auth/login
POST /auth/login
GET  /auth/logout
```

Form action:

```html
<form action="/auth/login" method="post">
```

Logic:

* Kiểm tra email/password.
* Chỉ user đã verify mới được login.
* Nếu status PENDING hoặc email_verified = false thì yêu cầu xác thực OTP.
* Nếu INACTIVE thì không cho đăng nhập.
* Nếu đúng thì lưu user vào session.
* Cập nhật last_login.
* Redirect theo role:

  * ADMIN → `/admin/dashboard`
  * CUSTOMER → `/`

## 14. Forgot password bằng OTP

Routes:

```text
GET  /auth/forgot-password
POST /auth/forgot-password

GET  /auth/forgot-password/verify
POST /auth/forgot-password/verify

GET  /auth/reset-password
POST /auth/reset-password
```

Flow:

1. Nhập email.
2. Kiểm tra email tồn tại.
3. Tạo OTP 6 số.
4. OTP hết hạn 5 phút.
5. Gửi OTP qua email.
6. Nhập OTP.
7. Nếu OTP đúng thì cho nhập mật khẩu mới.
8. Hash mật khẩu mới.
9. Redirect login.

Không dùng reset token URL.

## 15. Header user menu

Trong `navbar.jsp`:

Nếu chưa login, hiển thị:

```text
Login
Register
Cart
```

Nếu đã login, hiển thị:

```text
👤 Full Name
```

Có dropdown:

```text
Thông tin cá nhân
Đơn hàng của tôi
Đổi mật khẩu
Đăng xuất
```

Dùng icon user, có thể dùng Font Awesome class:

```text
fa-user-gear
```

hoặc SVG tương đương.

## 16. Profile page

Route:

```text
GET  /profile
POST /profile/update
POST /profile/change-password
```

Customer có thể:

* Update avatar
* Update fullname
* Update phone
* Update address
* Change password

Validate input.

## 17. Home page design

Trang chủ phải có layout giống trải nghiệm Hshop.vn nhưng code phải tự viết, không copy source.

Yêu cầu sections:

### Top Header

Hiển thị:

* Hotline
* Email
* Support

### Main Header

Hiển thị:

* Logo
* Search bar
* Cart
* User menu

Header phải sticky.

### Navigation

Có mega menu desktop.

Danh mục bắt buộc:

```text
Arduino
ESP32
STM32
Raspberry Pi
Module
Sensor
Relay
Motor
Display
IC
Power Supply
Electronic Components
```

Mobile phải có off canvas menu.

### Hero Section

Large Banner Slider:

* Auto slide
* Previous button
* Next button
* Indicators

Bên dưới có promotional banners.

### Category Section

Grid category card:

* Image
* Name
* Product count

### Featured Products

Product card có:

* Product image
* Product name
* Price
* Stock status
* View Detail
* Add To Cart

### New Arrivals

Responsive product grid.

### Best Sellers

Responsive product grid.

### Flash Sale

Hiển thị:

* Discount
* Countdown
* Hot Deal

### Blog Section

Card gồm:

* Thumbnail
* Title
* Date
* Short description

### Footer

Gồm:

* Contact
* About
* Shipping Policy
* Warranty Policy
* Privacy Policy
* Social Media

## 18. Design system

Dùng font:

```css
font-family:
-apple-system,
BlinkMacSystemFont,
Segoe UI,
Roboto,
Helvetica Neue,
Arial,
sans-serif;
```

Base font:

```text
14px
```

Font scale:

```text
14px
16px
18px
20px
24px
```

Dùng CSS variables:

```css
:root{
  --text-primary:#000080;
  --surface-base:#000000;
  --text-tertiary:#000f8f;
  --text-inverse:#ffffff;
  --surface-muted:#f2f2f2;
}
```

Không hardcode màu lặp lại nhiều nơi.

## 19. Product module

Routes:

```text
GET /products
GET /products/{slug}
GET /categories/{slug}
GET /search
```

Chức năng:

* Danh sách sản phẩm.
* Chi tiết sản phẩm.
* Lọc theo category.
* Tìm kiếm theo keyword.
* Hiển thị giá.
* Hiển thị tồn kho.
* Nút add to cart bằng form POST.
* Product detail hiển thị specification.

Product card phải có:

* Image
* Name
* Price
* Stock status
* View detail
* Add to cart

## 20. Cart module

Routes:

```text
GET  /cart
POST /cart/add
POST /cart/update
POST /cart/remove
POST /cart/clear
```

Chức năng:

* Add to cart.
* Update quantity.
* Remove item.
* Clear cart.
* Tính subtotal.
* Không cho add nếu product hết hàng.
* Không cho quantity <= 0.
* Tất cả actions dùng form submit, không dùng fetch/ajax.

## 21. Checkout module

Routes:

```text
GET  /checkout
POST /checkout
```

Form:

```text
Recipient Name
Phone
Address
Note
```

Logic:

* Bắt buộc đăng nhập.
* Kiểm tra cart không rỗng.
* Kiểm tra tồn kho.
* Tạo order.
* Tạo order_items.
* Trừ quantity sản phẩm.
* Clear cart.
* Redirect order success page.

## 22. Order module customer

Routes:

```text
GET /orders
GET /orders/{id}
```

Customer chỉ xem được đơn của chính mình.

Hiển thị:

* Mã đơn
* Ngày đặt
* Tổng tiền
* Trạng thái
* Danh sách sản phẩm
* Địa chỉ giao hàng
* Số điện thoại
* Ghi chú

## 23. Blog module

Routes:

```text
GET /blogs
GET /blogs/{slug}
```

Hiển thị:

* Danh sách blog
* Chi tiết blog
* Thumbnail
* Title
* Date
* Short description

## 24. Admin system

Chỉ role ADMIN được vào `/admin/**`.

Admin sidebar gồm:

```text
Dashboard
Products
Categories
Orders
Customers
Blogs
Revenue
Settings
```

## 25. Admin dashboard

Route:

```text
GET /admin/dashboard
```

Hiển thị statistics cards:

* Total Products
* Total Categories
* Total Users
* Total Orders
* Revenue

Charts:

* Revenue By Month
* Orders By Month

Dùng Chart.js.

Nếu chưa có đủ dữ liệu thật, service vẫn phải có method rõ ràng, có thể trả về số 0 hoặc danh sách rỗng.

## 26. Admin product management

Routes:

```text
GET  /admin/products
GET  /admin/products/create
POST /admin/products/create
GET  /admin/products/edit/{id}
POST /admin/products/edit/{id}
POST /admin/products/delete/{id}
```

Chức năng:

* CRUD product.
* Search product.
* Pagination cơ bản.
* Image upload hoặc lưu image path.
* Validate name, sku, price, quantity.
* Slug tự sinh từ name.
* Không xóa cứng nếu không cần, có thể đổi status INACTIVE.

## 27. Admin category management

Routes:

```text
GET  /admin/categories
GET  /admin/categories/create
POST /admin/categories/create
GET  /admin/categories/edit/{id}
POST /admin/categories/edit/{id}
POST /admin/categories/delete/{id}
```

Chức năng:

* CRUD category.
* Slug tự sinh.
* Validate name.
* Upload hoặc lưu image path.
* Bật/tắt status.

## 28. Admin user/customer management

Routes:

```text
GET  /admin/customers
GET  /admin/customers/{id}
POST /admin/customers/lock/{id}
POST /admin/customers/unlock/{id}
POST /admin/customers/delete/{id}
```

Chức năng:

* Xem danh sách customer.
* Tìm theo email/fullname/phone.
* Xem chi tiết customer.
* Lock account.
* Unlock account.
* Không xóa cứng nếu không cần, đổi status INACTIVE.

## 29. Admin order management

Routes:

```text
GET  /admin/orders
GET  /admin/orders/{id}
POST /admin/orders/update-status/{id}
```

Chức năng:

* Xem danh sách order.
* Xem chi tiết order.
* Cập nhật trạng thái order.

Order status gợi ý:

```text
PENDING
CONFIRMED
SHIPPING
COMPLETED
CANCELLED
```

## 30. Admin blog management

Routes:

```text
GET  /admin/blogs
GET  /admin/blogs/create
POST /admin/blogs/create
GET  /admin/blogs/edit/{id}
POST /admin/blogs/edit/{id}
POST /admin/blogs/delete/{id}
```

Chức năng:

* CRUD blog.
* Slug tự sinh.
* Thumbnail.
* Content.

## 31. Admin revenue/settings

Routes:

```text
GET /admin/revenue
GET /admin/settings
POST /admin/settings
```

Revenue page:

* Tổng doanh thu.
* Doanh thu theo tháng.
* Số đơn theo tháng.

Settings page:

* Store name.
* Store email.
* Hotline.
* Shipping policy.
* Warranty policy.

Nếu chưa tạo bảng settings thì có thể tạo entity Setting dạng key-value.

## 32. Validation

Dùng Jakarta Validation.

Validate:

* Email đúng định dạng.
* Password không rỗng, tối thiểu 6 ký tự.
* Confirm password trùng.
* Phone không rỗng.
* Quantity > 0.
* Price >= 0.
* Required fields.

Hiển thị validation messages trong JSP.

## 33. Accessibility

Giao diện phải hỗ trợ WCAG 2.2 AA ở mức cơ bản:

* Có label cho input.
* Có alt text cho image.
* Có focus visible.
* Có hover state.
* Có active state.
* Có disabled state.
* Có error state.
* Có loading state nếu có submit.
* Điều hướng keyboard dùng được.
* Button có text rõ ràng.

## 34. Error pages

Tạo:

```text
src/main/webapp/WEB-INF/views/pages/error/404.jsp
src/main/webapp/WEB-INF/views/pages/error/403.jsp
src/main/webapp/WEB-INF/views/pages/error/500.jsp
```

Cấu hình web.xml hoặc MVC để điều hướng lỗi.

## 35. Yêu cầu code quality

Bắt buộc:

* Code phải compile.
* Không thiếu import.
* Không tạo class trùng tên.
* Không viết SQL trong JSP.
* Không xử lý nghiệp vụ trong JSP.
* Controller mỏng.
* Service chứa business logic.
* DAO/Repository xử lý DB.
* Dùng transaction cho thao tác create/update/delete.
* Redirect sau POST để tránh submit lại form.
* Tên biến/method rõ nghĩa.
* Có comment TODO ở chỗ cần cấu hình SMTP/PostgreSQL thật.
* Không hardcode quá nhiều dữ liệu trong controller.
* Không dùng scriptlet Java trong JSP, ưu tiên JSTL/EL.

## 36. Thứ tự triển khai

Hãy triển khai theo phase để tránh lỗi lớn.

### Phase 1: Project foundation

Tạo:

* pom.xml
* database/schema.sql
* AppConfig.java
* WebMvcConfig.java
* HibernateConfig.java
* SecurityConfig.java
* web.xml nếu cần
* layout JSP
* CSS/JS base
* error pages

Đảm bảo project compile.

### Phase 2: Entity + DAO + Service base

Tạo:

* Entities
* Enums
* DAO/Repository
* Service interface
* Service implementation
* Utility: PasswordUtil, SlugUtil, OtpUtil

Đảm bảo compile.

### Phase 3: Auth

Tạo:

* Register
* Verify OTP
* Login
* Logout
* Forgot password
* Reset password
* EmailService

Đảm bảo flow chạy được bằng form submit.

### Phase 4: Customer pages

Tạo:

* Home
* Product list
* Product detail
* Category page
* Search
* Profile
* Blog list/detail

### Phase 5: Cart + Checkout + Orders

Tạo:

* Cart
* Add/update/remove/clear cart
* Checkout
* Create order
* Order history
* Order detail

### Phase 6: Admin

Tạo:

* Dashboard
* Product CRUD
* Category CRUD
* Customer management
* Order management
* Blog CRUD
* Revenue
* Settings

Sau mỗi phase hãy kiểm tra compile.

## 37. Kết quả sau khi code

Sau khi tạo/sửa code, hãy báo cáo rõ:

1. Đã tạo/sửa những file nào.
2. Phase nào đã hoàn thành.
3. URL nào có thể chạy thử.
4. Cách import project vào Eclipse.
5. Cách cấu hình PostgreSQL.
6. Cách chạy trên Tomcat.
7. Lệnh build Maven.
8. Tài khoản admin mặc định nếu có seed data.
9. Những TODO còn lại nếu có.

## 38. Yêu cầu cuối cùng

Hãy bắt đầu bằng Phase 1 và Phase 2 trước.

Sau khi Phase 1 và Phase 2 compile ổn, tiếp tục làm Phase 3.

Không cố nhồi tất cả vào một file.

Không bỏ qua cấu hình Maven/Spring MVC/Hibernate.

Không dùng Spring Boot.

Không dùng REST API.

Không dùng Fetch API/Axios.

Không dùng JWT.

Mục tiêu là project chạy được trực tiếp trên Eclipse + Maven + Tomcat + PostgreSQL.
