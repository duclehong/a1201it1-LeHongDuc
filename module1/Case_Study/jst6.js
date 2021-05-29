var arr = [];
class Customer {
    constructor(name, cmnd, ngay_sinh, email, dia_chi, loai_customer, sale, so_ngay_thue, so_nguoi, loai_phong,
        loai_dich_vu) {
        this.name = name;
        this.cmnd = cmnd;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
        this.dia_chi = dia_chi;
        this.loai_customer = loai_customer;
        this.sale = sale;
        this.so_ngay_thue = so_ngay_thue;
        this.so_nguoi = so_nguoi;
        this.loai_phong = loai_phong;
        this.loai_dich_vu = loai_dich_vu;
    }
    getName() {
        return this.name;
    }
    setName(name) {
        this.name = name;
    }
    getCmnd() {
        return this.cmnd;
    }
    setCmnd(cmnd) {
        this.cmnd = cmnd;
    }
    getNgaySinh() {
        return this.ngay_sinh;
    }
    setNgaySinh(ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }
    getEmail() {
        return this.email;
    }
    setEmail(email) {
        this.email = email;
    }
    getDiaChi() {
        return this.dia_chi;
    }
    setDiaChi(dia_chi) {
        this.dia_chi = dia_chi;
    }
    getLoaiCustomer() {
        return this.loai_customer;
    }
    setLoaiCustomer(loai_customer) {
        this.loai_customer = loai_customer;
    }
    getSale() {
        return this.sale;
    }
    setSale(sale) {
        this.sale = sale;
    }
    getSoNgayThue() {
        return this.so_ngay_thue;
    }
    setSoNgayThue(so_ngay_thue) {
        this.so_ngay_thue = so_ngay_thue;
    }
    getSoNguoi() {
        return this.so_nguoi;
    }
    setSoNguoi(so_nguoi) {
        this.so_nguoi = so_nguoi;
    }
    getLoaiPhong() {
        return this.loai_phong;
    }
    setLoaiPhong(loai_phong) {
        this.loai_phong = loai_phong;
    }
    getLoaiDichVu() {
        return this.loai_dich_vu;
    }
    setLoaiDichVu(loai_dich_vu) {
        this.loai_dich_vu = loai_dich_vu;
    }


    tinhTien() {
        console.log(this.getSoNgayThue());
        console.log(this.getLoaiDichVu());
        console.log(this.getSale());
        console.log(this.tinhSale());
        let tong = (this.getSoNgayThue() * this.getLoaiDichVu() * (1 - this.getSale * 100)) - this.tinhSale();
        console.log(typeof (this.getSoNgayThue()));
        console.log(typeof (this.getLoaiDichVu()));
        console.log(typeof (this.getSale()));
        console.log(typeof (this.tinhSale()));

        return tong;
    }
    tinhSale() {
        let i = 0;
        switch (this.loai_customer) {
            case 1:
                i += 15;
                break;
            case 2:
                i += 10;
                break;
            case 3:
                i += 5;
                break;
            case 4:
                i += 2;
                break;
            case 5:
                i += 0;
                break;
            default:
                break;
        }
        if (this.so_ngay_thue < 5 || this.so_ngay_thue > 1) {
            i += 10;
        } else {
            if (this.so_ngay_thue > 7) {
                i += 30;
            } else {
                i += 20;
            }
        }
        switch (this.dia_chi) {
            case 1:
                i += 20;
                break;
            case 2:
                i += 10;
                break;
            case 3:
                i += 5;
                break;
            default:
                break;
        }

        return i;
    }


}

