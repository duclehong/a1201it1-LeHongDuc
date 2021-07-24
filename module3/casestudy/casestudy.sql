create database case_study;
use case_study;
create table LoaiDichVu (
IDLoaiDichVu int primary key,
TenLoaiDichVu varchar(45)
);
insert into LoaiDichVu values
(01, 'Villa'),
(02, 'House'),
(03, 'Room');
create table KieuThue(
IDKieuThue int primary key,
TenKieuThue varchar(45),
Gia int
);
insert into KieuThue values
(11, 'Villa', 15000000),
(12, 'House', 7000000),
(13, 'Room', 2000000);
create table DichVu(
IDDichVu int primary key,
TenDichVu varchar(45),
DienTich int,
SoTang int,
SoNguoiToiDa varchar(45),
ChiPhiThue varchar(45),
IdKieuThue int,
foreign key (IdKieuThue) references KieuThue(IDKieuThue),
IdLoaiDichVu int,
foreign key (IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu),
TrangThai varchar(45)
);
insert into DichVu values
(001, 'Villa', 800, 3, '10', '15tr/day', 11, 01, 'Empty'),
(002, 'House', 400, 2, '5', '7tr/day', 12, 02, 'Empty'),
(003, 'Room', 200, 1, '2', '2tr/day', 13, 03, 'Empty');
create table HopDong(
IDHopDong int primary key,
IDNhanVien int,
foreign key (IDNhanVien) references NhanVien(IDNhanVien),
IDKhachHang int,
foreign key (IDKhachHang) references KhachHang(IDKhachHang),
IDDichVu int,
foreign key (IDDichVu) references DichVu(IDDichVu),
NgayLamHopDong date,
NgayKetThuc date,
TienDatCoc int,
TongTien int
);
insert into HopDong values
(2321, 5905, 583, 001, '2009-07-12', '2009-07-15', 5000000, 45000000),
(2322, 5903, 582, 002, '2004-06-20', '2004-06-25', 4000000, 35000000),
(2323, 5901, 586, 002, '2006-11-19', '2006-11-20', 2000000, 7000000),
(2324, 5904, 584, 003, '2012-02-15', '2012-02-22', 7000000, 14000000),
(2325, 5902, 585, 001, '2010-05-29', '2010-05-31', 8000000, 30000000);
create table KhachHang(
IDKhachHang int,
IDLoaiKhach int,
foreign key (IDLoaiKhach) references LoaiKhach(IDLoaiKhach),
HoTen varchar(45),
Ngaysinh Date,
SoCMTND varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45)
);
insert into KhachHang values
(582, 04311, 'Truong Gia Huy', '2001-11-23', '201820837', '089818205', 'huytg23112001@gmail', 'DaNang'),
(583, 04312, 'Nguyen Anh Tuan', '1990-05-16', '190449200', '0215348748', 'tuanna772@yahoo', 'QuangTri'),
(584, 04313, 'Tran Quoc Duy', '2000-08-12', '2095834844', '0906346983', 'duytq993@gmail', 'ThanhHoa'),
(585, 04314, 'Le Thien Ha', '1997-02-19', '1009339842', '01236598395', 'halt123@yahoo', 'Hue'),
(586, 04315, 'Le Anh Bao', '1995-04-27', '50394838494', '019283948934', 'baola665@gmail', 'HaNoi');
alter table KhachHang
add primary key (IDKhachHang);
create table LoaiKhach(
IDLoaiKhach int primary key,
TenLoaiKhach varchar(45)
);
insert into LoaiKhach values
(04311, 'Diamond'),
(04312, 'Platinium'),
(04313, 'Gold'),
(04314, 'Silver'),
(04315, 'Member');
create table DichVuDiKem(
IDDichVuDiKem int primary key,
TenDichVuDiKem varchar(45),
Gia int,
DonVi int,
TrangThaiKhaDung varchar(45)
);
insert into DichVuDiKem values
(0231, 'Massage', 500, 00, 'Open'),
(0232, 'Karaoke', 250, 00, 'Open'),
(0233, 'Food', 50, 0, 'Open'),
(0234, 'Water', 10, 0, 'Open'),
(0235, 'Car Rental', 100, 00, 'Open');
create table HopDongChiTiet(
IDHopDongChiTiet int primary key,
IDHopDong int,
foreign key (IDHopDong) references HopDong(IDHopDong),
IDDichVuDiKem int,
foreign key (IDDichVuDiKem) references DichVuDiKem(IDDichVuDiKem),
SoLuong int
);
insert into HopDongChiTiet values
(771, 2321, 0231, 2),
(772, 2322, 0232, 5),
(773, 2323, 0233, 3),
(774, 2324, 0234, 3),
(775, 2325, 0235, 7);
create table NhanVien(
IDNhanVien int primary key,
HoTen varchar(45),
IDViTri int,
foreign key (IDViTri) references ViTri(IDVitri),
IDTrinhDo int,
foreign key (IDTrinhDo) references TrinhDo(IDTrinhDo),
IDBoPhan int,
foreign key (IDBoPhan) references BoPhan(IDBoPhan),
NgaySinh date,
SoCMTND varchar(45),
Luong varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45)
);
insert into NhanVien values
(5901, 'Hoang Bao An', 291, 661, 973, '2001-5-18', '201899278683', '6tr/month', '0195382954', 'ba0065@gmail', 'Hai CHau'),
(5902, 'Nguyen Thanh Phuoc', 291, 661, 972, '1990-12-05', '2095859283', '6tr/month', '09196847345', 'ntphuoc92@gmail.com', 'Ngo Thi Nham'),
(5903, 'Le Hoai Nam', 291, 662, 971, '1998-07-08', '2019523839', '6tr/month', '0126739845', 'hnamtr1634@gmail', 'Ngo Quyen'),
(5904, 'Truong Gia Bao', 292, 661, 972, '1989-05-16', '2093985743', '10tr/month', '0839283821', 'baotg209@gmail', 'Le Dinh Ly'),
(5905, 'Nguyen Kim Dung', 291, 662, 971, '2000-02-26', '109582938', '6tr/month', '0152968349', 'kimdung4@gmail', 'Phan Thanh');
create table ViTri(
IDViTri int primary key,
TenViTri varchar(45)
);
insert into ViTri values
(291, 'member'),
(292, 'Leader');
create table TrinhDo(
IDTrinhDo int primary key,
TrinhDo varchar(45)
);
insert TrinhDo values
(661, 'University'),
(662, 'No have');
create table BoPhan(
IDBoPhan int primary key,
TenBoPhan varchar(45)
);
insert into BoPhan values
(971, 'Receptionist'),
(972, 'Office'),
(973, 'Report');



