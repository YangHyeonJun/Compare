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
                    <th width="100px">��ǰ����</th>
                    <th width="400px">��ǰ�̸�</th>
                </tr>
                <tr>
                    <td>���κ���</td>
                    <td name = "select1" id="p1">��ǰ�̸�</td>
                </tr>
                <tr>
                    <td>CPU</td>
                    <td id="p2"><input type = "text" size = 10></td>
                </tr>
                <tr>
                    <td>�޸�</td>
                    <td id="p3">��ǰ�̸�</td>
                </tr>
                <tr>
                    <td>SSD</td>
                    <td id="p4">��ǰ�̸�</td>
                </tr>
                <tr>
                    <td>���̽�</td>
                    <td id="p5">��ǰ�̸�</td>
                </tr>
                <tr>
                    <td>�׷���ī��</td>
                    <td id="p6">��ǰ�̸�</td>
                </tr>
                
            </table>
            <input type="button" value="����" onClick="compare1()">
        </div>
</body>
</html>