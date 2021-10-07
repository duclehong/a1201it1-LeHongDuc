@extends('layout')

@section('content')

<div id="slides-shop" class="cover-slides">
    <ul class="slides-container">
        <li class="text-left">
            <img src="{{asset('public/frontend/images/bn1.jpg')}}" alt="">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="m-b-20"><strong>Welcome To <br> The Wedding Shop</strong></h1>
                        <p class="m-b-40"> Bây giờ hãy bắt đầu trải nghiệm và tham khảo các dịch vụ cho tiệc cưới của bạn</p>
                        <p><a class="btn hvr-hover" href="#">Shop New</a></p>
                    </div>
                </div>
            </div>
        </li>
        <li class="text-center">
        <img src="{{asset('public/frontend/images/bns.jpg')}}" alt="">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="m-b-20"><strong>Welcome To <br> The Wedding Shop</strong></h1>
                        <p class="m-b-40"> Bây giờ hãy bắt đầu trải nghiệm và tham khảo các dịch vụ cho tiệc cưới của bạn</p>
                        <p><a class="btn hvr-hover" href="#">Shop New</a></p>
                    </div>
                </div>
            </div>
        </li>
        <li class="text-right">
        <img src="{{asset('public/frontend/images/bn4.jpg')}}" alt="">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="m-b-20"><strong>Welcome To <br> The Wedding Shop</strong></h1>
                        <p class="m-b-40"> Bây giờ hãy bắt đầu trải nghiệm và tham khảo các dịch vụ cho tiệc cưới của bạn</p>
                        <p><a class="btn hvr-hover" href="#">Shop New</a></p>
                    </div>
                </div>
            </div>
        </li>
    </ul>
    <div class="slides-navigation">
        <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
        <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
    </div>
</div>
<!-- Start Categories  -->
<div class="categories-shop">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="images/t-shirts-img.jpg" alt="" />
                    <a class="btn hvr-hover" href="#"> Váy cưới</a>
                </div>
                <div class="shop-cat-box">
                    <img class="img-fluid" src="images/shirt-img.jpg" alt="" />
                    <a class="btn hvr-hover" href="#"> Áo vest</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="images/wallet-img.jpg" alt="" />
                    <a class="btn hvr-hover" href="#">Bộ đồ cô dâu</a>
                </div>
                <div class="shop-cat-box">
                    <img class="img-fluid" src="images/women-bag-img.jpg" alt="" />
                    <a class="btn hvr-hover" href="#">Bộ đồ chú rể</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid" src="images/shoes-img.jpg" alt="" />
                    <a class="btn hvr-hover" href="#">Giày cô dâu</a>
                </div>
                <div class="shop-cat-box">
                    <img class="img-fluid" src="images/women-shoes-img.jpg" alt="" />
                    <a class="btn hvr-hover" href="#"> Giày chú rể</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Categories -->

