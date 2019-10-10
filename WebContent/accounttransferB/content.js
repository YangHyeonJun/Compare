// window.load는 페이지 로딩 후 실행
window.onload = function() {
	var action = document.form2.action.value;
	var part = document.form2.part.value;
	var selname = documnet.form2.selname.value;
	
	function setHtml(item_id, item_html)
	{
	     obj = document.getElementById(item_id);
	     obj.innerHTML = item_html;
	}

	setHtml("p1",selname);

}