function displayTable() {

    d = "<hr>";
    d += "<table>";
    d += "<tr><th> Tên </th><th> Số CMND </th><th> Ngày Sinh </th><th> Email </th><th> Địa Chỉ </th><th> Loại Customer </th><th> Sale OFF </th><th> Số Ngày Thuê </th><th> Số Người </th><th> Loại Phòng </th><th> Loại dịch vụ </th><th></th>"
    for (let i = 0; i < arr.length; i++) {
        let dc = arr[i].dia_chi;
        dc = parseInt(dc);
        switch (dc) {
            case 1:
                dc = "Đà Nẵng"
                break;
            case 2:
                dc = "Quảng Nam"
                break;
            case 3:
                dc = "Huế"
                break;
            default:
                break;
        }
        let tpc = arr[i].loai_customer;
        tpc = parseInt(tpc);
        switch (tpc) {
            case 1:
                tpc = "Diamond"
                break;
            case 2:
                tpc = "Plantinum"
                break;
            case 3:
                tpc = "Gold"
                break;
            case 4:
                tpc = "Silver"
                break;
            case 5:
                tpc = "Member"
                break;
            default:
                break;
        }
        let tr = arr[i].loai_phong;
        tr = parseInt(tr);
        switch (tr) {
            case 500:
                tr = "Villa"
                break;
            case 300:
                tr = "House"
                break;
            case 100:
                tr = "Room"
                break;
            default:
                break;
        }
        d += "<tr>";
        d += "<td>" + arr[i].name + "</td> <td>" + arr[i].cmnd + "</td> <td>" + arr[i].ngay_sinh + "</td><td>" +
            arr[
                i].email + "</td><td>" + dc + "</td><td>" + tpc + "</td><td>" +
            arr[i].sale +
            "%</td><td>" + arr[i].so_ngay_thue + "</td><td>" + arr[i].so_nguoi + "</td><td>" + tr + "</td><td>" + arr[i]
            .loai_dich_vu + "</td>" + "<td> <button onclick='tinhtien2(" + i + ")'> Tính tiền</button></td>";
        d += "</tr><tr><td colspan='2'></td></tr>";


    }
    d += "</table><br><p id ='show_money'> <p/>"

    document.getElementById("div2").innerHTML = d;
}

function tinhtien2(t) {
    console.log(t);
    for (let i = 0; i < arr.length; i++) {
        if (t == i) {

            n = arr[i].getName();
            a = parseFloat(arr[i].getSoNgayThue())
            b = parseFloat(arr[i].getLoaiDichVu())
            c = parseFloat(arr[i].getSale())
            d = parseFloat(arr[i].tinhSale())
            let tong = (a * b * (1 - c / 100)) - d;
            console.log(tong);
            document.getElementById("show_money").innerHTML = " <hr> Tổng tiền khách hàng " + n + " phải trả là: " + tong + "$";
            document.getElementById("show_money").innerHTML += " ( Thuê " + a + " Ngày * Loại dịch vu: " + b + " * (Sale " + c + "%) - Ưu đãi " + d + ")"
        }

    }

}

function display() {
    d = "";
    d += "<p> Nhập CMND người dùng cần hiển thị </p>";
    d += "<input id='id_tim' placeholder='CMND'> </input>";
    d += "<button onclick='display_id()'> Hiển Thị </button>"
    document.getElementById('div2').innerHTML = d;


}

