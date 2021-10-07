@extends('admin_layout')

@section('admin_content')

    <section class="wrapper">
        
        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Sửa sản phẩm
                </div>
                <div class="panel-body">
                    <div class="position-center">
                        <form role="form" action="{{ URL::to('/update-product') }}" method="POST" enctype="multipart/form-data">

                            {{ csrf_field() }}
                            <input type="hidden" value="{{$product->id}}" name="product_id">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Tên sản phẩm</label>
                                <input name="product_name" type="text" class="form-control"
                                    placeholder="Tên danh mục" required="" value="{{$product->ten_san_pham}}">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Giá sản phẩm</label>
                                <input name="product_price" type="text" class="form-control"
                                placeholder="Tên danh mục" required="" value="{{$product->gia}}">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Chiết khẩu</label>
                                <input name="product_chietkhau" type="text" class="form-control"
                                placeholder="Tên danh mục" required="" value="{{$product->chiet_khau}}">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Danh mục</label>
                                <select name="product_cate" class="form-control" id="">
                                   @foreach ($category as $row)
                                   <option value="{{$row->id}}">{{$row->name}}</option>
                                   @endforeach
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Mô tả</label>
                                <textarea   class="form-control" name="product_des" id="" cols="30" rows="5">
                                    {{$product->mo_ta}}
                                </textarea>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Ảnh</label>
                                <input value="" name="product_image" type="file" class="form-control"
                                placeholder="Tên danh mục">
                            </div>

                            <button type="submit" class="btn btn-info" name="category_product_submit">Sửa</button>
                            
                        </form>
                    </div>

                </div>
                
            </div>
        </div>
    </section>

@endsection
