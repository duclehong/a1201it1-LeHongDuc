@extends('admin_layout')

@section('admin_content')

    <section class="wrapper">

        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Đơn hàng
                </div>

                <div>
                    <table class="table" ui-jq="footable"
                        ui-options='{ "paging": { "enabled": true},"filtering": { "enabled": true},"sorting": {"enabled": true }}'>
                        <thead>
                            <tr>
                                <th>Tên khách hàng</th>
                                <th>Số điện thoại</th>
                                <th>Địa chỉ</th>
                                <th>thành phố</th>
                                <th>ghi chú</th>
                                <th>tổng tiền</th>
                                <th>xóa</th>

                            </tr>
                        </thead>
                        <tbody>
                            @foreach ($oders as $item)
                            <tr>
                                <td>{{$item->name}}</td>
                                <td>{{$item->phone}}</td>
                                <td>{{$item->address}}</td>
                                <td>{{$item->city}}</td>
                                <td>{{$item->note}}</td>
                                <td>{{$item->total}}</td>
                                <td><a href="">xóa</a></td>
                                <td><a href="{{URL::to('/chi-tiet-don-hang/'.$item->id)}}">chi tiết</a></td>
                            </tr>
                            @endforeach
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>

@endsection
