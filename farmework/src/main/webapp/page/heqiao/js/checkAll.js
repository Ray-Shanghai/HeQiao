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