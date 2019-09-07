//para后台接收的集合实体类参数名
//row行的class
//tag列的class
//name实体类属性名
function indexSort(para, row, tag, name) {
	if (para != null && para != '') {
		if (row != null && row != '') {
			if (tag != null && tag != '') {
				if (name != null && name != '') {
					var n = name.split(',');
					for (var i = 0; i < $('.' + row).length; i++) {
						var $tagObject = $('.' + row).eq(i).find("." + tag);
						for (var j = 0; j < n.length; j++) {
							$tagObject.eq(j).attr("name",
									para + "[" + i + "]." + n[j]);
						}
					}
				}
			}
		}
	}
}

// 非空验证
function required(para) {
	var paras = para.split(",");
	for ( var p in paras) {
		if ($("." + p).length > 1) {
			for (var i = 0; i < $("." + p).length; i++) {
				alert("请填写此处信息！");
				$("." + p).eq(i).focus();
				return false;
			}
		} else {
			if ($("." + p).val() == null || $("." + p).val()) {
				alert("请填写此处信息！");
				$("." + p).focus();
				return false;
			}
		}
	}
}

/**
 * 合计
 */
// e this,o单价,s金额,o1总金额,a class
function addOperation(e, o, s, o1, c) {
	$(e).parent().parent().find("input[name='" + s + "']").val(
			$(e).val()
					* $(e).parent().parent().find("input[name='" + o + "']")
							.val());
	operation(s, o1, c);
}
function operation(s, o1, c) {
	var a = 0;
	var num = 0;
	if (c != null && c != '') {
		a = $("." + c);
		for (var i = 0; i < a.length; i++) {
			num += parseFloat(a[i].value);
		}
		$("input[name='" + o1 + "']").val(num);
	} else {
		a = $("input[name='" + s + "']");
		for (var i = 0; i < a.length; i++) {
			num += parseFloat(a[i].value);
		}
		$("input[name='" + o1 + "']").val(num);
	}

}

/**
 * 分页
 */
function jqPage(totalCount, currPage) {
	if (totalCount > 0) {
		$.jqPaginator('#pagination', {
			totalPages : totalCount,
			visiblePages : 10,
			currentPage : currPage,
			first: '<li class="first"><a href="javascript:;">首页</a></li>',
			prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
			next : '<li class="next"><a href="javascript:;">下一页</a></li>',
			page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
			last: '<li class="last"><a href="javascript:;">末页</a></li>',
			jumpPage: '<li class="jumpPage"><input class="jumpin"></li>',
			go:'<li><a href="javascript:;">GO</a></li>',
			pageCountContent:'<li class="pageCountContent">第<lable id="currPagein">0</lable>页，共<lable id="totalPagein">0</lable>页  </li>',
			onPageChange : function(num, type) {
				console.info(type);
				if (type != 'init') {
					$("#currPage").val(num);
					document.forms[0].submit();
				}
			}
		});
	}

}

/**
 * 全选
 */
$(function() {
	$("#checkAll").click(function() {
		$("input[name='sonCheck'").attr("checked", this.checked);
	});
	$("input[name='sonCheck'")
			.click(
					function() {
						$("#checkAll")
								.attr(
										"checked",
										$("input[name='sonCheck']").length == $("input[name='sonCheck']:checked").length ? true
												: false);
					});
});

/**
 * 显示和隐藏
 */
function show(obj) {
	$(obj).attr("style", "display:block;");
}
function hide(obj) {
	$(obj).attr("style", "display:none;");
}

/**
 * 根据选择绑定值
 */
function binding(tag1, obj1, tag2, obj2, tag3, obj3, tag4, obj4, tag5, obj5,
		tag6, obj6, tag7, obj7, tag8, obj8, tag9, obj9,tag10,obj10) {
	if (tag1 != null && obj1 != null) {
		$(window.opener.document).find("input[name='" + tag1 + "']").val(obj1);
	}
	if (tag2 != null && obj2 != null) {
		$(window.opener.document).find("input[name='" + tag2 + "']").val(obj2);
	}
	if (tag3 != null && obj3 != null) {
		$(window.opener.document).find("input[name='" + tag3 + "']").val(obj3);
	}
	if (tag4 != null && obj4 != null) {
		$(window.opener.document).find("input[name='" + tag4 + "']").val(obj4);
	}
	if (tag5 != null && obj5 != null) {
		$(window.opener.document).find("input[name='" + tag5 + "']").val(obj5);
	}
	if (tag6 != null && obj6 != null) {
		$(window.opener.document).find("input[name='" + tag6 + "']").val(obj6);
	}
	if (tag7 != null && obj7 != null) {
		$(window.opener.document).find("input[name='" + tag7 + "']").val(obj7);
	}
	if (tag8 != null && obj8 != null) {
		$(window.opener.document).find("input[name='" + tag8 + "']").val(obj8);
	}
	if (tag9 != null && obj9 != null) {
		$(window.opener.document).find("input[name='" + tag9 + "']").val(obj9);
	}
	if (tag10 != null && obj10 != null) {
		$(window.opener.document).find("input[name='" + tag10 + "']").val(obj10);
	}
	window.close();
}

