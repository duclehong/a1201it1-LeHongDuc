@extends('layout')

@section('content')

    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Cart</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active">Cart</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                        <pre>
                            <?php
                                $content = Cart::content();
                                
                            ?>
                        </pre>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Images</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody>
                                @foreach ($content as $item)
                                <tr>
                                    <td class="thumbnail-img">
                                        <a href="#">
                                            <img class="img-fluid" src="{{asset('public/frontend/images/'.$item->options->image)}}" alt="" />
                                        </a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="{{URL::to('/chi-tiet-san-pham/'.$item->id)}}">
                                            {{$item->name}}
                                        </a>
                                    </td>
                                    <td class="price-pr">
                                        <p>${{$item->price}}</p>
                                    </td>
                                    <td class="quantity-box"><input type="number" size="4" value="{{$item->qty}}" min="0" step="1"
                                            class="c-input-text qty text"></td>
                                    <td class="total-pr">
                                        <p>${{number_format($item->price*$item->qty)}}</p>
                                    </td>
                                    <td class="remove-pr">
                                        <a href="{{URL::to('/delete-cart/'.$item->rowId)}}">
                                            <i class="fas fa-times"></i>
                                        </a>
                                    </td>
                                </tr>
                                @endforeach
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-6 col-sm-6">
                    <div class="coupon-box">
                        <div class="input-group input-group-sm">
                            <input class="form-control" placeholder="Enter your coupon code" aria-label="Coupon code"
                                type="text">
                            <div class="input-group-append">
                                <button class="btn btn-theme" type="button">Voucher giảm giá</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-sm-6">
                    <div class="update-box">
                        <input value="Cập nhật" type="submit">
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-8 col-sm-12"></div>
                <div class="col-lg-4 col-sm-12">
                    <div class="order-box">
                        <h3>Thống kê</h3>
                        <div class="d-flex">
                            <h4>Tổng</h4>
                            <div class="ml-auto font-weight-bold"> $ {{Cart::subtotal()}} </div>
                        </div>
                        <div class="d-flex">
                            <h4>Giảm giá</h4>
                            <div class="ml-auto font-weight-bold"> $ 0.00 </div>
                        </div>
                        <hr class="my-1">
                        <div class="d-flex">
                            <h4>Phiếu giảm giá</h4>
                            <div class="ml-auto font-weight-bold"> $ 0 </div>
                        </div>
                        <div class="d-flex">
                            <h4>Phí vận chuyển</h4>
                            <div class="ml-auto font-weight-bold"> Free </div>
                        </div>
                        <hr>
                        <div class="d-flex gr-total">
                            <h5>Tổng cộng</h5>
                            <div class="ml-auto h5"> $ {{Cart::subtotal()}} </div>
                        </div>
                        <hr>
                    </div>
                </div>
                <div class="col-12 d-flex shopping-box"><a href="{{URL::to('/thanh-toan')}}" class="ml-auto btn hvr-hover">Thanh toán</a>
                </div>
            </div>

        </div>
    </div>
    <!-- End Cart -->

@endsection