function display_id() {
    let id = parseFloat(document.getElementById("id_tim").value);
    d = "";
    d += "<table>";
    d += "<tr><th> Tên </th><th> Số CMND </th><th> Ngày Sinh </th><th> Email </th><th> Địa Chỉ </th><th> Loại Customer </th><th> Sale OFF </th><th> Số Ngày Thuê </th><th> Số Người </th><th> Loại Phòng </th><th> Loại dịch vụ </th>";


    for (let i = 0; i < arr.length; i++) {
        if (id == arr[i].cmnd) {
            let dc = arr[i].dia_chi;
            dc = parseInt(dc);
            switch (dc) {
                case 1:
                    dc = "Đà Nẵng"
                    break;
                case 2:
                    dc = "Quảng Nam"
                    break;
                case 3:
                    dc = "Huế"
                    break;
                default:
                    break;
            }
            
            
            let tpc = arr[i].loai_customer;
            tpc = parseInt(tpc);
            switch (tpc) {
                case 1:
                    tpc = "Diamond"
                    break;
                case 2:
                    tpc = "Plantinum"
                    break;
                case 3:
                    tpc = "Gold"
                    break;
                case 4:
                    tpc = "Silver"
                    break;
                case 5:
                    tpc = "Member"
                    break;
                default:
                    break;
            }
            
            let tr = arr[i].loai_phong;
            tr = parseInt(tr);
            switch (tr) {
                case 500:
                    tr = "Villa"
                    break;
                case 300:
                    tr = "House"
                    break;
                case 100:
                    tr = "Room"
                    break;
                default:
                    break;
            }
            d += "<tr>"
            d += "<td>" + arr[i].name + "</td> <td>" + arr[i].cmnd + "</td> <td>" + arr[i].ngay_sinh + "</td><td>" +
                arr[
                    i].email + "</td><td>" + dc + "</td><td>" + tpc + "</td><td>" +
                arr[i].sale +
                "</td><td>" + arr[i].so_ngay_thue + "</td><td>" + arr[i].so_nguoi + "</td><td>" + tr + "</td><td>" + arr[i]
                .loai_dich_vu + "</td> </tr>";

        }

    }
    d += "</tr>";
    d += "</table> "
    document.getElementById("div2").innerHTML = d;

}

function del() {
    d = "";
    d += "<p> Nhập CMND người dùng cần xóa </p>";
    d += "<input id='id_del' placeholder='CMND'> </input>";
    d += "<button onclick='del_id()'> Xóa </button>"
    document.getElementById('div2').innerHTML = d;
}

function del_id() {
    let id = parseFloat(document.getElementById("id_del").value);
    for (let i = 0; i < arr.length; i++) {
        if (id == arr[i].cmnd) {
            if (confirm("Bạn có chắc chắn không")) {
                arr.splice(i, 1);
            }

        }

    }
    displayTable();

}

function edit() {
    d = "";
    d += "<p> Nhập CMND người dùng cần sửa </p>";
    d += "<input id='id_edit' placeholder='CMND'> </input>";
    d += "<button onclick='edit_id()'> Sửa </button>"
    document.getElementById('div2').innerHTML = d;
}

function edit_id() {


    let id = parseFloat(document.getElementById("id_edit").value);
    for (let i = 0; i < arr.length; i++) {
        if (id == arr[i].cmnd) {
            document.getElementById("sua").innerHTML = "<button onclick='sua(" + id + ")'>Sửa</button>";

        }

    }
    document.getElementById("id").value = id;
    displayTable();


}

function sua(id) {
    var name = document.getElementById("name").value;
    console.log(id);

    var cmnd = document.getElementById("id").value;
    // check_cmnd(cmnd);
    var ngay_sinh = parseInt(document.getElementById("birth").value);
    // check_ns(ngay_sinh);
    var email = document.getElementById("email").value;

    var dia_chi = document.getElementById("address").value;
    var loai_customer = document.getElementById("type_customer").value;
    var sale = parseFloat(document.getElementById("sale_off").value);

    var so_ngay_thue = parseFloat(document.getElementById("sn").value)
    var so_nguoi = parseFloat(document.getElementById("ctm").value)
    var loai_phong = parseFloat(document.getElementById("type_room").value);
    var loai_dich_vu = parseFloat(document.getElementById("type_service").value);
    var a = new Customer(name, cmnd, ngay_sinh, email, dia_chi, loai_customer, sale, so_ngay_thue, so_nguoi,
        loai_phong, loai_dich_vu);

    sua_mang(id);

    function sua_mang(id) {
        for (let i = 0; i < arr.length; i++) {
            if (arr[i].getCmnd() == id) {
                name = removeAccents(name);
                arr[i].setName(name);
                arr[i].setDiaChi(dia_chi);
                arr[i].setEmail(email);
                arr[i].setNgaySinh(ngay_sinh);
                arr[i].setCmnd(cmnd);
                arr[i].setLoaiCustomer(loai_customer);
                arr[i].setSale(sale);
                arr[i].setSoNgayThue(so_ngay_thue);
                arr[i].setSoNguoi(so_nguoi);
                arr[i].setLoaiPhong(loai_phong);
                arr[i].setLoaiDichVu(loai_dich_vu);
                console.log(arr);
                displayTable();
            }

        }
    }

}

