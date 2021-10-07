         $(document).on('click','.btn-buy-now',function(e)
            {
                e.preventDefault();
            var parent = $(this).parents('.card');
            var cart=$(document).find('#cart-shop');
            var src=parent.find('img').attr('src');
            var parTop=parent.offset().top;
            var parLef=parent.offset().left;

            $('<img />',{
                class:'img-product-fly',
                src:src
            }).appendTo('body').css({
                'top':parTop,
                'left':parseInt(parLef)+parseInt(parent.width()) -50
            });
            setTimeout(function(){
$(document).find('.img-product-fly').css({
    'top':cart.offset().top,
                'left':cart.offset().left
});
setTimeout(function(){
$(document).find('.img-product-fly').remove();
var citem=parseInt(cart.find('#count-icon').data('count'))+1;
cart.find('#count-icon').text(citem+' cart').data('count',citem);
},1000);
            },500);
            
        });
$(document).ready(function() {
    var lastScrollTop = 0;
    $(window).scroll(function() {
        var currentScrollTop = $(this).scrollTop();
        if (currentScrollTop < lastScrollTop) {
            // Trượt lên
        } else {
            // Trượt xuống
        }
        lastScrollTop = currentScrollTop;
    });
});

$("#02").elevateZoom();
$(document).ready(function(){
            $('#01').zoom();
            $('#02').zoom();
            $('#03').zoom();
            $('#04').zoom();
            $('#05').zoom();
            $('#06').zoom();
            $('#07').zoom();
            $('#08').zoom();
            ;
        });