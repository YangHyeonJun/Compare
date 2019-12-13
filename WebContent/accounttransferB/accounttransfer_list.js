window.onload = function() {
	var action = document.form1.action.value;
	
	if (action == "mainboard_list") {
		document.getElementById("mainboard").style.display = 'block';
	} else if (action == "cpu_list") {
		document.getElementById("cpu").style.display = 'block';
	} else if (action == "ram_list") {
		document.getElementById("ram").style.display = 'block';
	} else if (action == "ssd_list") {
		document.getElementById("ssd").style.display = 'block';
	} else if (action == "cases_list") {
		document.getElementById("cases").style.display = 'block';
	} else if (action == "vga_list") {
		document.getElementById("vga").style.display = 'block';
	}

}

function retrivalcheck() {
	document.form1.action.value = "list";
	document.form1.submit();
}
function addcheck() {
	document.form1.action.value = "add";
	document.form1.submit();
}
function editcheck(id,part) {
	document.form1.action.value = "edit";
	document.form1.id.value = id;
	document.form1.part.value = part;
	
	document.form1.submit();
}

// ADD 창 띄우기

function part_insert1() {
	document.form1.action.value = "add_mainboard";
	document.form1.submit();
}
function part_insert2() {
	document.form1.action.value = "add_cpu";
	document.form1.submit();
}
function part_insert3() {
	document.form1.action.value = "add_ram";
	document.form1.submit();
}
function part_insert4() {
	document.form1.action.value = "add_ssd";
	document.form1.submit();
}
function part_insert5() {
	document.form1.action.value = "add_cases";
	document.form1.submit();
}
function part_insert6() {
	document.form1.action.value = "add_vga";
	document.form1.submit();
}



function part1(id) {
	document.form1.action.value = "mainboard_list";
	document.form1.part.value = "mainboard";
	document.form1.submit();
}
function part2(id) {
	document.form1.action.value = "cpu_list";
	document.form1.part.value = "cpu";
	document.form1.submit();
}
function part3(id) {
	document.form1.action.value = "ram_list";
	document.form1.part.value = "ram";
	document.form1.submit();
}
function part4(id) {
	document.form1.action.value = "ssd_list";
	document.form1.part.value = "ssd";
	document.form1.submit();
}
function part5(id) {
	document.form1.action.value = "cases_list";
	document.form1.part.value = "cases";
	document.form1.submit();
}
function part6(id) {
	document.form1.action.value = "vga_list";
	document.form1.part.value = "vga";
	document.form1.submit();
}

// td 에 담기

function setHtml(item_id, item_html)
{
     obj = document.getElementById(item_id);
     obj.innerHTML = item_html;
}


function pcheck(pp,name) {
	setHtml(pp,name);
}

function compare() {
	var table1 = document.getElementById("table1");
	var mm = document.form1.select1.value;
	alert("mm");
	
}

//function selected(selname) {
//	document.form1.action.value = "select_save";
//	document.form1.selname.value = selname;
//	document.form1.submit();
//}




















