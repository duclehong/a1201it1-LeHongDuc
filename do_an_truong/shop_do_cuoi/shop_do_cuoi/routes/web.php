<?php


use Illuminate\Support\Facades\Route;
/*7
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
//client
Route::get('/', 'HomeController@index');
Route::get('/trang-chu', 'HomeController@index');
Route::get('/dang-nhap', 'HomeController@show_dang_nhap');
Route::post('/dang-nhap-tk', 'HomeController@dang_nhap');

Route::post('/dang-ki-tk', 'HomeController@dang_ki');

Route::get('/dang-xuat', 'HomeController@dang_xuat');

//server
Route::get('/admin','AdminController@login');
Route::get('/dashboard','AdminController@index');
Route::post('/admin-login','AdminController@admin_login');
Route::get('/admin-logout', 'AdminController@logout');

Route::get('/all-san-pham', 'AdminController@show_product');
Route::get('/them-san-pham', 'AdminController@show_add_product');

Route::get('/don-hang', 'AdminController@show_don_hang');

Route::get('/chi-tiet-don-hang/{id}', 'AdminController@show_chi_tiet_don_hang');


//danh muc
Route::get('/add-category', 'CategoryController@add_category_product');
Route::post('/save-category-product', 'CategoryController@save_category_product');
Route::get('/all-category', 'CategoryController@all_category_product');

Route::get('/active-cate-pro/{id_cate_pro}', 'CategoryController@active_cate_pro');
Route::get('/unactive-cate-pro/{id_cate_pro}', 'CategoryController@unactive_cate_pro');
Route::get('/delete-cate-pro/{id_cate_pro}', 'CategoryController@delete_cate_pro');
//danh muc con
Route::get('/add-danh-muc-con', 'CategoryController@show_add_danh_muc_con');
Route::post('/save-danh-muc-con', 'CategoryController@add_danh_muc_con');
Route::get('/danh-muc-con', 'CategoryController@show_danh_muc_con');
Route::get('/active-danh-muc-con/{id}', 'CategoryController@active_danh_muc_con');
Route::get('/unactive-danh-muc-con/{id}', 'CategoryController@unactive_danh_muc_con');
Route::get('/delete-danh-muc-con/{id}', 'CategoryController@delete_danh_muc_con');

//product
Route::get('/san-pham', 'ProductController@show_san_pham');
Route::get('/chi-tiet-san-pham/{id}', 'ProductController@show_chi_tiet_san_pham');

Route::post('/add-product', 'AdminController@add_product');

Route::get('/sua-san-pham/{id}', 'ProductController@show_sua_san_pham');

Route::get('/san-pham-theo-danh-muc/{id}', 'ProductController@san_pham_theo_danh_muc');

Route::post('/update-product', 'AdminController@update_product');

Route::post('/comment/{id}', 'ProductController@comment');

Route::post('/search', 'ProductController@search');

//cart
Route::post('/save-cart', 'CartController@save_cart');
Route::get('/show-cart', 'CartController@show_cart');
Route::get('/delete-cart/{rowid}', 'CartController@delete_cart');
Route::get('/add-cart/{id}', 'CartController@add_cart');

Route::get('/thanh-toan', 'CartController@show_thanh_toan');

Route::post('/oders', 'CartController@oders');

//đặt bàn
Route::get('/dat-ban', 'DatBanController@show_datban');

