# Hệ Thống Quản Lý Sân Bóng 

Em đã sửa lại giao diện màn hình chính và viết thêm logic code để chuyển hẳn ứng dụng sang luồng chức năng dành cho Khách hàng vào xem và đặt lịch, thay vì làm giao diện cho Admin quản lý như tuần trước.

## Các phần em đã chỉnh sửa và hoàn thành:
- Dọn dẹp giao diện: Xóa bỏ các nút bấm của Admin như "Thêm sân mới" hay "Góc quản lý nhanh" để màn hình gọn gàng, đúng thực tế với app cho người đi thuê sân.
- Sắp xếp lại bố cục: Chia lại tỷ lệ 3 ô danh mục (Sân 5, Sân 7, Sân 11) ở đầu trang bằng layout_weight để các ô tự động dàn đều, nhìn cân đối và không bị thừa khoảng trắng.
- Bổ sung dữ liệu: Tự nhập thủ công danh sách 10 sân bóng vào ArrayList với đầy đủ tên sân và trạng thái khác nhau (Còn trống / Đã đặt) để hiển thị lên ListView.
- Thêm thanh trạng thái: Thiết kế thêm 2 ô nhỏ ở dưới cùng màn hình để hiển thị tổng số sân đang trống và số sân đã được đặt trong ngày.
- Viết sự kiện Click: Thiết lập khi người dùng bấm vào một sân bất kỳ trong danh sách, ứng dụng sẽ hiện lên một cái AlertDialog (hộp thoại lựa chọn) cơ bản gồm các nút: Đặt Sân & Cọc, Hủy Sân hoặc Liên Hệ Hotline.
- Xử lý thay đổi dữ liệu: Khi khách bấm Đặt hoặc Hủy trên hộp thoại, chữ trạng thái trên dòng đó sẽ tự thay đổi và 2 ô đếm số lượng sân trống phía dưới cũng tự động nhảy lại số chính xác.

## Hình ảnh chạy thực tế trên máy ảo:
<p align="center">
  <img width="373" height="786" alt="Màn hình đăng nhập" src="https://github.com/user-attachments/assets/0a0f7553-fc62-489e-9d92-0de76f0d70cd" />
  <img width="381" height="782" alt="Màn hình danh sách đặt sân online" src="https://github.com/user-attachments/assets/980ec0ac-85bb-4ace-8dad-a9b578de3f02" />
  <img width="387" height="795" alt="Hộp thoại chọn chức năng sân" src="https://github.com/user-attachments/assets/fde9c7da-3c45-4c41-b742-26b09996c3ee" />
</p>

## Cấu trúc mã nguồn thực hiện:
- Thiết kế giao diện hoàn toàn bằng LinearLayout lồng nhau, dùng ListView kết hợp ArrayAdapter cơ bản để đổ dữ liệu chuỗi (String) lên màn hình.
- Viết hàm capNhatSoLuongSan() sử dụng vòng lặp for để duyệt qua ArrayList, đếm chuỗi trạng thái và cập nhật lại nội dung cho các TextView hiển thị.
- Bắt sự kiện trực tiếp bằng setOnItemClickListener và xử lý nút bấm thông qua DialogInterface.OnClickListener của AlertDialog.
