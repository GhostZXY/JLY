$(function() {
	$("article ul li").click(function() {
		var index = $(this).index()
		if($(".edit_block:nth-of-type(2)").css("display") == "block") {
			alert("修改信息")
		}
		$(this).addClass("on")
		$(this).siblings("li").removeClass("on")
		$(".edit_block").eq(index).show().siblings(".edit_block").hide()
	})
	$(".my_info .edit").click(function() {
		$(".nickname").hide()
		$("#nickname").val($(".nickname").text()).show().focus()

	})
	$("#nickname").blur(function() {
		$(this).hide()
		$(".nickname").text($(this).val()).show()
	})
	$(".default_btn").click(function() {
		$(".default").text("设为默认").removeClass("default")
		$(this).text("默认地址").addClass("default")
		
	})
	$(".close").click(function(){
		$(this).parents(".mask").hide()
	})
	$(".add_address").click(function(){
		$(".mask").show()
		$(".address_add_client").show()
	})
	
})