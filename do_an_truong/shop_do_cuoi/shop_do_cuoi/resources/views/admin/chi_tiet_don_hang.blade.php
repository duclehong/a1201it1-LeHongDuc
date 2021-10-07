@extends('admin_layout')

@section('admin_content')

    <section class="wrapper">

        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Đơn hàng chi tiết
                </div>

                <div>
                    <table class="table" ui-jq="footable"
                        ui-options='{ "paging": { "enabled": true},"filtering": { "enabled": true},"sorting": {"enabled": true }}'>
                        <thead>
                            <tr>
                                <th>Tên sản phẩm</th>
                                <th>hình ảnh</th>
                                <th>số lượng</th>
                                <th>giá</th>
                                <th>tình trạng</th>
                                <th>xóa</th>
                                <th>thời gian</th>

                            </tr>
                        </thead>
                        <tbody>
                            @foreach ($chi_tiet as $chitiet)
                                <tr>
                                    <td>
                                        <?php foreach ($san_pham as $key) {
                                        if ($key->id == $chitiet->product_id) {
                                        echo $key->ten_san_pham;
                                        }
                                        } ?>
                                    </td>
                                    <td>
                                        <?php foreach ($san_pham as $key) {
                                        if ($key->id == $chitiet->product_id) { ?>
                                        <img width="70" src="{{ asset('public/frontend/images/' . $key->image) }}" alt="">
                                        <?php }
                                        } ?>
                                    </td>
                                    <td>{{$chitiet->quantity}}</td>
                                    <td>{{$chitiet->price}}</td>
                                    <td>
                                        <select name="" id="">
                                            <option value="">đang giao</option>
                                            <option value="">đang lấy hàng</option>
                                        </select>
                                    </td>
                                    <td><a href="">xóa</a></td>
                                    <td>{{$chitiet->created_at}}</td>
                                </tr>
                            @endforeach
                            <img src="" alt="">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>

@endsection
