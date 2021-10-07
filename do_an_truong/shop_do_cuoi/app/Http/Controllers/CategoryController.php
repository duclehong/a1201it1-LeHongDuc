<?php

namespace App\Http\Controllers;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Facades\Redirect;
use Illuminate\Http\Request;

class CategoryController extends Controller
{
    public function add_category_product()
    {
        return view('admin.add_category_product');
    }
    public function save_category_product(Request $request)
    {
        $data = array();
        $data['category_name'] = $request->category_product_name;
        $data['category_status'] = $request->category_product_status;

        DB::table('tbl_category_product')->insert($data);
        return Redirect::to('/all-category');
    }
    public function all_category_product()
    {
        $all_category_product = DB::table('tbl_category_product')->get();
        $manager_category_product = view('admin.all_category_product')->with('all_category_product',$all_category_product);

        return view('admin_layout')->with('admin.all_category_product',$manager_category_product);
    }
    public function delete_cate_pro($id_cate_pro)
    {
       DB::table('tbl_category_product')->where('category_id',$id_cate_pro)->delete();
       return Redirect::to('/all-category');
    }
    public function active_cate_pro($id_cate_pro)
    {
       DB::table('tbl_category_product')->where('category_id',$id_cate_pro)->update(['category_status' => 1]);
       return Redirect::to('/all-category');
    }
    public function unactive_cate_pro($id_cate_pro)
    {
       DB::table('tbl_category_product')->where('category_id',$id_cate_pro)->update(['category_status' => 0]);
       return Redirect::to('/all-category');
    }
    public function show_add_danh_muc_con(){
        $category_product = DB::table('tbl_category_product')->get();

        return view('admin.add_danh_muc_con', ['category_product' => $category_product]);
    
    }

    //danh mục con
    public function add_danh_muc_con(Request $request){
        $data = array();
        $data['name'] = $request->category_product_name;
        $data['id_cate'] = $request->category_id;
        $data['category_status'] = $request->category_product_status;

        DB::table('danh_muc_con')->insert($data);
        return Redirect::to('/add-danh-muc-con');
    }
    public function show_danh_muc_con(){
        $danh_muc_con = DB::table('danh_muc_con')->get();

        $danh_muc = DB::table('tbl_category_product')->get();

        return view('admin.danh_muc_con',['danhmuc_con' => $danh_muc_con,'danhmuc' => $danh_muc]);
    }
    public function active_danh_muc_con($id){
        DB::table('danh_muc_con')->where('id',$id)->update(['category_status' => 1]);
        return Redirect::to('/danh-muc-con');
    }
    public function unactive_danh_muc_con($id){
        DB::table('danh_muc_con')->where('id',$id)->update(['category_status' => 0]);
       return Redirect::to('/danh-muc-con');
    }
    public function delete_danh_muc_con($id){
        DB::table('danh_muc_con')->where('id',$id)->delete();
        return Redirect::to('/danh-muc-con');
    }
}
