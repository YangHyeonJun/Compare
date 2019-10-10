<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 오류 페이지 정의  -->
<%@ page errorPage="accounttransfer_error.jsp"%>

<!-- taglib 지시어  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>계좌이체 조회</title>

    <link rel="stylesheet" href="accounttransfer.css" type="text/css" media="screen" />
    <script type="text/javascript" src="accounttransfer_list.js"></script>

</head>

<body>
    <H2>부품 목록 조회</H2>
    <HR>


    <form name="form1" method="post" action="AccountTransferController">
        <input type="hidden" name="action" value=${action}>
        <input type="hidden" name="id" value=0>
        <input type="hidden" name="part" value=${part}>
        
        <div id="rightdiv">
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

        <div id="leftdiv">


            <table border=1>
                <tr>
                    <td colspan=6 align=center>
                        <input type="button" name="mainboard" value="메인보드" onClick="part1()">
                        <input type="button" name="cpu" value="CPU" onClick="part2()">
                        <input type="button" name="ram" value="RAM" onClick="part3()">
                        <input type="button" name="nvme" value="SSD" onClick="part4()">
                        <input type="button" name="cases" value="케이스" onClick="part5()">
                        <input type="button" name="vga" value="그래픽카드" onClick="part6()"></td>
                </tr>
            </table>
            <br><br>
            <div id="mainboard">
                <table border=1>
                    <tr>
                        <td colspan=3 align=center>메인보드</td>
                        <td colspan=3 align=center>
                            <input type="button" name="mainboard_insert" value="메인보드 등록" onClick="part_insert1()">
                        </td>
                    </tr>
                    <tr>
                        <th>제품번호</th>
                        <th>제품명</th>
                        <th>제품칩셋</th>
                        <th>DDR 버전</th>
                        <th>NVMe 지원</th>
                        <th>메인보드 규격</th>
                    </tr>

                    <c:forEach var="i" items="${accountTransferList}">
                        <tr>
                            <td><a href="javascript:editcheck(${i.mbNumber},'mainboard')">${i.mbNumber}</a></td>
                            <td>${i.mbName}</td>
                            <td>${i.mbChipset}</td>
                            <td>${i.mbDDR}</td>
                            <td>${i.mbNVMe}</td>
                            <td>${i.mbSize}</td>
                            <td><input type="button" name="mbcheck" value="선택" onClick="selected('${i.mbName}')"></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <div id="cpu">
                <table border=1>
                    <tr>
                        <td align=center>CPU</td>
                        <td colspan=2 align=center>
                            <input type="button" name="cpu_insert" value="CPU 등록" onClick="part_insert2()">
                        </td>
                    </tr>
                    <tr>
                        <th>제품번호</th>
                        <th>제품명</th>
                        <th>제품칩셋</th>
                    </tr>

                    <c:forEach var="i" items="${accountTransferList}">
                        <tr>
                            <td><a href="javascript:editcheck(${i.cpuNumber},'cpu')">${i.cpuNumber}</a></td>
                            <td>${i.cpuName}</td>
                            <td>${i.cpuChipset}</td>
                            <td><input type="button" name="cpucheck" value="선택" onClick="pcheck('p2','${i.cpuName}')"></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <div id="ram">
                <table border=1>
                    <tr>
                        <td align=center>RAM</td>
                        <td colspan=2 align=center>
                            <input type="button" name="ram_insert" value="RAM 등록" onClick="part_insert3()">
                        </td>
                    </tr>
                    <tr>
                        <th>제품번호</th>
                        <th>제품명</th>
                        <th>DDR버전</th>
                    </tr>

                    <c:forEach var="i" items="${accountTransferList}">
                        <tr>
                            <td><a href="javascript:editcheck(${i.ramNumber},'ram')">${i.ramNumber}</a></td>
                            <td>${i.ramName}</td>
                            <td>${i.ramDDR}</td>
                            <td><input type="button" name="ramcheck" value="선택" onClick="pcheck('p3','${i.ramName}')"></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <div id="ssd">
                <table border=1>
                    <tr>
                        <td align=center>SSD</td>
                        <td colspan=2 align=center>
                            <input type="button" name="ssd_insert" value="SSD 등록" onClick="part_insert4()">
                        </td>
                    </tr>
                    <tr>
                        <th>제품번호</th>
                        <th>제품명</th>
                        <th>NVMe 지원유무</th>
                    </tr>

                    <c:forEach var="i" items="${accountTransferList}">
                        <tr>
                            <td><a href="javascript:editcheck(${i.ssdNumber},'ssd')">${i.ssdNumber}</a></td>
                            <td>${i.ssdName}</td>
                            <td>${i.ssdNVMe}</td>
                            <td><input type="button" name="ssdcheck" value="선택" onClick="pcheck('p4','${i.ssdName}')"></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <div id="cases">
                <table border=1>
                    <tr>
                        <td align=center>케이스</td>
                        <td colspan=3 align=center>
                            <input type="button" name="cases_insert" value="케이스 등록" onClick="part_insert5()">
                        </td>
                    </tr>
                    <tr>
                        <th>제품번호</th>
                        <th>제품명</th>
                        <th>메인보드 규격</th>
                        <th>VGA지원 길이</th>
                    </tr>

                    <c:forEach var="i" items="${accountTransferList}">
                        <tr>
                            <td><a href="javascript:editcheck(${i.casesNumber},'cases')">${i.casesNumber}</a></td>
                            <td>${i.casesName}</td>
                            <td>${i.casesSize}</td>
                            <td>${i.casesWidth}</td>
                            <td><input type="button" name="casescheck" value="선택" onClick="pcheck('p5','${i.casesName}')"></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <div id="vga">
                <table border=1>
                    <tr>
                        <td align=center>그래픽카드</td>
                        <td colspan=2 align=center>
                            <input type="button" name="vga_insert" value="VGA 등록" onClick="part_insert6()">
                        </td>
                    </tr>
                    <tr>
                        <th>제품번호</th>
                        <th>제품명</th>
                        <th>길이</th>
                    </tr>

                    <c:forEach var="i" items="${accountTransferList}">
                        <tr>
                            <td><a href="javascript:editcheck(${i.vgaNumber},'vga')">${i.vgaNumber}</a></td>
                            <td>${i.vgaName}</td>
                            <td>${i.vgaWidth}</td>
                            <td><input type="button" name="vgacheck" value="선택" onClick="pcheck('p6','${i.vgaName}')"></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
    </form>
    </div>
</body>

</html>
