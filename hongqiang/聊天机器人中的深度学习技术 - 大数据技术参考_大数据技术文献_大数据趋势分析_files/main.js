/*返回顶部*/
$(document).ready(function() {
	$(".footer .tab span").toggle(function(){  //合作伙伴&友情链接展开收缩
		$(this).find('em').toggleClass('open');
		$(".footer>.con").eq($('.footer .tab span').index(this)).animate({height: 'toggle', opacity: 'toggle'}, "slow");
	},function(){
		$(this).find('em').toggleClass('open');
		$(".footer>.con").eq($('.footer .tab span').index(this)).animate({height: 'toggle', opacity: 'toggle'}, "slow");
	});
    
	$.fn.manhuatoTop = function(options) {
		var defaults = {showHeight : 150,speed : 1000};
		var options = $.extend(defaults,options);
		$("body").prepend("<div id='totop'><a></a></div>");
		var $toTop = $(this);
		var $top = $("#totop");
		var $ta = $("#totop a");
		$toTop.scroll(function(){
			var scrolltop=$(this).scrollTop();
			if(scrolltop>=options.showHeight){$top.show();}
			else{$top.hide();}
		});
		$top.click(function(){$("html,body").animate({scrollTop: 0}, options.speed);	});
	}

    $(window).manhuatoTop({
		showHeight : 100,//设置滚动高度时显示
		speed : 500 //返回顶部的速度以毫秒为单位
	});

})

