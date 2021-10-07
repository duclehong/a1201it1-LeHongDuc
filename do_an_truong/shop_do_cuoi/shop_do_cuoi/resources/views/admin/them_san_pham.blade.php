@extends('admin_layout')

@section('admin_content')

    <section class="wrapper">
        
        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Thêm sản phẩm
                </div>
                <div class="panel-body">
                    <div class="position-center">
                        <form role="form" action="{{ URL::to('/add-product') }}" method="POST" enctype="multipart/form-data">

                            {{ csrf_field() }}
                            <div class="form-group">
                                <label for="exampleInputEmail1">Tên sản phẩm</label>
                                <input name="product_name" type="text" class="form-control"
                                    placeholder="Tên danh mục" required="">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Giá sản phẩm</label>
                                <input name="product_price" type="text" class="form-control"
                                placeholder="Tên danh mục" required="">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Danh mục</label>
                                <select name="product_cate" class="form-control" id="">
                                    @foreach ($danh_muc as $item)
                                    <option value="{{$item->id}}">{{$item->name}}</option>
                                    @endforeach
                                    
                                    
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Mô tả</label>
                                <textarea  class="form-control" name="product_des" id="" cols="30" rows="5">

                                </textarea>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Ảnh</label>
                                <input name="product_image" type="file" class="form-control"
                                placeholder="Tên danh mục" required="">
                            </div>

                            <button type="submit" class="btn btn-info" name="category_product_submit">Thêm</button>
                            
                        </form>
                    </div>

                </div>
                
            </div>
        </div>
    </section>

@endsection
