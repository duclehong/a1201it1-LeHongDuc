<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Facades\Redirect;
class ProductController extends Controller
{
    public function show_san_pham(){

        $danh_muc = DB::table('tbl_category_product')->get();
        $danh_muc_con = DB::table('danh_muc_con')->get();

        $san_pham = DB::table('product')->get();

        return view('pages.san_pham')->with(
            [
                'danh_muc' => $danh_muc,
                'danh_muc_con' => $danh_muc_con,
                'san_pham' =>$san_pham
                
            ]);
        

    }
    public function show_chi_tiet_san_pham($id){
        $danh_muc = DB::table('tbl_category_product')->get();
        $danh_muc_con = DB::table('danh_muc_con')->get();

        $san_pham = DB::table('product')->get();

        $user = DB::table('users')->get();

        $san_pham_chitiet = DB::table('product')->where('id',$id)->get()->first();

        $comment = DB::table('comment')->where('id_product',$id)->orderBy('id','DESC')->get();
        return view('pages.chi_tiet_san_pham')->with(
            [
                'danh_muc' => $danh_muc,
                'danh_muc_con' => $danh_muc_con,
                'san_pham_ct' => $san_pham_chitiet,
                'san_pham' => $san_pham,
                'comment' => $comment,
                'users' => $user,
            ]);
    }
    public function show_sua_san_pham($id){

        $product = DB::table('product')->where('id',$id)->first();
        $category = DB::table('danh_muc_con')->get();

        return view('admin.sua_san_pham')->with('product',$product)->with('category',$category);
    }
    public function san_pham_theo_danh_muc($id){
        $danh_muc = DB::table('tbl_category_product')->get();
        $danh_muc_con = DB::table('danh_muc_con')->get();
        $san_pham = DB::table('product')->where('id_danhmuc',$id)->get();
        return view('pages.san_pham')->with(
            [
                'danh_muc' => $danh_muc,
                'danh_muc_con' => $danh_muc_con,
                'san_pham' =>$san_pham,
            ]);
        
    }
    public function comment($id , Request $request){
        $data = array();
        $data['content'] = $request->content;
        $data['id_product'] = $id;
        $data['id_user'] = Session::get('id');
        $data['created_at'] = date('y-m-d')." ".date('h:i:m');
        

        DB::table('comment')->insert($data);


        return Redirect::to('/chi-tiet-san-pham/'.$id);


    }
    public function search(Request $request){
        $product = DB::table('product')->where('ten_san_pham','like','%'.$request->timkiem.'%')
        ->orWhere('gia','like','%'.$request->timkiem.'%')->get();

        $danh_muc = DB::table('tbl_category_product')->get();
        $danh_muc_con = DB::table('danh_muc_con')->get();

        return view('pages.san_pham')->with(
            [
                'danh_muc' => $danh_muc,
                'danh_muc_con' => $danh_muc_con,
                'san_pham' =>$product
                
            ]);
        

    }
}
