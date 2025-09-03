<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>aopMenu.jsp</title>
</head>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<body>
<p><br/></p>
<div class="container">
	<h2>Service ��ü�� Ȱ���� AOP ����</h2>
	<hr/>
	<p>
		<a href="test1" class="btn btn-success me-2">����1</a>
		<a href="test2" class="btn btn-success me-2">����2</a>
		<a href="test3" class="btn btn-success me-2">����3</a>
		<a href="test4" class="btn btn-success me-2">����4</a>
	</p>
	<hr/>
	<h2>AOP: ������ �ٶ󺸴� ������ �������� ���α׷��� �ϴ� ���</h2>
	<pre>
		: �ٽɰ��ɻ�(core concern) - ������ �Ա�/���/����/~~��
		: ����(Ⱦ��)���ɻ�(cross-cutting concern) - �α�, Ʈ�����ó��, ����ó�� ... ��..
		- AOP�� �ٽ��ڵ带 ������ �ִ� Ŭ����(�θ�)�� �ǵ帮�� �ʰ�, ��ӹ޾� ����ϴ� �ڽ�Ŭ�������� �������̵��ؼ� �����Ѵ�.
		- AOP�� ������ �������� ��Ÿ�ӽÿ� ���Ͻø� �̿��Ͽ� �����Ű�� �ȴ�.(AOP�� ������ : ����(Weaving))
		
		-AOP�� �ֿ� ���:
		. Ÿ�� ������Ʈ(Target Object): ��ӹ޴� �θ�(�ڽ�)Ŭ���� - AOP�� �����ϰ� ���� Ŭ����
		. ��������Ʈ(JoinPoint): Ÿ�ٿ�����Ʈ�� �ִ� ó���ؾ��� ��� �޼ҵ�(�������ؼ� ����ϰԵ�)
		. ����Ʈ ��(Point cut): Ÿ�ٿ�����Ʈ���� ������ ó���ؾ��ϴ� �޼ҵ� - �����̽��� ����Ǵ� �޼ҵ�
		. �����̽�(Advice): Ÿ�ٿ�����Ʈ �ȿ��� ����ϰ��� �ϴ� �����ڵ�� �� �����ڵ尡 ���� �����ϰ� ������ ���ؼ� ó���Ѵ�.
			�����̽��� 5������ �������� �����ִ�.
			�����̼�(Advisor): ����Ʈ�ư� �����̽��� ��ģ��(�����)���� aspect�͵� ���� �ǹ̷� �ؼ��ȴ�.
			����Ǵ� ��ɾ�δ�? before advice, after, after-throwing, after-returning, around
		. ����(Weaving): Ÿ�ٿ�����Ʈ ���� �����ǵ� �޼ҵ� �߿��� �ٽ��ڵ忡 �����ڵ尡 ���ԵǴ� ��.
		. ������Ʈ(Aspect): AOP�� �ٽ�����, ����Ʈ �ư� �����̽��� ������ �ǹ��Ѵ�.
			��, �ش� ����Ʈ���� ��������� ����ǰ� �ϴ°��� ������ ���Ѵ�.
	</pre>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>