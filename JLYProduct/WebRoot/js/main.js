$(function() {
	var left_offset = 0

	$("#to_order").mouseover(function() {

		$("#nav_my_order").show()
	}).mouseout(function() {
		$("#nav_my_order").hide()
	})
	var timer = setInterval(autoPlay, 5000)
	$(".banner").mouseover(function() {
		clearInterval(timer)
	}).mouseout(function() {
		timer = setInterval(autoPlay, 5000)
	})
	$("#nav_first_category li").mouseover(function() {
		
		$("#nav_second_category").show()
	}).mouseout(function() {
		$("#nav_second_category").hide()
	})
	$("#nav_second_category").mouseover(function() {
		$("#nav_second_category").show()
	}).mouseout(function() {
		$("#nav_second_category").hide()
	})
	var recommend_timer = setInterval(function() {
		if(left_offset < (-1) * $(".recommend_products li").width()) {
			$(".recommend_products ul").append($(".recommend_products li").eq(0).clone())
			left_offset = 0
			$(".recommend_products ul").css("left", 0)
			$(".recommend_products li").eq(0).remove()
		} else {
			$(".recommend_products ul").css("left", --left_offset)
		}
	}, 30)

})

function autoPlay() {
	var offset = $(".banner_content li img").width()
	$(".banner_content").animate({
		left: (-1) * offset
	}, 1000)
	$(".banner_content").append($(".banner_content li").eq(0).clone())
	setTimeout(function() {
		$(".banner_content li").eq(0).remove()
		$(".banner_content").css("left", "0")
	}, 1500)

}