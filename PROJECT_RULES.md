# Nguyen tac phat trien project

- Chay theo Spring MVC truyen thong tich hop Tomcat va Eclipse IDE.
- Frontend chi dung HTML, CSS, Tailwind CSS va JavaScript.
- Backend dung Java, Spring MVC va Hibernate; database dung SQL.
- Chi van dung kien thuc trong `SpringMVC_Lesson1`, `Lesson3`, `Lesson4`, `Lesson5`, `Lesson6_Up`, `Lesson7`.
- Chi dung thu vien da co trong `lib` va `src/main/webapp/WEB-INF/lib`; khong tu dong them dependency moi.
- Khong dung REST API, JSON endpoint, `@RestController`, `@ResponseBody`, AJAX, `fetch`, Axios hoac goi API ben ngoai.
- JSP gui form truc tiep den Controller; Controller tra ve JSP view hoac `redirect:`.
- Cau hinh runtime dung XML tach file theo mau bai hoc: `WEB-INF/web.xml`, `WEB-INF/configs/*.xml`.
- Maven quan ly dependency build; khong them classpath entry thu cong vao jar Spring trong `lib`.
- `Design.md` chi dung tham khao phase; khong ap dung ky thuat ngoai tai lieu hoc.

## Kien thuc duoc dung

| Bai | Noi dung |
| --- | --- |
| 1 | DispatcherServlet, MVC, Model, web object, request mapping |
| 3 | Databinding, `@ModelAttribute`, Spring Form |
| 4 | JSP EL va JSTL |
| 5 | DI, bean XML, `@Autowired`, upload |
| 6 | Hibernate entity, SessionFactory, HQL, CRUD, transaction |
| 7 | Validator, BindingResult, Interceptor |

## Tien do

- Phase 1-2: da hoan thanh foundation XML, Hibernate entity, DAO va service.
- Phase 3: da hoan thanh dang ky, dang nhap, dang xuat bang form submit va session.
- Phase 4: da hoan thanh home, product list, product detail, category, search, blog list va profile upload.
- Phase 5: da hoan thanh cart session, checkout, order success, order history va order detail.
- Phase 6: da hoan thanh admin interceptor, dashboard, product CRUD; cac khu admin chua co bang du lieu dung placeholder JSP.
- Khong trien khai OTP, reset token URL hoac SMTP neu vuot ngoai pham vi tai lieu va bo jar hien co.
