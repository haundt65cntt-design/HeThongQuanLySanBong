# Hệ Thống Quản Lý Sân Bóng

 
Hiện tại ứng dụng đã hoàn thành cấu trúc khung sườn cơ bản, thiết kế giao diện và giả lập dữ liệu thành công.

## Tiến độ hiện tại:
* Hoàn thành giao diện Màn hình đăng nhập (chạy thử với tài khoản admin/admin).
* Hoàn thành giao diện Màn hình chính hiển thị danh sách các sân cỏ nhân tạo NTU bằng ListView.

## Hình ảnh kết quả chạy trên máy ảo:
<img width="373" height="786" alt="Screenshot 2026-05-25 232235" src="https://github.com/user-attachments/assets/0a0f7553-fc62-489e-9d92-0de76f0d70cd" />
<img width="381" height="782" alt="Screenshot 2026-05-30 121643" src="https://github.com/user-attachments/assets/980ec0ac-85bb-4ace-8dad-a9b578de3f02" />

Hiện tại ứng dụng đã được tinh chỉnh cấu trúc, chuyển đổi hoàn toàn sang luồng chức năng dành cho khách hàng đặt sân để phù hợp với thực tế và nâng cấp giao diện cân đối hơn.

## Tiến độ cập nhật (Lần 2):
* **Tối ưu hóa đối tượng sử dụng:** Loại bỏ các nút bấm và tính năng thuộc quyền Admin (thêm sân mới, quản lý nhanh) để tập trung 100% vào trải nghiệm của Khách hàng thuê sân.
* **Nâng cấp bố cục giao diện:**
  * Sử dụng thuộc tính `layout_weight` giúp chia đều tỉ lệ các danh mục Sân 5, Sân 7, Sân 11 giúp màn hình hiển thị cân đối tuyệt đối, không bị lỗi tràn viền hay khoảng trắng dư thừa.
  * Bổ sung thanh hiển thị **Trạng Thái Sân Hôm Nay** (Sân đang trống / Sân đã đặt) trực quan ở phía dưới cùng màn hình giúp người dùng nắm bắt thông tin nhanh.
* **Mở rộng dữ liệu:** Tự nhập thủ công danh sách đầy đủ 10 sân bóng thực tế với trạng thái giả lập khác nhau để kiểm thử giao diện.
* **Xử lý sự kiện nâng cao:**
  * Viết code bắt sự kiện khi click vào từng sân trong `ListView`.
  * Sử dụng `AlertDialog` cơ bản để hiển thị hộp thoại chức năng: cho phép khách hàng nhấn **Đặt Sân & Cọc**, **Hủy Sân** (tự động cập nhật lại số lượng trạng thái hiển thị real-time trên màn hình chính) hoặc bấm **Liên Hệ Chủ Sân** qua hotline.

## Hình ảnh kết quả Quản lý sân chạy trên máy ảo:
<img width="387" height="795" alt="Screenshot 2026-05-30 121618" src="https://github.com/user-attachments/assets/fde9c7da-3c45-4c41-b742-26b09996c3ee" />