-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select *
from nhanvien
where length(HoTen) <=15 and (HoTen like "H%" or HoTen like "T%" or HoTen like "K%");
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khachhang
where (YEAR(CURRENT_TIMESTAMP) - YEAR(NgaySinh) BETWEEN 18 AND 50) and 	DiaChi in ("DaNang","QuangTri");

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select khachhang.IDKhachHang,khachhang.IDLoaiKhach,khachhang.HoTen,khachhang.Ngaysinh,khachhang.SoCMTND,khachhang.SDT,khachhang.Email,khachhang.DiaChi , COUNT(khachhang.HoTen) as solan
from khachhang inner join loaikhach on khachhang.IDLoaiKhach = loaikhach.IDLoaiKhach inner join hopdong on khachhang.IDKhachHang = hopdong.IDKhachHang
where loaikhach.TenLoaiKhach = "Diamond"
group by khachhang.HoTen
order by solan;
-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select khachhang.IDKhachHang,khachhang.IDLoaiKhach,khachhang.HoTen,hopdong.IDHopDong, dichvudikem.TenDichVuDiKem, hopdong.NgayLamHopDong, (hopdong.TienDatCoc+dichvudikem.Gia) as tong
from khachhang  inner join hopdong on khachhang.IDKhachHang = hopdong.IDKhachHang inner join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong inner join dichvudikem on hopdongchitiet.IDDichVuDiKem = dichvudikem.IDDichVuDiKem;
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dichvu.IDDichVu,dichvu.TenDichVu, dichvu.DienTich, dichvu.ChiPhiThue, dichvu.TenDichVu, hopdong.NgayLamHopDong
from dichvu inner join hopdong on dichvu.IDDichVu = hopdong.IDDichVu
where hopdong.NgayLamHopDong between "2019-01-01" and CURRENT_TIMESTAMP ;
-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.

-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
select distinct HoTen
from khachhang;

select HoTen
from khachhang
union
select HoTen
from khachhang;

select HoTen
from khachhang
group by HoTen;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).


-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
-- 23.	Tạo Clustered Index có tên là IX_KHACHHANG trên bảng Khách hàng.
-- Giải thích lý do và thực hiện kiểm tra tính hiệu quả của việc sử dụng INDEX
-- 24.	Tạo Non-Clustered Index có tên là IX_SoDT_DiaChi trên các cột SODIENTHOAI và DIACHI trên bảng KHACH HANG và kiểm tra tính hiệu quả tìm kiếm sau khi tạo Index.
-- 25.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
-- 26.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
-- 27.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database
-- 28.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database
-- 29.	Tạo user function thực hiện yêu cầu sau:
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được truyền vào như là 1 tham số của function này.
-- 30.	Tạo Stored procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.
