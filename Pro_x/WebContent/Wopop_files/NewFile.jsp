<%@ page language="java"  pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
<head>
 
    <title>js��ʱ���뵹��ʱ</title>  
    <script type="text/javascript">  
        function countTime() {  
            //��ȡ��ǰʱ��  
            var date = new Date();  
            var now = date.getTime();  
            //���ý�ֹʱ��  
            var str="2017/5/17 00:00:00";
            var endDate = new Date(str); 
            var end = endDate.getTime();  
            
            //ʱ���  
            var leftTime = end-now; 
            //������� d,h,m,s���浹��ʱ��ʱ��  
            var d,h,m,s;  
            if (leftTime>=0) {  
                d = Math.floor(leftTime/1000/60/60/24);  
                h = Math.floor(leftTime/1000/60/60%24);  
                m = Math.floor(leftTime/1000/60%60);  
                s = Math.floor(leftTime/1000%60);                     
            }  
            //������ʱ��ֵ��div��  
            document.getElementById("_d").innerHTML = d+"��";  
            document.getElementById("_h").innerHTML = h+"ʱ";  
            document.getElementById("_m").innerHTML = m+"��";  
            document.getElementById("_s").innerHTML = s+"��";  
            //�ݹ�ÿ�����countTime��������ʾ��̬ʱ��Ч��  
            setTimeout(countTime,1000);  
  
        }  
    </script>  
</head >  
<body onload="countTime()" >  
    <div>  
        <span id="_d">00</span>  
        <span id="_h">00</span>  
        <span id="_m">00</span>  
        <span id="_s">00</span>  
    </div>  

</body>
</html>