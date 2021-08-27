$(function() {
	var total = 0
	var li_list = $(".sc_list").find("li")
	li_list.each(function() {
		var num = Number($(this).find(".li_num").val())
		var price = Number($(this).find(".pro_price").text())
		$(this).find("#li_total").val(num * price)
	})

	$(".li_btn_add").click(function() {
		var num = Number($(this).siblings(".li_num").val()) + 1
		var price = Number($(this).parents("li").find(".pro_price").text())
		$(this).siblings(".li_num").val(num)
		$(this).parents("li").find("#li_total").val(num * price)
		total_price()
	})
	$(".li_btn_sub").click(function() {
		var num = Number($(this).siblings(".li_num").val()) - 1
		var price = Number($(this).parents("li").find(".pro_price").text())
		if(num > 0) {
			$(this).siblings(".li_num").val(num)
			$(this).parents("li").find("#li_total").val(num * price)
			total_price()
		}
	})
	$(".li_check").click(function() {
		total_price()
	})
	$(".selectStore").click(function() {
		var store_items = $(this).parent(".btn_selectStore").next("ul").find("li")
		if($(this).is(":checked")) {
			store_items.each(function() {
				$(this).find(".li_check").prop("checked", true)
			})
		} else {
			store_items.each(function() {
				$(this).find(".li_check").prop("checked", false)

			})
		}
		total_price()
	})
	$("#selectAll").click(function() {

		if($(this).is(":checked")) {
			$(".selectStore").each(function() {
				$(this).prop("checked", true)
			})
			li_list.each(function() {
				$(this).find(".li_check").prop("checked", true)
			})
		} else {
			$(".selectStore").each(function() {
				$(this).prop("checked", false)
			})
			li_list.each(function() {
				$(this).find(".li_check").prop("checked", false)
			})
		}
		total_price()
	})

	function total_price() {
		total = 0
		li_list.each(function() {
			if($(this).find(".li_check").is(":checked")) {
				total += Number($(this).find("#li_total").val())
			}
		})
		$("#total_price").text(total)
	}
})