function check_name() {
    var em = document.getElementById("name").value;
    if (em == "") {
        document.getElementById("name").style.borderColor = "red";
        document.getElementById("name").value = "Không được bỏ trống ô này!";
        return false;
    } else {
        
        return true;
    }
}

function check_name2() {
    if (document.getElementById("email").value == "Không được bỏ trống ô này!") {
        document.getElementById("name").value = "";
    } else {

    }
}

function check_ns() {
    var b = document.getElementById("birth").value;


    if (b.length == 2) {
        document.getElementById("birth").value += "/";
    }
    if (b.length == 5) {
        document.getElementById("birth").value += "/";
    }
    if (b.length == 10) {
        console.log(b.length);

        document.getElementById("birth").style.borderColor = "#777";
        return true;

    } else {
        document.getElementById("birth").style.borderColor = "red";
        return false;
    }



}

function check_ns3() {
    var b = document.getElementById("birth").value;
    if (isNaN(b[0]) || isNaN(b[1]) || isNaN(b[3]) || isNaN(b[4]) || isNaN(b[6]) || isNaN(b[7]) || isNaN(b[8]) || isNaN(b[9])) {
        document.getElementById("birth").value = "Phải là dạng số!";
    }
    if (b[0] > 3) {

        document.getElementById("birth").value = "Ngày phải bé hơn 31";
    }
    if (b[0] == 3) {
        if (b[1] > 1) {
            document.getElementById("birth").value = "Ngày phải bé hơn 31";
        }
    }
    if (b[3] > 1) {
        document.getElementById("birth").value = "Tháng phải bé hơn 12";
    }
    if (b[3] == 1 && b[4] > 2) {
        document.getElementById("birth").value = "Tháng phải bé hơn 12";
    }
    c = parseInt(b[6] + b[7] + b[8] + b[9]);
    if (c < 1975) {
        document.getElementById("birth").value = "Chỉ nhập từ 1975";
    }
    y = new Date();
    if (c < Date.y) {
        document.getElementById("birth").value = "Chỉ nhập từ 1975";
    }
    console.log(c > y.getFullYear());
    if (c > y.getFullYear()) {
        document.getElementById("birth").value = "Người của tương lai!";
    }
    console.log(c);


    if (b == "") {
        document.getElementById("birth").style.borderColor = "red";
        document.getElementById("birth").value = "Không được bỏ trống ô này!";
        return false;
    }

    if (b.length < 10) {
        document.getElementById("birth").value = "Không hợp lệ";
    }
    if (b.length > 10) {
        document.getElementById("birth").value = "Không hợp lệ";
    }
    if (b.length == 10) {
        console.log(b.length);

        document.getElementById("birth").style.borderColor = "#777";
        return true;

    }

}

function check_ns2() {

    if (document.getElementById("birth").value == "Không được bỏ trống ô này!" || document.getElementById("birth").value == "Không hợp lệ" || document.getElementById("birth").value == "Phải là dạng số!" || document.getElementById("birth").value == "Ngày phải bé hơn 31" || document.getElementById("birth").value == "Tháng phải bé hơn 12" || document.getElementById("birth").value == "Chỉ nhập từ 1975" || document.getElementById("birth").value == "Người của tương lai!") {
        document.getElementById("birth").value = "";
        return false;

    } else {

    }


}

