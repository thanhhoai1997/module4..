<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/2/2024
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KHAI BÁO Y TẾ</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>${message}</h1>
<div style="margin: 5%">
    <div  align="center">
        <h1>TỜ KHAI Y TẾ</h1>
        <h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CUẢ ANH/CHỊ S GIÚP CƠ QUAN Y TẾ LIEN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
        <h5 style="color: red">Khuyến cáo : Khai báo thông tin sai là vi phạm pháp luật Viet Nam và có thể xử lý hình sự</h5>
    </div>
    <div>
        <form:form  method="post" action="khaibaoyte/save" modelAttribute="tokhaibaoyte">
            <div>
                <form:label  path="hoTen">Họ Tên (ghi chữ IN HOA)</form:label>
                <br>
                <form:errors path="hoTen" cssStyle="color: red;"></form:errors>

                <br>
                <form:input path="hoTen" cssStyle="width: 100%"/>
            </div>
            <div style="display:flex;">
                <div style="width: 33%" >
                    <form:label path="namSinh">Năm sinh</form:label>
                    <br>
                    <form:select cssStyle="width: 100%"  path="namSinh" items="${namSinh}"/>
                </div>
                <div style="width: 33%" >
                    <form:label path="gioiTinh">Giới tính</form:label>
                    <br>
                    <form:select cssStyle="width: 100%" path="gioiTinh">
                        <form:option value="true">Nam</form:option>
                        <form:option value="false">Nu</form:option>
                    </form:select>
                </div>
                <div style="width: 33%">
                    <form:label path="quocTich">Quoc tịch</form:label>
                    <br>
                    <form:select cssStyle="width: 100%"  path="quocTich" items="${quocTich}"/>


                </div>


            </div>
            <div>
                <form:label path="soCMND">Số hộ chiếu hoặc số CMND hoặc giấy thong hành hợp pháp khác</form:label>
                <form:input cssStyle="width: 100%" path="soCMND"/>
            </div>
            <div>
                <form:label path="phuongTien">Thông tin đi lại</form:label>
                <br>
                <form:radiobuttons path="phuongTien" items="${phuongTienDiLai}"/>
            </div>
            <div style="display: flex">
                <div style="width: 50%">
                    <form:label path="soHieuPhuongTien">Số hiệu phương tiện</form:label>
                    <form:input cssStyle="width: 100%" path="soHieuPhuongTien"/>
                </div>
                <div style="width: 50%">
                    <form:label  path="soGhe">Số Ghế</form:label>
                    <form:input cssStyle="width: 100%" path="soGhe"/>
                </div>
            </div>
            <div style="display: flex">
                <div style="width: 50%" >
                    <form:label path="ngayKhoiHanh">Ngày Khởi Hành</form:label>
                    <div>
                        <form:select cssStyle="width: 30%" path="ngayKhoiHanh.date" items="${ngay}"/>
                        <form:select cssStyle="width: 30%" path="ngayKhoiHanh.month" items="${thang}"/>
                        <form:select cssStyle="width: 30%" path="ngayKhoiHanh.year" items="${namSinh}"/>
                    </div>
                </div>
                <div style="width: 50%" >
                    <form:label path="ngayKetThuc">Ngày Kết Thúc</form:label>
                    <div>
                        <form:select cssStyle="width: 30%" path="ngayKetThuc.date" items="${ngay}"/>
                        <form:select cssStyle="width: 30%" path="ngayKetThuc.month" items="${thang}"/>
                        <form:select cssStyle="width: 30%" path="ngayKetThuc.year" items="${namSinh}"/>
                    </div>
                </div>
            </div>
            <div>
                <form:label path="ghiChu">Trong vòng 14 ngày qua ,Anh /Chị có đến tỉnh/ thành phố nào ?</form:label>
                <br>
                <form:textarea path="ghiChu" cssStyle="width: 100%"/>
            </div>
            <h3>Địa chỉ liên lạc</h3>
            <div style="display: flex">
                <div style="width: 33%">
                    <form:label path="tinh">Tỉnh / thành</form:label>
                    <form:select cssStyle="width: 100%" path="tinh" items="${tinh}"/>
                </div>
                <div style="width: 33%">
                    <form:label path="quan">Quận / huyện</form:label>
                    <form:select cssStyle="width: 100%" path="quan" items="${quan}"/>
                </div>
                <div style="width: 33%">
                    <form:label path="phuong">Phường / xã</form:label>
                    <form:select cssStyle="width: 100%" path="phuong" items="${phuong}"/>
                </div>
            </div>
            <h4>Trong Vòng 14 ngày qua,Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?</h4>

    <table style="width: 100%" border="1">
        <tr>
            <th>Triệu Chứng</th>
            <th>Có</th>
            <th>Không</th>
            <th>Triệu Chứng</th>
            <th>Có</th>
            <th>Không</th>

        </tr>
        <tr>
            <td>Sot</td>
            <td><form:radiobutton path="sot" value="true"/> </td>
            <td><form:radiobutton path="sot" value="false"/> </td>
            <td>Nôn/Buồn nôn</td>
            <td><form:radiobutton path="buonNon" value="true"/> </td>
            <td><form:radiobutton path="buonNon" value="false"/> </td>

        </tr>
        <tr>
            <td>Ho</td>
            <td><form:radiobutton path="ho" value="true"/> </td>
            <td><form:radiobutton path="ho" value="false"/> </td>
            <td>Tiêu Chảy</td>
            <td><form:radiobutton path="tieuChay" value="true"/> </td>
            <td><form:radiobutton path="tieuChay" value="false"/> </td>

        </tr>
        <tr>
            <td>Khó Thở</td>
            <td><form:radiobutton path="khoTho" value="true"/> </td>
            <td><form:radiobutton path="khoTho" value="false"/> </td>
            <td>Xuất Huyet Ngoài Da</td>
            <td><form:radiobutton path="xuatHuyetNgoaiDa" value="true"/> </td>
            <td><form:radiobutton path="xuatHuyetNgoaiDa" value="false"/> </td>

        </tr>
        <tr>
            <td>Đau Họng</td>
            <td><form:radiobutton path="dauHong" value="true"/> </td>
            <td><form:radiobutton path="dauHong" value="false"/> </td>
            <td>Nổi Ban Ngoài Da</td>
            <td><form:radiobutton path="noiBanNgoaiDa" value="true"/> </td>
            <td><form:radiobutton path="noiBanNgoaiDa" value="false"/> </td>

        </tr>

    </table>
            <h4>Lịch Sử Phơi Nhiễm: Trong vòng 14 ngày qua, Anh/Chị có:</h4>
            <table border="1" width="100%">
                <tr>
                    <th></th>
                    <th>Có</th>
                    <th>Không</th>
                </tr>
                <tr>
                    <td>Đến Trang Trại chăn nuôi/ chợ buôn bán động vật sống/ cơ sở giết mổ động vật/tiếp xúc động vật</td>
                    <td><form:radiobutton path="lichSuPhoiNhiem1" value="true"/> </td>
                    <td><form:radiobutton path="lichSuPhoiNhiem1" value="false"/> </td>

                </tr>
                <tr>
                    <td>Tiếp xúc gan (<2m) với người mắc bệnh viêm đường hô hấp do nCov</td>
                    <td><form:radiobutton path="lichSuPhoiNhiem2" value="true"/> </td>
                    <td><form:radiobutton path="lichSuPhoiNhiem2" value="false"/> </td>

                </tr>
            </table>
            <p style="color: red">Dữ Liệu bạn cung cấp hoàn toàn bảo mật vả chỉ phục vụ cho việc phòng chống dịch,thuộc quản lý của ban chỉ đạo quốc gia về phòng chống dich Covid-19</p>
            <div align="center">
                <form:button>Gửi Tờ Khai</form:button>

            </div>

        </form:form>
    </div>

</div>


</body>
</html>
