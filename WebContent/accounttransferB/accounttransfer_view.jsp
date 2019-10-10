<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 오류 페이지 정의  -->
<%@ page errorPage="accounttransfer_error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>계좌이체 등록</title>
	<link rel="stylesheet" href="accounttransfer.css" type="text/css" media="screen" />
	<script type="text/javascript" src="accounttransfer_view.js"></script>

</head>

<body>

<div align="center">
	<H2>계좌이체 등록</H2>
	<HR>

	<!-- 계좌이체 등록용 -->
	<form name="form1" method="post" action="AccountTransferController">
	
		<input type="hidden" name="id" value=${id}>
		<input type="hidden" name="action" value=${action}>
		<input type="hidden" name="part" value=${part}>
		
		<div id = "mainboard">
			<table>
				<tr>
					<th colspan = "5">메인보드</th>
				</tr>
				<tr>
					<th>제품명</th>
					<td><input type=text size=20 name=mbName value="${accountTransferDTO.mbName}"></td>
				</tr>
				<tr>
					<th>제품소켓</th>
					<td><input type=text size=20 name=mbChipset value="${accountTransferDTO.mbChipset}"></td>
				</tr>
				<tr>
					<th>DDR버전</th>
					<td><input type=text size=10 name=mbDDR value="${accountTransferDTO.mbDDR}"></td>
				</tr>
				<tr>
					<th>NVMe 유무</th>
					<td><input type=text size=10 name=mbNVMe value=${accountTransferDTO.mbNVMe}></td>
				</tr>
				<tr>
					<th>규격</th>
					<td><input type=text size=10 name=mbSize value="${accountTransferDTO.mbSize}"></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type="button" class="insert" value="입력" onClick="insertcheck1()">
						<input type="button" class="update" value="수정" onClick="updatecheck()">
						<input type="button" class="delete" value="삭제" onClick="deletecheck()">
						<input type="button" class="back" value="돌아가기" onClick="backcheck()">
					</td>
				</tr>
			</table>
		</div>
		
		<div id = "cpu">
			<table>
				<tr>
					<th colspan = "2">CPU</th>
				</tr>
				<tr>
					<th>제품명</th>
					<td><input type=text size=20 name=cpuName value="${accountTransferDTO.cpuName}"></td>
				</tr>
				<tr>
					<th>소켓</th>
					<td><input type=text size=20 name=cpuChipset value="${accountTransferDTO.cpuChipset}"></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type="button" class="insert" value="입력" onClick="insertcheck2()">
						<input type="button" class="update" value="수정" onClick="updatecheck()">
						<input type="button" class="delete" value="삭제" onClick="deletecheck()">
						<input type="button" class="back" value="돌아가기" onClick="backcheck()">
					</td>
				</tr>
			</table>
		</div>
		
		<div id = "ram">
			<table>
			<tr>
					<th colspan = "2">RAM</th>
				</tr>
				<tr>
					<th>제품명</th>
					<td><input type=text size=20 name=ramName value="${accountTransferDTO.ramName}"></td>
				</tr>
				<tr>
					<th>DDR 버전</th>
					<td><input type=text size=20 name=ramDDR value="${accountTransferDTO.ramDDR}"></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type="button" class="insert" value="입력" onClick="insertcheck3()">
						<input type="button" class="update" value="수정" onClick="updatecheck()">
						<input type="button" class="delete" value="삭제" onClick="deletecheck()">
						<input type="button" class="back" value="돌아가기" onClick="backcheck()">
					</td>
				</tr>
			</table>
		</div>
		
		<div id = "ssd">
			<table>
				<tr>
				<tr>
					<th colspan = "2">SSD</th>
				</tr>
					<th>제품명</th>
					<td><input type=text size=20 name=ssdName value="${accountTransferDTO.ssdName}"></td>
				</tr>
				<tr>
					<th>NVMe 지원유무</th>
					<td><input type=text size=20 name=ssdNVMe value=${accountTransferDTO.ssdNVMe}></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type="button" class="insert" value="입력" onClick="insertcheck4()">
						<input type="button" class="update" value="수정" onClick="updatecheck()">
						<input type="button" class="delete" value="삭제" onClick="deletecheck()">
						<input type="button" class="back" value="돌아가기" onClick="backcheck()">
					</td>
				</tr>
			</table>
		</div>
		
		<div id = "cases">
			<table>
			<tr>
					<th colspan = "3">케이스</th>
				</tr>
				<tr>
					<th>제품명</th>
					<td><input type=text size=20 name=casesName value="${accountTransferDTO.casesName}"></td>
				</tr>
				<tr>
					<th>메인보드 규격</th>
					<td><input type=text size=20 name=casesSize value="${accountTransferDTO.casesSize}"></td>
				</tr>
				<tr>
					<th>그래픽 길이</th>
					<td><input type=text size=10 name=casesWidth value=${accountTransferDTO.casesWidth}></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type="button" class="insert" value="입력" onClick="insertcheck5()">
						<input type="button" class="update" value="수정" onClick="updatecheck()">
						<input type="button" class="delete" value="삭제" onClick="deletecheck()">
						<input type="button" class="back" value="돌아가기" onClick="backcheck()">
					</td>
				</tr>
			</table>
		</div>
		
		<div id = "vga">
			<table>
			<tr>
					<th colspan = "2">그래픽카드</th>
				</tr>
				<tr>
					<th>제품명</th>
					<td><input type=text size=20 name=vgaName value="${accountTransferDTO.vgaName}"></td>
				</tr>
				<tr>
					<th>제품 길이</th>
					<td><input type=text size=20 name=vgaWidth value=${accountTransferDTO.vgaWidth}></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type="button" class="insert" value="입력" onClick="insertcheck6()">
						<input type="button" class="update" value="수정" onClick="updatecheck()">
						<input type="button" class="delete" value="삭제" onClick="deletecheck()">
						<input type="button" class="back" value="돌아가기" onClick="backcheck()">
					</td>
				</tr>
			</table>
		</div>
	</form>
	</div>


</body>
</html>