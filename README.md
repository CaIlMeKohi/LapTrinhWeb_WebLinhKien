# ElectroShop

Website ban linh kien dien tu trien khai theo mo hinh Spring MVC truyen thong,
chay tren Tomcat va phu hop de import vao Eclipse IDE.

## Cong nghe

- Frontend: JSP, HTML, CSS va JavaScript noi bo.
- Backend: Java, Spring MVC va Hibernate.
- Database: H2 de chay mau, cau hinh tai `src/main/resources/database.properties`.
- Build: Maven WAR.

Project khong dung REST API, JSON endpoint, AJAX, `fetch`, Axios, CDN hoac
framework frontend ben ngoai.

## Cau truc chinh

- `src/main/java`: controller, validator, interceptor, service, DAO va entity.
- `src/main/resources`: cau hinh database va du lieu khoi tao.
- `src/main/webapp`: JSP, CSS, hinh anh va cau hinh Tomcat/Spring MVC.
- `src/main/webapp/WEB-INF/configs`: Spring XML duoc nap khi ung dung chay.
- `database/schema.sql`: SQL tham khao cho cau truc database.
- `configs`: bo config tham khao tu tai lieu hoc, khong duoc nap luc runtime.
- `PROJECT_RULES.md`: quy tac phat trien can giu khi mo rong project.

## Cach chay

1. Import project vao Eclipse duoi dang Maven Project.
2. Gan project vao Tomcat trong Eclipse.
3. Chay Tomcat va mo `http://localhost:8081/electroshop/`.

Neu CSS chua cap nhat sau khi sua giao dien, chon `Clean` va `Publish` trong
tab Servers cua Eclipse, sau do refresh trinh duyet bang `Ctrl + F5`.
