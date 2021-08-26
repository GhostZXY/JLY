$(function() {
	var first_state = false
	var second_state = false
	$("#username").blur(function() {
		if($(this).val() == "") {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("用户名不能为空")
			$(this).siblings("b").hide()
			first_state = false
		} else if($(this).val().length < 8) {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("用户名不能少于8位")
			$(this).siblings("b").hide()
			first_state = false
		} else {
			$(this).css("background", "#F4FCEE")
			$(this).siblings(".tip").text("")
			$(this).siblings("b").show()
			first_state = true
		}
	})
	$("#password").blur(function() {
		if($(this).val() == "") {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("密码不能为空")
			$(this).siblings("b").hide()
			first_state = false
		} else if($(this).val().length < 8) {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("密码不能少于8位")
			$(this).siblings("b").hide()
			first_state = false
		} else {
			$(this).css("background", "#F4FCEE")
			$(this).siblings(".tip").text("")
			$(this).siblings("b").show()
			first_state = true
		}
	})
	$("#repeat_pwd").blur(function() {
		if($(this).val().length < 8 || $(this).val() == "") {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("输入格式有误")
			$(this).siblings("b").hide()
			first_state = false
		} else if($(this).val() != $("#step1 #password").val()) {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("两次密码不一致")
			$(this).siblings("b").hide()
			first_state = false
		} else {
			$(this).css("background", "#F4FCEE")
			$(this).siblings(".tip").text("")
			$(this).siblings("b").show()
			first_state = true

		}
	})
	$("#nickname").blur(function() {
		if($(this).val() == "") {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("不能为空")
			$(this).siblings("b").hide()
			second_state = false
		} else {
			$(this).css("background", "#F4FCEE")
			$(this).siblings(".tip").text("")
			$(this).siblings("b").show()
			second_state = true
		}
	})

	$("#tel").blur(function() {
		if($(this).val() == "") {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("不能为空")
			$(this).siblings("b").hide()
			second_state = false
		} else {
			$(this).css("background", "#F4FCEE")
			$(this).siblings(".tip").text("")
			$(this).siblings("b").show()
			second_state = true
		}
	})
	$("#email").blur(function() {
		if($(this).val() == "") {
			$(this).css("background", "#FFE5E5")
			$(this).siblings(".tip").text("不能为空")
			$(this).siblings("b").hide()
			second_state = false
		} else {
			$(this).css("background", "#F4FCEE")
			$(this).siblings(".tip").text("")
			$(this).siblings("b").show()
			second_state = true
		}
	})

	$("#step1 .next_step").click(function() {
		if(first_state == true) {
			$("#step1").hide()
			$("#step2").show()
			$(".register_progress .step").eq(0).removeClass("on")
			$(".register_progress .step").eq(1).addClass("on")
		}
	})
	$("#step2 .next_step").click(function() {
		if(second_state == true && $("#head").val() != "") {
			$("#step2").hide()
			$("#step3").show()
			$(".register_progress .step").eq(1).removeClass("on")
			$(".register_progress .complete").addClass("on")
//			var sec = 3
//			setInterval(function(){
//				
//				$("#jump_to_home").text("注册成功，"+(--sec)+"秒后跳转到主页")
//				if(sec == 0){
//					window.location.href="home.html"
//				}
//			},1000)
		}
	})
	$("#step2 .previous_step").click(function() {
		$("#step2").hide()
		$("#step1").show()
		$(".register_progress .step").eq(1).removeClass("on")
		$(".register_progress .step").eq(0).addClass("on")
	})
})