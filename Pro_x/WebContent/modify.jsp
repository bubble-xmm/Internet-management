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
                      联系人信息${empty param.t?'修改':'添加' }
      <hr width="160">
    </caption>
    <tr>
      <td align="center">姓名</td>
      <td>
       <e:text name="name" required="true" autofocus="true" defval="${ins.name } "/>
      </td>
    </tr>
    <tr>
      <td align="center">年龄</td>
      <td>
       <e:text name="age" required="true" autofocus="true" defval="${ins.age } "/>
      </td>
    </tr>
    <tr>
      <td align="center">性别</td>
      <td>
       <e:text name="gender" required="true" autofocus="true" defval="${ins.gender } "/>
      </td>
    </tr>
    <tr>
      <td align="center">手机号码</td>
      <td>
       <e:text name="phone" required="true" autofocus="true" defval="${ins.phone } "/>
      </td>
    </tr>
    <tr>
      <td align="center">电子邮箱</td>
      <td>
       <e:text name="mail" required="true" autofocus="true" defval="${ins.mail } "/>
      </td>
    </tr>
    <tr>
      <td align="center">地址</td>
      <td>
       <e:text name="address" required="true" autofocus="true" defval="${ins.address } "/>
      </td>
    </tr>
    
    <tr>
      <td colspan="2" align="center">
         <input type="submit" name="next" value="${empty param.t?'修改':'添加' }"  formaction="${path }/u${empty param.t?'modify':'add' }.html">
         <input type="submit" name="next" value="返回" formnovalidate="formnovalidate" formaction="${path }/uquery.html">
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