function check_cmnd() {
    cmnd = document.getElementById("id").value;
    if (cmnd == "") {
        document.getElementById("id").style.borderColor = "red";
        document.getElementById("id").value = "Không được bỏ trống ô này!";
        return false;
    }
    if (isNaN(cmnd)) {
        document.getElementById("id").style.borderColor = "red";
        // document.getElementById("id"). ;
        document.getElementById("id").value = "Sai định dạng";
        return false;

    } else {
        if (cmnd > 0) {
            if (cmnd.length == 8) {
                document.getElementById("id").style.borderColor = "#777";
                return true;
            } else {
                document.getElementById("id").value = "Phải gồm 8 kí tự số!";
            }

        } else {
            document.getElementById("id").value = "Số cmnd phải lớn hơn 0";
            return false;
        }
    }

}


function check_cmnd2() {
    if (document.getElementById("id").value == "Sai định dạng" || document.getElementById("id").value == "Không được bỏ trống ô này!" || document.getElementById("id").value == "Phải gồm 8 kí tự số!") {
        document.getElementById("id").value = "";

    } else {

    }
}

function check_email() {
    var em = document.getElementById("email").value;
    if (em == "") {
        document.getElementById("email").style.borderColor = "red";
        document.getElementById("email").value = "Không được bỏ trống ô này!";
        return false;
    }
    var temp1 = 0;
    var temp2 = 0;
    for (let i = 0; i < em.length; i++) {
        if (em.charAt(i) === "@") {
            temp1 += 1;
            let j = i + 4;
            for (j; j < em.length; j++) {
                if (em.charAt(j) === ".") {
                    temp2 += 1;
                }

            }
        }

    }
    if (temp1 == 1 && temp2 == 1) {
        console.log(1);
        document.getElementById("email").style.borderColor = "#777";
        return true;
    } else {
        document.getElementById("email").style.borderColor = "red";
        document.getElementById("email").value = "Sai định dạng";
        return false;
    }
}

function check_email2() {
    if (document.getElementById("email").value == "Sai định dạng" || document.getElementById("email").value == "Không được bỏ trống ô này!") {
        document.getElementById("email").value = "";
    } else {

    }
}



function check_sale() {
    var sale = document.getElementById("sale_off").value;
    if (sale == "") {
        document.getElementById("sale_off").style.borderColor = "red";
        document.getElementById("sale_off").value = "Không được bỏ trống ô này!";
        return false;
    }
    if (isNaN(sale)) {
        document.getElementById("sale_off").style.borderColor = "red";
        document.getElementById("sale_off").value = "Sale phải là dạng số";
        return false;
    } else {
        if (sale > 0 && sale < 100) {
            document.getElementById("sale_off").style.borderColor = "#777";
            return true;
        } else {
            document.getElementById("sale_off").style.borderColor = "red";
            document.getElementById("sale_off").value = "100<n<0!! Nhập lại!"
            return false;
        }
    }
}

function check_sale2() {
    if (document.getElementById("sale_off").value == "Sale phải là dạng số" || document.getElementById("sale_off").value == "100<n<0!! Nhập lại!" || document.getElementById("sale_off").value == "Không được bỏ trống ô này!") {
        document.getElementById("sale_off").value = "";

    } else {}
}


function check_so_ngay_thue() {
    var sn = document.getElementById("sn").value;
    if (sn == "") {
        document.getElementById("sn").style.borderColor = "red";
        document.getElementById("sn").value = "Không được bỏ trống ô này!";
        return false;
    }
    if (isNaN(sn)) {
        document.getElementById("sn").style.borderColor = "red";
        document.getElementById("sn").value = "số ngày phải là dạng số!";
        return false;
    } else {
        if (sn > 0) {
            document.getElementById("sn").style.borderColor = "#777";
            return true;
        } else {
            document.getElementById("sn").style.borderColor = "red";
            document.getElementById("sn").value = "Phải thuê ít nhất 1 ngày!";
            return false;
        }
    }
}

function check_so_ngay_thue2() {
    if (document.getElementById("sn").value == "số ngày phải là dạng số!" || document.getElementById("sn").value == "Phải thuê ít nhất 1 ngày!" || document.getElementById("sn").value == "Không được bỏ trống ô này!") {
        document.getElementById("sn").value = "";

    } else {

    }
}

