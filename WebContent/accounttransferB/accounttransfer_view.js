// window.load는 페이지 로딩 후 실행
window.onload = function() {
	var action = document.form1.action.value;
	var part = document.form1.part.value;
	
	var btninsert = document.getElementsByClassName("insert");
	var btnupdate = document.getElementsByClassName("update");
	var btndelete = document.getElementsByClassName("delete");
	
	
	// edit 이 아닐시 버튼 Disable
	if (action != "edit") {
		for (i = 0; i < btnupdate.length; i++) {
			btnupdate[i].disabled = true;
			btndelete[i].disabled = true;
		}
	} else if (action == "edit") {
		for (i = 0; i < btnupdate.length; i++) {
			btninsert[i].disabled = true;
			btnupdate[i].disabled = false;
			btndelete[i].disabled = false;
		}
	}

	if (action == "add_mainboard") {
		document.getElementById("mainboard").style.display = 'block';
	} else if (action == "add_cpu") {
		document.getElementById("cpu").style.display = 'block';
	} else if (action == "add_ram") {
		document.getElementById("ram").style.display = 'block';
	} else if (action == "add_ssd") {
		document.getElementById("ssd").style.display = 'block';
	} else if (action == "add_cases") {
		document.getElementById("cases").style.display = 'block';
	} else if (action == "add_vga") {
		document.getElementById("vga").style.display = 'block';
	} else {
		document.getElementById(part).style.display = 'block'; 
	}
	
	
}

function insertcheck1() {
	document.form1.action.value = "insert_mainboard";
	document.form1.submit();
}
function insertcheck2() {
	document.form1.action.value = "insert_cpu";
	document.form1.submit();
}
function insertcheck3() {
	document.form1.action.value = "insert_ram";
	document.form1.submit();
}
function insertcheck4() {
	document.form1.action.value = "insert_ssd";
	document.form1.submit();
}
function insertcheck5() {
	document.form1.action.value = "insert_cases";
	document.form1.submit();
}
function insertcheck6() {
	document.form1.action.value = "insert_vga";
	document.form1.submit();
}

function updatecheck() {

	document.form1.action.value = "update";
	
	document.form1.submit();
}

function deletecheck() {
	result = confirm("정말로 삭제하시겠습니까 ?");

	if (result == true) {

		// post방식
		document.form1.action.value = "delete";
		document.form1.submit();
	} else
		return;
}

function backcheck() {
	// post방식
	document.form1.action.value = "mainboard_list";
	document.form1.submit();
	// history.go(-1);

}