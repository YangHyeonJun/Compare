<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<title>content</title>
</head>
<body>
	<div id="rightdiv1">
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
        </div>
</body>
</html>