@extends('admin_layout')

@section('admin_content')
    <section class="wrapper">
        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Danh mục con
                </div>
                <div>
                    <table class="table" ui-jq="footable"
                        ui-options='{ "paging": { "enabled": true},"filtering": { "enabled": true},"sorting": {"enabled": true }}'>
                        <thead>
                            <tr>
                                <th data-breakpoints="xs">Tên danh mục</th>
                                <th>Danh mục cha</th>
                                <th>Ẩn/Hiện</th>
                                <th>Sửa</th>
                                <th data-breakpoints="xs">Xóa</th>

                            </tr>
                        </thead>
                        <tbody>
                            @foreach ($danhmuc_con as $key => $cate_pro)
                                <tr data-expanded="true">
                                    <td>{{ $cate_pro->name }}</td>
                                    <td>
                                       @foreach ($danhmuc as $key => $danh_muc)
                                           @if ($danh_muc->category_id == $cate_pro->id_cate)
                                               {{$danh_muc->category_name}}
                                           @endif
                                       @endforeach
                                        
                                    </td>
                                    <td>
                                        <?php if ($cate_pro->category_status == 0) { ?>
                                        <a style="color: rgb(212, 54, 54)"
                                            href={{ URL::to('/active-danh-muc-con/' . $cate_pro->id) }}><i
                                                class="fa fa-thumbs-down"></i></a>
                                        <?php } else { ?>
                                        <a style="color: rgb(68, 226, 81)"
                                            href={{ URL::to('/unactive-danh-muc-con/' . $cate_pro->id) }}><i
                                                class="fa fa-thumbs-up"></i></a>
                                        <?php } ?>

                                    </td>
                                    <td><a href="" style="color: rgb(15, 201, 108);font-size: 20px;"><i
                                                class="fa fa-cogs"></i></a></td>
                                    <td><a onclick="return confirm('Bạn có chắc muốn xóa?')"
                                            href={{ URL::to('/delete-danh-muc-con/' . $cate_pro->id) }}
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