<!-- Start Products  -->
<div class="products-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="title-all text-center">
                    <h1>Sản phẩm nổi bật </h1>
                    <p> Xem thêm ở phần menu</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="special-menu text-center">
                    <div class="button-group filter-button-group">
                        <button class="active" data-filter="*">All</button>
                        <button data-filter=".top-featured">Top featured</button>
                        <button data-filter=".best-seller">Best seller</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="row special-list">
            <div class="col-lg-3 col-md-6 special-grid best-seller">
                <div class="products-single fix">
                    <div class="box-img-hover">
                        <div class="type-lb">
                            <p class="sale">Sale 35%</p>
                        </div>
                        <img src="{{asset('public/frontend/images/ft1.jpg')}}"  class="img-fluid" alt="Image">
                        <div class="mask-icon">
                            <ul>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                            </ul>
                            <a class="cart" href="#">Add to Cart</a>
                        </div>
                    </div>
                    <div class="why-text">
                        <h4>Hotdeal ÁO VEST NHUNG NAM</h4>
                        <h5> $69</h5>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 special-grid top-featured">
                <div class="products-single fix">
                    <div class="box-img-hover">
                        <div class="type-lb">
                            <p class="new">New</p>
                        </div>
                        <img src="{{asset('public/frontend/images/ft2.jpg')}}"  class="img-fluid" alt="Image">
                        <div class="mask-icon">
                            <ul>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                            </ul>
                            <a class="cart" href="#">Add to Cart</a>
                        </div>
                    </div>
                    <div class="why-text">
                        <h4>áo vest nam xanh xước</h4>
                        <h5> $12.65</h5>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 special-grid top-featured">
                <div class="products-single fix">
                    <div class="box-img-hover">
                        <div class="type-lb">
                            <p class="sale">Sale</p>
                        </div>
                        <img src="{{asset('public/frontend/images/ft3.jpg')}}"  class="img-fluid" alt="Image">
                        <div class="mask-icon">
                            <ul>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                            </ul>
                            <a class="cart" href="#">Add to Cart</a>
                        </div>
                    </div>
                    <div class="why-text">
                        <h4>Áo vest thanh lịch</h4>
                        <h5> $100</h5>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 special-grid best-seller">
                <div class="products-single fix">
                    <div class="box-img-hover">
                        <div class="type-lb">
                            <p class="sale">Sale 20%</p>
                        </div>
                        <img src="{{asset('public/frontend/images/ft4.jpg')}}"  class="img-fluid" alt="Image">
                        <div class="mask-icon">
                            <ul>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>
                                <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                            </ul>
                            <a class="cart" href="#">Add to Cart</a>
                        </div>
                    </div>
                    <div class="why-text">
                        <h4>Set đồ chú rể</h4>
                        <h5> $155.79</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Products  -->

<!-- Start Blog  -->
<div class="latest-blog">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="title-all text-center">
                    <h1>Luôn đồng hành cùng các cặp đôi</h1>
                    <p> Nhiều ưu đãi và dịch vụ tiện lợi</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-lg-4 col-xl-4">
                <div class="blog-box">
                    <div class="blog-img">
                        <img class="img-fluid" src="images/blog-img.jpg" alt="" />
                    </div>
                    <div class="blog-content">
                        <div class="title-blog">
                            <h3>Hỗ trọ tư vấn các gói dịch vụ cho các cặp đôi</h3>
                            <p> Hãy liên hệ ngay với The Wedding Shop để được tư vấn và trải nghiệm những dịch vụ cần có trong đám cưới, tính toán chi phí hiệu quả, đội ngũ nhân viên luôn sẵn sàng 24/7 để giải đáp thắc mắc cho bạn.</p>
                        </div>
                        <ul class="option-blog">
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Likes"><i class="far fa-heart"></i></a></li>
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Views"><i class="fas fa-eye"></i></a></li>
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Comments"><i class="far fa-comments"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-4 col-xl-4">
                <div class="blog-box">
                    <div class="blog-img">
                        <img class="img-fluid" src="images/blog-img-01.jpg" alt="" />
                    </div>
                    <div class="blog-content">
                        <div class="title-blog">
                            <h3>Cam kết về chất lượng sản phẩm</h3>
                            <p>The Wedding Shop cam kết mọi sản phẩm mà bạn mua đều có xuất xứ tại Việt Nam. Chất liệu cao cấp đáp ứng hoàn hảo cho các lễ cưới truyền thống hay hiện đại. Hoàn trả tiền nếu không như cam kết.</p>
                        </div>
                        <ul class="option-blog">
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Likes"><i class="far fa-heart"></i></a></li>
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Views"><i class="fas fa-eye"></i></a></li>
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Comments"><i class="far fa-comments"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-4 col-xl-4">
                <div class="blog-box">
                    <div class="blog-img">
                        <img class="img-fluid" src="images/blog-img-02.jpg" alt="" />
                    </div>
                    <div class="blog-content">
                        <div class="title-blog">
                            <h3>Dịch vụ bảo hành an toàn</h3>
                            <p> Các dòng sản phẩm cao cấp của The Way Shop đều được đảm bảo về chất lượng và mọi sự cố và lỗi trên sản phẩm khi phát sinh do yếu tố nhà sản xuất sẽ được bảo hành trong vòng 4 tháng.</p>
                        </div>
                        <ul class="option-blog">
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Likes"><i class="far fa-heart"></i></a></li>
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Views"><i class="fas fa-eye"></i></a></li>
                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Comments"><i class="far fa-comments"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Blog  -->
@endsection