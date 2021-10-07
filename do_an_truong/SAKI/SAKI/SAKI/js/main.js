//Con tro len trang dau tien
$("#back-to-top-top").click(function(){return $("body, html").animate({scrollTop:0},1000),!1});
$(function(){$('[data-toggle="tooltip"]').tooltip()});
//cuon thanh menu
 $(document).ready(function(){
$(window).scroll(function(){
  if($(window).scrollTop()>60)
  {
    $('.my-navbar').addClass('navbar-scroll');

  }
  else{
    $('.my-navbar').removeClass('navbar-scroll');
  }
});
  });
