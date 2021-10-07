<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Facades\Redirect;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Date;

class AdminController extends Controller
{
    public function login()
    {
        return view('admin_login');
    }
    public function index()
    {
        return view('admin.dashboard');
    }

    public function admin_login(Request $request)
    {
        $admin_email = $request->admin_email;
        $admin_password = md5($request->admin_password);

        $result = DB::table('tbl_admin')->where('admin_email', $admin_email)->where('admin_password', $admin_password)->first();

        if ($result) {
            Session::put('admin_email', $result->admin_email);
            Session::put('admin_name', $result->admin_name);
            Session::put('admin_id', $result->admin_id);
            return Redirect::to('/dashboard');
        } else {
            Session::put('message', 'Sai email hoặc mật khẩu');
            return Redirect::to('/admin');
        }
    }

    public function logout()
    {
        Session::put('admin_email', null);
        Session::put('admin_name', null);
        Session::put('admin_id', null);
        return Redirect::to('/admin');
    }

    public function show_product()
    {
        $product = DB::table('product')->get();

        return view('admin.san_pham')->with('product', $product);
    }
    public function show_add_product()
    {
        $danh_muc = DB::table('danh_muc_con')->get();

        return view('admin.them_san_pham')->with('danh_muc', $danh_muc);
    }
    public function add_product(Request $request)
    {
        $name = $request->product_name;
        $price = $request->product_price;
        $des = $request->product_des;
        $pro_cate = $request->product_cate;
        $get_img = $request->file('product_image');

        $get_name_img = $get_img->getClientOriginalName();
        $name_img = current(explode('.', $get_name_img));
        $new_img = $name_img . "-" . rand(0, 99) . "." . $get_img->getClientOriginalExtension();
        $get_img->move('public/frontend/images', $new_img);

        DB::table('product')->insert([
            'id_danhmuc' => $pro_cate,
            'ten_san_pham' => $name,
            'gia' => $price,
            'mo_ta' => $des,
            'image' => $new_img,
            'chiet_khau' => 0
        ]);

        return Redirect::to('/all-san-pham');
    }
    public function update_product(Request $request)
    {

        

        $name = $request->product_name;
        $price = $request->product_price;
        $des = $request->product_des;
        $chiet_khau = $request->product_chietkhau;
        $pro_cate = $request->product_cate;
        $get_img = $request->file('product_image');

        $id = $request->product_id;

        $product = DB::table('product')->where('id', $id)->first();

        if ($get_img) {
            $get_name_img = $get_img->getClientOriginalName();
            $name_img = current(explode('.', $get_name_img));
            $new_img = $name_img . "-" . rand(0, 99) . "." . $get_img->getClientOriginalExtension();
            $get_img->move('public/frontend/images', $new_img);
        }else{
            $new_img = $product->image;
        }


        DB::table('product')->where('id', $id)->update([
            'id_danhmuc' => $pro_cate,
            'ten_san_pham' => $name,
            'gia' => $price,
            'mo_ta' => $des,
            'image' => $new_img,
            'chiet_khau' => $chiet_khau
        ]);

        return Redirect::to('/all-san-pham');
    }
    public function show_don_hang(){

        $oder = DB::table('oders')->get();

        return view('admin.don_hang')->with('oders',$oder);
    }
    public function show_chi_tiet_don_hang($id){

        $chi_tiet = DB::table('oders_detail')->where('oder_id',$id)->get();

        $product = DB::table('product')->get();
        return view('admin.chi_tiet_don_hang')->with(['chi_tiet'=>$chi_tiet,'san_pham'=> $product ]);
    }
}
