<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<html>
<head>
  <title>Insert title here</title>
     <style type="text/css">
     td{
       height:28px;
     }
   </style>
</head>
<body>
<e:message/>
<br>
<br>
<form id="myform" action="" method="post">
  <table border="1" width="55%" align="center">
    <caption>
                      ��ϵ����Ϣ${empty param.t?'�޸�':'���' }
      <hr width="160">
    </caption>
    <tr>
      <td align="center">����</td>
      <td>
       <e:text name="name" required="true" autofocus="true" defval="${ins.name } "/>
      </td>
    </tr>
    <tr>
      <td align="center">����</td>
      <td>
       <e:text name="age" required="true" autofocus="true" defval="${ins.age } "/>
      </td>
    </tr>
    <tr>
      <td align="center">�Ա�</td>
      <td>
       <e:text name="gender" required="true" autofocus="true" defval="${ins.gender } "/>
      </td>
    </tr>
    <tr>
      <td align="center">�ֻ�����</td>
      <td>
       <e:text name="phone" required="true" autofocus="true" defval="${ins.phone } "/>
      </td>
    </tr>
    <tr>
      <td align="center">��������</td>
      <td>
       <e:text name="mail" required="true" autofocus="true" defval="${ins.mail } "/>
      </td>
    </tr>
    <tr>
      <td align="center">��ַ</td>
      <td>
       <e:text name="address" required="true" autofocus="true" defval="${ins.address } "/>
      </td>
    </tr>
    
    <tr>
      <td colspan="2" align="center">
         <input type="submit" name="next" value="${empty param.t?'�޸�':'���' }"  formaction="${path }/u${empty param.t?'modify':'add' }.html">
         <input type="submit" name="next" value="����" formnovalidate="formnovalidate" formaction="${path }/uquery.html">
      </td>
    </tr>
  </table>
  <c:if test="${empty param.t }">
   <input type="hidden" name="uid" value="${uid }">
  </c:if>
  <c:if test="${empty uid }">
  <input type="hidden" name="uid" value="${param.uid }">
  </c:if>
  
  <input type="hidden" name="cid" value="${cid }">
</form>
</body>
</html>