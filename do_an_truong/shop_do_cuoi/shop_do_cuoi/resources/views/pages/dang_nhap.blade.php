@extends('layout')

@section('content')

    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Checkout</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active">đăng nhập hoặc đăng kí</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <h3 class="text-center">
                @if (Session::get('thongbao'))
                    {{Session::get('thongbao')}}
                    {{Session::forget('thongbao')}}
                @endif
            </h3>
            <div class="row new-account-login">
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="title-left">
                        <h3>Đăng nhập tài khoản</h3>
                    </div>
                    <form class="mt-3 review-form-box" id="formLogin" action="{{ URL::to('/dang-nhap-tk') }}"
                        method="POST">

                        {{ csrf_field() }}

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="InputEmail" class="mb-0">Email</label>
                                <input type="email" class="form-control" id="InputEmail" placeholder="Email" name="email">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="InputPassword" class="mb-0">Mật khẩu</label>
                                <input type="password" class="form-control" id="InputPassword" placeholder="Mật khẩu"
                                    name="pass">
                            </div>
                        </div>
                        <button type="submit" class="btn hvr-hover">Đăng nhập</button>
                    </form>
                </div>
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="title-left">
                        <h3>Đăng kí tài khoản</h3>
                    </div>
                    <form class="mt-3  review-form-box" id="formRegister" method="POST" action="{{URL::to('/dang-ki-tk')}}">
                        {{ csrf_field() }}
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="InputName" class="mb-0">Họ *</label>
                                <input type="text" class="form-control" id="InputName" placeholder="Họ" name="ho">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="InputLastname" class="mb-0">Tên *</label>
                                <input type="text" class="form-control" id="InputLastname" placeholder="Tên" name="ten">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="InputEmail1" class="mb-0">Email </label>
                                <input type="email" class="form-control" id="InputEmail1" placeholder="Email" name="email">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="InputPassword1" class="mb-0">Mật khẩu</label>
                                <input type="password" class="form-control" id="InputPassword1" placeholder="Mật khẩu" name="matkhau">
                            </div>
                        </div>
                        <button type="submit" class="btn hvr-hover">Đăng kí</button>
                    </form>
                </div>
            </div>

        </div>
    </div>
    <!-- End Cart -->

@endsection
