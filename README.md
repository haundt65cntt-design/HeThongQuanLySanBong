# Hệ Thống Quản Lý Sân Bóng

Em đã tiến hành cấu trúc lại toàn bộ mã nguồn và tối ưu hóa giao diện màn hình chính từ dạng lưới (Grid) cũ sang dạng danh sách tính năng thông minh bằng CardView, giúp tập trung xử lý phân hệ cốt lõi cho việc Quản trị hệ thống (Admin).

## Các phần em đã chỉnh sửa và hoàn thành:
- **Dọn dẹp và tối ưu giao diện:** Loại bỏ hoàn toàn các nút chức năng chưa ổn định (như "Doanh thu") và nút Đăng xuất làm rối luồng. Chuyển đổi các ô chức năng nhỏ sang cấu trúc thanh Banner chữ nhật dài bằng `CardView` có thuộc tính `elevation` tạo đổ bóng, giúp giao diện hiện đại và trực quan hơn.
- **Xử lý khoảng trống màn hình:** Bọc toàn bộ các khối chức năng vào một `ScrollView` để đảm bảo giao diện không bị lỗi tràn (Overflown) khi chạy trên các thiết bị màn hình nhỏ. Đồng thời thiết kế thêm một khung Footer chứa thông tin hỗ trợ kỹ thuật và Hotline ở dưới cùng để lấp đầy khoảng trống.
- **Đồng bộ hóa luồng đặt sân & lưu trạng thái:** Xây dựng logic đếm số lượng sân động phía cuối danh sách thông qua vòng lặp kiểm tra trạng thái ("Còn trống" / "Đã đặt"). Thiết kế màn hình Xác nhận đặt cọc tích hợp mã QR chuyển khoản tự động kèm biểu mẫu điền thông tin khách hàng, luân chuyển trạng thái sang danh sách chờ xác nhận một cách khép kín.
- **Khắc phục lỗi Duplicate class hệ thống:** Phát hiện và bóc tách thành công Class `QuenMatKhauActivity` bị khai báo lồng sai vị trí trong tệp `DangKyActivity.java` trước đó, cấu trúc lại định tuyến file trong `AndroidManifest.xml` giúp hệ thống Build Gradle thành công không còn lỗi đỏ.

## Hình ảnh chạy thực tế trên máy ảo:
<p align="center">
  <img width="240" alt="Màn hình đăng nhập" src="https://github.com/user-attachments/assets/ba414ca2-f4d2-4879-b9f9-0d75535313b0" />
  <img width="240" alt="Màn hình chính admin" src="https://github.com/user-attachments/assets/4d414bae-23a0-423d-8f90-63c96f544d23" />
  <img width="240" alt="Danh sách trạng thái sân" src="https://github.com/user-attachments/assets/b784709e-31e5-408a-8366-906d977702bd" />
</p>

<p align="center">
  <img width="240" alt="Quét mã QR đặt cọc" src="https://github.com/user-attachments/assets/dacd0e1a-3da1-425c-a0fe-630d736ef12e" />
  <img width="240" alt="Lịch khách đặt chờ duyệt" src="https://github.com/user-attachments/assets/856805bc-1c80-4ee7-8e09-1d8f82770bf0" />
</p>

## Cấu trúc mã nguồn thực hiện:
- Thiết kế giao diện hoàn toàn bằng `LinearLayout` lồng nhau, phối hợp linh hoạt cùng `CardView` (bo góc `14dp`) và `RelativeLayout` sử dụng bộ lọc màu đen mờ để làm nổi bật chữ trên hình nền sân bóng.
- Khởi tạo mảng `ArrayList<SanBong>` động để lưu trữ dữ liệu trạng thái thay vì fix cứng văn bản.
- Tận dụng hàm duyệt vòng lặp `for` lồng cấu trúc điều kiện `if-else` để đếm chính xác số lượng Sân đang trống / Sân đã đặt, tự động cập nhật lên màn hình mỗi khi tương tác dữ liệu.
- Đảm bảo an toàn hệ thống, ngăn ngừa tuyệt đối lỗi văng ứng dụng (`NullPointerException`) bằng cách bọc tất cả các sự kiện `setOnClickListener` trong các khối lệnh kiểm tra điều kiện an toàn (`if (view != null)`).