// 下拉框
function selectValue(tag1, i1, tag2, i2, tag3, i3) {
	if (i1 != null && i1 != '') {
		document.getElementsByName(tag1)[0].options[i1].selected = true;
	}
	if (i2 != null && i2 != '') {
		document.getElementsByName(tag2)[0].options[i2].selected = true;
	}
	if (i3 != null && i3 != '') {
		document.getElementsByName(tag3)[0].options[i3].selected = true;
	}
}

/**
 * 删除父标签的父标签
 */
function remove(num) {
	$(num).parent().parent().remove();
}

var a = document.getElementsByName("sonCheck");
function getProducts() {
	var productIds=window.opener.document.getElementsByName("productIds");
	if(productIds.length>0){
		for (var j = 0; j < $(a+":checked").length; j++) {
			for (var i = 0; i < productIds.length; i++) {
				var productIdVal=$(a+":checked").eq(j).parent().parent().find("td").eq(1).text();
				if(productIds[i].value==productIdVal){
					alert("你添加的商品"+$(a+":checked").eq(j).parent().parent().find("td").eq(2).text()+"已经存在！");
					return;
				}
			}
		}
	}
	for (var i = 0; i < a.length; i++) {
		if (a[i].checked) {
			var rowIndex = a[i].parentElement.parentElement.rowIndex;
			window.opener.add();
			window.opener.document.getElementsByName("productIds")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(1)").text();
			window.opener.document.getElementsByName("productNames")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(2)").text();
			window.opener.document.getElementsByName("productSpecifications")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(3)").text();
			window.opener.document.getElementsByName("productConfigs")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(4)").text();
			window.opener.document.getElementsByName("serialNumbers")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(5)").text();
			window.opener.document.getElementsByName("productPacks")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(6)").text();
			window.opener.document.getElementsByName("batchNumbers")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(7)").text();
			if (window.opener.document.getElementsByName("manufacturerss").length > 0) {
				window.opener.document.getElementsByName("manufacturerss")[0].value = $(
						"tr:eq(" + rowIndex + ") td:eq(8)").text();
			}
			if (window.opener.document.getElementsByName("remarks").length > 0) {
				window.opener.document.getElementsByName("remarks")[0].value = $(
						"tr:eq(" + rowIndex + ") td:eq(9)").text();
			}
		}
	}
}
function getDailySupplies() {
	var productIds=window.opener.document.getElementsByName("productIds");
	if(productIds.length>0){
		for (var j = 0; j < $(a+":checked").length; j++) {
			for (var i = 0; i < productIds.length; i++) {
				var productIdVal=$(a+":checked").eq(j).parent().parent().find("td").eq(1).text();
				if(productIds[i].value==productIdVal){
					alert("你添加的商品"+$(a+":checked").eq(j).parent().parent().find("td").eq(2).text()+"已经存在！");
					return;
				}
			}
		}
	}
	for (var i = 0; i < a.length; i++) {
		if (a[i].checked) {
			window.opener.add();
			var rowIndex = a[i].parentElement.parentElement.rowIndex;
			window.opener.document.getElementsByName("productIds")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(1)").text();
			window.opener.document.getElementsByName("productNames")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(2)").text();
			window.opener.document.getElementsByName("productConfigs")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(3)").text();
			window.opener.document.getElementsByName("productSpecifications")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(4)").text();
			window.opener.document.getElementsByName("batchNumbers")[0].value = $(
					"tr:eq(" + rowIndex + ") td:eq(5)").text();
		}
	}
	window.close();
}
function mainOpen(url) {
	var iWidth = 1000; // 弹出窗口的宽度;
	var iHeight = 600; // 弹出窗口的高度;
	var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
	// 获得窗口的水平位置
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
	window
			.open(
					url,
					"child",
					'height='
							+ iHeight
							+ ',,innerHeight='
							+ iHeight
							+ ',width='
							+ iWidth
							+ ',innerWidth='
							+ iWidth
							+ ',top='
							+ iTop
							+ ',left='
							+ iLeft
							+ ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
}

/**
 * 检索
 */
function changeValue(type) {
	var d = {
		customerName : $("input[name=customerName]").val(),
		customerStatusType : type
	}
	$
			.ajax({
				url : "/ZCManager/customer/getCustomerName.do",
				data : d,
				async : false,
				success : function(cus) {
					$("#customerName").html("");
					var cusName = "";
					for (var int = 0; int < cus.cus.length; int++) {
						cusName += '<tr onclick="selected(this)"><td><input type="hidden" value="'
								+ cus.cus[int].customerId
								+ '"/>'
								+ cus.cus[int].customerName + '</td></tr>';
					}
					$("#customerName").html(cusName);
				}
			});
}
$(function() {
	$("body").click(function() {
		$("#customerName").html("");
	});
});

window.onunload = function() {
	if (window.opener != undefined) {
		window.opener.selected('');
	}
};

// 添加联系人
function addContacts(obj) {
	$(obj)
			.parent()
			.parent()
			.parent()
			.next()
			.eq(0)
			.after(
					'<tr class="r"><td><input name="contactsName" value=" "/></td><td><input name="contactsPhone" value=" "/></td><td><input name="contactsWechat" value=" "/></td><td><input name="contactsQq" value=" "/></td><td><input name="contactsEmail" value=" "/></td><td><input name="contactsTel" value=" "/></td><td></td><td><a onclick="delContacts(this)">删除</a></td></tr>')
}

function save() {
	var productId1 = $("input[name='productId']");
	var productName1 = $("input[name='productName']");
	var productSpecification1 = $("input[name='productSpecification']");
	var productConfig1 = $("input[name='productConfig']");
	var serialNumber1 = $("input[name='serialNumber']");
	var productPack1 = $("input[name='productPack']");
	var batchNumber1 = $("input[name='batchNumber']");
	var manufacturers1 = $("input[name='manufacturers']");
	var remark1 = $("input[name='remark']");
	var createUserName1 = $("input[name='createUserName']");
	var createTime1 = $("input[name='createTime']");
	var productSalesNumber1 = $("input[name='productSalesNumber']");
	var productSalesPrice1 = $("input[name='productSalesPrice']");
	var productSalesMoney1 = $("input[name='productSalesMoney']");

	var productId = new Array();
	var productName = new Array();
	var productSpecification = new Array();
	var productConfig = new Array();
	var productPack = new Array();
	var serialNumber = new Array();
	var batchNumber = new Array();
	var manufacturers = new Array();

	var productSalesNumber = new Array();
	var productSalesPrice = new Array();
	var productSalesMoney = new Array();

	var remark = new Array();
	var createUserName = new Array();
	var createTime = new Array();

	for (var i = 0; i < productId1.length; i++) {
		productId.push(productId1[i].value);
		productName.push(productName1[i].value);
		productSpecification.push(productSpecification1[i].value);
		productConfig.push(productConfig1[i].value);
		serialNumber.push(serialNumber1[i].value);
		productPack.push(productPack1[i].value);
		batchNumber.push(batchNumber1[i].value);
		manufacturers.push(manufacturers1[i].value);
		remark.push(remark1[i].value);
		createUserName.push(createUserName1[i].value);
		createTime.push(createTime1[i].value);
	}
	var msg = {
		productId : productId,
		productName : productName,
		productSpecification : productSpecification,
		productConfig : productConfig,
		serialNumber : serialNumber,
		productPack : productPack,
		batchNumber : batchNumber,
		manufacturers : manufacturers,
		remark : remark,
		createUserName : createUserName,
		createTime : createTime
	};
	$.ajax({
		type : "GET",
		data : msg,
		traditional : true,
		url : "/ZCManager/product/addselectgoods.do",
		success : function() {
			alert("添加成功！");
		}
	});
}
/**
 * 验证黑名单
 */
$(function() {
	$(".rr input").live("change", function() {
		var dat=$(this).val();
		$.ajax({
			url : '/ZCManager/blackcustomer/checkBlackCustomer.do',
			success : function(black) {
				for (var int = 0; int < black.blackCustomer.length; int++) {
					var blackName = black.blackCustomer[int].contactsName;
					if (blackName == dat) {
						alert("您输入的联系人信息已被拉入黑名单！");
					/*	$(".msg").html("您输入的联系人信息已被拉入黑名单，请谨慎添加！");*/
					}
					var blackPhone = black.blackCustomer[int].blacklistPhone;
					if (blackPhone == dat) {
						alert("您输入的联系人电话已被拉入黑名单，请谨慎添加！");
					/*	$(".msg").html("您输入的联系人电话已被拉入黑名单，请谨慎添加！");*/
					}
					var blackWechat = black.blackCustomer[int].blacklistWechat;
					if (blackWechat == dat) {
						alert("您输入的联系人微信已被拉入黑名单，请谨慎添加！");
					/*	$(".msg").html("您输入的联系人微信已被拉入黑名单，请谨慎添加！");*/
					}
					var blackQq = black.blackCustomer[int].blacklistQq;
					if (blackQq == dat) {
						alert("您输入的联系人QQ已被拉入黑名单，请谨慎添加！");
						/*$(".msg").html("您输入的联系人QQ已被拉入黑名单，请谨慎添加！");*/
					}
					var blackEmail = black.blackCustomer[int].blacklistEmail;
					if (blackEmail == dat) {
						alert("您输入的联系人邮箱已被拉入黑名单，请谨慎添加！");
						/*$(".msg").html("您输入的联系人邮箱已被拉入黑名单，请谨慎添加！");*/
					}
					var blackTel = black.blackCustomer[int].blacklistTel;
					if (blackTel == dat) {
						alert("您输入的联系人座机已被拉入黑名单，请谨慎添加！");
						/*$(".msg").html("您输入的联系人座机已被拉入黑名单，请谨慎添加！");*/
					}
				}
			}
		});

	});
});