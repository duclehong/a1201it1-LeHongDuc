function getUrlwindow(sParam) {
	var pageUrl =  $(location).attr('search').substring(1);
	var arrUrl = pageUrl.split("&");
	for (var i=0; i< arrUrl.length; i++) {
		var pair = arrUrl[i].split("=");
		if(pair[0] == sParam){
			return pair[1];}
		}
	}
var email = decodeURIComponent(getUrlwindow('email'));
	var username = decodeURIComponent(getUrlwindow('username'));
	var phone_number = decodeURIComponent(getUrlwindow('phone_number'));
	var address = decodeURIComponent(getUrlwindow('address'));
	var address_2 = decodeURIComponent(getUrlwindow('address_2'));
	var message = decodeURIComponent(getUrlwindow('message'));


	$('.email').html('Email: '+ email);
	$('.username').html('Your name: '+ username);
	$('.phone_number').html('Phone: '+ phone_number);
	$('.message').html('Notes: ' + message);
	$('.address').html('Ward: ' + address);
	$('.address_2').html('Province : ' + address_2);
