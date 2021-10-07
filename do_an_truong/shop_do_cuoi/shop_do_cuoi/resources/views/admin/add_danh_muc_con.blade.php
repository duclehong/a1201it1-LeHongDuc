@extends('admin_layout')

@section('admin_content')

    <section class="wrapper">
        <div class="form-w3layouts">
            <!-- page start-->
            <!-- page start-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Thêm danh mục con
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                                <form role="form" action="{{ URL::to('/save-danh-muc-con') }}" method="POST">

                                    {{ csrf_field() }}
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Tên danh mục</label>
                                        <input name="category_product_name" type="text" class="form-control"
                                            placeholder="Tên danh mục" required="">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputFile">danh mục cha</label>
                                        <select name="category_id" class="form-control" id="">
                                            @foreach( $category_product as $key)
                                            <option value="{{$key->category_id}}">{{$key->category_name}}</option>
                                            
                                            @endforeach
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputFile">Hiển thị</label>
                                        <select name="category_product_status" class="form-control" name="" id="">
                                            <option value="0">Ẩn</option>
                                            <option value="1">Hiện</option>
                                        </select>
                                    </div>

                                    <button type="submit" class="btn btn-info" name="category_product_submit">Thêm</button>
                                    
                                </form>
                            </div>

                        </div>
                    </section>

                </div>
            </div>

            <!-- page end-->
        </div>
    </section>

@endsection
