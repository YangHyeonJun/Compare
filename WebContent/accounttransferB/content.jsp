<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>content</title>
</head>
<body>
	<form name="form2" method="post" action="AccountTransferController">
	<input type="hidden" name="action" value=${action}>
        <input type="hidden" name="id" value=0>
        <input type="hidden" name="part" value=${part}>
        <input type="hidden" name="selname" value=${selname}>
            <table id = "table1" border=1>
                <tr>
                    <th width="100px">부품종류</th>
                    <th width="400px">부품이름</th>
                </tr>
                <tr>
                    <td>메인보드</td>
                    <td name = "select1" id="p1">부품이름</td>
                </tr>
                <tr>
                    <td>CPU</td>
                    <td id="p2"><input type = "text" size = 10></td>
                </tr>
                <tr>
                    <td>메모리</td>
                    <td id="p3">부품이름</td>
                </tr>
                <tr>
                    <td>SSD</td>
                    <td id="p4">부품이름</td>
                </tr>
                <tr>
                    <td>케이스</td>
                    <td id="p5">부품이름</td>
                </tr>
                <tr>
                    <td>그래픽카드</td>
                    <td id="p6">부품이름</td>
                </tr>
                
            </table>
            <input type="button" value="선택" onClick="compare1()">
            </form>

</body>
</html>