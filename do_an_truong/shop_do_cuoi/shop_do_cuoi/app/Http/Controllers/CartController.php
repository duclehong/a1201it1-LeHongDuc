<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Facades\Redirect;
use Illuminate\Http\Request;

use App\Models\Oder_detail;
use App\Models\Oders;

use Gloudemans\Shoppingcart\Facades\Cart;

class CartController extends Controller
{
    public function show_cart()
    {
        $danh_muc = DB::table('tbl_category_product')->get();
        $danh_muc_con = DB::table('danh_muc_con')->get();
        return view('pages.gio_hang')->with(
            [
                'danh_muc' => $danh_muc,
                'danh_muc_con' => $danh_muc_con,
            ]
        );
    }
    public function save_cart(Request $request)
    {
        $id = $request->id;
        $product = DB::table('product')->where('id',$id)->first();

        $data['id'] = $id;
        $data['name'] = $product->ten_san_pham;
        $data['qty'] = $request->quantity;
        $data['price'] = $product->gia-(($product->gia*$product->chiet_khau)/100);
        $data['weight'] = $request->id;
        $data['options']['image'] = $product->image;

        Cart::add($data);
        // Cart::destroy();
        return Redirect::to('/show-cart');
    }
    public function delete_cart($rowid){
        Cart::remove($rowid);
        return Redirect::to('/show-cart');
    }
    public function add_cart($id)
    {
        $product = DB::table('product')->where('id',$id)->first();

        $data['id'] = $id;
        $data['name'] = $product->ten_san_pham;
        $data['qty'] = 1;
        $data['price'] = $product->gia-(($product->gia*$product->chiet_khau)/100);
        $data['weight'] =   $id;
        $data['options']['image'] = $product->image;

        Cart::add($data);
        // Cart::destroy();
        return Redirect::to('/san-pham');
    }
    public function show_thanh_toan(){

        $danh_muc = DB::table('tbl_category_product')->get();
        $danh_muc_con = DB::table('danh_muc_con')->get();
        return view('pages.thanh_toan')->with(
            [
                'danh_muc' => $danh_muc,
                'danh_muc_con' => $danh_muc_con,
            ]
        );
    }
    public function oders(Request $request){

        $data = array();
        $content = Cart::content();;

        $oder = new Oders();

        $oder->name = $request->ho." ".$request->ten;
        $oder->phone = $request->sdt;
        $oder->address = $request->dia_chi;
        $oder->city = $request->thanh_pho;
        $oder->note = $request->ghi_chu;
        $oder->total = Cart::subtotal();
        $oder->save();

        $id_oder = $oder->id;
        
        $oder_detail = new Oder_detail();
        

        foreach($content as $value){
            $data['oder_id'] = $id_oder;
            $data['product_id'] = $value->id;
            $data['user_id'] = Session::get('id');
            $data['quantity'] = $value->qty;
            $data['price'] = $value->price;
            $data['created_at'] = date('y-m-d')." ".date('h:i:m');
            DB::table('oders_detail')->insert($data);

        }

        Cart::destroy();
        return Redirect::to('/');
    }
    
}
