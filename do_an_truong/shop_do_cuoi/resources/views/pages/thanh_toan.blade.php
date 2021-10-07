@extends('layout')

@section('content')

    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Checkout</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active">Checkout</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <form action="{{URL::to('/oders')}}" method="POST">
                {{ csrf_field() }}
                <div class="row">
                    <div class="col-sm-6 col-lg-6 mb-3">
                        <div class="checkout-address">
                            <div class="title-left">
                                <h3>Địa chỉ</h3>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="firstName">Họ *</label>
                                    <input type="text" class="form-control" id="firstName" name="ho" required>
                                    <div class="invalid-feedback"> Valid first name is required. </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="lastName">Tên *</label>
                                    <input type="text" class="form-control" id="lastName" name="ten" required>
                                    <div class="invalid-feedback"> Valid last name is required. </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="username">Địa chỉ *</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="username" name="dia_chi" required>
                                    <div class="invalid-feedback" style="width: 100%;"> Your username is required.
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="email">Thành phố *</label>
                                <input type="text" class="form-control" id="email" name="thanh_pho">
                                <div class="invalid-feedback"> Please enter a valid email address for shipping updates.
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="address">Sổ điện thoại *</label>
                                <input type="text" class="form-control" id="address" name="sdt" required>
                                <div class="invalid-feedback"> Please enter your shipping address. </div>
                            </div>
                            <div class="mb-3">
                                <label for="address">Ghi chú</label>
                                <textarea name="ghi_chu" id="" cols="30" rows="10" class="form-control"></textarea>
                                <div class="invalid-feedback"> Please enter your shipping address. </div>
                            </div>
                            <hr class="mb-1">
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-6 mb-3">
                        <div class="row">
                            <div class="col-md-12 col-lg-12">
                                <div class="shipping-method-box">
                                    <div class="title-left">
                                        <h3>Shipping Method</h3>
                                    </div>
                                    <div class="mb-4">
                                        <div class="custom-control custom-radio">
                                            <input id="shippingOption1" name="shipping-option" class="custom-control-input"
                                                checked="checked" type="radio">
                                            <label class="custom-control-label" for="shippingOption1">Standard
                                                Delivery</label> <span class="float-right font-weight-bold">FREE</span>
                                        </div>
                                        <div class="ml-4 mb-2 small">(3-7 business days)</div>
                                        <div class="custom-control custom-radio">
                                            <input id="shippingOption2" name="shipping-option" class="custom-control-input"
                                                type="radio">
                                            <label class="custom-control-label" for="shippingOption2">Express
                                                Delivery</label> <span class="float-right font-weight-bold">$10.00</span>
                                        </div>
                                        <div class="ml-4 mb-2 small">(2-4 business days)</div>
                                        <div class="custom-control custom-radio">
                                            <input id="shippingOption3" name="shipping-option" class="custom-control-input"
                                                type="radio">
                                            <label class="custom-control-label" for="shippingOption3">Next Business
                                                day</label> <span class="float-right font-weight-bold">$20.00</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 col-lg-12">
                                <div class="odr-box">
                                    <div class="title-left">
                                        <h3>Shopping cart</h3>
                                    </div>
                                    <div class="rounded p-2 bg-light">
                                        <?php $content = Cart::content(); ?>
                                        @foreach ($content as $item)
                                            <div class="media mb-2 border-bottom">

                                                <div class="media-body"> <a href="detail.html"> {{ $item->name }}</a>
                                                    <div class="small text-muted">Price: ${{ $item->price }} <span
                                                            class="mx-2">|</span> Qty: {{ $item->qty }} <span
                                                            class="mx-2">|</span> Subtotal: ${{ $item->price * $item->qty }}
                                                    </div>
                                                </div>

                                            </div>
                                        @endforeach
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 col-lg-12">
                                <div class="order-box">
                                    <div class="title-left">
                                        <h3>Your order</h3>
                                    </div>
                                    <div class="d-flex">
                                        <div class="font-weight-bold">Product</div>
                                        <div class="ml-auto font-weight-bold">Total</div>
                                    </div>
                                    <hr class="my-1">
                                    <div class="d-flex">
                                        <h4>Sub Total</h4>
                                        <div class="ml-auto font-weight-bold"> $ 440 </div>
                                    </div>
                                    <div class="d-flex">
                                        <h4>Discount</h4>
                                        <div class="ml-auto font-weight-bold"> $ 40 </div>
                                    </div>
                                    <hr class="my-1">
                                    <div class="d-flex">
                                        <h4>Coupon Discount</h4>
                                        <div class="ml-auto font-weight-bold"> $ 10 </div>
                                    </div>
                                    <div class="d-flex">
                                        <h4>Tax</h4>
                                        <div class="ml-auto font-weight-bold"> $ 2 </div>
                                    </div>
                                    <div class="d-flex">
                                        <h4>Shipping Cost</h4>
                                        <div class="ml-auto font-weight-bold"> Free </div>
                                    </div>
                                    <hr>
                                    <div class="d-flex gr-total">
                                        <h5>Grand Total</h5>
                                        <div class="ml-auto h5"> $ 388 </div>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                            <div class="col-12 d-flex shopping-box">
                                @if (!Session::get('id'))
                                    <a href="{{ URL::to('/dang-nhap') }}" onclick="return confirm('bạn chưa đăng nhập')"
                                        class="ml-auto btn hvr-hover">Đặt hàng</a>
                                @else
                                    <button  type="submit" name="submit"
                                        class="ml-auto btn hvr-hover" style="color: white">Đặt hàng</button>
                                @endif
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- End Cart -->

@endsection