function check_so_nguoi() {
    var so_ng = document.getElementById("ctm").value;
    if (so_ng == "") {
        document.getElementById("ctm").style.borderColor = "red";
        document.getElementById("ctm").value = "Không được bỏ trống ô này!";
        return false;
    }
    if (isNaN(so_ng)) {
        document.getElementById("ctm").style.borderColor = "red";
        document.getElementById("ctm").value = "Số người phải là dạng số";
        return false;
    } else {
        if (so_ng < 0) {
            document.getElementById("ctm").style.borderColor = "red";
            document.getElementById("ctm").value = "người âm";
            return false;
        } else {
            document.getElementById("ctm").style.borderColor = "#777";
            return true;
        }
    }
}

function check_so_nguoi2() {
    if (document.getElementById("ctm").value == "Số người phải là dạng số" || document.getElementById("ctm").value == "người âm" || document.getElementById("ctm").value == "Không được bỏ trống ô này!") {
        document.getElementById("ctm").value = "";
    } else {

    }
}

function removeAccents(str) {
    var AccentsMap = [
      "aàảãáạăằẳẵắặâầẩẫấậ",
      "AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬ",
      "dđ", "DĐ",
      "eèẻẽéẹêềểễếệ",
      "EÈẺẼÉẸÊỀỂỄẾỆ",
      "iìỉĩíị",
      "IÌỈĨÍỊ",
      "oòỏõóọôồổỗốộơờởỡớợ",
      "OÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢ",
      "uùủũúụưừửữứự",
      "UÙỦŨÚỤƯỪỬỮỨỰ",
      "yỳỷỹýỵ",
      "YỲỶỸÝỴ"    
    ];
    for (var i=0; i<AccentsMap.length; i++) {
      var re = new RegExp('[' + AccentsMap[i].substr(1) + ']', 'g');
      var char = AccentsMap[i][0];
      str = str.replace(re, char);
    }
    return str;
  }

function add() {
    var name = document.getElementById("name").value;
    var cmnd = document.getElementById("id").value;
    var ngay_sinh = document.getElementById("birth").value;
    var email = document.getElementById("email").value;
    var dia_chi = document.getElementById("address").value;
    var loai_customer = document.getElementById("type_customer").value;
    var sale = parseFloat(document.getElementById("sale_off").value);

    var so_ngay_thue = parseFloat(document.getElementById("sn").value)
    var so_nguoi = parseFloat(document.getElementById("ctm").value)
    var loai_phong = parseFloat(document.getElementById("type_room").value);
    var loai_dich_vu = parseFloat(document.getElementById("type_service").value);
    var a = new Customer(name, cmnd, ngay_sinh, email, dia_chi, loai_customer, sale, so_ngay_thue, so_nguoi,
        loai_phong, loai_dich_vu);
    var temp = true;
    for (let i = 0; i < arr.length; i++) {
        if (cmnd == arr[i].getCmnd()) {
            alert("Đã tồn tại số CMND này, yêu cầu nhập lại");
            temp = false;
        }
        console.log(arr[i].getCmnd());

    }
    if (temp) {
        console.log(check_cmnd());
        console.log(check_email());
        console.log(check_ns3());
        console.log(check_sale());
        console.log(check_so_ngay_thue());
        console.log(check_so_nguoi());
        console.log(check_name());
        if (check_cmnd() && check_email() && check_ns() && check_sale() && check_so_ngay_thue() && check_so_nguoi()) {
            arr.push(a);
            name = removeAccents(name);
            a.setName(name);
        } else {
            alert("sai ở đâu đó");
        }

    }

    console.log(cmnd);
    displayTable();

}


function main() {
    var d = new Customer("duc", 1, 22052001, "lehongduc@gmail.com", 1, 1, 50, 3, 2, 500, 500);
    var e = new Customer("dau", 2, 22052002, "lehongduc2@gmail.com", 2, 1, 50, 3, 2, 500, 500);
    arr.push(d);
    arr.push(e);
}

main();