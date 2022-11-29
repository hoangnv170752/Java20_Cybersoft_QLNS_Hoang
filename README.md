# Java20_Cybersoft_QLNS_Hoang
Bài tập quản lí nhân sự - xây dựng ứng dụng quản lí nhân sự của 1 công ty bằng những yêu cầu trong file md
Công ty có tên công ty, mã số thuế, doanh thu tháng. Công ty có 3 loại nhân viên: giám đốc, trưởng phòng, nhân viên thường. Mỗi người trong công ty phải
có các thông tin: mã số, họ tên, số điện thoại, số ngày làm việc, lương 1 ngày và cách tính lương. Ngoài các thông tin chung, mỗi chức vụ trong công ty
còn có các thuộc tính riêng:
###Nhân viên:
- Có thêm trưởng phòng quản lý. Nếu không có ai quản lý thì để null
- Công thức tính lương tháng : lương 1 ngày * số ngày làm việc .Lương 1 ngày của nhân viên: 100
###Trưởng phòng:
- Có số lượng nhân viên dưới quyền. Thuộc tính này tăng lên khi có thêm 1 nhân viên thêm vào do trưởng phòng đó quản lý.
- Công thức tính lương tháng: lương 1 ngày * số ngày làm việc + 100 * số lượng nhân viên dưới quyền. Lương 1 ngày của trưởng phòng: 200
###Giám đốc:
- Có thêm thuộc tính cổ phần trong công ty. Trị số này là số %, không được vượt quá 100%
- Công thức tính lương tháng : lương 1 ngày * số ngày làm việc. Lương 1 ngày của Giam đốc: 300
##Yêu cầu:   
In ra menu cho chọn các chức năng sau: (Xuất thông tin theo biểu mẫu tablet có cột số thứ tự)
1. Nhập thông tin công ty
2. Phân bổ Nhân viên vào Trưởng phòng
3. Thêm, xóa thông tin một nhân sự (có thể là Nhân viên, trưởng phòng hoặc giám đốc). Lưu ý khi xóa trưởng phòng, phải ngắt liên kết với các nhân viên
   đang tham chiếu tới.
4. Xuất ra thông tin toàn bộ người trong công ty
5. Tính và xuất tổng lương cho toàn công ty
6. Tìm Nhân viên thường có lương cao nhất
7. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất
8. Sắp xếp nhân viên toàn công ty theo thứ tự abc
9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần
10. Tìm Giám Đốc có số lượng cổ phần nhiều nhất
11. Tính và Xuất tổng THU NHẬP của từng Giám Đốc
##Note:    
- Thu nhập = Lương tháng + số cổ phần * Lợi nhuận công ty
- Lợi nhuận công ty = Doanh thu tháng của công ty - tổng lương toàn công ty trong tháng.
