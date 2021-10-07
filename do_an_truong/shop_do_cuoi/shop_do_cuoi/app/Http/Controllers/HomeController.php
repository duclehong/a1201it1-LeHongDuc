<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Facades\Redirect;

class HomeController extends Controller
{
    public function index()
    {

        $danh_muc = DB::table('tbl_category_product')->get();
        $danh_muc_con = DB::table('danh_muc_con')->get();
        return view('pages.home')->with(
            [
                'danh_muc' => $danh_muc,
                'danh_muc_con' => $danh_muc_con,
            ]
        );
    }
    public function show_dang_nhap()
    {
        $danh_muc = DB::table('tbl_category_product')->get();
        $danh_muc_con = DB::table('danh_muc_con')->get();
        return view('pages.dang_nhap')->with(
            [
                'danh_muc' => $danh_muc,
                'danh_muc_con' => $danh_muc_con,
            ]
        );
    }
    public function dang_nhap(Request $request)
    {
        $email = request()->email;
        $pass = md5(request()->pass);

        $result = DB::table('users')->where('email', $email)->where('password', $pass)->first();

        if ($result) {
            Session::put('email', $result->email);
            Session::put('name', $result->name);
            Session::put('id', $result->id);
            return Redirect::to('/trang-chu');
        } else {
            Session::put('message', 'Sai email hoặc mật khẩu');
            return Redirect::to('/dang-nhap');
        }
    }
    public function dang_ki(Request $request)
    {
        $email = request()->email;
        $pass = md5(request()->matkhau);
        $ho = $request->ho;
        $ten = $request->ten;

        $result = DB::table('users')->where('email', $email)->first();

        if ($result) {
            Session::put('thongbao', 'Tải khoản đã tồn tại');
            return Redirect::to('/dang-nhap');
        } else {
           DB::table('users')->insert([
               'email' => $email,
               'password' => $pass,
               'name' => $ho." ".$ten,
               'created_at' => date('y-m-d')." ".date('h:i:m'),
           ]);
           Session::put('thongbao', 'Đăng kí thành công');
           return Redirect::to('/dang-nhap');
        }
    }
    public function dang_xuat()
    {
        Session::forget('email');
        Session::forget('name');
        Session::forget('id');

        return Redirect::to('/trang-chu');
    }
}
