<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
   <title>ͨѶ¼</title>
   <style type="text/css">
     td{
       height:28px;
     }
     select{
       height:22px;
       width:162px;
     }
   </style>
   <script type="text/javascript">
      function onEdit(object)
      {
   	      var f = document.getElementById("myform");
	      f.action = "${path }/ufindbyid.html?cid="+object;
	      f.submit();
      }
      function onDel(object)
      {
    	  var f = document.getElementById("myform");
    	  f.action = "${path }/udelete.html?idlist="+object;
    	  f.submit();
      }
      var count = 0;
      function onSelect(object)
      {
    	  object?count++:count--;
    	  document.getElementById("next1").disabled=(count==0);
      }
   </script>
</head>
<body>
<br>
<br>
<form id="myform" action="${path }/uquery.html" method="post">
 <!-- ��ѯ���� -->
 <table border="1" width="95%" align="center">
   <caption>
                ͨѶ¼
     <hr width="160">
   </caption>
   <tr>
     <td colspan="4">&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>��ѯ����</td>
   </tr>
   <tr>
     <td align="center">����</td>
     <td>
       <e:text name="qname" autofocus="true"/>
     </td>
   </tr>
 </table>

 <!-- ���ݵ��� -->
 <table border="1" width="95%" align="center">
   <tr align="center">
     <td></td>
     <td>���</td>
     <td>����</td>
     <td>����</td>
     <td>�Ա�</td>
     <td>�ֻ�����</td>
     <td>�����ʼ�</td>
     <td>��ַ</td>
     <td></td>
   </tr>
   <c:choose>
     <c:when test="${rows!=null }">
        <c:forEach items="${rows }" var="ins" varStatus="vs">
		   <tr align="center">
		     <td>
		     <input type="checkbox" name="idlist" value="${ins.cid }" onclick="onSelect(this.checked)"/>
		     </td>
		     <td>${vs.count }</td>
		     <td>
		      <a href="#" onclick="onEdit('${ins.cid}')">${ins.name }</a>
		     </td>
		     <td>${ins.age }</td>
		     <td>${ins.gender }</td>
		     <td>${ins.phone }</td>
		     <td>${ins.mail }</td>
		     <td>${ins.address }</td>
		     <td>
		     <a href="#" onclick="onDel('${ins.cid}')">[ɾ��]</a>
		     </td>
		   </tr>
        </c:forEach>
        <c:forEach begin="${fn:length(rows)+1 }" step="1" end="10">
		   <tr>
		     <td></td>
		     <td></td>
		     <td></td>
	         <td></td>
	         <td></td>
		     <td></td>
		     <td></td>
		     <td></td>
		     <td></td>
		   </tr>
        </c:forEach>
     </c:when>
     <c:otherwise>
       <c:forEach begin="1" step="1" end="10">
            <tr>
		     <td></td>
		     <td></td>
		     <td></td>
		     <td></td>
		     <td></td>
		     <td></td>
		     <td></td>
		     <td></td>
		     <td></td>
		   </tr>
       </c:forEach>
     </c:otherwise>
   </c:choose>
 </table>
 <!-- ���ܰ�ť -->
 <table border="1" width="95%" align="center">
   <tr>
     <td align="center">
       <input type="submit" name="next" id="next3" value="���" formaction="${path }/modify.jsp?t=1&uid=${uid }">
       <input type="submit" name="next" id="next0" value="��ѯ">
       <c:if test="${requestScope.rows!=null }">
          <input type="submit" name="next" id="next1" value="ɾ��" disabled="disabled" formaction="${path }/udelete.html" >
       </c:if>
       <input type="submit" name="next" id="next2" value="�˳�" formaction="${path }/index.jsp">
     </td>
   </tr>
 </table>
 <input type="hidden" name="uid" value="${uid }">
</form>
</body>

</html>




