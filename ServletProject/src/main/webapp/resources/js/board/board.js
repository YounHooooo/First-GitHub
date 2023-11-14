function detailPage(idx) {
	const pageUrl = '/freeDetail.do?idx=' + idx;
	window.location.href = pageUrl;
}

function boardUpdate() {
	const form = document.getElementById("detail-form");

	form.action = "/boardUpdate.do";
	form.method = "post";
	form.submit();
}

function boardDelete() {

	const form = document.getElementById("detail-form");

	if (confirm("삭제하시겠습니까?")) {
		form.action = "/boardDelete.do";
		form.method = "post";
		form.submit();
	} else {
		form.action = "/views/board/free/freeDetail.jsp"
	}

}
