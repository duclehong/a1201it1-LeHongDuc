@extends('admin_layout')

@section('admin_content')

    <section class="wrapper">

        <div class="table-agile-info">
            <a class="btn btn-success" href="{{ URL::to('/them-san-pham') }}">Thêm sản phẩm</a>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Danh mục sản phẩm
                </div>

                <div>
                    <table class="table" ui-jq="footable"
                        ui-options='{ "paging": { "enabled": true},"filtering": { "enabled": true},"sorting": {"enabled": true }}'>
                        <thead>
                            <tr>
                                <th>Tên sản phẩm</th>
                                <th>Ảnh</th>
                                <th>giá</th>
                                <th>Mô tả</th>
                                <th>Chiết khấu</th>
                                <th>Sửa</th>
                                <th>Xóa</th>

                            </tr>
                        </thead>
                        <tbody>
                            @foreach ($product as $key => $pro)

                                <tr data-expanded="true">
                                    <td>{{ $pro->ten_san_pham }}</td>
                                    <td><img width="50" height="50"
                                            src="{{ asset('public/frontend/images/' . $pro->image) }}" alt=""></td>
                                    <td>{{ $pro->gia }}</td>
                                    <td>{{ $pro->mo_ta }}</td>
                                    <td>{{ $pro->chiet_khau }}%</td>
                                    <td><a href="{{URL::to('/sua-san-pham/'.$pro->id)}}" style="color: rgb(15, 201, 108);font-size: 20px;"><i
                                                class="fa fa-cogs"></i></a></td>
                                    <td><a onclick="return confirm('Bạn có chắc muốn xóa?')" href=""
                                            style="color: rgb(212, 54, 54);font-size: 20px;"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                            @endforeach

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>

@endsection
