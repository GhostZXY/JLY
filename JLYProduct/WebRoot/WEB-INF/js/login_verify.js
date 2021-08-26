$(function() {
	$("#login_btn").click(function() {
		if($("#username").val() == "") {
			$(".tip font").text("账号不能为空")
			$(".tip").show()
		} else if($("#password").val() == "") {
			$(".tip font").text("密码不能为空")
			$(".tip").show()
		}else{
			$(".login form").submit()
		}
	})
})