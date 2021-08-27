$(function() {
	$("#add_btn").click(function() {
		$("#num").val(Number($("#num").val()) + 1)
	})
	$("#sub_btn").click(function() {
		if(Number($("#num").val()) > 1) {
			$("#num").val(Number($("#num").val()) - 1)
		}

	})
	$(".fa-angle-left").click(function() {

		$(".pic_select ul").animate({
			left: 0
		}, 500)
	})
	$(".fa-angle-right").click(function() {
		if($(".pic_select ul li").length > 4) {
			$(".pic_select ul").animate({
				left: -102
			}, 500)
		}
	})
	$(".pic_main img").mousemove(function(e) {
		$(".pic_zoom").css("display", "block")
		var x = (e.pageX - $(this).offset().left) * (-2) + 300; //获取当前鼠标相对img的X坐标  
		var y = (e.pageY - $(this).offset().top) * (-2) + 260; //获取当前鼠标相对img的Y坐标  
		if(x > 0) x = 0
		if(x < -220) x = -220
		if(y > 0) y = 0
		if(y < -200) y = -200
		$(".pic_zoom").css("background-position-x", x)
		$(".pic_zoom").css("background-position-y", y)
	})
	$(".pic_main img").mouseout(function() {
		$(".pic_zoom").css("display", "none")
	})
	$(".pic_select ul li").mouseover(function() {
		var src = $(this).find("img").attr("src")
		$(".pic_main img").attr("src", src)
		$(".pic_zoom").css("background-image", "url(" + src + ")")
	})
})